package com.kd.SystemDesign.LLD.Questions.RideSharingService1.Entity;

import lombok.Data;

@Data
public class User {
    private String id;
    private String name;
    private final String phoneNumber;

    public User(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber =phoneNumber;
    }
}
