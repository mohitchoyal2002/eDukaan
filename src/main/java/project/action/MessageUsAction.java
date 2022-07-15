package project.action;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import project.ConnectionProvider;

public class MessageUsAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {	
			HttpSession session = request.getSession();
			String email = session.getAttribute("email").toString();
			String subject = request.getParameter("subject");
			String body = request.getParameter("body");
		
		
			Connection con = ConnectionProvider.getCon();
			PreparedStatement ps = con.prepareStatement("insert into message (email,subject,body) values(?,?,?)");
			ps.setString(1, email);
			ps.setString(2, subject);
			ps.setString(3, body);
			ps.executeUpdate();
			
			response.sendRedirect("messageUs.jsp?msg=done");
		}
		catch(Exception e) {
			System.out.println(e);
			response.sendRedirect("messageUs.jsp?msg=error");
		}
	}

}
