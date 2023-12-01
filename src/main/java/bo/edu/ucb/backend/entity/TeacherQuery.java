package bo.edu.ucb.backend.entity;

import jakarta.persistence.*;

import java.sql.Timestamp;
import java.util.Date;

@Entity
@Table(name = "teacher_query")
public class TeacherQuery {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer teacherQueryId;
    @ManyToOne
    @JoinColumn(name = "teacher_subject_id")
    private TeacherSubject teacherSubject;

    @Column(name = "query_text")
    private String queryText;

    @Column(name = "api_response")
    private String apiResponse;

    @Column(name = "date")
    private Date date;

    @Column(name = "status")
    private short status;

    @Column(name = "tx_user")
    private String txUser;

    @Column(name = "tx_date")
    private Timestamp txDate;

    @Column(name = "tx_host")
    private String txHost;

    public TeacherQuery() {
    }

    public TeacherQuery(Integer teacherQueryId, TeacherSubject teacherSubject, String queryText, String apiResponse, Date date, short status, String txUser, Timestamp txDate, String txHost) {
        this.teacherQueryId = teacherQueryId;
        this.teacherSubject = teacherSubject;
        this.queryText = queryText;
        this.apiResponse = apiResponse;
        this.date = date;
        this.status = status;
        this.txUser = txUser;
        this.txDate = txDate;
        this.txHost = txHost;
    }

    public Integer getTeacherQueryId() {
        return teacherQueryId;
    }

    public void setTeacherQueryId(Integer teacherQueryId) {
        this.teacherQueryId = teacherQueryId;
    }

    public TeacherSubject getTeacherSubject() {
        return teacherSubject;
    }

    public void setTeacherSubject(TeacherSubject teacherSubject) {
        this.teacherSubject = teacherSubject;
    }

    public String getQueryText() {
        return queryText;
    }

    public void setQueryText(String queryText) {
        this.queryText = queryText;
    }

    public String getApiResponse() {
        return apiResponse;
    }

    public void setApiResponse(String apiResponse) {
        this.apiResponse = apiResponse;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
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
        return "TeacherQuery{" +
                "teacherQueryId=" + teacherQueryId +
                ", teacherSubject=" + teacherSubject +
                ", queryText='" + queryText + '\'' +
                ", apiResponse='" + apiResponse + '\'' +
                ", date=" + date +
                ", status=" + status +
                ", txUser=" + txUser +
                ", txDate=" + txDate +
                ", txHost='" + txHost + '\'' +
                '}';
    }
}
