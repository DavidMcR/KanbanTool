package dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;

@Entity (name="BLOG1")
public class Blog1 {
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int aKey;
	@Column(columnDefinition="TEXT")
	private String thingString;
	//@Temporal(Temporal)
	private Date insertDate;
	private String userId;
	private String title;
	

	public Blog1(){
		
	}

	public String getThingString() {
		return thingString;
	}

	public void setThingString(String thingString) {
		this.thingString = thingString;
	}

	public int getaKey() {
		return aKey;
	}

	public void setaKey(int aKey) {
		this.aKey = aKey;
	}

	public Date getInsertDate() {
		return insertDate;
	}

	public void setInsertDate(java.util.Date date) {
		this.insertDate =  date;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}



}
