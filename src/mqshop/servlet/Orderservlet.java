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

import mqshop.beans.ORDERS;
import mqshop.utils.DBUtils;
import servlet.conn.connectDB;

@WebServlet(urlPatterns= {"/order"})
public class Orderservlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	public Orderservlet() {
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
		
		List<ORDERS> listorder=null;
		
		try {
			listorder=DBUtils.queryOrder(conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		request.setAttribute("listorder", listorder);
		
		RequestDispatcher dispatcher=request.getServletContext().getRequestDispatcher("/WEB-INF/Views/Order.jsp");
		dispatcher.forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}
}
