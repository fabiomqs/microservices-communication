package com.github.fabiomqs.sender.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class JMSServiceImpl implements JMSService {

    private final JMSSender jmsSender;

    public JMSServiceImpl(JMSSender jmsSender) {
        this.jmsSender = jmsSender;
    }

    @Override
    public void send(String message) {
        log.info("Sending Message" + message);
        jmsSender.sendMessage(message);
    }
}
