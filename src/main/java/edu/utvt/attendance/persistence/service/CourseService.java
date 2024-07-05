package edu.utvt.attendance.persistence.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;

import edu.utvt.attendance.persistence.entities.Course;

public interface CourseService {
	public Course save(Course course);
	
	public Course update(Long id, Course course);
	
	public List<Course> getAll();
	
	public Optional<Course> findById(Long id);
	
	public ResponseEntity<Course> deleteById(Long id);
	
	public Page<Course> get(Integer page, Integer size);
	
	public Page<Course> findAll(Integer page, Integer size);
	
	public List<Course> findAll();
}
