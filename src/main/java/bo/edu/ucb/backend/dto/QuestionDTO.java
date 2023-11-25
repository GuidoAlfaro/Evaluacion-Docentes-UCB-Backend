package bo.edu.ucb.backend.dto;

public class QuestionDTO {
    private Integer questionId;
    private String questionText;

    public QuestionDTO() {
    }

    public QuestionDTO(Integer questionId, String questionText) {
        this.questionId = questionId;
        this.questionText = questionText;
    }

    public Integer getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Integer questionId) {
        this.questionId = questionId;
    }

    public String getQuestionText() {
        return questionText;
    }

    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }

    @Override
    public String toString() {
        return "QuestionDTO{" +
                "questionId=" + questionId +
                ", questionText='" + questionText + '\'' +
                '}';
    }
}
