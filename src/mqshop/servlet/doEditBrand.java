package mqshop.servlet;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import mqshop.beans.BRANDS;
import mqshop.beans.USERS;
import mqshop.utils.DBUtils;
import mqshop.utils.MyUtils;
import servlet.conn.connectDB;

@WebServlet(urlPatterns= {"/doEditBrand"})
@MultipartConfig
public class doEditBrand extends HttpServlet{
	private static final long serialVersionUID = 1L;
	private static final String UPLOAD_DIRECTORY="images";
	public doEditBrand() {
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
			System.out.println("3");
		}
		
		HttpSession session=request.getSession();
		
		USERS loginedUser=MyUtils.getstoreLoginedUser(session);
		String fileName = null;
		int brandID=Integer.parseInt(request.getParameter("brandID")); //Sai dòng này WTF
		
		String namebrand=request.getParameter("namebrand");
		String descriptionbrand=request.getParameter("descriptionbrand");
		
		Part filePart = request.getPart("image");
		fileName=filePart.getSubmittedFileName();
		String uploadPath=getServletContext().getRealPath("")+File.separator+UPLOAD_DIRECTORY;
		
		BRANDS brand=new BRANDS();
		//brand.setBrandID(Integer.parseInt((String) request.getAttribute("brandID")));
		brand.setBrandID(brandID);
		brand.setNamebrand(namebrand);
		brand.setDescriptionbrand(descriptionbrand);
		brand.setImage(UPLOAD_DIRECTORY+"/"+fileName);
		brand.setUpdatedby(loginedUser.getUsername());

		try {
			//System.out.println("1");
			DBUtils.updateBrand(conn, brand);
			//System.out.println("2");
			
			//if(filePart!=null) {
			File fileSaveDir = new File(uploadPath);
			if (!fileSaveDir.exists()) {
	            fileSaveDir.mkdirs();
	        }
	        System.out.println("Upload File Directory="+fileSaveDir.getAbsolutePath());
	       
	        for (Part part : request.getParts()) { 	        	
	        	fileName=filePart.getSubmittedFileName();
	        	part.write(uploadPath + File.separator + fileName);
	            request.setAttribute("part", part);
	            }
			//}
		} catch (SQLException e) {
			System.out.println("4");
			e.printStackTrace();
			errorString=e.getMessage();
		}
		
		request.setAttribute("errorString", errorString);
		request.setAttribute("brand", brand);
		if(errorString!=null||namebrand=="") {
			RequestDispatcher dispatcher=request.getServletContext().getRequestDispatcher("/WEB-INF/Views/EditBrand.jsp");
			dispatcher.forward(request, response);
		}
		else
		{
			response.sendRedirect(request.getContextPath()+"/brand");
		}
		
	}
}
