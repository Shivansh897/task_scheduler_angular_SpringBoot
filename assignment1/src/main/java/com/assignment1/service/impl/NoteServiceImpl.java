package com.assignment1.service.impl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assignment1.model.Notes;
import com.assignment1.model.User;
import com.assignment1.repo.NotesRepository;
import com.assignment1.service.NoteService;

@Service
public class NoteServiceImpl implements NoteService{
	
	@Autowired
	private NotesRepository notesRepository;
	

	
	
	

	@Override
	public void deleteNotesOlderThanOneHour() {
		
		List<Notes> toBeDeleted = new ArrayList<>();
		
		//new
		LocalDateTime oneHourAgo = LocalDateTime.now().minusHours(1);
		
		List<Notes> oldNotes = notesRepository.findByCreatedAtBefore(oneHourAgo);
//		List<Notes> oldNotes = notesRepository.findAll();
		
		
		
		for(Notes note: oldNotes) {
			User user =  note.getUser();
			  System.out.println("for user"+user.getId());
			  
			    List<Notes> Top10NotesOfUser = notesRepository.findTop10ByUserIdOrderByCreatedAtDesc(user.getId());
			    
			    
			

			
			System.out.println("all note id no."+note.getId());
			

			
			System.out.println("top10 notes are");
			
			for(Notes n1: Top10NotesOfUser) {
				System.out.println(n1.getId());
			}
	
				
				if(!Top10NotesOfUser.contains(note)) {
					if(!toBeDeleted.contains(note)) {
						toBeDeleted.add(note);
					}
				}

				
				
			}
		
		
		
		System.out.println("notes to be deleted");
		for(Notes nn: toBeDeleted) {
			System.out.println(nn.getId());
			notesRepository.delete(nn);
		}
		
		notesRepository.deleteAll(toBeDeleted);
			
			
			
			
		
		
	

		
		
		

		

		        

		
		
		
	}
	


}
