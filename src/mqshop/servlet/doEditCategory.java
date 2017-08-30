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

import mqshop.beans.CATEGORIES;
import mqshop.beans.USERS;
import mqshop.utils.DBUtils;
import mqshop.utils.MyUtils;
import servlet.conn.connectDB;

@WebServlet(urlPatterns= {"/doEditCategory"})
public class doEditCategory extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	public doEditCategory() {
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
		
		HttpSession session=request.getSession();
		//Connection conn=null;
		int categoryID=Integer.parseInt(request.getParameter("categoryID"));
		String namecategory=request.getParameter("namecategory");
		String descriptioncategory=request.getParameter("descriptioncategory");
		USERS loginedUser=MyUtils.getstoreLoginedUser(session);
		
		CATEGORIES category=new CATEGORIES();
		category.setCategoryID(categoryID);
		category.setNamecategory(namecategory);
		category.setDescriptioncategory(descriptioncategory);
		//category.setUpdateddate(updateddate);
		category.setUpdatedby(loginedUser.getUsername());
		
		String errorString=null;
		
		try {
			DBUtils.updateCategory(conn, category);
		} catch (SQLException e) {
			e.printStackTrace();
			errorString=e.getMessage();
		}
		
		
		request.setAttribute("errorString", errorString);
		request.setAttribute("category", category);
		
		if(errorString!=null||namecategory=="") {
			RequestDispatcher dispatcher=request.getServletContext().getRequestDispatcher("/WEB-INF/Views/EditCategory.jsp");
			dispatcher.forward(request, response);
		}
		else
		{
			response.sendRedirect(request.getContextPath()+"/category");
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		doGet(request,response);
	}
}
