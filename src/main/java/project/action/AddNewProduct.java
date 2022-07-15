package project.action;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import project.ConnectionProvider;


public class AddNewProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("id");
		String productName = request.getParameter("name");
		String category = request.getParameter("category"); 
		int price = Integer.parseInt(request.getParameter("price")); 
		String active = request.getParameter("active");
		
		try {
			Connection con = ConnectionProvider.getCon();
			PreparedStatement ps =con.prepareStatement("insert into product values(?,?,?,?,?)");
			ps.setString(1,id);
			ps.setString(2, productName);
			ps.setString(3, category);
			ps.setInt(4,price);
			ps.setString(5, active);
			ps.executeUpdate();
			ps.close();
			response.sendRedirect("admin/addNewProduct.jsp?msg=done");
		}
		catch(Exception e) {
			System.out.println(e);
			response.sendRedirect("admin/addNewProduct.jsp?msg=error");
		}
	}

}
