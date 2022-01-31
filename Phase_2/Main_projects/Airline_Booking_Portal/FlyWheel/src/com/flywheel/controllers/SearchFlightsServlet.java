package com.flywheel.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.flywheel.beans.Flight;
import com.flywheel.dao.FlightDao;
import com.flywheel.dao.FlightDaoImpli;


public class SearchFlightsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 List<Flight> flights ;
  
    public SearchFlightsServlet() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		HttpSession session= request.getSession();
		
		
	    if(session.isNew())
	    {
	    	out.println("Please Login again");
	    	RequestDispatcher dispatch = request.getRequestDispatcher("index.jsp");
	    	dispatch.forward(request, response);
	    }
	    else
	    {
	    	String source = request.getParameter("source");
	    	String destin = request.getParameter("destin");
	    	String date = request.getParameter("date");
	    	System.out.println(source+ " " + destin + " " +date);
	    	int passnum = Integer.parseInt(request.getParameter("passnum"));
	    	FlightDao flightDao = new FlightDaoImpli(); 
	    	
	    	 flights= flightDao.searchFlights(source, destin, date);
	    	 if(flights.isEmpty())
	    	 {
	    		 out.print("No flight is available for your selection");
	    		 out.print("Please search again");
	    		 RequestDispatcher dispatch = request.getRequestDispatcher("/search.jsp");
		    	 dispatch.forward(request, response);
	    	 }
	    	 else
	    	 {
	    	 for(Flight flight : flights)
	    	 {
	    		 System.out.println("Got it " +flight.getFlightname() + " "+flight.getPrice());
	    	 }
	    	 request.setAttribute("flights", flights);
	    	 RequestDispatcher dispatch2 = request.getRequestDispatcher("bookflight.jsp");
	    	 dispatch2.forward(request, response);
	    	 }
	    }
	        
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
