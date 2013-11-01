package dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;

@Entity (name="ITEM")
public class Item {
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int aKey;
	@Column(columnDefinition="TEXT")
	private String userTextEntry;
	//@Temporal(Temporal)
	private Date insertDate;  //This gives the date the item entry was added.
	private int commentIndex;
	private String userId;    //This gives the userId of the individual that created the entry.
	private String title;     //This gives the title of the entry. (For forums can be used to group them. 
	private String type;      //This is weather it is a blog or a forum entry.
	private String itemName;      //This is the user assigned name. To help get the details for the user. 
	private String content;
	private String comment1;
	private String comment2;
	private String comment3;
	private String comment4;
	private String comment5;
	private String comment6;
	private String comment7;
	private String comment8;
	private String comment9;
	private String comment10;
	
	public int getaKey() {
		return aKey;
	}
	public void setaKey(int aKey) {
		this.aKey = aKey;
	}
	public String getUserTextEntry() {
		return userTextEntry;
	}
	public void setUserTextEntry(String userTextEntry) {
		this.userTextEntry = userTextEntry;
	}
	public Date getInsertDate() {
		return insertDate;
	}
	public void setInsertDate(Date insertDate) {
		this.insertDate = insertDate;
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
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getName() {
		return itemName;
	}
	public void setName(String name) {
		this.itemName = name;
	}
	public String getComment1() {
		return comment1;
	}
	public void setComment1(String comment1) {
		this.comment1 = comment1;
	}
	public String getComment2() {
		return comment2;
	}
	public void setComment2(String comment2) {
		this.comment2 = comment2;
	}
	public String getComment3() {
		return comment3;
	}
	public void setComment3(String comment3) {
		this.comment3 = comment3;
	}
	public String getComment4() {
		return comment4;
	}
	public void setComment4(String comment4) {
		this.comment4 = comment4;
	}
	public String getComment5() {
		return comment5;
	}
	public void setComment5(String comment5) {
		this.comment5 = comment5;
	}
	public String getComment6() {
		return comment6;
	}
	public void setComment6(String comment6) {
		this.comment6 = comment6;
	}
	public String getComment7() {
		return comment7;
	}
	public void setComment7(String comment7) {
		this.comment7 = comment7;
	}
	public String getComment8() {
		return comment8;
	}
	public void setComment8(String comment8) {
		this.comment8 = comment8;
	}
	public String getComment9() {
		return comment9;
	}
	public void setComment9(String comment9) {
		this.comment9 = comment9;
	}
	public String getComment10() {
		return comment10;
	}
	public void setComment10(String comment10) {
		this.comment10 = comment10;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}

	public int getCommentIndex() {
		return commentIndex;
	}
	public void setCommentIndex(int commentIndex) {
		this.commentIndex = commentIndex;
	}

	








}
