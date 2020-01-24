package entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "student", schema = "ead_final")
public class StudentEntity {
    private int sid;
    private String name;
    private String regno;
    private int semester;

    @Id
    @Column(name = "sid", nullable = false)
    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    @Basic
    @Column(name = "name", nullable = false, length = 100)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "regno", nullable = false, length = 100)
    public String getRegno() {
        return regno;
    }

    public void setRegno(String regno) {
        this.regno = regno;
    }

    @Basic
    @Column(name = "semester", nullable = false)
    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StudentEntity that = (StudentEntity) o;
        return sid == that.sid &&
                semester == that.semester &&
                Objects.equals(name, that.name) &&
                Objects.equals(regno, that.regno);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sid, name, regno, semester);
    }
}
