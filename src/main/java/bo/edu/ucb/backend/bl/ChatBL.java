// ChatBL.java
package bo.edu.ucb.backend.bl;

import bo.edu.ucb.backend.dto.*;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
public class ChatBL {
    private static final Logger log = org.slf4j.LoggerFactory.getLogger(ChatBL.class);

    @Value("${openai.apiKey}")
    private String apiKey;

    public String generateChat(ChatRequest chatRequest) {
        String apiUrl = "https://api.openai.com/v1/chat/completions";
        String content = chatRequest.getPrompt();
        RestTemplate restTemplate = new RestTemplate();

        // Define tu payload
        String prompt = String.join("\n", content);
        String payload = "{\"model\": \"gpt-4\", \"messages\": [{\"role\": \"system\", \"content\": \"You are a helpful assistant.\"}, {\"role\": \"user\", \"content\": \"" + prompt + "\"}]}";

        // Configura los encabezados de la solicitud
        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type", "application/json");
        headers.set("Authorization", "Bearer " + apiKey);
        HttpEntity<String> requestEntity = new HttpEntity<>(payload, headers);

        // Realiza la solicitud y devuelve la respuesta
        return restTemplate.postForEntity(apiUrl, requestEntity, String.class).getBody();
    }

    @Async
    public CompletableFuture<List<ChatResponse>> fetchAnswers(List<ParameterDTO> params){
        List<ChatResponse> answers = new ArrayList<>();

        for (ParameterDTO param : params) {
            String prompt = "A partir de la pregunta: ";
            for (QuestionAnswerDTO questionAnswerDTO : param.getData()) {
                prompt += questionAnswerDTO.getQuestionText() + "Y las respuestas son: ";
                for (AnswerDTO answerDTO : questionAnswerDTO.getAnswers()) {
                    prompt += answerDTO.getAnswerText() + ". ";
                }
            }
            String request = "Devuelve un JSON que contenga 2 objetos. El primer objeto 'messageForTeacher' es un mensaje (dirigido al docente) muy breve, pero preciso, que resume las respuestas de los estudiantes (solo es un breve resumen, no contiene consejos ni nada por el estilo). El segundo objeto 'parameterCalification' es una calificación del 1 al 100 (utiliza un decimal si es necesario), calculada en base a las respuestas de los estudiantes. No digas nada mas, solo dame el JSON";
            prompt += request;

            //log.info("Promt para chat gpt3: {}", prompt);
            //log.info("Envio de prompt a chat gpt3");

            String response = generateChat(new ChatRequest(prompt));
            log.info("Respuesta de chat gpt3: {}", response);

            // Procesar el contenido de 'content' como un string
            ChatResponse chatResponse = parseChatResponse(response);

            answers.add(chatResponse);
            log.info("Respuesta de chat gpt3 procesada: {}", chatResponse);
//            if(answers.size() == 3) {
//                break;
//            }
        }
        return CompletableFuture.completedFuture(answers);
    }

    //FIXME: LA VERDAD NO SE COMO FUNCIONA ESTO XD
    private ChatResponse parseChatResponse(String response) {
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            JsonNode rootNode = objectMapper.readTree(response);
            JsonNode contentNode = rootNode.path("choices").path(0).path("message").path("content");

            if (!contentNode.isMissingNode()) {
                String content = contentNode.asText();

                // Check if the content is enclosed in triple backticks
                if (content.startsWith("```") && content.endsWith("```")) {
                    // Remove triple backticks and unescape escaped double quotes
                    content = content.substring(3, content.length() - 3).replace("\\\"", "\"");
                } else if (content.startsWith("```json") && content.endsWith("```")) {
                    // Remove triple backticks and the "json" keyword
                    content = content.substring(7, content.length() - 3);
                }

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
