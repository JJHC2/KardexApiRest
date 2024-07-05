package edu.utvt.attendance.persistence.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import edu.utvt.attendance.persistence.entities.Career;
import edu.utvt.attendance.persistence.repositories.CareerRepository;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class CareerServiceImplementation implements CareerService {

    @Autowired
    private CareerRepository repository;

    @Override
    public Career save(Career career) {
        return repository.save(career);
    }

    @Override
    public Career update(Long id, Career career) {
        Optional<Career> careerOptional = null;
        careerOptional =this.findById(id);
        
        if (careerOptional.isPresent()) {
            careerOptional.get().setName(career.getName());
            careerOptional.get().setDescription(career.getDescription());
            careerOptional.get().setLength(career.getLength());
            careerOptional.get().setCourses(career.getCourses());
            return repository.save(career);
        } 
        
        return careerOptional.orElseThrow();
    }

    @Override
    public List<Career> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<Career> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public ResponseEntity<Career> deleteById(Long id) {
        Optional<Career> careerOptional = repository.findById(id);
        if (careerOptional.isPresent()) {
            repository.deleteById(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @Override
    public Page<Career> getCareers(Integer page, Integer size) {
        return repository.findAll(PageRequest.of(page, size));
    }

	@Override
	public Page<Career> get(Integer page, Integer size) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<Career> findAll(Integer page, Integer size) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Career> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
