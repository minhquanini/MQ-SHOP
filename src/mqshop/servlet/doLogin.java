package mqshop.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mqshop.beans.USERS;
import mqshop.utils.DBUtils;
import mqshop.utils.MyUtils;
import servlet.conn.connectDB;

@WebServlet(urlPatterns="/doLogin")
public class doLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		//Sẽ thêm vào rememberMe sau.
		
		USERS user=null;
		boolean hasError=false;
		String errorString=null;
		Connection conn=null;
		if(username==""||password=="") {
			hasError=true;
			errorString="Please enter Username or Password!";
			
		}
		else
		{
			//conn=connectDB.getConnection();
			try {
				conn=connectDB.getConnection();
				//MyUtils.storeConnection(request, conn);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			
			try {
				user=DBUtils.findUser(conn, username, password);
				if(user==null) {
					hasError=true;
					errorString="Username or Password ivalid!";
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
				hasError=true;
				errorString=e.getMessage();
			}
			

		}
		
		if(hasError) {
			user=new USERS();
			user.setUsername(username);
			user.setPassword(password);
			
			request.setAttribute("errorString", errorString);
			request.setAttribute("user", user);
			
			RequestDispatcher dispatcher=this.getServletContext().getRequestDispatcher("/WEB-INF/Views/login.jsp");
			dispatcher.forward(request, response);
			
		}
		else
		{
			HttpSession session=request.getSession();
			MyUtils.storeLoginedUser(session, user);
			
			
			response.sendRedirect(request.getContextPath()+"/home");
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}
}
