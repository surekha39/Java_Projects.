package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.*;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/QueryServlet")

public class QueryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QueryServlet() {
        super();
        
    }

    @Override
   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String productId = request.getParameter("productId");
		out.print("<h1>Display the Record </h1>");
		out.print("<table border='1'><tr><th>Id</th><th>Name</th?</tr>");
		
		try {
			 Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "root");
		Statement stmt=con.createStatement();
		ResultSet rs =stmt.executeQuery("select * from t12 where id="+productId+"");
		
		
    
		while (rs.next())
		{
			out.print("<tr><td>");
			out.println(rs.getInt(1));
			out.print("</td>");
			out.print("<td>");
			out.print(rs.getInt(2));
			out.print("</td>");
			out.print("<td>");
			out.print(rs.getInt(3));
			out.print("</td><");
			out.print("</tr>");
		}
		
	
    } catch (Exception p) {
       System.out.println(p);
    }
		out.print("</table>");
}
    
    
}


