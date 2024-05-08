package com.assignment1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.assignment1.repo.NotesRepository;

@Component
public class NotesCleanupTask {
	
	@Autowired
	private NoteService noteService;
	
	@Autowired
	private NotesRepository notesRepository;
	
	@Scheduled(fixedRate = 3600000)
	public void deleteOldNotes() {
		
	    noteService.deleteNotesOlderThanOneHour();
		
		
	}

}
