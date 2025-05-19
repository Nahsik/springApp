package com.kd.springApp.controllers;

import com.kd.springApp.entity.JournalEntry;
import com.kd.springApp.services.JournalEntryService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/journal")
public class JournalEntryController {

    @Autowired
    private JournalEntryService journalEntityService;

    @GetMapping("/getAll")
    public ResponseEntity<List<JournalEntry>> getAll() {
        return new ResponseEntity<>(journalEntityService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/get/{journalId}")
    public ResponseEntity<JournalEntry> get(@PathVariable ObjectId journalId) {
        JournalEntry journalEntry = journalEntityService.get(journalId);
        if (null != journalEntry) {
            return new ResponseEntity<>(journalEntry, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/create")
    public ResponseEntity<JournalEntry> createEntry(@RequestBody JournalEntry journalEntity) {
        JournalEntry journalEntry = journalEntityService.create(journalEntity);
        return new ResponseEntity<>(journalEntry, HttpStatus.CREATED);
    }

    @PutMapping("update")
    public ResponseEntity<JournalEntry> update(@RequestBody JournalEntry journalEntry) {
        JournalEntry journalEntry1 = journalEntityService.update(journalEntry);
        return new ResponseEntity<>(journalEntry1, HttpStatus.CREATED);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable ObjectId id) {
        journalEntityService.delete(id);
        return new ResponseEntity<>(true, HttpStatus.OK);
    }


}
