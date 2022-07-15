package project.action;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import project.ConnectionProvider;


public class ChangeSecurityQuestion extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String email = session.getAttribute("email").toString();
		String securityQuestion = request.getParameter("securityQuestion");
		String answer = request.getParameter("answer");
		String password = request.getParameter("password");
		boolean flag = false;
		try {
			Connection con =ConnectionProvider.getCon();
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select password from users where email='"+email+"'");
			while(rs.next()) {
				if(password.equals(rs.getString(1))) {
					flag=true;
				}
			}
			if(flag) {
				String querry = "update users set securityQuestion='"+securityQuestion+"', answer='"+answer+"' where email='"+email+"'";
				st.executeUpdate(querry);
				response.sendRedirect("changeSecurityQuestion.jsp?msg=done");
			}
			else {
				response.sendRedirect("changeSecurityQuestion.jsp?msg=wrong");
			}
		}
		catch(Exception e) {
			System.out.println(e);
			response.sendRedirect("changeSecurityQuestion.jsp?msg=error");
		}
	}

}
