package bo.edu.ucb.backend.api;

import bo.edu.ucb.backend.bl.ChatBL;
import bo.edu.ucb.backend.dto.ChatRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class ChatController {

    @Autowired
    private ChatBL chatBL;

    @PostMapping("/generate")
    public ResponseEntity<String> generateChat(@RequestBody ChatRequest chatRequest) throws InterruptedException {
        // Llama a la capa de lógica de negocio
        //String response = chatBL.generateChat(chatRequest);
        return ResponseEntity.ok("Hola");
    }
}