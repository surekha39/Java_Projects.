package com.flywheel.controllers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.flywheel.beans.Flight;

import com.flywheel.util.HibernateUtil;


public class UpdateFlights extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public UpdateFlights() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		//get flight details
		String flightname =request.getParameter("flightname");
		String source = request.getParameter("source");
		String destination = request.getParameter("destination");
		String date = request.getParameter("date");
	
		float price = Float.parseFloat(request.getParameter("price"));
		
		int capacity   = Integer.parseInt(request.getParameter("passnum")) ;
		
		 
		Flight newFlight = new Flight(flightname, source,destination, date, price,  capacity );
					//newFlight.toString();
      
		
		SessionFactory factory = HibernateUtil.getSessionFactory();		
        
        Session hbSession = factory.openSession();
        
        Transaction transaction = hbSession.beginTransaction();
           
        
        hbSession.save(newFlight);
        
        transaction.commit();
        
        factory.close();
          if(newFlight != null)
         {
        	out.println("The fligt details was succefully added"); 
           RequestDispatcher dispatch = request.getRequestDispatcher("/adminDashboard.jsp");
           dispatch.include(request, response);
         }
         else
         {
        	 out.println("An error occured.."); 
             RequestDispatcher dispatch = request.getRequestDispatcher("/adminDashboard.jsp");
             dispatch.include(request, response);
         }
        
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
