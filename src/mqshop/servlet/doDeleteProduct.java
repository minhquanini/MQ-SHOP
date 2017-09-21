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
@WebServlet(urlPatterns= {"/deleteProduct"})
public class doDeleteProduct extends HttpServlet{
	private static final long serialVersionUID = 1L;
	public doDeleteProduct() {
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
		
		int productID=Integer.parseInt(request.getParameter("productID"));
		
		try {
			DBUtils.deleteAttributeValue(conn, productID);
		} catch (SQLException e) {
			e.printStackTrace();
			errorString=e.getMessage();
		}
		if(errorString==null) {
			try {
				DBUtils.deleteProduct(conn, productID);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		else {
			errorString="Không thể xóa!";
		}
		request.setAttribute("errorString", errorString);
		if(errorString!=null) {
			RequestDispatcher dispatcher=request.getServletContext().getRequestDispatcher("/WEB-INF/Views/Product.jsp");
			dispatcher.forward(request, response);
		}
		else
		{
			response.sendRedirect(request.getContextPath()+"/product");
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}
}
