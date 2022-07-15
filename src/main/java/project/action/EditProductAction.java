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


public class EditProductAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id=request.getParameter("id");
		String productName=request.getParameter("productName");
		String category=request.getParameter("category");
		String price=request.getParameter("price");
		String active=request.getParameter("active");
		
		try {
			Connection con = ConnectionProvider.getCon();
			Statement st =con.createStatement();
			st.executeUpdate("update product set name='"+productName+"',category='"+category+"',price="+price+",active='"+active+"' Where id="+id);
			if(active.equals("no")) {
				st.executeUpdate("delete from product where active='no'");
			}
			response.sendRedirect("admin/allProductEditProduct.jsp?msg=done");
			con.close();
		}
		catch(Exception e) {
			System.out.println(e);
			response.sendRedirect("admin/allProductEditProduct.jsp?msg=error");
		}
	}

}
