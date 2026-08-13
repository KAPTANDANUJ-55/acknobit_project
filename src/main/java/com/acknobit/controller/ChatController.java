package com.acknobit.controller;

import com.acknobit.dto.ChatRequest;
import com.acknobit.dto.ChatResponse;
import org.springframework.ai.chat.messages.SystemMessage;
import org.springframework.ai.chat.messages.UserMessage;
import org.springframework.ai.chat.model.ChatModel;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/chat")
@CrossOrigin(origins = "*")
public class ChatController {

    private final ChatModel chatModel;


    public ChatController(ChatModel chatModel) {
        this.chatModel = chatModel;
    }

    @PostMapping
    public ChatResponse chat(@RequestBody ChatRequest request) {

        String systemInstructions = """
            You are Acknobit AI, an automation & technical guidance assistant for Acknobit platform.
            
            STRICT RULES TO FOLLOW:
            1. DO NOT write or generate full automation code, ready-made scripts, or ready-to-use workflows for the user.
            2. Instead, GUIDE the user step-by-step on how they can build it themselves (e.g., 'Go to X settings', 'Use Y tool/API', 'Configure Z parameter').
            3. Keep your answers concise, structured, and easy to follow.
            4. Always maintain a helpful, professional, and guiding tone as Acknobit AI.
            5. If any one writes garbage messages different from your main core nature (like if someone says dance you mad etc) you will say sorry i cant understand what you're saying kindly tell in which thing thing i will help you
            """;


        SystemMessage systemMessage = new SystemMessage(systemInstructions);
        UserMessage userMessage = new UserMessage(request.message());
        Prompt prompt = new Prompt(systemMessage, userMessage);

        String aiReply = chatModel.call(prompt).getResult().getOutput().getText();
        return new ChatResponse(aiReply);
    }
}