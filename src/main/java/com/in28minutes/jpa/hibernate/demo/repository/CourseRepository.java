package com.in28minutes.jpa.hibernate.demo.repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.in28minutes.jpa.hibernate.demo.entity.Course;


@Repository
//add transactional to be able to use delete method
@Transactional
public class CourseRepository {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	//to connect to EntityManager
	@Autowired
	EntityManager em;
	
	//public Course findById(Long id)
	public Course findById(Long id) {
		return em.find(Course.class, id);
	}
	//public Course save(Course course)
	public Course save(Course course) {
		if(course.getId()==null) {
			//insert
			em.persist(course);
		} else {
			//update
			em.merge(course);
		}
		return course;
	}	
	
	public void playWithEntetyManager() {
		Course course1 = new Course("Web Services in 30 steps");
		em.persist(course1);
		
		Course course2 = findById(10001L);
		course2.setName("Hibernate in 30 steps - Updated");
	}
	
	
	
	/*
	//public void deleteById(Long id)
	 
	public void deleteById(Long id) {
		Course course = findById(id);
		em.remove(course);
	}
	*/
	
	/*
	// use of EntetyManager
	public void playWithEntetyManager() {
		Course course = new Course("Web Services in 30 steps");
		em.persist(course);
		course.setName("Web Services in 30 steps - Updated");
		
	}
	*/
	/*
	public void playWithEntetyManager() {
		Course course1 = new Course("Web Services in 30 steps");
		em.persist(course1);
		Course course2 = new Course("Angular in 20 steps");
		em.persist(course2);
		
		em.flush();
		
		//not to save in database
		em.clear();
		//or you can use detach instead of clear
		em.detach(course1);
		em.detach(course2);
		
		course1.setName("Web Services in 30 steps - Updated");
		course2.setName("Angular in 20 steps - Updated");
		
		/*
		Course course1 = new Course("Web Services in 30 steps");
		em.persist(course1);
		Course course2 = new Course("Angular in 20 steps");
		em.persist(course2);
		
		em.flush();
		
		course1.setName("Web Services in 30 steps - Updated");
		course2.setName("Angular in 20 steps - Updated");
		
		//suppose we do not need course1 updated
		//then you can use refresh method
		em.refresh(course1);
		
		em.flush();
		 
		
	}
	
	*/
	
	
}
