package bo.edu.ucb.backend.dto;

public class UserTypeDTO {
    private String userType;

    public UserTypeDTO() {
    }

    public UserTypeDTO(String userType) {
        this.userType = userType;
    }

    public String getUserType() {
        return this.userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    @Override
    public String toString(){
        return "UserTypeDTO{" +
                "userType='" + userType + '\'' +
                '}';
    }
}
