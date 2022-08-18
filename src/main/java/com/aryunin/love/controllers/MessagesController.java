package com.aryunin.love.controllers;

import com.aryunin.love.models.Message;
import com.aryunin.love.services.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
public class MessagesController {
    private final MessageService messageService;

    @Autowired
    public MessagesController(MessageService messageService) {
        this.messageService = messageService;
    }

    @GetMapping
    public String index(Model model) {
        model.addAttribute("messages", messageService.getAllMessages());
        return "index";
    }

    @GetMapping("/{id}")
    public String getMessage(Model model, @PathVariable("id") int id) {
        Optional<Message> message = messageService.findById(id);
        if(message.isPresent()) model.addAttribute("message", message.get());
        else return "redirect:/";
        return "message";
    }
}
