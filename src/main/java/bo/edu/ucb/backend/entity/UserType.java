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
    private Integer user_type_id;

    @Column(name = "description")
    private String description;

    public UserType() {
    }

    public UserType(Integer user_type_id, String description) {
        this.user_type_id = user_type_id;
        this.description = description;
    }

    public Integer getUser_type_id() {
        return this.user_type_id;
    }

    public void setUser_type_id(Integer user_type_id) {
        this.user_type_id = user_type_id;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString(){
        return "UserType{" +
                "user_type_id=" + user_type_id +
                ", description='" + description + '\'' +
                '}';
    }
}
