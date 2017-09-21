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

import mqshop.beans.BRANDS;
import mqshop.utils.DBUtils;
import servlet.conn.connectDB;

@WebServlet(urlPatterns= {"/editBrand"})
public class EditBrand extends HttpServlet{
	private static final long serialVersionUID = 1L;

	public EditBrand() {
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
		
		BRANDS brand=null;
		String errorString=null;
		
		int brandid=Integer.parseInt(request.getParameter("brandID"));
		
		try {
			brand=DBUtils.findBrand(conn, brandid);
		} catch (SQLException e) {
			e.printStackTrace();
			errorString=e.getMessage();
		}
		
		if(errorString!=null) {
			response.sendRedirect(request.getContextPath()+"/brand");
			return;
		}
		else
		{
			request.setAttribute("brand", brand);
			request.setAttribute("brandid", brand.getBrandID());
			RequestDispatcher dispatcher=request.getServletContext().getRequestDispatcher("/WEB-INF/Views/EditBrand.jsp");
			dispatcher.forward(request, response);
		}

	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}
}
