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

import mqshop.utils.DBUtils;
import servlet.conn.connectDB;

@WebServlet(urlPatterns= {"/deleteCategory"})
public class doDeleteCategory extends HttpServlet{
	private static final long serialVersionUID = 1L;
	public doDeleteCategory() {
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
		
		int categoryid=Integer.parseInt(request.getParameter("categoryID"));
		
		try {
			DBUtils.deleteCategory(conn, categoryid);
		} catch (SQLException e) {
			e.printStackTrace();
			errorString=e.getMessage();
		}
		if(errorString!=null) {
		request.setAttribute("errorString", errorString);
		RequestDispatcher dispatcher=request.getServletContext().getRequestDispatcher("/WEB-INF/Views/Category.jsp");
		dispatcher.forward(request, response);
		}
		else
		{
			response.sendRedirect(request.getContextPath()+"/category");
		}
		
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}
}
