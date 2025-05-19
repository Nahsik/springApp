package com.kd.springApp.services;

import com.kd.springApp.entity.JournalEntry;
import com.kd.springApp.repository.JournalEntryRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class JournalEntryService {

    @Autowired
    private JournalEntryRepository journalEntryRepository;

    public List<JournalEntry> getAll() {
        return journalEntryRepository.findAll();
    }

    public JournalEntry get(ObjectId id) {
        return journalEntryRepository.findById(id).orElse(null);
    }

    public JournalEntry create(JournalEntry journalEntity) {
        journalEntity.setDate(LocalDate.now());
        journalEntryRepository.insert(journalEntity);
        return journalEntity;
    }

    public JournalEntry update(JournalEntry journalEntry) {
        JournalEntry journalEntry1 = get(journalEntry.getId());
        if (null != journalEntry1) {
            journalEntry1.setName(journalEntry.getName());
            journalEntry1.setData(journalEntry.getData());
        }
        journalEntryRepository.save(journalEntry1);
        return journalEntry1;
    }


    public void delete(ObjectId objectId) {
        journalEntryRepository.deleteById(objectId);
    }

}
