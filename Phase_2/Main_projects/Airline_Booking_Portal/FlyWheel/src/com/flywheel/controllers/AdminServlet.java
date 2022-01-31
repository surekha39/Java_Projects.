package com.flywheel.controllers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class AdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public AdminServlet() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	     //Check for Log in credentials
		   String adminId = request.getParameter("adminId");
		   String password = request.getParameter("pass");
		   PrintWriter out = response.getWriter();
		   response.setContentType("text/html");
		   if(adminId.equalsIgnoreCase("admin") && password.equalsIgnoreCase("admin"))
		   {
			   
			   RequestDispatcher dispatch = request.getRequestDispatcher("adminDashboard.jsp");
			   dispatch.forward(request, response);
		   }
		   else
		   {
			   out.println("invalid Credentials.. please login again");
			   RequestDispatcher dispatch = request.getRequestDispatcher("admin.jsp");
			   dispatch.forward(request, response);
		   }
		// forward to AdminDashboard
	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
