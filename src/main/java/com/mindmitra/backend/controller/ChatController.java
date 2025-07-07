package com.mindmitra.backend.controller;

import com.mindmitra.backend.service.AIService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/chat")
@CrossOrigin(origins = "http://localhost:5174") // frontend port
public class ChatController {

    private final AIService aiService;

    public ChatController(AIService aiService) {
        this.aiService = aiService;
    }

    @PostMapping
    public String chatWithAI(@RequestBody String message) {
        return aiService.getAIReply(message);
    }
}
