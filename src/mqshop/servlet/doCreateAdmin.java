package mqshop.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import javax.print.attribute.standard.DateTimeAtCompleted;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mqshop.beans.USERS;
import mqshop.utils.DBUtils;
import servlet.conn.connectDB;

@WebServlet(urlPatterns= {"/doCreateAdmin"})
public class doCreateAdmin extends HttpServlet{
	private static final long serialVersionUID = 1L;
	public doCreateAdmin() {
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
		
		
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		//String repassword=request.getParameter("repassword");
		String fullname=request.getParameter("fullname");
		String email=request.getParameter("email");
		String phone=request.getParameter("phone");
		String getbirthday = request.getParameter("birthday");
		DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date fd = null;
		try {
			fd = formatter.parse(getbirthday);
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		java.sql.Date sqlDate = new java.sql.Date(fd.getTime());
		//select1.setDate(1, sqlDate);
		String address=request.getParameter("address");
		
		USERS admin=new USERS();
		admin.setUsername(username);
		admin.setPassword(password);
		admin.setFullname(fullname);
		admin.setEmail(email);
		admin.setPhone(phone);
		admin.setBirthday(sqlDate); 
		admin.setAddress(address);
		
		if(username==""||password=="") {
			errorString="Không nhập đầy đủ";
		}
		if(errorString==null)
		{
			try {
				DBUtils.insertAdmin(conn, admin);
				//System.out.println("inserted");
			} catch (SQLException e) {
				e.printStackTrace();
				errorString=e.getMessage();
			}
		}
		
		
		if(errorString!=null) {
			request.setAttribute("errorString", errorString);
			RequestDispatcher dispatcher=request.getServletContext().getRequestDispatcher("/WEB-INF/Views/CreateAdmin.jsp");
			dispatcher.forward(request, response);
		}
		else
		{
			response.sendRedirect(request.getContextPath()+"/account");
		}
		
	}
}
