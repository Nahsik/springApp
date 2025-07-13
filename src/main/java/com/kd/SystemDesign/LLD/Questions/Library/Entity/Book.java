package com.kd.SystemDesign.LLD.Questions.Library.Entity;

import com.kd.SystemDesign.LLD.Questions.Library.Enum.BookStatus;
import com.kd.SystemDesign.LLD.Questions.Library.Enum.Genre;
import lombok.Data;

@Data
public class Book {
    static int count = 1;
    private String isbn;
    private String title;
    private String author;
    private Genre genre;
    private String publisher;
    private int availableCopies;
    private int totalCopies;
    private BookStatus status;

    private Book(String isbn, String title, Genre genre, String author, String publisher,
                 int availableCopies,int totalCopies) {
        this.isbn = isbn;
        this.title = title;
        this.genre = genre;
        this.author = author;
        this.publisher = publisher;
        this.totalCopies = totalCopies;
        this.availableCopies = availableCopies;
        this.status = BookStatus.AVAILABLE;
    }


    public void borrowBook() {
        if (availableCopies > 0) {
            availableCopies--;
            if (availableCopies == 0) {
                status = BookStatus.NOT_AVAILABLE;
            }
        }
    }

    public void returnBook() {
        if (availableCopies < totalCopies) {
            availableCopies++;
            status = BookStatus.AVAILABLE;
        }
    }

}