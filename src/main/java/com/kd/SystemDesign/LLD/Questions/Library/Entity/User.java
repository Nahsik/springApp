package com.kd.SystemDesign.LLD.Questions.Library.Entity;

import lombok.Data;

@Data
public abstract class User {
    private static int count = 0;
    private int userId;
    private String name;
    private String phoneNumber;
    private static final int MAX_ALLOWD_BOOKS = 5;

    public User(String name, String phoneNumber) {
        this.userId = count++;
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public abstract int getMaxAllowdBooks();
}
