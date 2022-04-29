package com.github.fabiomqs.sender.resources;

import com.github.fabiomqs.sender.service.JMSService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/home")
@RestController
public class HomeResource {

    private final JMSService jmsService;

    public HomeResource(JMSService jmsService) {
        this.jmsService = jmsService;
    }

    @GetMapping("/send/{message}")
    public void sendMessage(@PathVariable String message) {
        jmsService.send(message);
    }
}
