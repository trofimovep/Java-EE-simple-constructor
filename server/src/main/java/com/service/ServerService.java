package com.service;

import com.repo.Repository;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;


@RequestScoped
public class ServerService {


    @Inject
    Repository repository = new Repository();

    public String changeMessages(String message) {
        return repository.changeMessage(message);
    }


}
