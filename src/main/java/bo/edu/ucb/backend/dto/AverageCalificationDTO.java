package bo.edu.ucb.backend.dto;

public class AverageCalificationDTO {
    private Double averageCalification;

    public AverageCalificationDTO() {
    }

    public AverageCalificationDTO(Double averageCalification) {
        this.averageCalification = averageCalification;
    }

    public Double getAverageCalification() {
        return averageCalification;
    }

    public void setAverageCalification(Double averageCalification) {
        this.averageCalification = averageCalification;
    }

    @Override
    public String toString() {
        return "AverageCalificationDTO{" +
                "averageCalification=" + averageCalification +
                '}';
    }
}
