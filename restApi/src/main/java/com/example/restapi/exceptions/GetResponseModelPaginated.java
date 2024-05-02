package com.example.restapi.exceptions;

import java.util.List;
import com.example.restapi.domain.User;

public class GetResponseModelPaginated {

    public List<User> data;
    public String message;
    public Boolean nextPage;
    public Integer total;

    public GetResponseModelPaginated(List<User> data, String message, Boolean nextPage, Integer total) {
        this.data = data;
        this.message = message;
        this.nextPage = nextPage;
        this.total = total;
    }

}
