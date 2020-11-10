package com.weapp.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Application {
	

	private int id; 
	private String name; 
	private String description; 
	private String organization; 
	private String platform; 
	private String category; 
	private String version; 
	private String link; 
	private String imgSrc;
	private String screenshots; 
	private double price; 
	private boolean approved; 
	private User user; 

	public Application() {}
	
	public Application(int id, String name, String description, String organization, String platform, String category,
			String version, String link, String imgSrc, String screenshots, double price, boolean approved, User user) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.organization = organization;
		this.platform = platform;
		this.category = category;
		this.version = version;
		this.link = link;
		this.imgSrc = imgSrc;
		this.screenshots = screenshots;
		this.price = price;
		this.approved = approved;
		this.user = user;
	}



	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getOrganization() {
		return organization;
	}
	public void setOrganization(String organization) {
		this.organization = organization;
	}
	public String getPlatform() {
		return platform;
	}
	public void setPlatform(String platform) {
		this.platform = platform;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public String getImgSrc() {
		return imgSrc;
	}
	public void setImgSrc(String imgSrc) {
		this.imgSrc = imgSrc;
	}
	public String getScreenshots() {
		return screenshots;
	}
	public void setScreenshots(String screenshots) {
		this.screenshots = screenshots;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	public boolean getApproved() {
		return approved;
	}
	public void setApproved(boolean approved) {
		this.approved = approved;
	}
	@ManyToOne
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	@Override
	public String toString() {
		return "Application [id=" + id + ", name=" + name + ", description=" + description + ", organization="
				+ organization + ", platform=" + platform + ", category=" + category + ", version=" + version
				+ ", link=" + link + ", imgSrc=" + imgSrc + ", price=" + price + ", approved=" + approved + ", user="
				+ user + "]";
	}
}
