package mqshop.beans;

public class ATTRIBUTES {
	public int attributeID;
	public String nameattribute;
	
	public ATTRIBUTES() {
	}
	
	public ATTRIBUTES(int attributeID,String nameattribute) {
		this.attributeID=attributeID;
		this.nameattribute=nameattribute;
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
}
