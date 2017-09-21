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

import mqshop.beans.PRODUCTS;
import mqshop.beans.PRO_CA_BRA;
import mqshop.beans.USERS;
import mqshop.utils.DBUtils;
import mqshop.utils.MyUtils;
import servlet.conn.connectDB;

@WebServlet(urlPatterns= {"/product"})
public class ProductServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	public ProductServlet() {
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
		
		//List<PRODUCTS> list=null;
		List<PRO_CA_BRA> listpca=null;
		
		try {
			//list=DBUtils.queryProduct(conn);
			listpca=DBUtils.queryPROCABRA(conn);
		} catch (SQLException e) {
			e.printStackTrace();
			errorString=e.getMessage();
		}
		//request.setAttribute("productList", list);
		request.setAttribute("listpca", listpca);
		
		HttpSession session=request.getSession();
		USERS loginedUser=MyUtils.getstoreLoginedUser(session);
		if(loginedUser==null) {
			response.sendRedirect(request.getContextPath()+"/login");
			return;
		}
		
		RequestDispatcher dispatcher=this.getServletContext().getRequestDispatcher("/WEB-INF/Views/Product.jsp");
		dispatcher.forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}
}
