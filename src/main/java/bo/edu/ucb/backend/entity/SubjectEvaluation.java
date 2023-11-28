package bo.edu.ucb.backend.entity;

import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
@Table(name = "subject_evaluation")
public class SubjectEvaluation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer subjectEvaluationId;

    @ManyToOne
    @JoinColumn(name = "subject_id")
    private Subject subject;

    @ManyToOne
    @JoinColumn(name = "evaluation_id")
    private Evaluation evaluation;

    @Column(name = "status")
    private short status;

    @Column(name = "tx_user")
    private String txUser;

    @Column(name = "tx_date")
    private Timestamp txDate;

    @Column(name = "tx_host")
    private String txHost;

    public SubjectEvaluation() {
    }

    public SubjectEvaluation(Integer subjectEvaluationId, Subject subject, Evaluation evaluation, short status, String txUser, Timestamp txDate, String txHost) {
        this.subjectEvaluationId = subjectEvaluationId;
        this.subject = subject;
        this.evaluation = evaluation;
        this.status = status;
        this.txUser = txUser;
        this.txDate = txDate;
        this.txHost = txHost;
    }

    public Integer getSubjectEvaluationId() {
        return subjectEvaluationId;
    }

    public void setSubjectEvaluationId(Integer subjectEvaluationId) {
        this.subjectEvaluationId = subjectEvaluationId;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public Evaluation getEvaluation() {
        return evaluation;
    }

    public void setEvaluation(Evaluation evaluation) {
        this.evaluation = evaluation;
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
        return "SubjectEvaluation{" +
                "subjectEvaluationId=" + subjectEvaluationId +
                ", subject=" + subject +
                ", evaluation=" + evaluation +
                ", status=" + status +
                ", txUser='" + txUser + '\'' +
                ", txDate=" + txDate +
                ", txHost='" + txHost + '\'' +
                '}';
    }
}
