package com.in28minutes.jpa.hibernate.demo.entity;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
//if your table name is course_datails but entity name is Course then specify name on @Table
//@Table(name="CourseDetails")
//if not then keep @Table(name="Course") or you can remove table annotation since the name is the same

public class Course {
	//to show primary key
	@Id
	//to let JPA generate id
	@GeneratedValue
	private Long id;
	
	//if the name of the field is not the same as in column
	//then you can specify it, suppose column name is full_name so 
	//@Column(name="fullname")
	//also if you want to have name field not to be NULL so 
	//@Column(name="fullname", nullable = false)
	private String name;
	
	
	//once you add annotaion with timestamp 
	//you have to add it in data.sql so hibernate will see it
	//CREATED_DATE, LAST_UPDATED_DATE
	
	@UpdateTimestamp
	private LocalDateTime lastUpdatedDate;
	
	@CreationTimestamp
	private LocalDateTime createdDate;
	
	
	
	//default constructor mandated by JPA
	protected Course() {
		
	}
	
	public Course(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	@Override
	public String toString() {
		return String.format("Course[%s]", name);
	}
	
}

