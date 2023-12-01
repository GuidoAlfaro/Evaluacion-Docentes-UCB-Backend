package bo.edu.ucb.backend.entity;

import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
@Table(name = "subject_result")
public class SubjectResult {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "subject_result_id")
    private Integer subjectResultId;
    @ManyToOne
    @JoinColumn(name = "teacher_subject_id")
    private TeacherSubject teacherSubject;
    @Column(name = "overall_calification")
    private Double overAllCalification;
    @Column(name = "status")
    private short status;
    @Column(name = "tx_user")
    private String txUser;
    @Column(name = "tx_date")
    private Timestamp txDate;
    @Column(name = "tx_host")
    private String txHost;


    public SubjectResult() {
    }

    public SubjectResult(Integer subjectResultId, TeacherSubject teacherSubject, Double overallResult, short status, String txUser, Timestamp txDate, String txHost) {
        this.subjectResultId = subjectResultId;
        this.teacherSubject = teacherSubject;
        this.overAllCalification = overallResult;
        this.status = status;
        this.txUser = txUser;
        this.txDate = txDate;
        this.txHost = txHost;
    }

    public Integer getSubjectResultId() {
        return subjectResultId;
    }

    public void setSubjectResultId(Integer subjectResultId) {
        this.subjectResultId = subjectResultId;
    }

    public TeacherSubject getTeacherSubject() {
        return teacherSubject;
    }

    public void setTeacherSubject(TeacherSubject teacherSubject) {
        this.teacherSubject = teacherSubject;
    }

    public Double getOverallResult() {
        return overAllCalification;
    }
    public void setOverallResult(Double overallResult) {
        this.overAllCalification = overallResult;
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
        return "SubjectResult{" +
                "subjectResultId=" + subjectResultId +
                ", teacherSubject=" + teacherSubject +
                ", overAllCalification=" + overAllCalification +
                ", status=" + status +
                ", txUser='" + txUser + '\'' +
                ", txDate=" + txDate +
                ", txHost='" + txHost + '\'' +
                '}';
    }
}
