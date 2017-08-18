package mqshop.beans;

import java.sql.Date;

public class BRANDS {
	public int brandID;
	public String namebrand;
	public String descriptionbrand;
	public String image;
	public Date createddate;
	public String createdby;
	public Date updateddate;
	public String updatedby;
	
	public BRANDS() {
	}
	
	public void setBrandID(int brandID) {
		this.brandID = brandID;
	}
	public int getBrandID() {
		return brandID;
	}
	public void setNamebrand(String namebrand) {
		this.namebrand = namebrand;
	}
	public String getNamebrand() {
		return namebrand;
	}
	public void setDescriptionbrand(String descriptionbrand) {
		this.descriptionbrand = descriptionbrand;
	}
	public String getDescriptionbrand() {
		return descriptionbrand;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getImage() {
		return image;
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
