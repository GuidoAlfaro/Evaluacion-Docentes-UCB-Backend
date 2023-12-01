package bo.edu.ucb.backend.dto;

public class TeacherQueryResponseDTO {
    private String response;

    public TeacherQueryResponseDTO() {
    }

    public TeacherQueryResponseDTO(String response) {
        this.response = response;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    @Override
    public String toString() {
        return "TeacherQueryResponseDTO{" +
                "response='" + response + '\'' +
                '}';
    }
}