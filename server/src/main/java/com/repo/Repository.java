package com.repo;

import com.dto.ExampleDto;
import com.service.DatabaseService;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

/**
 * A class for work with repository.
 * */

@ApplicationScoped
public class Repository {

    @Inject
    DatabaseService databaseService;

    public String changeMessage(String message) {
        String ans = "\n - client message: " + message +
                "\n - server answer: Hi, client, I am a Server !\n";
        return ans;
    }

    public ExampleDto getExanpleDto(long id) {
        ExampleDto dto = new ExampleDto();
        dto.setId(id);
        dto.setName("Example Dto");
        return dto;
    }
}
