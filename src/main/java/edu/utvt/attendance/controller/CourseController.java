package edu.utvt.attendance.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import edu.utvt.attendance.persistence.entities.Course;
import edu.utvt.attendance.persistence.service.CourseService;


@RestController
@RequestMapping("/api/v1/course")
public class CourseController {
	
	@Autowired
	private CourseService courseService;
	
	@GetMapping("/All")
	public List<Course> get(){
		return this.courseService.getAll();
	}
	
	@GetMapping
	public Page<Course>findAll(@RequestParam(defaultValue = "1", value = "page") Integer page, Integer size){
		return this.courseService.findAll(page,size);
	}
	
	@PostMapping
	public ResponseEntity<Course>save(@RequestBody Course course){
		return ResponseEntity.created(null).body(this.courseService.save(course));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Course> update(@PathVariable("id") Long id,@RequestBody Course course){
		return ResponseEntity.ok(this.courseService.update(id, course));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Course> findById(@PathVariable("id") Long id){
		return ResponseEntity.of(this.courseService.findById(id));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteById(@PathVariable("id") Long id){
		this.courseService.deleteById(id);
		return ResponseEntity.noContent().build();
	}
	
	

}
