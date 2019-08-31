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

        String ans = "Ok, I got ur message, and i am the server!\n"+
         " and ur message is: \n" + message;

        return ans;
    }
}
