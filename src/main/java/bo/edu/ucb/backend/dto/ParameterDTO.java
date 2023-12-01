package bo.edu.ucb.backend.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class ParameterDTO {
    @JsonProperty("parameter")
    private String parameter;

    @JsonProperty("data")
    private List<QuestionAnswerDTO> data;

    public ParameterDTO() {
    }

    public ParameterDTO(String parameter, List<QuestionAnswerDTO> data) {
        this.parameter = parameter;
        this.data = data;
    }

    public String getParameter() {
        return parameter;
    }

    public void setParameter(String parameter) {
        this.parameter = parameter;
    }

    public List<QuestionAnswerDTO> getData() {
        return data;
    }

    public void setData(List<QuestionAnswerDTO> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "ParameterDTO{" +
                "parameter='" + parameter + '\'' +
                ", data=" + data +
                '}';
    }
}
