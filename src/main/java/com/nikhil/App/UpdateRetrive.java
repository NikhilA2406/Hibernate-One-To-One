package com.nikhil.App;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.nikhil.model.Question;

public class UpdateRetrive {

	public static void main(String[] args) 
	{
		Configuration config = null;
		SessionFactory sessionFactory = null;
		Session session = null;
		
		config=new Configuration();
		
		config.configure();

		sessionFactory=config.buildSessionFactory();
		
		session=sessionFactory.openSession();
		
		Question q1=session.get(Question.class, 1);
		System.out.println(q1);
		Question q2=session.get(Question.class, 2);
		System.out.println(q2);
		try
		{
			
			
		}
		catch(HibernateException e)
		{
			e.printStackTrace();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		finally
		{
			
			
			session.close();
			sessionFactory.close();
		}


	}

}
