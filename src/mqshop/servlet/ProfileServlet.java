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

@WebServlet(urlPatterns= {"/profile"})
public class ProfileServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	public ProfileServlet() {
		super();
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection conn=null;
		String errorString=null;
		try {
			conn=connectDB.getConnection();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		HttpSession session=request.getSession();
		USERS loginedUser=MyUtils.getstoreLoginedUser(session);
		
		USERS user=new USERS();
		user.setUserID(loginedUser.getUserID());
		user.setUsername(loginedUser.getUsername());
		user.setFullname(loginedUser.getFullname());
		user.setEmail(loginedUser.getEmail());
		user.setPhone(loginedUser.getPhone());
		user.setBirthday(loginedUser.getBirthday());
		user.setAddress(loginedUser.getAddress());
		/*
		USERS queryuser=null;
		try {
			queryuser=DBUtils.queryUser(conn,user.getUserID());
		} catch (SQLException e) {
			e.printStackTrace();
			errorString=e.getMessage();
		}
		*/
		if(errorString==null) {
			request.setAttribute("user", user);
			RequestDispatcher dispatcher=request.getServletContext().getRequestDispatcher("/WEB-INF/Views/Profile.jsp");
			dispatcher.forward(request, response);
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException ,IOException {
		doGet(request,response);
	}
}
