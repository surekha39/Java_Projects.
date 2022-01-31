package com.flywheel.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import com.flywheel.beans.Flight;

public class FlightDaoImpli implements FlightDao {

			private SessionFactory factory;
	
	public FlightDaoImpli() {
		StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();  
        Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();  
		factory = meta.getSessionFactoryBuilder().build();
	}

	public  List<Flight>searchFlights(String source, String destin, String date) {
		Session session  = factory.openSession();
		Transaction txn = session.beginTransaction();
		String fsource = source;
		String fdestin = destin;
		String fdate = date;
		System.out.println(fsource+" "+ fdestin+ "  " + fdate);
		         String hql = "FROM Flight f where f.source = :fsource and f.destin = :fdestin and f.date = :fdate";      
	            System.out.println(hql);
	            Query query = session.createQuery(hql);
	            query.setParameter("fsource", fsource);
	            query.setParameter("fdestin", fdestin);
	            query.setParameter("fdate", fdate);
		         List<Flight> flights = query.list();
		return flights;
	}
         
}
