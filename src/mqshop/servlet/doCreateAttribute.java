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

import mqshop.beans.ATTRIBUTES;
import mqshop.utils.DBUtils;
import servlet.conn.connectDB;

@WebServlet(urlPatterns= {"/doCreateAttribute"})
public class doCreateAttribute extends HttpServlet{
	private static final long serialVersionUID = 1L;
	public doCreateAttribute() {
		super();
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		doPost(request,response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");				
		Connection conn=null;
		String errorString=null;
		try {
			conn=connectDB.getConnection();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		String nameattribute=request.getParameter("nameattribute");
		
		ATTRIBUTES attribute=new ATTRIBUTES();
		attribute.setNameattribute(nameattribute);
		
		
		if(nameattribute=="") {
			errorString="Nhập vào tên thuộc tính!";
		}
		
		try {
			DBUtils.insertAttribute(conn, attribute);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		request.setAttribute("attribute", attribute);
		request.setAttribute("errorString", errorString);
		
		if(errorString!=null) {
			RequestDispatcher dispatcher=request.getServletContext().getRequestDispatcher("/WEB-INF/Views/CreateAttribute.jsp");
			dispatcher.forward(request, response);
		}
		else
		{
			response.sendRedirect(request.getContextPath()+"/attribute");
		}
		
	}
	
}
