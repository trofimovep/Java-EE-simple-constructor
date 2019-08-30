package com.app;

import com.plugins.main.MessageChanger;

import java.util.Locale;
import java.util.concurrent.ExecutionException;

public class App {

    public static void main(String[] args) {

        Locale.setDefault(new Locale("ru", "RU"));
        System.setProperty("server", "http://127.0.0.1:8080/");
        System.setProperty("server.uri", System.getProperty("server") + "server/");


        MessageChanger messageChanger = new MessageChanger();
        try {
            messageChanger.changeMessages("Hi, I am client!");
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}
