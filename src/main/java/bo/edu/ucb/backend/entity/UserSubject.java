package bo.edu.ucb.backend.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "user_subject")
public class UserSubject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userSubjectId;

    @ManyToOne
    @JoinColumn(name = "student_user_id")
    private User studentUserId;

    @ManyToOne
    @JoinColumn(name = "teacher_user_id")
    private User teacherUserId;

    @ManyToOne
    @JoinColumn(name = "subject_id")
    private Subject subjectId;

    @Column(name = "semester")
    private String semester;

    @Column(name = "year")
    private Integer year;

    @Column(name = "parallel")
    private int parallel;

    @Column(name = "evaluated")
    private boolean evaluated;

    public UserSubject() {
    }

    public UserSubject(Integer userSubjectId, User studentUserId, User teacherUserId, Subject subjectId, String semester, Integer year, int parallel, boolean evaluated) {
        this.userSubjectId = userSubjectId;
        this.studentUserId = studentUserId;
        this.teacherUserId = teacherUserId;
        this.subjectId = subjectId;
        this.semester = semester;
        this.year = year;
        this.parallel = parallel;
        this.evaluated = evaluated;
    }

    public Integer getUserSubjectId() {
        return this.userSubjectId;
    }

    public void setUserSubjectId(Integer userSubjectId) {
        this.userSubjectId = userSubjectId;
    }

    public User getStudentUserId() {
        return this.studentUserId;
    }

    public void setStudentUserId(User studentUserId) {
        this.studentUserId = studentUserId;
    }

    public User getTeacherUserId() {
        return this.teacherUserId;
    }

    public void setTeacherUserId(User teacherUserId) {
        this.teacherUserId = teacherUserId;
    }

    public Subject getSubjectId() {
        return this.subjectId;
    }

    public void setSubjectId(Subject subjectId) {
        this.subjectId = subjectId;
    }

    public String getSemester() {
        return this.semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public Integer getYear() {
        return this.year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public int getParallel() {
        return this.parallel;
    }

    public void setParallel(int parallel) {
        this.parallel = parallel;
    }

    public void setEvaluated(boolean evaluated) {
        this.evaluated = evaluated;
    }

    public boolean getEvaluated() {
        return this.evaluated;
    }

    @Override
    public String toString(){
        return "UserSubject{" +
                "user_subject_id=" + userSubjectId +
                ", student_user_id=" + studentUserId +
                ", teacher_user_id=" + teacherUserId +
                ", subject_id=" + subjectId +
                ", semester='" + semester + '\'' +
                ", year=" + year +
                ", parallel=" + parallel +
                ", evaluated=" + evaluated +
                '}';
    }
}
