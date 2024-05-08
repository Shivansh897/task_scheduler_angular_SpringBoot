package com.assignment1.controller;

import java.util.List;
import java.util.Optional;

import javax.management.AttributeNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.assignment1.model.Notes;
import com.assignment1.model.User;
import com.assignment1.repo.NotesRepository;
import com.assignment1.repo.UserRepository;

@RestController
@RequestMapping("/notes")
@CrossOrigin("*")
public class NotesController {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private NotesRepository notesRepository;
	
	@GetMapping("/all")
	public List<Notes> getAllReviews() {
	    List<Notes> allnotes = notesRepository.findAll();
	    return allnotes;
	}
	
	//get note by id
	@GetMapping("/{note_id}")
	 public Optional<Notes> getsingleNote(@PathVariable("note_id")Long noteId) {
		
		return notesRepository.findById(noteId);
		 
	 }
	
	//give notes using user id
	@PostMapping("/{user_id}")
	public Notes createNote(@PathVariable("user_id") Long UserId, @RequestBody Notes notes) throws Exception {
		Optional<User> optionalUser = userRepository.findById(UserId);
		
		if(optionalUser.isPresent()) {
			User user = optionalUser.get();
		    notes.setUser(user);
		return notesRepository.save(notes);
		}
		else {
			throw new AttributeNotFoundException("note not found with id:" + UserId);
		}
	}
	   // delete notes by id
		@DeleteMapping("/{note_id}")
		public ResponseEntity<String> deleteNoteById(@PathVariable("note_id") Long noteId) {
		    Optional<Notes> optionalNote = notesRepository.findById(noteId);
		    
		    if (optionalNote.isPresent()) {
		        notesRepository.deleteById(noteId);
		        return ResponseEntity.ok("Note deleted successfully");
		    } else {
		        return ResponseEntity.notFound().build();
		    }
		}
		
		// get notes for specific user by id
		@GetMapping("/user/{user_id}")
		public List<Notes> getAllReviewsForProduct(@PathVariable("user_id") Long userId){
			
			List<Notes> notes = notesRepository.findByUserId(userId);
			
			return notes;
		}
		
     //return 10 recent notes
		@GetMapping("/recent-notes/{user_id}")
		public List<Notes> getTop10RecentNotes(@PathVariable("user_id") Long userId)
		{
			
			
			
//			return notesRepository.findTop10ByOrderByCreatedAtDesc();
			return notesRepository.findTop10ByUserIdOrderByCreatedAtDesc(userId);
			
		}
}
