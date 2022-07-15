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


public class ChangePasswordAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String email = session.getAttribute("email").toString();
		String oldPass = request.getParameter("oldPass");
		String newPass = request.getParameter("newPass");
		String verifyPass = request.getParameter("verifyPass");
		boolean flag =false;
		
		try {
			
			Connection con = ConnectionProvider.getCon();
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select password from users where email='"+email+"'");
			while(rs.next()) {
				if(oldPass.equals(rs.getString(1))) {
					flag=true;
				}
			}
			if(!flag) {
				response.sendRedirect("changePassword.jsp?msg=wrong");
			}
			else if(flag && newPass.equals(verifyPass)) {
				st.executeUpdate("update users set password ='"+newPass+"' where email='"+email+"'");
				response.sendRedirect("changePassword.jsp?msg=done");
			}
			else if(flag && !newPass.equals(verifyPass)){
				response.sendRedirect("changePassword.jsp?msg=notMatch");
			}
		}
		catch(Exception e) {
			System.out.println(e);
			response.sendRedirect("changePassword.jsp?msg=error");
		}
		
	}

}
