package bo.edu.ucb.backend.bl;

import bo.edu.ucb.backend.dao.TeacherQueryDAO;
import bo.edu.ucb.backend.dto.ChatRequest;
import bo.edu.ucb.backend.dto.ChatResponse;
import bo.edu.ucb.backend.dto.TeacherQueryResponseDTO;
import bo.edu.ucb.backend.entity.DetailedResult;
import bo.edu.ucb.backend.entity.TeacherQuery;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class TeacherQueryBL {
    private static final Logger LOG = org.slf4j.LoggerFactory.getLogger(TeacherQueryBL.class);
    @Autowired
    private TeacherQueryDAO teacherQueryDAO;
    @Autowired
    private ChatBL chatBL;
    @Autowired
    private DetailedResultBL detailedResultBL;
    public TeacherQueryResponseDTO createTeacherQuery(TeacherQuery teacherQuery, ChatRequest chatRequest) {
        try {
            List<ChatResponse> chatResponses = new ArrayList<>();
            chatResponses = detailedResultBL.findDetailedResultsByTeacherSubjectId(teacherQuery.getTeacherSubject().getTeacherSubjectId());
            String promt = "A partir de estos feedbacks: ";
            for (ChatResponse chatResponse : chatResponses) {
                promt += chatResponse.getMessageForTeacher() + ". ";
            }
            promt+= "Responde a esta pregunta realizada por el docente: " + chatRequest.getPrompt();
            LOG.info("Prompt para el chat {}", promt);
            String response = chatBL.generateChat(chatRequest);
            teacherQuery.setQueryText(chatRequest.getPrompt());
            teacherQuery.setApiResponse(response);
            Date date = new Date();
            teacherQuery.setDate(date);
            teacherQuery.setStatus((short) 1);
            teacherQuery.setTxUser("guidoalfaro");
            teacherQuery.setTxHost("192.168.277.0");
            LOG.info("Guardando la consulta del profesor");
            teacherQueryDAO.save(teacherQuery);
            return new TeacherQueryResponseDTO(response);
        } catch (Exception ex) {
            LOG.error("Ocurrio un error mientras se guardaba la consulta del profesor: ", ex);
            throw new RuntimeException("Ocurrio un error mientras se guardaba la consulta del profesor");
        }
    }
}
