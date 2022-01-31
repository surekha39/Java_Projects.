package com.flywheel.controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.flywheel.beans.User;
import com.flywheel.util.HibernateUtil;


public class UserLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public UserLoginServlet() {
        super();

    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		                 String email;
		                 email = request.getParameter("username");
		                 HttpSession session = request.getSession();
		               
		                session.setAttribute("uname", email);		 
		                
		              
		                 
		                SessionFactory factory = HibernateUtil.getSessionFactory();		
		                
		                Session hbSession = factory.openSession();
		                
		                Transaction transaction = hbSession.beginTransaction();
		                
		                System.out.println(email);
		                User newUser = new User(email);
		                
		                hbSession.save(newUser);
		                
		                transaction.commit();
		                
		                factory.close();
		                
		                RequestDispatcher rd = request.getRequestDispatcher("search.jsp");
		                
		                rd.forward(request, response);
		                
		                
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    
		doGet(request, response);
	}

}
