package com.plugins.main;

import com.plugins.main.dto.ExampleDto;
import com.plugins.main.services.MainService;

import java.util.concurrent.ExecutionException;

public class ExampleDtoGetter {

    MainService service;

    public ExampleDtoGetter() {
        service = new MainService();
    }

    public ExampleDto getExampleDto() {
        ExampleDto dto = null;
        long id = 1;
        try {
            dto = service.getExampleDto(id).toCompletableFuture().get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        return dto;
    }

}
