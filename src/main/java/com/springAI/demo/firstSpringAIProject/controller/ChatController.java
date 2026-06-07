package com.springAI.demo.firstSpringAIProject.controller;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class ChatController {

    private ChatClient chatClient;

    public ChatController(ChatClient.Builder builder) {
        this.chatClient = builder.build();
    }

    @GetMapping("/ollama/chat")
    public ResponseEntity ollamaChat(@RequestParam(value = "q") String query) {
        String response = chatClient.prompt(query).call().content();
        return ResponseEntity.ok(response);
    }

}
