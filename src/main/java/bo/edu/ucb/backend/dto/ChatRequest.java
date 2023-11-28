package bo.edu.ucb.backend.dto;

import java.util.List;

public class ChatRequest {
    private String prompt;
    public ChatRequest() {
    }

    public ChatRequest(String prompt) {
        this.prompt = prompt;
    }

    public String getPrompt() {
        return prompt;
    }

    public void setPrompt(String prompt) {
        this.prompt = prompt;
    }

    @Override
    public String toString() {
        return "ChatRequest{" +
                "prompt='" + prompt + '\'' +
                '}';
    }
}
