package com.gc.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity 
@Table(name = "Item")


public class Item implements Serializable {

	private String inHamper;
	private int userId;
	private String type;
	private String cat;
	private String description;
	private String imageURL;
	private int itemId;
	
	public Item() {
		
	}
	
	//itemID removed from below constructor since it's auto-generated
	public Item(String inHamper, int userId, String type, String description, String imageURL, String cat) {
		super();
		this.inHamper = inHamper;
		this.userId = userId;
		this.type = type;
		this.description = description;
		this.imageURL = imageURL;
		this.cat = cat;
	}
	
	
	@Column
	public String getInHamp() {
		return inHamper;
	}
	public void setInHamp(String inHamper) {
		this.inHamper = inHamper;
	}

	@Column
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	@Column
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	@Column
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	@Column
	public String getImageURL() {
		return imageURL;
	}
	public void setImageURL(String imageURL) {
		this.imageURL = imageURL;
	}
	
	@Id
	@GeneratedValue
	@Column
	public int getItemId() {
		return itemId;
	}
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
	
	@Column
	public String getCategory() {
		return cat;
	}

	public void setCategory(String cat) {
		this.cat = cat;
	}
	
	
	
}
