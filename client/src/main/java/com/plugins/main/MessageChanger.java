package com.plugins.main;

import com.plugins.main.services.MainService;

import java.util.concurrent.ExecutionException;

public class MessageChanger {
    MainService service;

    public MessageChanger() {
        service = new MainService();
    }

    public String changeMessages(String message) throws ExecutionException, InterruptedException {
        String serverMessage = service.changeMessages(message).toCompletableFuture().get();
        return serverMessage;
    }
}
