package mqshop.beans;

public class ATTRIBUTE_VALUES_MODEL {
	int attributeID;
	String nameattribute;
	int productID;
	String value;
	
	public ATTRIBUTE_VALUES_MODEL() {
	}
	
	public ATTRIBUTE_VALUES_MODEL(int attributeID,	String nameattribute,int productID, String value) {
		this.attributeID=attributeID;
		this.nameattribute=nameattribute;
		this.productID=productID;
		this.value=value;
	}
	
	public void setAttributeID(int attributeID) {
		this.attributeID=attributeID;
	}
	public int getAttributeID() {
		return attributeID;
	}
	
	public void setNameattribute(String nameattribute) {
		this.nameattribute = nameattribute;
	}
	
	public String getNameattribute() {
		return nameattribute;
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
