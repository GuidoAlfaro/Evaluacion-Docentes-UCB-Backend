package bo.edu.ucb.backend.bl;

import bo.edu.ucb.backend.dto.*;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class TeacherBL {
    private static final Logger log = org.slf4j.LoggerFactory.getLogger(TeacherBL.class);
    @Autowired
    private UserBL userBL;
    @Autowired
    private ChatBL chatBL;
    public Iterable<TeacherSubjectsDTO> findTeacherSubjects(Integer teacherUserId) {
        return userBL.findMateriasDocente(teacherUserId);
    }

    public List<ChatResponse> fetchAnswers(List<ParameterDTO> params) throws InterruptedException {
        List<ChatResponse> answers = new ArrayList<>();

        for (ParameterDTO param : params) {
            String prompt = "A partir de la pregunta: ";
            for (QuestionAnswerDTO questionAnswerDTO : param.getData()) {
                prompt += questionAnswerDTO.getQuestionText() + "Y las respuestas son: ";
                for (AnswerDTO answerDTO : questionAnswerDTO.getAnswers()) {
                    prompt += answerDTO.getAnswerText() + ". ";
                }
            }
            String request = "Devuelve un JSON que contenga 2 objetos. El primer objeto 'messageForTeacher' es un mensaje (dirigido al docente) muy breve, pero preciso, que resume las respuestas de los estudiantes (solo es un breve resumen, no contiene consejos ni nada por el estilo). El segundo objeto 'parameterCalification' es una calificación del 1 al 100 (utiliza un decimal si es necesario), calculada en base a las respuestas de los estudiantes.";
            prompt += request;

            log.info("Promt para chat gpt3: {}", prompt);
            log.info("Envio de prompt a chat gpt3");

            String response = chatBL.generateChat(new ChatRequest(prompt));
            log.info("Respuesta de chat gpt3: {}", response);

            // Procesar el contenido de 'content' como un string
            ChatResponse chatResponse = parseChatResponse(response);

            answers.add(chatResponse);
            log.info("Respuesta de chat gpt3 procesada: {}", chatResponse);
            if(answers.size() == 3) {
                break;
            }
        }
        return answers;
    }

    private ChatResponse parseChatResponse(String response) {
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            JsonNode rootNode = objectMapper.readTree(response);
            JsonNode contentNode = rootNode.path("choices").path(0).path("message").path("content");

            if (!contentNode.isMissingNode()) {
                String content = contentNode.asText();
                return objectMapper.readValue(content, ChatResponse.class);
            } else {
                log.error("Formato de respuesta no válido: {}", response);
                return new ChatResponse("Error al procesar la respuesta", 0.0);
            }
        } catch (IOException e) {
            log.error("Error al procesar la respuesta: {}", e.getMessage());
            return new ChatResponse("Error al procesar la respuesta", 0.0);
        }
    }

}