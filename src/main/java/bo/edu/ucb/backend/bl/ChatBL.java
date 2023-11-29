// ChatBL.java
package bo.edu.ucb.backend.bl;

import bo.edu.ucb.backend.dto.ChatRequest;
import bo.edu.ucb.backend.dto.ChatResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ChatBL {
    @Value("${openai.apiKey}")
    private String apiKey;

    public String generateChat(ChatRequest chatRequest) {
        String apiUrl = "https://api.openai.com/v1/chat/completions";
        String content = chatRequest.getPrompt();
        RestTemplate restTemplate = new RestTemplate();

        // Define tu payload
        String prompt = String.join("\n", content);
        String payload = "{\"model\": \"gpt-3.5-turbo\", \"messages\": [{\"role\": \"system\", \"content\": \"You are a helpful assistant.\"}, {\"role\": \"user\", \"content\": \"" + prompt + "\"}]}";

        // Configura los encabezados de la solicitud
        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type", "application/json");
        headers.set("Authorization", "Bearer " + apiKey);
        HttpEntity<String> requestEntity = new HttpEntity<>(payload, headers);

        // Realiza la solicitud y devuelve la respuesta
        return restTemplate.postForEntity(apiUrl, requestEntity, String.class).getBody();
    }
}
