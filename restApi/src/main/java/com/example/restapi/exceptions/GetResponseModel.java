package com.example.restapi.exceptions;

import java.util.List;
import com.example.restapi.domain.User;

/*
 * Generic response model to wrap responses in
 */
public class GetResponseModel {

    public List<User> data; // to hold user data from endpoint
    public String message; // to hold message to show to user
    // public boolean nextPage; // pagination

    public GetResponseModel(List<User> data, String message) {
        this.data = data;
        this.message = message;
    }
}
