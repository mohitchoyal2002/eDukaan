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


public class ChangeMobileNumber extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String email = session.getAttribute("email").toString();
		String mobileNumber = request.getParameter("mobileNumber");
		String password = request.getParameter("password");
		boolean flag = false;
		try {
			Connection con  = ConnectionProvider.getCon();
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select password from users where email='"+email+"'");
			while(rs.next()) {
				if(password.equals(rs.getString(1))) {
					flag=true;
				}
			}
			if(flag) {
				st.executeUpdate("update users set mobileNumber='"+mobileNumber+"' where email='"+email+"'");
				response.sendRedirect("changeMobileNumber.jsp?msg=done");
			}
			else {
				response.sendRedirect("changeMobileNumber.jsp?msg=wrong");
			}
		}
		catch(Exception e) {
			System.out.println(e);
			response.sendRedirect("changeMobileNumber.jsp?msg=error");
		}
		
	}

}
