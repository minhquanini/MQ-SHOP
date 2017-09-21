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

import mqshop.beans.ATTRIBUTES;
import mqshop.beans.USERS;
import mqshop.utils.DBUtils;
import mqshop.utils.MyUtils;
import servlet.conn.connectDB;

@WebServlet(urlPatterns= {"/attribute"})
public class AttributeServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	public AttributeServlet() {
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
		
		List<ATTRIBUTES> listAttribute=null;
		
		
		try {
			listAttribute=DBUtils.queryAttribute(conn);
		} catch (SQLException e) {
			e.printStackTrace();
			errorString=e.getMessage();
		}
		
		HttpSession session=request.getSession();
		USERS loginedUser=MyUtils.getstoreLoginedUser(session);
		if(loginedUser==null) {
			response.sendRedirect(request.getContextPath()+"/login");
			return;
		}
		
		request.setAttribute("listAttribute", listAttribute);
		request.setAttribute("errorString", errorString);
		
		
		RequestDispatcher dispatcher=request.getServletContext().getRequestDispatcher("/WEB-INF/Views/Attribute.jsp");
		dispatcher.forward(request, response);
		
	}
	
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}
}
