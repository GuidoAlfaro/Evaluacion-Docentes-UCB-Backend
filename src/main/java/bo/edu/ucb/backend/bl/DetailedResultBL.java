package bo.edu.ucb.backend.bl;

import bo.edu.ucb.backend.dao.DetailedResultDAO;
import bo.edu.ucb.backend.dto.ChatResponse;
import bo.edu.ucb.backend.dto.ParameterDTO;
import bo.edu.ucb.backend.entity.DetailedResult;
import bo.edu.ucb.backend.entity.Parameter;
import bo.edu.ucb.backend.entity.TeacherSubject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@Service
public class DetailedResultBL {
    private static final org.slf4j.Logger LOG = org.slf4j.LoggerFactory.getLogger(DetailedResultBL.class);
    @Autowired
    private DetailedResultDAO detailedResultDAO;
    public DetailedResult createDetailedResult(DetailedResult detailedResult) {
        return detailedResultDAO.save(detailedResult);
    }

    public void createDetailedResults(CompletableFuture<List<ChatResponse>> chatResponses, List<ParameterDTO> parameters, Integer subjectEvaluationId) throws ExecutionException, InterruptedException {

        TeacherSubject teacherSubject = new TeacherSubject();

        teacherSubject.setTeacherSubjectId(subjectEvaluationId);
        LOG.info("Cantidad de respuestas: {}", chatResponses.get().size());
        for (int i = 0; i < chatResponses.get().size(); i++) {
            DetailedResult detailedResultToSave = new DetailedResult();
            detailedResultToSave.setTeacherSubject(teacherSubject);

            Parameter parameter = new Parameter();
            parameter.setParameterId(Integer.parseInt(parameters.get(i).getParameter()));

            LOG.info("El id del parametro es: {}", parameter.getParameterId());

            detailedResultToSave.setParameter(parameter);
            detailedResultToSave.setMessageForTeacher(chatResponses.get().get(i).getMessageForTeacher());
            detailedResultToSave.setParameterCalification(chatResponses.get().get(i).getParameterCalification());
            detailedResultToSave.setStatus((short) 1);
            detailedResultToSave.setTxUser("guidoalfaro");
            detailedResultToSave.setTxHost("192.168.207.0");

            LOG.info("resultado para el docente {}",detailedResultToSave.toString());
            detailedResultDAO.save(detailedResultToSave);
        }

    }
}
