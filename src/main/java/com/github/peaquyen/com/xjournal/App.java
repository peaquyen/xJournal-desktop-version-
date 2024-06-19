package com.github.peaquyen.com.xjournal;

import java.util.List;

public class App {
    public static void main(String[] args) {
        JournalDAO journalDAO = new JournalDAO();

        // Create a new journal entry
        Journal newJournal = new Journal("Title", "Description", "Happy", "[]", "2024-06-18 12:00:00", 1);
        journalDAO.create(newJournal);

        // Retrieve all journal entries for a user
        List<Journal> journals = journalDAO.getMultiple(1);
        for (Journal journal : journals) {
            System.out.println(journal);
        }

        // Update a journal entry
        newJournal.setTitle("Updated Title");
        journalDAO.update(newJournal.getId(), newJournal, 1);

        // Remove a journal entry
        journalDAO.remove(newJournal.getId(), 1);
    }
}
