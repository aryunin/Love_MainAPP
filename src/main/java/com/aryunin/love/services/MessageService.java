package com.aryunin.love.services;

import com.aryunin.love.models.Message;
import com.aryunin.love.repositories.MessagesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MessageService {
    private final MessagesRepository messagesRepository;

    @Autowired
    public MessageService(MessagesRepository messagesRepository) {
        this.messagesRepository = messagesRepository;
    }

    public List<Message> getAllMessages() {
        return messagesRepository.findAll(Sort.by("date"));
    }

    public Optional<Message> findById(int id) {
        return messagesRepository.findById(id);
    }
}
