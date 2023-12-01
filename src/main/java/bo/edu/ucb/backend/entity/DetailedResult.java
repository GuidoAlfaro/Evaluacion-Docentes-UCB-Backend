package bo.edu.ucb.backend.entity;

import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
@Table(name = "detailed_result")
public class DetailedResult {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer detailedResultId;

    @ManyToOne
    @JoinColumn(name = "teacher_subject_id")
    private TeacherSubject teacherSubject;

    @ManyToOne
    @JoinColumn(name = "parameter_id")
    private Parameter parameter;

    @Column(name = "message_for_teacher")
    private String messageForTeacher;

    @Column(name = "parameter_calification")
    private Double parameterCalification;

    @Column(name = "status")
    private short status;

    @Column(name = "tx_user")
    private String txUser;

    @Column(name = "tx_date")
    private Timestamp txDate;

    @Column(name = "tx_host")
    private String txHost;

    public DetailedResult() {
    }

    public DetailedResult(Integer detailedResultId, TeacherSubject teacherSubject, Parameter parameter, String messageForTeacher, Double parameterCalification, short status, String txUser, Timestamp txDate, String txHost) {
        this.detailedResultId = detailedResultId;
        this.teacherSubject = teacherSubject;
        this.parameter = parameter;
        this.messageForTeacher = messageForTeacher;
        this.parameterCalification = parameterCalification;
        this.status = status;
        this.txUser = txUser;
        this.txDate = txDate;
        this.txHost = txHost;
    }

    public Integer getDetailedResultId() {
        return detailedResultId;
    }

    public void setDetailedResultId(Integer detailedResultId) {
        this.detailedResultId = detailedResultId;
    }

    public TeacherSubject getTeacherSubject() {
        return teacherSubject;
    }

    public void setTeacherSubject(TeacherSubject teacherSubject) {
        this.teacherSubject = teacherSubject;
    }

    public Parameter getParameter() {
        return parameter;
    }

    public void setParameter(Parameter parameter) {
        this.parameter = parameter;
    }

    public String getMessageForTeacher() {
        return messageForTeacher;
    }

    public void setMessageForTeacher(String messageForTeacher) {
        this.messageForTeacher = messageForTeacher;
    }

    public Double getParameterCalification() {
        return parameterCalification;
    }

    public void setParameterCalification(Double parameterCalification) {
        this.parameterCalification = parameterCalification;
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
        return "DetailedResult{" +
                "detailedResultId=" + detailedResultId +
                ", teacherSubject=" + teacherSubject +
                ", parameter=" + parameter +
                ", messageForTeacher='" + messageForTeacher + '\'' +
                ", parameterCalification=" + parameterCalification +
                ", status=" + status +
                ", txUser=" + txUser +
                ", txDate=" + txDate +
                ", txHost='" + txHost + '\'' +
                '}';
    }
}
