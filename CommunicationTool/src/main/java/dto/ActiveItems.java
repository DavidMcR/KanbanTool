package dto;

public class ActiveItems {
	private String type;      //This is whether it is a blog or a forum entry.
	private String itemName;      //This is the user assigned name. To help get the details for the user. 
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
}
