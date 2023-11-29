package bo.edu.ucb.backend.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ChatResponse {
    @JsonProperty("messageForTeacher")
    private String messageForTeacher;

    @JsonProperty("parameterCalification")
    private Double parameterCalification;

    // Constructor, getters y setters

    // Constructor por defecto necesario para la deserialización
    public ChatResponse() {
    }

    public ChatResponse(String messageForTeacher, Double parameterCalification) {
        this.messageForTeacher = messageForTeacher;
        this.parameterCalification = parameterCalification;
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
        return "ChatResponse{" +
                "messageForTeacher='" + messageForTeacher + '\'' +
                ", parameterCalification=" + parameterCalification +
                '}';
    }
}
