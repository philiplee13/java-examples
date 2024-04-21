/**
 * This file is used for the domain
 * This should be the Identicial to whatever row we are extracting from a given database
 * So in this example, it should mirror the "users" that we're pulling out
 * This domain will be used in both Dao folder for the row mapper in the dao folder
 */

package com.example.restapi.domain;

public class User {
    public String firstName; // without public keyword - it defaults to private
    // so need to do this -
    // https://stackoverflow.com/questions/59578802/jackson-no-serializer-found-for-class-and-no-properties-discovered-to-cre
    public String lastName;
    public String email;

    public User() {
    };

    public User(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    @Override
    // needed to print out actual result
    public String toString() {
        return "User{" +
                "first_name=" + firstName +
                ", last_name='" + lastName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
