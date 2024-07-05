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
import edu.utvt.attendance.persistence.entities.Career;
import edu.utvt.attendance.persistence.service.CareerService;

@RestController
@RequestMapping("/api/v1/careers")
public class CareerController {
	
	@Autowired
	private CareerService careerService;
	
	@GetMapping("/All")
	public List<Career> get(){
		return this.careerService.getAll();
	}
	
	@GetMapping
	public Page<Career>findAll(@RequestParam(defaultValue = "1", value = "page") Integer page, Integer size){
		return this.careerService.findAll(page,size);
	}
	
	@PostMapping
	public ResponseEntity<Career>save(@RequestBody Career career){
		return ResponseEntity.created(null).body(this.careerService.save(career));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Career> update(@PathVariable("id") Long id,@RequestBody Career career){
		return ResponseEntity.ok(this.careerService.update(id, career));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Career> findById(@PathVariable("id") Long id){
		return ResponseEntity.of(this.careerService.findById(id));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteById(@PathVariable("id") Long id){
		this.careerService.deleteById(id);
		return ResponseEntity.noContent().build();
	}
	
	

}
