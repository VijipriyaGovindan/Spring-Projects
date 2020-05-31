package com.myspring.hibernate.manytomany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class CreateAll {

	public static void main(String[] args) {
		// Create Sessionfactory, session using hibernate
		SessionFactory factory = new Configuration().configure("hibernate.cfg5.xml").
				addAnnotatedClass(Instructor.class).
				addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Course.class).addAnnotatedClass(Reviews.class).
				buildSessionFactory();
		Session session = factory.getCurrentSession();
		//Create and save student data,commit it
		try
		{
			Instructor instructor = new Instructor("ArunRaj", "Kappi", "vijigov@gmail.com");
			InstructorDetail instructorDetail = new InstructorDetail("TorontoSamaa", "dancing");
			instructor.setInstructorDetail(instructorDetail);
			Course course1 = new Course("Selenium Jva");
			Course course2 = new Course("AWS cloud Developer");
			Reviews review1 = new Reviews("Just Ok");
			Reviews review2 = new Reviews("Very Good");
			instructor.addCourse(course1);
			course1.addReview(review1);
			instructor.addCourse(course2);
			course2.addReview(review2);
			System.out.println(instructor);
			Transaction transaction = session.beginTransaction();
			session.save(review1);
			session.save(review2);
			session.save(course1);
			session.save(course2);
			session.save(instructor);
			transaction.commit();
			System.out.println("instructor and other details are created" );
			
		}
		catch (Exception e) {
			System.out.println("Error" + e.getMessage());
		}
		finally {
			session.close();
			factory.close();
		}



	}

}
