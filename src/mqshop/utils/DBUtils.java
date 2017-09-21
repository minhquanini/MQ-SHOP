package mqshop.utils;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.api.jdbc.Statement;

import mqshop.beans.ATTRIBUTES;
import mqshop.beans.ATTRIBUTE_VALUES;
import mqshop.beans.ATTRIBUTE_VALUES_MODEL;
import mqshop.beans.BRANDS;
import mqshop.beans.CATEGORIES;
import mqshop.beans.PRODUCTS;
import mqshop.beans.PRO_CA_BRA;
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
	
	
	public static List<PRO_CA_BRA> queryPROCABRA(Connection conn) throws SQLException{
		String sql="SELECT c.*,a.namecategory,b.namebrand FROM CATEGORIES a,BRANDS b, PRODUCTS c WHERE c.brandID=b.brandID and c.categoryID=a.categoryID";
		
		PreparedStatement pstm=conn.prepareStatement(sql);
		//pstm.setInt(1, productid);
		ResultSet rs=pstm.executeQuery();
		List<PRO_CA_BRA> list=new ArrayList<PRO_CA_BRA>();
		while(rs.next()) {
			PRO_CA_BRA pca=new PRO_CA_BRA();
			pca.setProductID(rs.getInt("productID"));
			pca.setNameproduct(rs.getString("nameproduct"));
			pca.setCategoryID(rs.getInt("categoryID"));
			pca.setBrandID(rs.getInt("brandID"));
			pca.setImageproduct(rs.getString("imageproduct"));
			pca.setOriginalprice(rs.getDouble("originalprice"));
			pca.setPrice(rs.getDouble("price"));
			pca.setPromotionprice(rs.getDouble("promotionprice"));
			pca.setQuantity(rs.getInt("quantity"));
			pca.setWarranty(rs.getInt("warranty"));
			pca.setDescriptionproduct(rs.getString("descriptionproduct"));
			pca.setContentproduct(rs.getString("contentproduct"));
			pca.setNamecategory(rs.getString("namecategory"));
			pca.setNamebrand(rs.getString("namebrand"));
			list.add(pca);
		}
		return list;
	}
	
	/*
	public static PRODUCTS findCategoryfromPID(Connection conn,int productid) throws SQLException {
		String sql="SELECT categoryID FROM PRODUCTS WHERE productID=?";
		PreparedStatement pstm=conn.prepareStatement(sql);
		pstm.setInt(1, productid);
		ResultSet rs=pstm.executeQuery();
		while(rs.next()) {
			PRODUCTS product=new PRODUCTS();
			product.setCategoryID(rs.getInt("categoryID"));
			return product;
		}
		return null;
	}
	*/
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
	
	
	public static BRANDS findBrand(Connection conn,int brandid) throws SQLException {
		String sql="SELECT * FROM BRANDS WHERE brandID=?";
		PreparedStatement pstm=conn.prepareStatement(sql);
		pstm.setInt(1, brandid);
		ResultSet rs=pstm.executeQuery();
		while(rs.next()) {
			String namebrand=rs.getString("namebrand");
			String descriptionbrand=rs.getString("descriptionbrand");
			Date createddate=rs.getDate("createddate");
			String createdby=rs.getString("createdby");
			BRANDS category=new BRANDS();
			category.setBrandID(brandid);
			category.setNamebrand(namebrand);
			category.setDescriptionbrand(descriptionbrand);
			category.setCreateddate(createddate);
			category.setCreatedby(createdby);
			return category;
		}
		return null;
	}
	
	public static PRODUCTS findProduct(Connection conn,int productid) throws SQLException {
		String sql="SELECT * FROM PRODUCTS WHERE productID=?";
		PreparedStatement pstm=conn.prepareStatement(sql);
		pstm.setInt(1, productid);
		ResultSet rs=pstm.executeQuery();
		while(rs.next()) {
			PRODUCTS product=new PRODUCTS();
			product.setProductID(productid);
			product.setNameproduct(rs.getString("nameproduct"));
			product.setCategoryID(rs.getInt("categoryID"));
			product.setBrandID(rs.getInt("brandID"));
			product.setImageproduct(rs.getString("imageproduct"));
			product.setOriginalprice(rs.getDouble("originalprice"));
			product.setPrice(rs.getDouble("price"));
			product.setPromotionprice(rs.getDouble("promotionprice"));
			product.setQuantity(rs.getInt("quantity"));
			product.setWarranty(rs.getInt("warranty"));
			product.setDescriptionproduct(rs.getString("descriptionproduct"));
			product.setContentproduct(rs.getString("contentproduct"));
			product.setCreateddate(rs.getDate("createddate"));
			product.setCreatedby(rs.getString("createdby"));
			return product;
		}
		return null;
	}
