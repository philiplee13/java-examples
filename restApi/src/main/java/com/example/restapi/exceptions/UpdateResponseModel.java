package com.example.restapi.exceptions;

import com.example.restapi.domain.User;

// to be used in create, updates, or deletes
public class UpdateResponseModel {

    public Integer numberOfRowsAffected; // to hold num of rows affected
    public String message; // to hold message to return

    public UpdateResponseModel(Integer numberOfRowsAffected, String message) {
        this.numberOfRowsAffected = numberOfRowsAffected;
        this.message = message;
    }

}
