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
@Table(name = "subject_enrollment")
public class SubjectEnrollment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer enrollmentId;

    @ManyToOne
    @JoinColumn(name = "student_user_id")
    private User studentUserId;

    @ManyToOne
    @JoinColumn(name = "subject_id")
    private Subject subjectId;

    @Column(name = "evaluated")
    private boolean evaluated;

    @Column(name = "status")
    private boolean status;

    public SubjectEnrollment() {
    }

    public SubjectEnrollment(Integer enrollmentId, User studentUserId, Subject subjectId, boolean evaluated, boolean status) {
        this.enrollmentId = enrollmentId;
        this.studentUserId = studentUserId;
        this.subjectId = subjectId;
        this.evaluated = evaluated;
        this.status = status;
    }

    public Integer getEnrollmentId() {
        return enrollmentId;
    }

    public void setEnrollmentId(Integer enrollmentId) {
        this.enrollmentId = enrollmentId;
    }

    public User getStudentUserId() {
        return studentUserId;
    }

    public void setStudentUserId(User studentUserId) {
        this.studentUserId = studentUserId;
    }

    public Subject getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(Subject subjectId) {
        this.subjectId = subjectId;
    }

    public boolean isEvaluated() {
        return evaluated;
    }

    public void setEvaluated(boolean evaluated) {
        this.evaluated = evaluated;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "{" +
            " enrollmentId='" + getEnrollmentId() + "'" +
            ", studentUserId='" + getStudentUserId() + "'" +
            ", subjectId='" + getSubjectId() + "'" +
            ", evaluated='" + isEvaluated() + "'" +
            ", status='" + isStatus() + "'" +
            "}";
    }
}
