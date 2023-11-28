package bo.edu.ucb.backend.dto;
public class ChatResponse {
    private String assistantMessage;
    private Double parameterCalification;

    public ChatResponse(String assistantMessage, Double parameterCalification) {
        this.assistantMessage = assistantMessage;
        this.parameterCalification = parameterCalification;
    }

    public String getAssistantMessage() {
        return assistantMessage;
    }

    public void setAssistantMessage(String assistantMessage) {
        this.assistantMessage = assistantMessage;
    }

    public Double getParameterCalification() {
        return parameterCalification;
    }

    public void setParameterCalification(Double parameterCalification) {
        this.parameterCalification = parameterCalification;
    }
}
