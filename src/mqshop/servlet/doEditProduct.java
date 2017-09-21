package mqshop.servlet;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Arrays;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import mqshop.beans.ATTRIBUTE_VALUES;
import mqshop.beans.PRODUCTS;
import mqshop.beans.USERS;
import mqshop.utils.DBUtils;
import mqshop.utils.MyUtils;
import servlet.conn.connectDB;

@WebServlet(urlPatterns= {"/doEditProduct"})
@MultipartConfig
public class doEditProduct extends HttpServlet{
	private static final long serialVersionUID = 1L;
	private static final String UPLOAD_DIRECTORY="images";
	public doEditProduct() {
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
		
		HttpSession session=request.getSession();
		
		USERS loginedUser=MyUtils.getstoreLoginedUser(session);
		
		
		int productID=Integer.parseInt(request.getParameter("productID"));
		
		String nameproduct=request.getParameter("nameproduct");
		int categoryid=Integer.parseInt(request.getParameter("categoryID"));
		int brandid=Integer.parseInt(request.getParameter("brandID"));
		Double originalprice= Double.parseDouble(request.getParameter("originalprice"));
		Double price= Double.parseDouble(request.getParameter("price"));
		Double promotionprice= Double.parseDouble(request.getParameter("promotionprice"));
		int quantity=Integer.parseInt(request.getParameter("quantity"));
		int warranty=Integer.parseInt(request.getParameter("warranty"));
		String descriptionproduct=request.getParameter("descriptionproduct");
		String contentproduct=request.getParameter("contentproduct");
		
		
		String fileName=null;
		Part filePart = request.getPart("image"); 
		fileName=filePart.getSubmittedFileName();
		String uploadPath=getServletContext().getRealPath("")+File.separator+UPLOAD_DIRECTORY;
		
		PRODUCTS product=new PRODUCTS();
		product.setProductID(productID);
		product.setNameproduct(nameproduct);
		product.setCategoryID(categoryid);
		product.setBrandID(brandid);
		product.setImageproduct(UPLOAD_DIRECTORY+"/"+fileName);
		product.setOriginalprice(originalprice);
		product.setPrice(price);
		product.setPromotionprice(promotionprice);
		product.setQuantity(quantity);
		product.setWarranty(warranty);
		product.setDescriptionproduct(descriptionproduct);
		product.setContentproduct(contentproduct);
		product.setUpdatedby(loginedUser.getUsername());
		
		if(nameproduct==""||originalprice.toString()==""||price.toString()=="") {
			errorString="Chưa nhập đầy đủ thông tin sản phẩm!";	
		}
		
		if(errorString==null) {
			try {
				
				DBUtils.updateProduct(conn, product);
			
		File fileSaveDir = new File(uploadPath);
		if (!fileSaveDir.exists()) {
            fileSaveDir.mkdirs();
        }				
       
        for (Part part : request.getParts()) {
        	fileName=filePart.getSubmittedFileName();
        	part.write(uploadPath + File.separator + fileName);
            request.setAttribute("part",part);   
        }
        System.out.println("Upload File Directory="+fileSaveDir.getAbsolutePath());
	
        String[] array=request.getParameterValues("attributeID");
        int[] attributeid = Arrays.stream(array).mapToInt(Integer::parseInt).toArray();
        String[] values=request.getParameterValues("value");
        //int maxid=DBUtils.getMaxProductID(conn);
        
        for(int i=0;i<values.length;i++) {
        	ATTRIBUTE_VALUES attributevalue=new ATTRIBUTE_VALUES();
        	attributevalue.setProductID(productID);
        	attributevalue.setAttributeID(attributeid[i]);
        	attributevalue.setValue(values[i]);
        			        	
        	DBUtils.updateAttributeValue(conn, attributevalue);
        	}
			} catch (SQLException e) {
				e.printStackTrace();
			}			
		}
		if(errorString!=null) {
			request.setAttribute("errorString", errorString);
				RequestDispatcher dispatcher=request.getServletContext().getRequestDispatcher("/WEB-INF/Views/EditProduct.jsp");
				dispatcher.forward(request, response);
		}
		else
		{
			response.sendRedirect(request.getContextPath()+"/product");
		}
	}
}
