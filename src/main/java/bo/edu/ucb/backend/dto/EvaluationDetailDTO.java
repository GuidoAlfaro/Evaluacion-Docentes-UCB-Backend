package bo.edu.ucb.backend.dto;

public class EvaluationDetailDTO {
    private String parameter;
    private String messageForTeacher;
    private Double parameterCalification;

    public EvaluationDetailDTO() {
    }

    public EvaluationDetailDTO(String parameter, String messageForTeacher, Double parameterCalification) {
        this.parameter = parameter;
        this.messageForTeacher = messageForTeacher;
        this.parameterCalification = parameterCalification;
    }

    public String getParameter() {
        return parameter;
    }

    public void setParameter(String parameter) {
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

    @Override
    public String toString() {
        return "EvaluationDetailDTO{" +
                "parameter='" + parameter + '\'' +
                ", messageForTeacher='" + messageForTeacher + '\'' +
                ", parameterCalification='" + parameterCalification + '\'' +
                '}';
    }
}
