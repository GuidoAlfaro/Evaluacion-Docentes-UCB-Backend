package bo.edu.ucb.backend.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AnswerDTO {
    @JsonProperty("answerText")
    private String answerText;

    public AnswerDTO() {
    }

    public AnswerDTO(String answerText) {
        this.answerText = answerText;
    }

    public String getAnswerText() {
        return answerText;
    }

    public void setAnswerText(String answerText) {
        this.answerText = answerText;
    }

    @Override
    public String toString() {
        return "AnswerDTO{" +
                "answerText='" + answerText + '\'' +
                '}';
    }
}
