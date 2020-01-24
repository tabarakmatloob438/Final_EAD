package entities;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "courseregistration", schema = "ead_final")
public class CourseregistrationEntity {
    private int crid;
    private Timestamp registrationtime;

    @Id
    @Column(name = "crid", nullable = false)
    public int getCrid() {
        return crid;
    }

    public void setCrid(int crid) {
        this.crid = crid;
    }

    @Basic
    @Column(name = "registrationtime", nullable = false)
    public Timestamp getRegistrationtime() {
        return registrationtime;
    }

    public void setRegistrationtime(Timestamp registrationtime) {
        this.registrationtime = registrationtime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CourseregistrationEntity that = (CourseregistrationEntity) o;
        return crid == that.crid &&
                Objects.equals(registrationtime, that.registrationtime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(crid, registrationtime);
    }
}
