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

import mqshop.beans.ATTRIBUTES;
import mqshop.beans.BRANDS;
import mqshop.beans.CATEGORIES;
import mqshop.utils.DBUtils;
import servlet.conn.connectDB;

@WebServlet(urlPatterns= {"/createProduct"})
public class CreateProductServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	public CreateProductServlet() {
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
		List<CATEGORIES> listcat=null;
		List<BRANDS> listbrand=null;
		List<ATTRIBUTES> listatt=null;
		try {
			listcat=DBUtils.queryCategory(conn);
			listbrand=DBUtils.queryBrand(conn);
			listatt=DBUtils.queryAttribute(conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		request.setAttribute("listcat", listcat);
		request.setAttribute("listbrand", listbrand);
		request.setAttribute("listatt", listatt);
		RequestDispatcher dispatcher=request.getServletContext().getRequestDispatcher("/WEB-INF/Views/CreateProduct.jsp");
		dispatcher.forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}
}
