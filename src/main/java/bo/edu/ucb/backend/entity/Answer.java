package bo.edu.ucb.backend.entity;

import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
@Table(name = "answer")
public class Answer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer answerId;

    @ManyToOne
    @JoinColumn(name = "subject_evaluation_id")
    private SubjectEvaluation subjectEvaluation;

    @ManyToOne
    @JoinColumn(name = "question_id")
    private Question question;

    @ManyToOne
    @JoinColumn(name = "student_user_id")
    private User student;

    @Column(name = "answer_text")
    private String answerText;

    @Column(name = "status")
    private short status;

    @Column(name = "tx_user")
    private String txUser;

    @Column(name = "tx_date")
    private Timestamp txDate;

    @Column(name = "tx_host")
    private String txHost;

    public Answer() {
    }

    public Answer(Integer answerId, SubjectEvaluation subjectEvaluation, Question question, User student, String answerText, short status, String txUser, Timestamp txDate, String txHost) {
        this.answerId = answerId;
        this.subjectEvaluation = subjectEvaluation;
        this.question = question;
        this.student = student;
        this.answerText = answerText;
        this.status = status;
        this.txUser = txUser;
        this.txDate = txDate;
        this.txHost = txHost;
    }

    public Integer getAnswerId() {
        return answerId;
    }

    public void setAnswerId(Integer answerId) {
        this.answerId = answerId;
    }

    public SubjectEvaluation getSubjectEvaluation() {
        return subjectEvaluation;
    }

    public void setSubjectEvaluation(SubjectEvaluation subjectEvaluation) {
        this.subjectEvaluation = subjectEvaluation;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public User getStudent() {
        return student;
    }

    public void setStudent(User student) {
        this.student = student;
    }

    public String getAnswerText() {
        return answerText;
    }

    public void setAnswerText(String answerText) {
        this.answerText = answerText;
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
        return "Answer{" +
                "answerId=" + answerId +
                ", subjectEvaluation=" + subjectEvaluation +
                ", question=" + question +
                ", student=" + student +
                ", answerText='" + answerText + '\'' +
                ", status=" + status +
                ", txUser='" + txUser + '\'' +
                ", txDate=" + txDate +
                ", txHost='" + txHost + '\'' +
                '}';
    }
}
