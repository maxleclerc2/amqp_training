package fr.lernejo.chat;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ChatMessageController {
    @GetMapping("/api/message")
    public List<String> getTenLastMessages() {
        return ChatMessageListener.repo.getLastTenMessages();
    }
}
