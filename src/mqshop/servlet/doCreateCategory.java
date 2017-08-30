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

@WebServlet(urlPatterns= {"/doCreateCategory"})
public class doCreateCategory extends HttpServlet{
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection conn=null;
		//CATEGORIES cate=null;
		HttpSession session=request.getSession();
		String errorString=null;
		try {
			conn=connectDB.getConnection();
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		}
		String namecategory=request.getParameter("namecategory");
		String descriptioncategory=request.getParameter("descriptioncategory");
		
		USERS loginedUser=MyUtils.getstoreLoginedUser(session);
		
		
		CATEGORIES category=new CATEGORIES();
		category.setNamecategory(namecategory);
		category.setDescriptioncategory(descriptioncategory);		
		category.setCreatedby(loginedUser.getUsername());

		
		if(namecategory==""||descriptioncategory=="") {
			errorString ="Nhập vào tên danh mục hoặc mô tả danh mục!";			
		}
		
		if(errorString==null) {
			try {
				DBUtils.insertCategory(conn, category);
			} catch (SQLException e) {
				
				e.printStackTrace();
				//errorString=e.getMessage();
			}
		}
		request.setAttribute("errorString", errorString);
		request.setAttribute("category", category);
		
		if(errorString!=null) {
			RequestDispatcher dispatcher=this.getServletContext().getRequestDispatcher("/WEB-INF/Views/CreateCategory.jsp");
			dispatcher.forward(request, response);
			//request.setAttribute("category", category);
			//response.sendRedirect(request.getContextPath()+"/category");
		}
		else {			
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
