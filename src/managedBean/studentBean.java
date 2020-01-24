package managedBean;

import beakingBean.student;
import entities.StudentEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class studentBean {
    private student student1;


    public studentBean() {
        student1=new student();

    }

    public student getStudent1() {
        return student1;
    }

    public void setStudent1(student student1) {
        this.student1 = student1;
    }
    public String register_student()
    {
        int id=2;
        StudentEntity studentEntity=new StudentEntity();
        studentEntity.setName(student1.getName());
        studentEntity.setRegno(student1.getRegno());
        studentEntity.setSemester(student1.getSemester());
        studentEntity.setSid(id);

        SessionFactory factory= new Configuration().configure().buildSessionFactory();
        Session session=factory.openSession();
        session.save(studentEntity);
        session.beginTransaction().commit();
        session.close();
        factory.close();


        return "index";
    }
    public String gotoStudent()
    {
        return "student";
    }
}
