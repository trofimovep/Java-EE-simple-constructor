package com.service;

import com.dto.ExampleDto;
import com.repo.Repository;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;


@RequestScoped
public class ServerService {

    @Inject
    Repository repository = new Repository();

    public String changeMessages(String message) {
        return repository.changeMessage(message);
    }

    public ExampleDto getExanpleDto(long id) {
        return repository.getExanpleDto(id);
    }

}
