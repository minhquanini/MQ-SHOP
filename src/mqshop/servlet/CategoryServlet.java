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

import mqshop.beans.CATEGORIES;
import mqshop.beans.USERS;
import mqshop.utils.DBUtils;
import mqshop.utils.MyUtils;
import servlet.conn.connectDB;

@WebServlet(urlPatterns= {"/category"})
public class CategoryServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	public CategoryServlet() {
		super();
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Connection conn=MyUtils.getStoredConnection(request);
		Connection conn=null;
		//USERS loginedUser=null;
		
		try {
			conn = connectDB.getConnection();
		} catch (ClassNotFoundException e1) {
			
			System.out.println("Can not connect to Database!");
			e1.printStackTrace();
		}
		
		String errorString=null;
		List<CATEGORIES> list=null;
		try {
			list=DBUtils.queryCategory(conn);
			//System.out.println("Get query");
		} catch (SQLException e) {
			System.out.println("In exception");
			e.printStackTrace();
			errorString=e.getMessage();
		}
		
		request.setAttribute("errorString", errorString);
		request.setAttribute("categoryList", list);	
		//request.setAttribute("user", user);
		//MyUtils.checkLoginedUser(request, loginedUser);
		
		/*
		if(MyUtils.checkLoginedUser(request, loginedUser)==false) {
			response.sendRedirect(request.getContextPath()+"/login");
			return;
		}
		*/
		//Kiểm tra xem đã đăng nhập chưa. Nếu chưa trả về trang login, nếu rồi sẽ đi đến trang category.
		HttpSession session=request.getSession();
		USERS loginedUser=MyUtils.getstoreLoginedUser(session);
		if(loginedUser==null) {
			response.sendRedirect(request.getContextPath()+"/login");
			return;
		}
		request.setAttribute("user", loginedUser);
		
		
		RequestDispatcher dispatcher=this.getServletContext().getRequestDispatcher("/WEB-INF/Views/Category.jsp");
		dispatcher.forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}
}
