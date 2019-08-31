package com.app;

import com.plugins.main.ExampleDtoGetter;
import com.plugins.main.MessageChanger;
import com.plugins.main.dto.ExampleDto;

import java.util.Locale;

public class App {

    public static void main(String[] args) {

        Locale.setDefault(new Locale("ru", "RU"));
        System.setProperty("server", "http://127.0.0.1:8080/");
        System.setProperty("server.uri", System.getProperty("server") + "server/");

        // get string example
        MessageChanger messageChanger = new MessageChanger();
        String serverMess = messageChanger.changeMessages("Hi, I am a client !");

        // get object example
        ExampleDtoGetter dtoGetter = new ExampleDtoGetter();
        ExampleDto dto = dtoGetter.getExampleDto();

        System.out.println("=========================");
        System.out.println("+++++++++ Success !+++++++++");
        System.out.println("Get String from Server");
        System.out.println(serverMess);
        System.out.println("++++++++++++++++++++++++++++");
        System.out.println("Get Object from Server: ");
        System.out.println("id : " + dto.getId());
        System.out.println("name : " + dto.getName());
        System.out.println("=========================");
    }

}
