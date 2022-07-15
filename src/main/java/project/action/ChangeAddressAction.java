package project.action;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Statement;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import project.ConnectionProvider;


public class ChangeAddressAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String email = session.getAttribute("email").toString();
		String address = request.getParameter("address");
		String city = request.getParameter("city");
		String state = request.getParameter("state");
		String country = request.getParameter("country");
		
		try {
			Connection con = ConnectionProvider.getCon();
			Statement st = con.createStatement();
			st.executeUpdate("update users set address='"+address+"', city='"+city+"', state='"+state+"', country='"+country+"' where email='"+email+"'");
			response.sendRedirect("addChangeAddress.jsp?msg=done");
		}
		catch(Exception e) {
			System.out.println(e);
			response.sendRedirect("addChangeAddress.jsp?msg=error");
		}
		
	}

}
