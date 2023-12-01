package bo.edu.ucb.backend.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class QuestionAnswerDTO {
    @JsonProperty("questionText")
    private String questionText;

    @JsonProperty("answers")
    private List<AnswerDTO> answers;

    public QuestionAnswerDTO() {
    }

    public QuestionAnswerDTO(String questionText, List<AnswerDTO> answers) {
        this.questionText = questionText;
        this.answers = answers;
    }

    public String getQuestionText() {
        return questionText;
    }

    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }

    public List<AnswerDTO> getAnswers() {
        return answers;
    }

    public void setAnswers(List<AnswerDTO> answers) {
        this.answers = answers;
    }

    @Override
    public String toString() {
        return "QuestionAnswerDTO{" +
                "questionText='" + questionText + '\'' +
                ", answers=" + answers +
                '}';
    }
}
