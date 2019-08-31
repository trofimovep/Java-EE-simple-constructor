package com.plugins.main;

import com.plugins.main.services.MainService;

import java.util.concurrent.ExecutionException;

public class MessageChanger {
    MainService service;

    public MessageChanger() {
        service = new MainService();
    }

    public String changeMessages(String message) {
        String serverMessage = null;
        try {
            serverMessage = service.changeMessages(message).toCompletableFuture().get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        return serverMessage;
    }
}
