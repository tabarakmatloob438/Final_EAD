package Views;

import beakingBean.user;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import java.util.List;

@ManagedBean
@RequestScoped
public class SelectOneView {

    private String option;
    private user theme;
    private List<user> themes;


    private ThemeService service;

    @PostConstruct
    public void init() {
        themes = service.getThemes();
    }

    public String getOption() {
        return option;
    }

    public void setOption(String option) {
        this.option = option;
    }

    public user getTheme() {
        return theme;
    }

    public void setTheme(user theme) {
        this.theme = theme;
    }

    public List<user> getThemes() {
        return themes;
    }

    public void setService(ThemeService service) {
        this.service = service;
    }


}
