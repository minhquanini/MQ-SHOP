package mqshop.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

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

@WebServlet(urlPatterns= {"/account"})
public class AccountServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	public AccountServlet() {
		super();
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection conn=null;
		
		try {
			conn=connectDB.getConnection();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		List<USERS> listuser=null;
		
		try {
			listuser=DBUtils.queryUser(conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		HttpSession session=request.getSession();
		USERS loginedUser=MyUtils.getstoreLoginedUser(session);
		if(loginedUser==null) {
			response.sendRedirect(request.getContextPath()+"/login");
			return;
		}
		
		request.setAttribute("listuser", listuser);
		
		RequestDispatcher dispatcher=request.getServletContext().getRequestDispatcher("/WEB-INF/Views/Account.jsp");
		dispatcher.forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}
}
