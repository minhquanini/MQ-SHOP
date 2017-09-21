package mqshop.servlet;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import mqshop.beans.BRANDS;
import mqshop.beans.USERS;
import mqshop.utils.DBUtils;
import mqshop.utils.MyUtils;
import servlet.conn.connectDB;

@WebServlet(urlPatterns= {"/doCreateBrand"})
@MultipartConfig(fileSizeThreshold=1024*1024*2, // 2MB
maxFileSize=1024*1024*10,      // 10MB
maxRequestSize=1024*1024*50)
public class doCreateBrand extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	private static final String UPLOAD_DIRECTORY="images";
	
	//private static final int MEMORY_THRESHOLD= 1024*1024*3;
	//private static final int MAX_FILE_SIZE=1024*1024*40;
	//private static final int MAX_REQUEST_SIZE=1024*1024*50;
	
	public doCreateBrand() {
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
		//doGet(request,response);
		
		
		Connection conn=null;
		String errorString=null;
		HttpSession session=request.getSession();
		try {
			conn=connectDB.getConnection();
		} catch (ClassNotFoundException e) {	
			e.printStackTrace();
		}
		
		USERS loginedUser=MyUtils.getstoreLoginedUser(session);
		
		String fileName = null;
		
		String namebrand=request.getParameter("namebrand");
		String descriptionbrand=request.getParameter("descriptionbrand");
		//String image=request.getParameter("image");
		Part filePart = request.getPart("image");
		
		
		//fileName=Paths.get(filePart.getSubmittedFileName()).getFileName().toString(); 
		fileName=filePart.getSubmittedFileName();
		String uploadPath=getServletContext().getRealPath("")+File.separator+UPLOAD_DIRECTORY;
		
		
		
		BRANDS brand=new BRANDS();
		brand.setNamebrand(namebrand);
		brand.setDescriptionbrand(descriptionbrand);
		//brand.setImage("images/"+image);
		brand.setImage(UPLOAD_DIRECTORY+"/"+fileName);
		brand.setCreatedby(loginedUser.getUsername());
		
		if(namebrand==""||descriptionbrand=="") {
			errorString="Nhập vào tên nhãn hiệu hoặc mô tả nhãn hiệu!";
		}
		
		if(errorString==null) {
			try {
				DBUtils.insertBrand(conn, brand);
				
				
				File fileSaveDir = new File(uploadPath);
				if (!fileSaveDir.exists()) {
		            fileSaveDir.mkdirs();
		        }
		        System.out.println("Upload File Directory="+fileSaveDir.getAbsolutePath());
		        //String fileName = null;
		        for (Part part : request.getParts()) {
		            //fileName = request.getPart("image");
		        	//fileName=Paths.get(filePart.getSubmittedFileName()).getFileName().toString(); // Bỏ lấy cả tên thư mục!!!!!	        	
		        	fileName=filePart.getSubmittedFileName();
		        	part.write(uploadPath + File.separator + fileName);
		            request.setAttribute("part", part);
		            
		        }
		        
				
				
					
			} catch (SQLException e) {
				e.printStackTrace();
				errorString="có lỗi 111";
				//request.setAttribute("errorString", errorString);
			}
		}
		
		request.setAttribute("errorString", errorString);
		
		
		if(errorString!=null) {
			RequestDispatcher dispatcher=request.getServletContext().getRequestDispatcher("/WEB-INF/Views/CreateBrand.jsp");
			dispatcher.forward(request, response);
		}
		else {
			//RequestDispatcher dispatcher=request.getServletContext().getRequestDispatcher("/WEB-INF/Views/Brand.jsp");
			//dispatcher.forward(request, response);
			response.sendRedirect(request.getContextPath()+"/brand");
			
		}
		
		
		
	}

}
