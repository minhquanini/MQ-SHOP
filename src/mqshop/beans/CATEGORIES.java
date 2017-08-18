package mqshop.beans;

import java.sql.Date;

public class CATEGORIES {
	public int categoryID;
	public String namecategory;
	public String descriptioncategory;
	public int displayorder;
	public String imagecategory;
	public Date createddate;
	public String createdby;
	public Date updateddate;
	public String updatedby;
	
	
	public CATEGORIES() {
	}
	
	public void setCategoryID(int categoryID) {
		this.categoryID = categoryID;
	}
	public int getCategoryID() {
		return categoryID;
	}
	public void setNamecategory(String namecategory) {
		this.namecategory = namecategory;
	}
	public String getNamecategory() {
		return namecategory;
	}
	public void setDescriptioncategory(String descriptioncategory) {
		this.descriptioncategory = descriptioncategory;
	}
	public String getDescriptioncategory() {
		return descriptioncategory;
	}
	public void setDisplayorder(int displayorder) {
		this.displayorder = displayorder;
	}
	public int getDisplayorder() {
		return displayorder;
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
	public void setImagecategory(String imagecategory) {
		this.imagecategory = imagecategory;
	}
	public String getImagecategory() {
		return imagecategory;
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
