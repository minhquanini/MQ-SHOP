package mqshop.beans;

import java.sql.Date;

public class PRODUCTS {
	public int productID;
	public String nameproduct;
	public int categoryID;
	public int brandID;
	public String imageproduct;
	public double originalprice;
	public double price;
	public double promotionprice;
	public int warranty;
	public String descriptionproduct;
	public String contentproduct;
	public int sizeID;
	public Date createddate;
	public String createdby;
	public Date updateddate;
	public String updatedby;
	
	public PRODUCTS() {
	}
	
	public void setProductID(int productID) {
		this.productID = productID;
	}
	public int getProductID() {
		return productID;
	}
	public void setNameproduct(String nameproduct) {
		this.nameproduct = nameproduct;
	}
	public String getNameproduct() {
		return nameproduct;
	}
	public void setCategoryID(int categoryID) {
		this.categoryID = categoryID;
	}
	public int getCategoryID() {
		return categoryID;
	}
	public void setBrandID(int brandID) {
		this.brandID = brandID;
	}
	public int getBrandID() {
		return brandID;
	}
	public void setImageproduct(String imageproduct) {
		this.imageproduct = imageproduct;
	}
	public String getImageproduct() {
		return imageproduct;
	}
	public void setOriginalprice(double originalprice) {
		this.originalprice = originalprice;
	}
	public double getOriginalprice() {
		return originalprice;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public double getPrice() {
		return price;
	}
	public void setPromotionprice(double promotionprice) {
		this.promotionprice = promotionprice;
	}
	public double getPromotionprice() {
		return promotionprice;
	}
	public void setWarranty(int warranty) {
		this.warranty = warranty;
	}
	public int getWarranty() {
		return warranty;
	}
	public void setDescriptionproduct(String descriptionproduct) {
		this.descriptionproduct = descriptionproduct;
	}
	public String getDescriptionproduct() {
		return descriptionproduct;
	}
	public void setContentproduct(String contentproduct) {
		this.contentproduct = contentproduct;
	}
	public String getContentproduct() {
		return contentproduct;
	}
	public void setSizeID(int sizeID) {
		this.sizeID = sizeID;
	}
	public int getSizeID() {
		return sizeID;
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
	public void setUpdateddate(Date updateddate) {
		this.updateddate = updateddate;
	}
	public Date getUpdateddate() {
		return updateddate;
	}
	public void setUpdatedby(String updatedby) {
		this.updatedby = updatedby;
	}
	public String getUpdatedby() {
		return updatedby;
	}
}
