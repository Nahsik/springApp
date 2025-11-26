package com.kd.springApp.repository;

import com.kd.springApp.entity.JournalEntry;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface JournalEntryRepository extends MongoRepository<JournalEntry, ObjectId> {

    @Query("select * from tableName where ")
    public JournalEntry findByIdAndName(String id,String name);

}
