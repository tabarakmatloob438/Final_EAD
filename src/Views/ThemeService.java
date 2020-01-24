package Views;

import beakingBean.user;
import managedBean.userBean;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.annotation.PostConstruct;
import javax.faces.bean.ApplicationScoped;
import java.util.ArrayList;
import java.util.List;


@ApplicationScoped
public class ThemeService {

    private List<user> themes;

    @PostConstruct
    public void init() {

        themes = new ArrayList<>();

        SessionFactory factory= new Configuration().configure().buildSessionFactory();

        Session session=factory.openSession();
        session.beginTransaction();
        String query="from UserEntity";
        List list=session.createQuery(query).list();
        session.close();
        factory.close();
        themes=list;
    }

    public List<user> getThemes() {
        return themes;
    }
}
