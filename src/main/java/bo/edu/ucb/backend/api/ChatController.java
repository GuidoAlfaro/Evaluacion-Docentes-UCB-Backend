package bo.edu.ucb.backend.api;

import bo.edu.ucb.backend.dto.ChatRequest;
import bo.edu.ucb.backend.dto.ChatResponse;
import bo.edu.ucb.backend.dto.ResponseDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@RestController
@RequestMapping("/api/v1")
public class ChatController {

    @Value("${openai.apiKey}")
    private String apiKey;

    @PostMapping("/generate")
    public ResponseEntity<String> generateChat(@RequestBody ChatRequest chatRequest) {
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

        // Realiza la solicitud
        return restTemplate.postForEntity(apiUrl, requestEntity, String.class);
    }
}
