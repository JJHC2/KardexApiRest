package edu.utvt.attendance.persistence.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;

import edu.utvt.attendance.persistence.entities.Career;

public interface CareerService {
	Career save(Career career);
    
    Career update(Long id, Career career);
    
    List<Career> findAll();
    
    Optional<Career> findById(Long id);
    
    ResponseEntity<Career> deleteById(Long id);
    
    Page<Career> get(Integer page, Integer size);
    
    Page<Career> findAll(Integer page, Integer size);

	List<Career> getAll();

	Page<Career> getCareers(Integer page, Integer size);

	static Optional<Career> getCareerById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}
}
