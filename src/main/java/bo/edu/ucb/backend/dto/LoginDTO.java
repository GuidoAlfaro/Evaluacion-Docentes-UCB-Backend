package bo.edu.ucb.backend.dto;

public class LoginDTO {
    private String email;

    public LoginDTO() {
    }

    public LoginDTO(String email) {
        this.email = email;
    }

    // Getters and setters
    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString(){
        return "LoginDTO{" +
                "email='" + email + '\'' +
                '}';
    }
}
