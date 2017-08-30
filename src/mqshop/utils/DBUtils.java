package mqshop.utils;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import mqshop.beans.BRANDS;
import mqshop.beans.CATEGORIES;
import mqshop.beans.PRODUCTS;
import mqshop.beans.USERS;
import servlet.conn.connectDB;

public class DBUtils {
	//Sử dụng cho đăng nhập
	public static USERS findUser(Connection conn,String username,String password) throws SQLException {
		String sql="SELECT u.username, u.password FROM USERS u "+"WHERE u.username=? and u.password=?";
		PreparedStatement pstm=conn.prepareStatement(sql);
		pstm.setString(1, username);
		pstm.setString(2, password);
		ResultSet rs=pstm.executeQuery();
		
		while(rs.next()) {
			USERS user=new USERS();
			user.setUsername(username);
			user.setPassword(password);
			return user;
		}
		return null;
	}
	//dành cho Category
	public static List<CATEGORIES> queryCategory(Connection conn) throws SQLException{
		String sql="SELECT * FROM CATEGORIES";
		PreparedStatement pstm=conn.prepareStatement(sql);
		ResultSet rs=pstm.executeQuery();
		List<CATEGORIES> list=new ArrayList<CATEGORIES>();
		while(rs.next()) {
			int categoryID=rs.getInt("categoryID");
			String namecategory=rs.getString("namecategory");
			String descriptioncategory=rs.getString("descriptioncategory");
			Date createddate=rs.getDate("createddate");
			String createdby=rs.getString("createdby");
			Date updateddate=rs.getDate("updateddate");
			String updatedby=rs.getString("updatedby");
			CATEGORIES category=new CATEGORIES();
			category.setCategoryID(categoryID);
			category.setNamecategory(namecategory);
			category.setDescriptioncategory(descriptioncategory);
			category.setCreateddate(createddate);
			category.setCreatedby(createdby);
			category.setUpdateddate(updateddate);
			category.setUpdatedby(updatedby);
			list.add(category);
		}
		return list;
	}
	
	public static void insertCategory(Connection conn,CATEGORIES category) throws SQLException {
		String sql="INSERT INTO CATEGORIES(namecategory,descriptioncategory,createddate,createdby) VALUES(?,?,?,?)";
		PreparedStatement pstm=conn.prepareStatement(sql);
		pstm.setString(1, category.getNamecategory());
		pstm.setString(2, category.getDescriptioncategory());
		//pstm.setDouble(3, category.getDisplayorder());
		java.sql.Date sqldate = new java.sql.Date(new java.util.Date().getTime());
		pstm.setDate(3, sqldate);
		pstm.setString(4, category.getCreatedby());
		
		pstm.executeUpdate();
	}
	
	
	public static CATEGORIES findCategory(Connection conn,int categoryid) throws SQLException {
		String sql="SELECT * FROM CATEGORIES WHERE categoryID=?";
		PreparedStatement pstm=conn.prepareStatement(sql);
		//pstm.setString(1, categoryid);
		pstm.setInt(1, categoryid);
		ResultSet rs=pstm.executeQuery();
		while(rs.next()) {
			String namecategory=rs.getString("namecategory");
			String descriptioncategory=rs.getString("descriptioncategory");
			Date createddate=rs.getDate("createddate");
			String createdby=rs.getString("createdby");
			CATEGORIES category=new CATEGORIES();
			category.setCategoryID(categoryid);
			category.setNamecategory(namecategory);
			category.setDescriptioncategory(descriptioncategory);
			category.setCreateddate(createddate);
			category.setCreatedby(createdby);
			return category;
		}
		return null;
	}
	
	
	public static void updateCategory(Connection conn,CATEGORIES category) throws SQLException {
		String sql="UPDATE CATEGORIES SET namecategory=?, descriptioncategory=?, updateddate=?,updatedby=? WHERE categoryID=?";
		PreparedStatement pstm=conn.prepareStatement(sql);
		
		pstm.setString(1, category.getNamecategory());
		pstm.setString(2, category.getDescriptioncategory());
		java.sql.Date day = new java.sql.Date(new java.util.Date().getTime());
		pstm.setDate(3, day);
		pstm.setString(4, category.getUpdatedby());
		pstm.setInt(5, category.getCategoryID());
		pstm.executeUpdate();
	}
	
	public static void deleteCategory(Connection conn,int categoryid) throws SQLException {
		String sql="DELETE FROM CATEGORIES WHERE categoryID=?";
		PreparedStatement pstm=conn.prepareStatement(sql);
		pstm.setInt(1, categoryid);
		pstm.executeUpdate();
	}

	//Dành cho Brand
	public static List<BRANDS> queryBrand(Connection conn) throws SQLException{
		String sql="SELECT * FROM BRANDS";
		PreparedStatement pstm=conn.prepareStatement(sql);
		ResultSet rs=pstm.executeQuery();
		List<BRANDS> list=new ArrayList<BRANDS>();
		while(rs.next()) {
			BRANDS brand=new BRANDS();
			brand.setBrandID(rs.getInt("brandID"));
			brand.setNamebrand(rs.getString("namebrand"));		
			brand.setDescriptionbrand(rs.getString("descriptionbrand"));
			brand.setImage(rs.getString("image"));
			brand.setCreateddate(rs.getDate("createddate"));
			brand.setCreatedby(rs.getString("createdby"));
			brand.setUpdateddate(rs.getDate("updateddate"));
			brand.setUpdatedby(rs.getString("updatedby"));
			list.add(brand);
		}
		return list;
	}
	
	public static void insertBrand(Connection conn,BRANDS brand) throws SQLException {
		String sql="INSERT INTO BRANDS(namebrand,descriptionbrand,image,createddate,createdby) VALUES(?,?,?,?,?)";
		PreparedStatement pstm=conn.prepareStatement(sql);
		pstm.setString(1, brand.getNamebrand());
		pstm.setString(2, brand.getDescriptionbrand());
		pstm.setString(3, brand.getImage());
		java.sql.Date date=new java.sql.Date(new java.util.Date().getTime());
		pstm.setDate(4, date);
		pstm.setString(5, brand.getCreatedby());
		pstm.executeUpdate();
	}
	
}
