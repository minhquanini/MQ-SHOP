package mqshop.utils;

import java.sql.Connection;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import mqshop.beans.USERS;

public class MyUtils {
	public static final String ATT_NAME_CONNECTION="ATTRIBUTE_FOR_CONNECTION";
	public static final String ATT_NAME_USER_NAME="ATTRIBUTE_FOR_STORE_USER_NAME";
	
	//Lưu trữ Connection vào một thuộc tính của Request. 
	public static void storeConnection(ServletRequest request, Connection conn) {
		request.setAttribute(ATT_NAME_CONNECTION, conn);
	}
	
	//Lấy Connection đã được lưu trữ vào request.
	public static Connection getStoredConnection(ServletRequest request) {
		Connection conn=(Connection) request.getAttribute(ATT_NAME_CONNECTION);
		return conn;
	}
	
	//Lưu thông tin người dùng vào Session
	public static void storeLoginedUser(HttpSession session,USERS loginedUser) {
		session.setAttribute("loginedUser", loginedUser);
	}
	
	//Lấy thông tin người dùng đã lưu vào Session
	public static USERS getstoreLoginedUser(HttpSession session) {
		USERS loginedUser=(USERS) session.getAttribute("loginedUser");
		return loginedUser;
	}
	
	/*
	public static boolean checkLoginedUser(HttpServletRequest request,USERS loginedUser) {
		HttpSession session=request.getSession();
		loginedUser=getstoreLoginedUser(session);
		if(loginedUser==null) return false;
		else return true;
	}
	*/
	
} 
