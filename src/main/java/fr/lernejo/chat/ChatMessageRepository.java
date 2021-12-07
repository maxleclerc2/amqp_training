package fr.lernejo.chat;

import java.util.LinkedList;
import java.util.List;

public class ChatMessageRepository {
    List<String> messageList = new LinkedList<>();

    public void addChatMessage(String message) {
        messageList.add(message);
    }

    public List<String> getLastTenMessages() {
        List<String> list = new LinkedList<>();

        if (messageList.size() > 9) {
            for (int i = messageList.size() - 10; i < messageList.size(); i++) {
                list.add(messageList.get(i));
            }
        } else {
            list.addAll(messageList);
        }

        return list;
    }
}
