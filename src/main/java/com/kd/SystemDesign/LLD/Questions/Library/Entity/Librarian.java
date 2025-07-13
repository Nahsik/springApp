package com.kd.SystemDesign.LLD.Questions.Library.Entity;

import lombok.Getter;

@Getter
public class Librarian extends User {

    private static int count;
    private final String librarianId;

    public Librarian(String userId, String name, String phoneNumber) {
        super( name, phoneNumber);
        this.librarianId = "LA-" + count;
        count++;
    }

    @Override
    public int getMaxAllowdBooks() {
        return 1000;
    }
}
