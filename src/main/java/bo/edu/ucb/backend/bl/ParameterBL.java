package bo.edu.ucb.backend.bl;

import bo.edu.ucb.backend.dao.ParameterDAO;
import bo.edu.ucb.backend.dto.AnswerDTO;
import bo.edu.ucb.backend.dto.ParameterDTO;
import bo.edu.ucb.backend.dto.QuestionAnswerDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class ParameterBL {

    @Autowired
    private ParameterDAO parameterDAO;

    public List<ParameterDTO> findParametersAndQuestionsWithAnswers(Integer subjectEvaluationId) {
        List<String> parameterDescriptions = parameterDAO.findParametersUsedInCurrentEvaluation();
        List<ParameterDTO> result = new ArrayList<>();

        for (String paramDescription : parameterDescriptions) {
            List<Object[]> questionAnswerPairs = parameterDAO.findQuestionsAndAnswersByParameterAndEvaluation(paramDescription, subjectEvaluationId);

            Map<String, List<AnswerDTO>> questionAnswerMap = new HashMap<>();

            for (Object[] pair : questionAnswerPairs) {
                String questionText = (String) pair[0];
                String answerText = (String) pair[1];

                questionAnswerMap.computeIfAbsent(questionText, key -> new ArrayList<>())
                        .add(new AnswerDTO(answerText));
            }

            List<QuestionAnswerDTO> questionAnswerDTOs = questionAnswerMap.entrySet().stream()
                    .map(entry -> new QuestionAnswerDTO(entry.getKey(), entry.getValue()))
                    .collect(Collectors.toList());

            result.add(new ParameterDTO(paramDescription, questionAnswerDTOs));
        }
        return result;
    }
}