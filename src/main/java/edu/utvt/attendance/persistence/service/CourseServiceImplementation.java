package edu.utvt.attendance.persistence.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import edu.utvt.attendance.persistence.entities.Course;
import edu.utvt.attendance.persistence.repositories.CourseRepository;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class CourseServiceImplementation implements CourseService {


	@Autowired
	private CourseRepository repository;
	

	@Override
	public Course save(Course course) {
		return repository.save(course);
	}

	@Override
	public Course update(Long id, Course course) {
		Optional<Course> courseOptional = null;
		courseOptional = this.findById(id);
		
		if(courseOptional.isPresent()) {
			
			courseOptional.get().setName(course.getName());
			courseOptional.get().setFourMonthPeriod(course.getFourMonthPeriod());
			courseOptional.get().setCareer(course.getCareer());
			return repository.save(course);
			
		}
		return courseOptional.orElseThrow();
	}

	@Override
	public List<Course> getAll() {
		return null;
	}

	@Override
	public Optional<Course> findById(Long id) {
		return repository.findById(id);
	}

	@Override
	public ResponseEntity<Course> deleteById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<Course> get(Integer page, Integer size) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<Course> findAll(Integer page, Integer size) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Course> findAll() {
		// TODO Auto-generated method stub
		return null;
	}
	

}
