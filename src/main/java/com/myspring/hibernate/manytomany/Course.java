package com.myspring.hibernate.manytomany;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="course")
public class Course {
	
	@Override
	public String toString() {
		return "Course [id=" + id + ", title=" + title + ", instructor=" + instructor + "]";
	}
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Column(name="title")
	private String title;
	@ManyToOne(cascade= {CascadeType.DETACH,CascadeType.MERGE, CascadeType
			.PERSIST, CascadeType.REFRESH})
	@JoinColumn(name="instructor_id")
	private Instructor instructor;
	
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name="course_id")
	private List<Reviews> reviews;
	
	@ManyToMany(cascade= {CascadeType.DETACH,CascadeType.MERGE, CascadeType
			.PERSIST, CascadeType.REFRESH})
	@JoinTable(name="course_student", joinColumns =@JoinColumn(name="course_id"), inverseJoinColumns = @JoinColumn(name="student_id"))
	
	public List<Reviews> getReviews() {
		return reviews;
	}
	public void setReviews(List<Reviews> reviews) {
		this.reviews = reviews;
	}
	public Course() {
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Instructor getInstructor() {
		return instructor;
	}
	public Course(String title) {
		super();
		this.title = title;
	}
	public void setInstructor(Instructor instructor) {
		this.instructor = instructor;
	}
	
	public void addReview(Reviews tempReview)
	{
		if(reviews==null)
		{
			reviews = new ArrayList<Reviews>();
		}
		reviews.add(tempReview);
	}
	
}
