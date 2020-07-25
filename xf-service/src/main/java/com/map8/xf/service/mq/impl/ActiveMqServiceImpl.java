package com.map8.xf.service.mq.impl;

import com.map8.xf.service.mq.ActiveMqService;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * zhangfei
 */
@Service
public class ActiveMqServiceImpl implements ActiveMqService {

    private JmsTemplate jmsTemplate = new JmsTemplate();

    @Override
    public void sendMsg(String message) {
        System.out.println("发送消息【"+message+"】");
        jmsTemplate.convertAndSend(message);
    }

    @JmsListener(destination = "${spring.jms.template.default-destination}")
    @Override
    public void receiveMsg(String message) {
        System.out.println("接收到信息：【"+message+"]");
    }
}
