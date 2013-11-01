package dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;

@Entity (name="TABLE_LIST")
public class TableList {
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int aKey;
	private String TableName;
	private String ItemName;
	

	public TableList(){
		
	}


	public int getaKey() {
		return aKey;
	}


	public void setaKey(int aKey) {
		this.aKey = aKey;
	}


	public String getTableName() {
		return TableName;
	}


	public void setTableName(String tableName) {
		TableName = tableName;
	}


	public String getItemName() {
		return ItemName;
	}


	public void setItemName(String itemName) {
		ItemName = itemName;
	}


}
