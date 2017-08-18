package mqshop.beans;

import java.sql.Date;

public class ORDERS {
	public int orderID;
	public String customername;
	public String customeremail;
	public String customerphone;
	public String customeraddress;
	public String customermessage;
	public Date createddate;
	public String createdby;
	public double ordertotal;
	public String paymentmethod;
	public int orderstatus;
	public String userID;
	public int paymentstatus;
	
	public ORDERS() {
	}
	public void setOrderID(int orderID) {
		this.orderID = orderID;
	}
	public int getOrderID() {
		return orderID;
	}
	public void setCustomername(String customername) {
		this.customername = customername;
	}
	public String getCustomername() {
		return customername;
	}
	public void setCustomeremail(String customeremail) {
		this.customeremail = customeremail;
	}
	public String getCustomeremail() {
		return customeremail;
	}
	public void setCustomerphone(String customerphone) {
		this.customerphone = customerphone;
	}
	public String getCustomerphone() {
		return customerphone;
	}
	public void setCustomeraddress(String customeraddress) {
		this.customeraddress = customeraddress;
	}
	public String getCustomeraddress() {
		return customeraddress;
	}
	public void setCustomermessage(String customermessage) {
		this.customermessage = customermessage;
	}
	public String getCustomermessage() {
		return customermessage;
	}
	public void setCreateddate(Date createddate) {
		this.createddate = createddate;
	}
	public Date getCreateddate() {
		return createddate;
	}
	public void setCreatedby(String createdby) {
		this.createdby = createdby;
	}
	public String getCreatedby() {
		return createdby;
	}
	public void setOrdertotal(double ordertotal) {
		this.ordertotal = ordertotal;
	}
	public double getOrdertotal() {
		return ordertotal;
	}
	public void setPaymentmethod(String paymentmethod) {
		this.paymentmethod = paymentmethod;
	}
	public String getPaymentmethod() {
		return paymentmethod;
	}
	public void setOrderstatus(int orderstatus) {
		this.orderstatus = orderstatus;
	}
	public int getOrderstatus() {
		return orderstatus;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	public String getUserID() {
		return userID;
	}
	public void setPaymentstatus(int paymentstatus) {
		this.paymentstatus = paymentstatus;
	}
	public int getPaymentstatus() {
		return paymentstatus;
	}
}
