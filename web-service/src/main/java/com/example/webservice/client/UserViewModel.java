package com.example.webservice.client;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserViewModel {
    private int id;

    private String username;
   
    private String fullname;

    private String email;

    public UserViewModel(String username, String fullname, String email) {
        this.username = username;
        this.fullname = fullname;
        this.email = email;
    }


//    public UserViewModel(String username, String fullname) {
//
//    }
}
