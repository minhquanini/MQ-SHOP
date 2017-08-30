package mqshop.servlet;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mqshop.beans.BRANDS;
import servlet.conn.connectDB;

@WebServlet(urlPatterns= {"/doCreateBrand"})
public class doCreateBrand extends HttpServlet{
	private static final long serialVersionUID = 1L;
	public doCreateBrand() {
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
		
		String namebrand=request.getParameter("namebrand");
		String descriptionbrand=request.getParameter("descriptionbrand");
		String image=request.getParameter("image");
		
		BRANDS brand=new BRANDS();
		brand.setNamebrand(namebrand);
		brand.setDescriptionbrand(descriptionbrand);
		brand.setImage(image);
		
	}
}
