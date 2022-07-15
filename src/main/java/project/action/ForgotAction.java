package project.action;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import project.ConnectionProvider;

/**
 * Servlet implementation class ForgotAction
 */
public class ForgotAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String email = request.getParameter("email");
//		String  mobileNumber = request.getParameter("mobileNumber");
		String securityQuestion = request.getParameter("securityQuestion");
		String answer = request.getParameter("answer");
		String pass1=request.getParameter("new_password");
//		String pass2=request.getParameter("pass2");
		
		try {
			Connection con= ConnectionProvider.getCon();
			Statement st = con.createStatement();
			String q = "select * from users where name='"+name+"' and email='"+email+"' and securityQuestion='"+securityQuestion+"' and answer='"+answer+"'";
			ResultSet rs=st.executeQuery(q);
			System.out.println("Hellllllooooo");
			int check=0;
			while(rs.next()) {
				st.executeUpdate("update users set password='"+pass1+"' where email='"+email+"'");
				response.sendRedirect("forgotPassword.jsp?msg=done");
			}
				
			if(check==0) {
				System.out.println("djbsjkfbjkfnjkfndkjn");
				response.sendRedirect("forgotPassword.jsp?msg=invalid");
			}
			rs.close();
		}
		catch(Exception e) {
//			response.sendRedirect("forgotPassword.jsp?msg=invalid");
			System.out.println(e);
		}
	}

}
