package com.kd.SystemDesign.LLD.Questions.Library.Entity;

import lombok.Getter;

@Getter
public class Member extends User {
    private static int count = 0;
    private final String memberId;

    public Member(String userId, String name, String phoneNumber) {
        super( name, phoneNumber);
        this.memberId = "MA-" + count;
        count++;
    }

    @Override
    public int getMaxAllowdBooks() {
        return 10;
    }

}
