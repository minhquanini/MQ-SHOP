package mqshop.beans;

public class ATTRIBUTE_VALUES {
	public int attributeID;
	public int productID;
	public String value;
	
	public ATTRIBUTE_VALUES() {
	}
	
	public ATTRIBUTE_VALUES(int attributeID,int productID, String value) {
		this.attributeID=attributeID;
		this.productID=productID;
		this.value=value;
	}
	
	public void setAttributeID(int attributeID) {
		this.attributeID=attributeID;
	}
	public int getAttributeID() {
		return attributeID;
	}
	
	public void setProductID(int productID) {
		this.productID = productID;
	}
	
	public int getProductID() {
		return productID;
	}
	
	public void setValue(String value) {
		this.value = value;
	}
	
	public String getValue() {
		return value;
	}
}
