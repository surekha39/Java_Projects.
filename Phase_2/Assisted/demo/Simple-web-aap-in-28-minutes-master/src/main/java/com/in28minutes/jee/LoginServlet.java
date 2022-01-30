package com.in28minutes.jee;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/login.do")
public class LoginServlet extends HttpServlet {

	private ValidationService service=new ValidationService();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException 
	{
		request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException 
	{
		String name=request.getParameter("name");
		String password=request.getParameter("password");
		
		boolean isUserValid=service.isUserValid(name, password);
		if(isUserValid)
		{
		request.setAttribute("name", name);
		request.setAttribute("password", password);
		request.getRequestDispatcher("/WEB-INF/views/welcome.jsp").forward(request, response);
		}
		else
		{   request.setAttribute("errorMessage", "Invalid Credentials !");
			request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);
		}
	}
}


