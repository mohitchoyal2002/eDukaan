package project.action;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;


import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import project.ConnectionProvider;


public class APFOAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String email = session.getAttribute("email").toString();
		String address = request.getParameter("address");
		String city = request.getParameter("city");
		String state = request.getParameter("state");
		String country = request.getParameter("country");
		String paymentMethod = request.getParameter("paymentMethod");
		String mobileNumber = request.getParameter("mobileNumber");
		String transaction_id="";
		transaction_id = request.getParameter("transactionId");
		String status="bill";
		
		try {
			Connection con = ConnectionProvider.getCon();
//			System.out.println("Hello");
			PreparedStatement ps = con.prepareStatement("update users set address=?, city=?, state=?, country=?, mobileNumber=? where email=?");
			ps.setString(1, address);
			ps.setString(2, city);
			ps.setString(3, state);
			ps.setString(4, country);
			ps.setString(5, mobileNumber);
			ps.setString(6, email);
			ps.executeUpdate();
//			System.out.println("world");
			PreparedStatement ps2 = con.prepareStatement("update cart set address=?, city=?, state=?, country=?, mobileNumber=?,orderDate=now(),delivaryDate=Date_ADD(orderDate,INTERVAL 7 DAY), paymentMethod=?, transction_Id=?, status=? where email=? and address is NULL");
			ps2.setString(1,address);
			ps2.setString(2,city);
			ps2.setString(3,state);
			ps2.setString(4,country);
			ps2.setString(5,mobileNumber);
			ps2.setString(6,paymentMethod);
			ps2.setString(7,transaction_id);
			ps2.setString(8,status);
			ps2.setString(9,email);
			ps2.executeUpdate();
			response.sendRedirect("bill.jsp");
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}

}
