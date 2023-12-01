package bo.edu.ucb.backend.bl;

import bo.edu.ucb.backend.dto.*;
import bo.edu.ucb.backend.entity.DetailedResult;
import bo.edu.ucb.backend.entity.SubjectResult;
import bo.edu.ucb.backend.entity.TeacherQuery;
import bo.edu.ucb.backend.entity.TeacherSubject;
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
    @Autowired
    private SubjectResultBL subjectResultBL;
    public Iterable<TeacherSubjectsDTO> findTeacherSubjects(Integer teacherUserId) {
        return userBL.findMateriasDocente(teacherUserId);
    }

    public void generateSubjectResults(List<ParameterDTO> parameterDTOList, Integer teacherSubjectId) throws ExecutionException, InterruptedException {
        CompletableFuture<List<ChatResponse>> chatResponses = chatBL.fetchAnswers(parameterDTOList);
        //log.info("El id del teacherSubject es: {}", teacherSubjectId);

        // para el detalle se guardara en detailedResult
        detailedResultBL.createDetailedResults(chatResponses, parameterDTOList, teacherSubjectId);

        //para el ranking se guardara en subjectResult
        saveSubjectResults(teacherSubjectId);
    }

    public TeacherQueryResponseDTO generateTeacherQuery(ChatRequest chatRequest, Integer teacherSubjectId) {
        TeacherQuery teacherQuery = new TeacherQuery();

        TeacherSubject teacherSubject = new TeacherSubject();
        teacherSubject.setTeacherSubjectId(teacherSubjectId);
        teacherQuery.setTeacherSubject(teacherSubject);
        return teacherQueryBL.createTeacherQuery(teacherQuery, chatRequest);
    }

    public List<TeacherQueryDTO> findAllTeacherQueries(Integer teacherSubjectId) {
        return teacherQueryBL.findAllTeacherQueries(teacherSubjectId);
    }


    public TeacherQuery updateTeacherQuery(Integer teacherQueryId) {
        try{
            return teacherQueryBL.updateTeacherQuery(teacherQueryId);
        }catch (Exception ex){
            log.error("Ocurrio un error mientras se actualizaba la consulta del profesor: ", ex);
            throw new RuntimeException("Ocurrio un error mientras se actualizaba la consulta del profesor");
        }
    }

    public List<EvaluationDetailDTO> findTeacherSubjectDetails(Integer teacherSubjectId) {
        return userBL.findTeacherSubjectDetails(teacherSubjectId);
    }

    // ranking
    public void saveSubjectResults(Integer teacherSubjectId) {
        subjectResultBL.createSubjectResult(teacherSubjectId);
    }

    public List<RankingDTO> findRanking() {
        return subjectResultBL.fetchRanking();
    }


}