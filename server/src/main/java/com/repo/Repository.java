package com.repo;

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
        return "Ok, I got ur message, and i am the server!";
    }
}
