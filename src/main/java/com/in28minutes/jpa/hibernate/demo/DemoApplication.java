package com.in28minutes.jpa.hibernate.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.in28minutes.jpa.hibernate.demo.entity.Course;
import com.in28minutes.jpa.hibernate.demo.repository.CourseRepository;

@SpringBootApplication
//to use CourseRepository while launching application 
//you have to add implements CommandLineRunner
//then add unimplemented methods
//then add @Autowired CourseRepository
//since we do not have id so create data.sql file and add course data

public class DemoApplication implements CommandLineRunner {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private CourseRepository repository;
	
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		/*
		Course course = repository.findById(10001L);
		logger.info("Course 10001 -> {}", course);
		repository.save(new Course("Microservices in 99 steps"));
		
		repository.deleteById(10001L);
		*/
		repository.playWithEntetyManager();
	}

}
