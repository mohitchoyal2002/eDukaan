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

/**
 * Servlet implementation class LoginAction
 */
public class LoginAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		
		if(email.equals("admin123@gmail.com") && password.equals("admin#277423")) {
			HttpSession session=request.getSession();
			session.setAttribute("email", email);
			response.sendRedirect("admin/adminHome.jsp");
		}
		else {
			int z=0;
			try {
				Connection con=ConnectionProvider.getCon();
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery("select * from users where email='"+email+"' and password='"+password+"'");
				while(rs.next()) {
					z=1;
					HttpSession session = request.getSession();
					session.setAttribute("email", email);
					response.sendRedirect("home.jsp");
				}
				if(z==0) {
					response.sendRedirect("login.jsp?msg=wrong");
				}
			}
			catch(Exception e) {
				System.out.println(e);
				response.sendRedirect("login.jsp?msg=error");
			}
		}
	}

}
