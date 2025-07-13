package com.kd.SystemDesign.LLD.Questions.RideSharingService.Entity;

import lombok.Getter;

@Getter
public class User {
    private final String userId;
    private String name;
    private final String phoneNumber;
    private Address address;

    public User(String name, String phoneNumber, Address address) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.userId = phoneNumber;
        this.address = address;
    }

    public void updateAddress(Address address){
        this.address = address;
    }
}
