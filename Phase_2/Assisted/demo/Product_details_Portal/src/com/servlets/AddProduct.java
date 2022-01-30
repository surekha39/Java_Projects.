package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/addproduct")
public class AddProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name = request.getParameter("name");
		double price = Double.valueOf(request.getParameter("price"));
		String category = request.getParameter("category");
		

		
		PrintWriter out = response.getWriter();
			
			out.println("<html><body>");
			
			out.println("<table border='1' width='60%'>");
			out.println("<tr>");
			out.println("<th>Model Id</th> <th>Product Name</th> <th>Price</th><th>Category</th> </tr>");
			out.println("<tr style='text-align:center'>");
			out.println("<td>1</td> <td>" + name+ "</td> <td>" + price + "</td> <td>" + category
					+ "</td>");
			out.println("</tr>");
			out.println("</table>");
            out.println("<button><a  href='add_product.jsp'>Go Back to add another product</a></button>");

			out.println("</body></html>");		

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
