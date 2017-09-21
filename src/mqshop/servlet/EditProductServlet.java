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
import mqshop.beans.ATTRIBUTE_VALUES;
import mqshop.beans.ATTRIBUTE_VALUES_MODEL;
import mqshop.beans.BRANDS;
import mqshop.beans.CATEGORIES;
import mqshop.beans.PRODUCTS;
import mqshop.beans.PRO_CA_BRA;
import mqshop.utils.DBUtils;
import servlet.conn.connectDB;

@WebServlet(urlPatterns= {"/editProduct"})
public class EditProductServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	public EditProductServlet() {
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
		
		//List<ATTRIBUTE_VALUES> attributevalue=null;
		PRODUCTS product=null;
		String errorString=null;
		List<CATEGORIES> listcat=null;
		List<BRANDS> listbrand=null;
		//List<PRO_CA_BRA> listpca=null;
		List<ATTRIBUTES> listatt=null;
		List<ATTRIBUTE_VALUES_MODEL> listavm =null;
		int productid=Integer.parseInt(request.getParameter("productID"));
		try {
			//attributevalue=DBUtils.findProductinValue(conn, productid);
			listavm=DBUtils.ProductinValue(conn, productid);
			product=DBUtils.findProduct(conn, productid);
			//product1=DBUtils.findCategoryfromPID(conn, productid);
			listcat=DBUtils.queryCategory(conn);
			listbrand=DBUtils.queryBrand(conn);
			//listatt=DBUtils.queryAttribute(conn);
			//listpca=DBUtils.queryPROCABRA(conn, productid);

		} catch (SQLException e) {
			e.printStackTrace();
			errorString=e.getMessage();
		}
		
		if(errorString!=null) {
			response.sendRedirect(request.getContextPath()+"/product");
		}
		else
		{
		//request.setAttribute("attributevalue", attributevalue);
		request.setAttribute("listavm", listavm);
		request.setAttribute("product", product);
		//request.setAttribute("listpca", listpca);
		request.setAttribute("listcat", listcat);
		request.setAttribute("listbrand", listbrand);
		//request.setAttribute("listatt", listatt);
		RequestDispatcher dispatcher=request.getServletContext().getRequestDispatcher("/WEB-INF/Views/EditProduct.jsp");
		dispatcher.forward(request, response);
		}
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}
}
