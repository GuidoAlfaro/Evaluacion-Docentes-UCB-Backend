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
@Table(name = "account")
public class User {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Integer userId;

    @ManyToOne
    @JoinColumn(name = "user_type_id")
    private UserType userType;

    @Column(name = "first_names")
    private String firstNames;

    @Column(name = "last_names")
    private String lastNames;

    @Column (name = "email")
    private String email;

    @Column (name = "status")
    private short status;

    @Column (name = "tx_user")
    private String txUser;

    @Column (name = "tx_date")
    private Timestamp txDate;

    @Column (name = "tx_host")
    private String txHost;

    public User() {
    }

    public User(Integer userId, UserType userType, String firstNames, String lastNames, String email, short status, String txUser, Timestamp txDate, String txHost) {
        this.userId = userId;
        this.userType = userType;
        this.firstNames = firstNames;
        this.lastNames = lastNames;
        this.email = email;
        this.status = status;
        this.txUser = txUser;
        this.txDate = txDate;
        this.txHost = txHost;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }

    public String getFirstNames() {
        return firstNames;
    }

    public void setFirstNames(String firstNames) {
        this.firstNames = firstNames;
    }

    public String getLastNames() {
        return lastNames;
    }

    public void setLastNames(String lastNames) {
        this.lastNames = lastNames;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
        return "User{" +
                "userId=" + userId +
                ", userType=" + userType +
                ", firstNames='" + firstNames + '\'' +
                ", lastNames='" + lastNames + '\'' +
                ", email='" + email + '\'' +
                ", status=" + status +
                ", txUser='" + txUser + '\'' +
                ", txDate=" + txDate +
                ", txHost='" + txHost + '\'' +
                '}';
    }
}