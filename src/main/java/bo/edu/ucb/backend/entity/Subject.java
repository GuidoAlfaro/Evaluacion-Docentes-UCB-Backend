package bo.edu.ucb.backend.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "subject")
public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer subjectId;

    @Column(name = "name")
    private String name;


    @Column(name = "parallel")
    private String parallel;

    @Column(name = "semester")
    private String semester;

    @Column(name = "year")
    private String year;

    @Column(name = "status")
    private boolean status;

    public Subject() {
    }

    public Subject(Integer subjectId, String name, String parallel, String semester, String year, boolean status) {
        this.subjectId = subjectId;
        this.name = name;
        this.parallel = parallel;
        this.semester = semester;
        this.year = year;
        this.status = status;
    }

    public Integer getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(Integer subjectId) {
        this.subjectId = subjectId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getParallel() {
        return parallel;
    }

    public void setParallel(String parallel) {
        this.parallel = parallel;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Subject{" +
                "subjectId=" + subjectId +
                ", name='" + name + '\'' +
                ", parallel='" + parallel + '\'' +
                ", semester='" + semester + '\'' +
                ", year='" + year + '\'' +
                ", status=" + status +
                '}';
    }
}
