package com.myspring.hibernate.mappings.demo1;

import org.hibernate.Transaction;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.myspring.hibernate.entity.Instructor;
import com.myspring.hibernate.entity.InstructorDetail;

public class CreateInstructor {

	public static void main(String[] args) {
		// Create Sessionfactory, session using hibernate
		SessionFactory factory = new Configuration().configure("hibernate.cfg2.xml").
				addAnnotatedClass(Instructor.class).
				addAnnotatedClass(InstructorDetail.class).buildSessionFactory();
		Session session = factory.getCurrentSession();
		//Create and save student data,commit it
		try
		{
			Instructor instructor = new Instructor("Nithisha", "Arunraj", "vijigov@gmail.com");
			InstructorDetail instructorDetail = new InstructorDetail("somesd", "Dancing");
			instructor.setInstructorDetail(instructorDetail);
			Transaction transaction = session.beginTransaction();
			session.save(instructor);
			transaction.commit();
			System.out.println("instructor and details created" );
			
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
