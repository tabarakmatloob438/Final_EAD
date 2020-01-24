package entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "course", schema = "ead_final")
public class CourseEntity {
    private int cid;
    private String ccode;
    private String cname;
    private int chours;

    @Id
    @Column(name = "cid", nullable = false)
    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    @Basic
    @Column(name = "ccode", nullable = false, length = 100)
    public String getCcode() {
        return ccode;
    }

    public void setCcode(String ccode) {
        this.ccode = ccode;
    }

    @Basic
    @Column(name = "cname", nullable = false, length = 100)
    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    @Basic
    @Column(name = "chours", nullable = false)
    public int getChours() {
        return chours;
    }

    public void setChours(int chours) {
        this.chours = chours;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CourseEntity that = (CourseEntity) o;
        return cid == that.cid &&
                chours == that.chours &&
                Objects.equals(ccode, that.ccode) &&
                Objects.equals(cname, that.cname);
    }
    @Override
    public String toString() {
        return cname;
    }

    @Override
    public int hashCode() {
        return Objects.hash(cid, ccode, cname, chours);
    }
}
