package managedBean;

import beakingBean.user;
import entities.UserEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@ManagedBean
@SessionScoped
public class userBean {

    private user user1;


    public userBean() {
        user1=new user();

    }

    public user getUser1() {
        return user1;
    }

    public void setUser1(user user1) {
        this.user1 = user1;
    }

    public String register()
    {
        return "login";
    }


    public String register_user()
    {

        UserEntity userEntity=new UserEntity();
        userEntity.setName(user1.getName());
        userEntity.setEmail(user1.getEmail());
        userEntity.setPassword(user1.getPassword());
        SessionFactory factory= new Configuration().configure().buildSessionFactory();
        Session session=factory.openSession();
        session.save(userEntity);
        session.beginTransaction().commit();
        session.close();
        factory.close();
        return "index";
    }

    public String loginUser(){


        SessionFactory factory= new Configuration().configure().buildSessionFactory();

        Session session=factory.openSession();
        session.beginTransaction();
        String query="from UserEntity";
        List list=session.createQuery(query).list();
        Iterator iterator=list.iterator();
        while(iterator.hasNext()){
            UserEntity obj=(UserEntity)iterator.next();
            System.out.println(obj.getEmail()+"\t"+obj.getPassword());
            if(user1.getEmail().equals(obj.getEmail())&&user1.getPassword().equals(obj.getPassword()))
            {
                HttpSession session1 =(HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
                session1.setAttribute("username", user1.getId());
                session1.setMaxInactiveInterval(10*60);
                return "welcome.xhtml?faces-redirect=true";
            }

        }
        session.close();
        factory.close();
        return "index";
    }

    public List<UserEntity> getUsers()
    {
        List<UserEntity> Options=new ArrayList<UserEntity>();
        SessionFactory factory= new Configuration().configure().buildSessionFactory();

        Session session=factory.openSession();
        session.beginTransaction();
        String query="from UserEntity";
        List list=session.createQuery(query).list();
        Iterator iterator=list.iterator();
        while(iterator.hasNext()){
            UserEntity obj=(UserEntity)iterator.next();
            Options.add(obj);

        }
        session.close();
        factory.close();

        return list;
    }

    public boolean isLoggedIn(){
        HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        if(session!=null){
            Integer uname =(Integer) session.getAttribute("username");
            if(uname!=null){
                return true;
            }

        }
        return false;
    }
    public String logoutUser(){
        HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        session.invalidate();
        return "index.xhtml?faces-redirect=true";
    }

}
