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


import mqshop.beans.CATEGORIES;
import mqshop.utils.DBUtils;
import mqshop.utils.MyUtils;
import servlet.conn.connectDB;

@WebServlet(urlPatterns= {"/editCategory"})
public class EditCategory extends HttpServlet{
	private static final long serialVersionUID = 1L;
	public EditCategory() {
		super();
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Connection conn=MyUtils.getStoredConnection(request);
		Connection conn=null;
		
		try {
			conn=connectDB.getConnection();
			//MyUtils.storeConnection(request, conn);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		int categoryid=Integer.parseInt(request.getParameter("categoryID"));
		//String categoryid=request.getParameter("categoryID");
		CATEGORIES category=null;
		String errorString =null;
		
		try {
			category=DBUtils.findCategory(conn, categoryid);
		} catch (SQLException e) {
			e.printStackTrace();
			errorString=e.getMessage();
		}
		
		if(errorString!=null) {
			request.setAttribute("errorString", errorString);
			response.sendRedirect(request.getServletPath()+"/category");
			return;
		}
		else
		{
		
		request.setAttribute("category", category);
		
		RequestDispatcher dispatcher=request.getServletContext().getRequestDispatcher("/WEB-INF/Views/EditCategory.jsp");
		dispatcher.forward(request, response);
		}
		
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}
