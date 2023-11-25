package bo.edu.ucb.backend.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "question")
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer questionId;

    @ManyToOne
    @JoinColumn(name = "evaluation_id")
    private Evaluation evaluation;

    @Column(name = "question_text")
    private String questionText;

    @Column(name = "status")
    private boolean status;

    public Question() {
    }

    public Question(Integer questionId, Evaluation evaluation, String questionText, boolean status) {
        this.questionId = questionId;
        this.evaluation = evaluation;
        this.questionText = questionText;
        this.status = status;
    }

    public Integer getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Integer questionId) {
        this.questionId = questionId;
    }

    public Evaluation getEvaluation() {
        return evaluation;
    }

    public void setEvaluation(Evaluation evaluation) {
        this.evaluation = evaluation;
    }

    public String getQuestionText() {
        return questionText;
    }

    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Question{" +
                "questionId=" + questionId +
                ", evaluation=" + evaluation +
                ", questionText='" + questionText + '\'' +
                ", status=" + status +
                '}';
    }
}
