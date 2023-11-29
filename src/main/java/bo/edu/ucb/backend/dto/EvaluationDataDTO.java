package bo.edu.ucb.backend.dto;

import java.util.List;

public class EvaluationDataDTO {
    private List<ParameterDTO> parameters;

    public EvaluationDataDTO(List<ParameterDTO> parameters) {
        this.parameters = parameters;
    }

    public List<ParameterDTO> getParameters() {
        return parameters;
    }

    public void setParameters(List<ParameterDTO> parameters) {
        this.parameters = parameters;
    }
}