/*	
	public static List<ATTRIBUTE_VALUES> findProductinValue(Connection conn,int productid) throws SQLException {
		String sql= "SELECT a.attributeID,a.value,b.nameattribute FROM ATTRIBUTE_VALUES a, ATTRIBUTES b WHERE a.attributeID=b.attributeID and productID=?";
		PreparedStatement pstm=conn.prepareStatement(sql);
		pstm.setInt(1, productid);
		ResultSet rs=pstm.executeQuery();
		List<ATTRIBUTE_VALUES> list=new ArrayList<ATTRIBUTE_VALUES>();
		while(rs.next()) {
			ATTRIBUTE_VALUES attributevalue=new ATTRIBUTE_VALUES();
			attributevalue.setAttributeID(rs.getInt("attributeID"));
			attributevalue.setValue(rs.getString("value"));
			
			list.add(attributevalue);
		}
		return list;
	}
	*/
	public static List<ATTRIBUTE_VALUES> findProductinValue(Connection conn,int productid) throws SQLException {
		String sql= "SELECT attributeID,value FROM ATTRIBUTE_VALUES WHERE productID=?";
		PreparedStatement pstm=conn.prepareStatement(sql);
		pstm.setInt(1, productid);
		ResultSet rs=pstm.executeQuery();
		List<ATTRIBUTE_VALUES> list=new ArrayList<ATTRIBUTE_VALUES>();
		while(rs.next()) {
			ATTRIBUTE_VALUES attributevalue=new ATTRIBUTE_VALUES();
			attributevalue.setProductID(productid);
			attributevalue.setAttributeID(rs.getInt("attributeID"));
			attributevalue.setValue(rs.getString("value"));
			list.add(attributevalue);
		}
		return list;
	}
	
	public static List<ATTRIBUTE_VALUES_MODEL> ProductinValue(Connection conn,int productid) throws SQLException {
		String sql= "SELECT a.attributeID,a.value,b.nameattribute FROM ATTRIBUTE_VALUES a, ATTRIBUTES b WHERE a.attributeID=b.attributeID and productID=?";
		PreparedStatement pstm=conn.prepareStatement(sql);
		pstm.setInt(1, productid);
		ResultSet rs=pstm.executeQuery();
		List<ATTRIBUTE_VALUES_MODEL> list=new ArrayList<ATTRIBUTE_VALUES_MODEL>();
		while(rs.next()) {
			ATTRIBUTE_VALUES_MODEL avm=new ATTRIBUTE_VALUES_MODEL();
			avm.setAttributeID(rs.getInt("attributeID"));
			avm.setNameattribute(rs.getString("nameattribute"));
			avm.setValue(rs.getString("value"));
			list.add(avm);
		}
		return list;
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
	
	public static void updateBrand(Connection conn,BRANDS brand) throws SQLException {
		String sql="UPDATE BRANDS SET namebrand=?, descriptionbrand=?, image=?, updateddate=?,updatedby=? WHERE brandID=?";
		PreparedStatement pstm=conn.prepareStatement(sql);
		
		pstm.setString(1, brand.getNamebrand());
		pstm.setString(2, brand.getDescriptionbrand());
		pstm.setString(3, brand.getImage());
		java.sql.Date day = new java.sql.Date(new java.util.Date().getTime());
		pstm.setDate(4, day);
		pstm.setString(5, brand.getUpdatedby());
		pstm.setInt(6, brand.getBrandID());
		pstm.executeUpdate();
	}
	
	public static void updateAttributeValue(Connection conn, ATTRIBUTE_VALUES attributevalue) throws SQLException {
		String sql="UPDATE ATTRIBUTE_VALUES SET value=? WHERE productID=? and attributeID=?";
		PreparedStatement pstm=conn.prepareStatement(sql);
		//pstm.setInt(1, attributevalue.getAttributeID());
		pstm.setString(1, attributevalue.getValue());
		pstm.setInt(2, attributevalue.getProductID());
		pstm.setInt(3, attributevalue.getAttributeID());
		pstm.executeUpdate();
	}
	
	public static void updateProduct(Connection conn,PRODUCTS product) throws SQLException {
		String sql="UPDATE PRODUCTS SET nameproduct=?,categoryID=?,brandID=?,imageproduct=?,originalprice=?,price=?,promotionprice=?,quantity=?,warranty=?,descriptionproduct=?,contentproduct=?,updateddate=?,updatedby=? WHERE productID=?";
		PreparedStatement pstm=conn.prepareStatement(sql);
		pstm.setString(1, product.getNameproduct());
		pstm.setInt(2, product.getCategoryID());
		pstm.setInt(3, product.getBrandID());
		pstm.setString(4, product.getImageproduct());
		pstm.setDouble(5, product.getOriginalprice());
		pstm.setDouble(6, product.getPrice());
		pstm.setDouble(7, product.getPromotionprice());
		pstm.setInt(8, product.getQuantity());
		pstm.setInt(9, product.getWarranty());
		pstm.setString(10, product.getDescriptionproduct());
		pstm.setString(11, product.getContentproduct());
		java.sql.Date date=new java.sql.Date(new java.util.Date().getTime());
		pstm.setDate(12, date);
		pstm.setString(13, product.getUpdatedby());
		pstm.setInt(14, product.getProductID());
		pstm.executeUpdate();
	}
	
	public static void deleteCategory(Connection conn,int categoryid) throws SQLException {
		String sql="DELETE FROM CATEGORIES WHERE categoryID=?";
		PreparedStatement pstm=conn.prepareStatement(sql);
		pstm.setInt(1, categoryid);
		pstm.executeUpdate();
	}
	
	
	public static void deleteBrand(Connection conn,int brandid) throws SQLException {
		String sql="DELETE FROM BRANDS WHERE brandID=?";
		PreparedStatement pstm=conn.prepareStatement(sql);
		pstm.setInt(1, brandid);
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
		
	
	public static void insertAttribute(Connection conn, ATTRIBUTES attribute) throws SQLException {
		String sql="INSERT INTO ATTRIBUTES(nameattribute) VALUES(?)";
		PreparedStatement pstm=conn.prepareStatement(sql);
		pstm.setString(1, attribute.getNameattribute());
		pstm.executeUpdate();
	}
	
	public static List<ATTRIBUTES> queryAttribute(Connection conn) throws SQLException{
		String sql="SELECT * FROM ATTRIBUTES";
		PreparedStatement pstm=conn.prepareStatement(sql);
		ResultSet rs=pstm.executeQuery();
		List<ATTRIBUTES> list=new ArrayList<ATTRIBUTES>();
		while(rs.next()) {
			ATTRIBUTES attribute=new ATTRIBUTES();
			attribute.setAttributeID(rs.getInt("attributeID"));
			attribute.setNameattribute(rs.getString("nameattribute"));
			list.add(attribute);
	}
		return list;
	}
	
	
	public static List<PRODUCTS> queryProduct(Connection conn) throws SQLException{
		String sql="SELECT * FROM PRODUCTS";
		PreparedStatement pstm=conn.prepareStatement(sql);
		ResultSet rs=pstm.executeQuery();
		List<PRODUCTS> list=new ArrayList<PRODUCTS>();
		while(rs.next()) {
			PRODUCTS product=new PRODUCTS();
			product.setProductID(rs.getInt("productID"));
			product.setNameproduct(rs.getString("nameproduct"));
			product.setCategoryID(rs.getInt("categoryID"));
			product.setBrandID(rs.getInt("brandID"));
			product.setImageproduct(rs.getString("imageproduct"));
			product.setOriginalprice(rs.getDouble("originalprice"));
			product.setPrice(rs.getDouble("price"));
			product.setPromotionprice(rs.getDouble("promotionprice"));
			product.setQuantity(rs.getInt("quantity"));
			product.setWarranty(rs.getInt("warranty"));
			product.setDescriptionproduct(rs.getString("descriptionproduct"));
			product.setContentproduct(rs.getString("contentproduct"));
			
			list.add(product);
		}
		return list;
	}
	
	public static void deleteAttribute(Connection conn,int attributeID) throws SQLException {
		String sql="DELETE FROM ATTRIBUTES WHERE attributeID=?";
		PreparedStatement pstm=conn.prepareStatement(sql);
		pstm.setInt(1, attributeID);
		pstm.executeUpdate();
	}
	
	public static void deleteProduct(Connection conn,int productID) throws SQLException {
		String sql="DELETE FROM PRODUCTS WHERE productID=?";
		PreparedStatement pstm=conn.prepareStatement(sql);
		pstm.setInt(1, productID);
		pstm.executeUpdate();
	}

	public static void deleteAttributeValue(Connection conn,int productID) throws SQLException {
		String sql="DELETE FROM ATTRIBUTE_VALUES WHERE productID=?";
		PreparedStatement pstm=conn.prepareStatement(sql);
		pstm.setInt(1, productID);
		pstm.executeUpdate();
	}
	
	public static void insertProduct(Connection conn,PRODUCTS product) throws SQLException {
		String sql="INSERT INTO PRODUCTS(nameproduct,categoryID,brandID,imageproduct,originalprice,price,promotionprice,quantity,warranty,descriptionproduct,contentproduct,createddate,createdby) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)";
		//PreparedStatement pstm=conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
		PreparedStatement pstm=conn.prepareStatement(sql);
		pstm.setString(1, product.getNameproduct());
		pstm.setInt(2, product.getCategoryID());
		pstm.setInt(3, product.getBrandID());
		pstm.setString(4, product.getImageproduct());
		pstm.setDouble(5, product.getOriginalprice());
		pstm.setDouble(6, product.getPrice());
		pstm.setDouble(7, product.getPromotionprice());
		pstm.setInt(8, product.getQuantity());
		pstm.setInt(9, product.getWarranty());
		pstm.setString(10, product.getDescriptionproduct());
		pstm.setString(11, product.getContentproduct());
		java.sql.Date date=new java.sql.Date(new java.util.Date().getTime());
		pstm.setDate(12, date);
		pstm.setString(13, product.getCreatedby());
		pstm.executeUpdate();
		/*
		 ResultSet rs = pstm.getGeneratedKeys();
		 int productid =0;
		 if(rs.next())
         {
             productid = rs.getInt(1);
         }
		 
		return productid;
		*/
	}
	
	//insert vào bảng ATTRIBUTES-VALUES
	public static void insertAttributeValue(Connection conn,ATTRIBUTE_VALUES attributevalue) throws SQLException {
		String sql="INSERT INTO ATTRIBUTE_VALUES(attributeID,productID,value) VALUES(?,?,?)";
		PreparedStatement pstm=conn.prepareStatement(sql);
		pstm.setInt(1, attributevalue.getAttributeID());
		pstm.setInt(2, attributevalue.getProductID());
		pstm.setString(3, attributevalue.getValue());
		pstm.executeUpdate();
	}
	

	public static int getMaxProductID(Connection conn) throws SQLException {
		String sql="SELECT productID FROM PRODUCTS ORDER BY productID DESC LIMIT 1;";
		PreparedStatement pstm=conn.prepareStatement(sql);
		ResultSet rs=pstm.executeQuery();
		PRODUCTS product = null;
		while(rs.next()) {
			product=new PRODUCTS();
			product.setProductID(rs.getInt("productID"));
		}
		return product.productID;
	}
}
