package com.map8.xf.service.mq;

public interface ActiveMqService {
    public void sendMsg(String message);
    public void receiveMsg(String message);
}
