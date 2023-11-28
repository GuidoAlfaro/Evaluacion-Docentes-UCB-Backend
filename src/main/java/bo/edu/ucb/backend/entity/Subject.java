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
    private short status;

    @Column(name = "tx_user")
    private String txUser;

    @Column(name = "tx_date")
    private String txDate;

    @Column(name = "tx_host")
    private String txHost;
    public Subject() {
    }

    public Subject(Integer subjectId, String name, String parallel, String semester, String year, short status, String txUser, String txDate, String txHost) {
        this.subjectId = subjectId;
        this.name = name;
        this.parallel = parallel;
        this.semester = semester;
        this.year = year;
        this.status = status;
        this.txUser = txUser;
        this.txDate = txDate;
        this.txHost = txHost;
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

    public String getTxDate() {
        return txDate;
    }

    public void setTxDate(String txDate) {
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
        return "Subject{" +
                "subjectId=" + subjectId +
                ", name='" + name + '\'' +
                ", parallel='" + parallel + '\'' +
                ", semester='" + semester + '\'' +
                ", year='" + year + '\'' +
                ", status=" + status +
                ", txUser='" + txUser + '\'' +
                ", txDate='" + txDate + '\'' +
                ", txHost='" + txHost + '\'' +
                '}';
    }
}
