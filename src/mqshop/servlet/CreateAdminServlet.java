package mqshop.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mqshop.beans.USERS;
import mqshop.utils.MyUtils;

@WebServlet(urlPatterns= {"/createAdmin"})
public class CreateAdminServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	public CreateAdminServlet() {
		super();
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher=request.getServletContext().getRequestDispatcher("/WEB-INF/Views/CreateAdmin.jsp");
		dispatcher.forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}
}
