package bo.edu.ucb.backend.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import java.sql.Timestamp;

@Entity
@Table(name = "subject_enrollment")
public class SubjectEnrollment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer enrollmentId;

    @ManyToOne
    @JoinColumn(name = "student_user_id")
    private User student;

    @ManyToOne
    @JoinColumn(name = "subject_id")
    private Subject subject;

    @Column(name = "evaluated")
    private boolean evaluated;

    @Column(name = "status")
    private short status;

    @Column(name = "tx_user")
    private String txUser;

    @Column(name = "tx_date")
    private Timestamp txDate;

    @Column(name = "tx_host")
    private String txHost;

    public SubjectEnrollment() {
    }

    public SubjectEnrollment(Integer enrollmentId, User student, Subject subject, boolean evaluated, short status, String txUser, Timestamp txDate, String txHost) {
        this.enrollmentId = enrollmentId;
        this.student = student;
        this.subject = subject;
        this.evaluated = evaluated;
        this.status = status;
        this.txUser = txUser;
        this.txDate = txDate;
        this.txHost = txHost;
    }

    public Integer getEnrollmentId() {
        return enrollmentId;
    }

    public void setEnrollmentId(Integer enrollmentId) {
        this.enrollmentId = enrollmentId;
    }

    public User getStudent() {
        return student;
    }

    public void setStudent(User student) {
        this.student = student;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public boolean isEvaluated() {
        return evaluated;
    }

    public void setEvaluated(boolean evaluated) {
        this.evaluated = evaluated;
    }

    public short getStatus() {
        return status;
    }

    public void setStatus(short status) {
        this.status = status;
    }

    public String getTxUser() {
        return txUser;
    }

    public void setTxUser(String txUser) {
        this.txUser = txUser;
    }

    public Timestamp getTxDate() {
        return txDate;
    }

    public void setTxDate(Timestamp txDate) {
        this.txDate = txDate;
    }

    public String getTxHost() {
        return txHost;
    }

    public void setTxHost(String txHost) {
        this.txHost = txHost;
    }

    @Override
    public String toString() {
        return "SubjectEnrollment{" +
                "enrollmentId=" + enrollmentId +
                ", student=" + student +
                ", subject=" + subject +
                ", evaluated=" + evaluated +
                ", status=" + status +
                ", txUser='" + txUser + '\'' +
                ", txDate=" + txDate +
                ", txHost='" + txHost + '\'' +
                '}';
    }
}
