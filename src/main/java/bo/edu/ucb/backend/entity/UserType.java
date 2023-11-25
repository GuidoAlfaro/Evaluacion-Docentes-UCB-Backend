package bo.edu.ucb.backend.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "user_type")
public class UserType {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userTypeId;

    @Column(name = "description")
    private String description;

    @Column(name = "status")
    private boolean status;

    public UserType() {
    }

    public UserType(Integer userTypeId, String description, boolean status) {
        this.userTypeId = userTypeId;
        this.description = description;
        this.status = status;
    }

    public Integer getUserTypeId() {
        return this.userTypeId;
    }

    public void setUserTypeId(Integer userTypeId) {
        this.userTypeId = userTypeId;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getStatus() {
        return this.status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "{" +
            " userTypeId='" + getUserTypeId() + "'" +
            ", description='" + getDescription() + "'" +
            ", status='" + getStatus() + "'" +
            "}";
    }
}
