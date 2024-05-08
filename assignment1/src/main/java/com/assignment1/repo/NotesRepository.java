package com.assignment1.repo;

import java.time.LocalDateTime;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.assignment1.model.Notes;
import com.assignment1.model.User;

public interface NotesRepository extends JpaRepository<Notes, Long> {
	
	List<Notes> findByUserId(Long UserId);
	
	List<Notes> findTop10ByOrderByCreatedAtDesc();
	List<Notes> findTop10ByUserIdOrderByCreatedAtDesc(Long userId);
	
	
	List<Notes> findByUserOrderByCreatedAtDesc(User user);
	
	
	@Transactional
	void deleteByCreatedAtBefore(LocalDateTime timestamp);
	
	
	//new 
	
	List<Notes> findByCreatedAtBefore(LocalDateTime dateTime);

	//delete
	
	
	  
		
		
		
	

}
