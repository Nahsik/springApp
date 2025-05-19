package com.kd.springApp.entity;

import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Data
@Document(collection = "journal_entry")
public class JournalEntry {

    @Id
    private ObjectId id;

    private String name;
    private String data;
    private LocalDate date;
}
