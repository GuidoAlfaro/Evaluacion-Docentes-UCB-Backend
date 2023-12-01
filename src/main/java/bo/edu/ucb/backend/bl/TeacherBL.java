package bo.edu.ucb.backend.bl;

import bo.edu.ucb.backend.dto.*;
import bo.edu.ucb.backend.entity.DetailedResult;
import bo.edu.ucb.backend.entity.TeacherQuery;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@Service
public class TeacherBL {
    private static final Logger log = org.slf4j.LoggerFactory.getLogger(TeacherBL.class);
    @Autowired
    private UserBL userBL;
    @Autowired
    private ChatBL chatBL;
    @Autowired
    private TeacherSubjectBL teacherSubjectBL;
    @Autowired
    private DetailedResultBL detailedResultBL;
    @Autowired
    private TeacherQueryBL teacherQueryBL;
    public Iterable<TeacherSubjectsDTO> findTeacherSubjects(Integer teacherUserId) {
        return userBL.findMateriasDocente(teacherUserId);
    }

    public void generateSubjectResults(List<ParameterDTO> parameterDTOList, Integer teacherSubjectId) throws ExecutionException, InterruptedException {
        CompletableFuture<List<ChatResponse>> chatResponses = chatBL.fetchAnswers(parameterDTOList);
        //Integer teacherSubjectId = teacherSubjectBL.findTeacherSubjectIdBySubjectEvaluation(subjectEvaluationId);
        log.info("El id del teacherSubject es: {}", teacherSubjectId);
        detailedResultBL.createDetailedResults(chatResponses, parameterDTOList, teacherSubjectId);
    }

    public TeacherQueryResponseDTO generateTeacherQuery(ChatRequest chatRequest, Integer teacherSubjectId) {
        TeacherQuery teacherQuery = new TeacherQuery();
        return teacherQueryBL.createTeacherQuery(teacherQuery, chatRequest);
    }


}