package mqshop.utils;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import mqshop.beans.CATEGORIES;
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
	
	public static List<CATEGORIES> queryCategory(Connection conn) throws SQLException{
		String sql="SELECT * FROM CATEGORIES";
		PreparedStatement pstm=conn.prepareStatement(sql);
		ResultSet rs=pstm.executeQuery();
		List<CATEGORIES> list=new ArrayList<CATEGORIES>();
		while(rs.next()) {
			//int categoryID=rs.getInt("categoryID");
			String namecategory=rs.getString("namecategory");
			String descriptioncategory=rs.getString("descriptioncategory");
			//int displayorder=rs.getInt("displayorder");//Thứ tự hiển thị của danh mục
			String imagecategory=rs.getString("imagecategory");
			Date createddate=rs.getDate("createddate");
			String createdby=rs.getString("createdby");
			Date updateddate=rs.getDate("updateddate");
			String updatedby=rs.getString("updatedby");
			CATEGORIES category=new CATEGORIES();
			//category.setCategoryID(categoryID);
			category.setNamecategory(namecategory);
			category.setDescriptioncategory(descriptioncategory);
			//category.setDisplayorder(displayorder);
			category.setImagecategory(imagecategory);
			category.setCreateddate(createddate);
			category.setCreatedby(createdby);
			category.setUpdateddate(updateddate);
			category.setUpdatedby(updatedby);
			list.add(category);
		}
		return list;
	}
	
	
	
}
