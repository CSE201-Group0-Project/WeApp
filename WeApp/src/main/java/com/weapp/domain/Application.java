/*
 * 
 */
package com.weapp.domain;

import java.util.SortedSet;
import java.util.TreeSet;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;

// TODO: Auto-generated Javadoc
/**
 * Simple domain object representing an application.
 */
@Entity
public class Application {


	/** The id. */
	private int id; 
	
	/** The name. */
	private String name; 
	
	/** The description. */
	private String description; 
	
	/** The organization. */
	private String organization; 
	
	/** The platform. */
	private String platform; 
	
	/** The category. */
	private String category; 
	
	/** The version. */
	private String version; 
	
	/** The link. */
	private String link; 
	
	/** The img src. */
	private String imgSrc;
	
	/** The screenshots. */
	private String screenshots; 
	
	/** The price. */
	private double price; 
	
	/** The approved. */
	private boolean approved; 
	
	/** The user. */
	private User user; 
	
	/** The comments. */
	private SortedSet<Comment> comments = new TreeSet<>();

	/**
	 * Instantiates a new application.
	 */
	public Application() {}
	

	/**
	 * Instantiates a new application.
	 *
	 * @param id the id
	 * @param name the name
	 * @param category the category
	 * @param user the user
	 */
	public Application(int id, String name, String category, User user) {
		super();
		this.id = id;
		this.name = name;
		this.category = category;
		this.user = user;
	}

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getId() {
		return id;
	}
	
	/**
	 * Sets the id.
	 *
	 * @param id the new id
	 */
	public void setId(int id) {
		this.id = id;
	}
	
	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Sets the name.
	 *
	 * @param name the new name
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Gets the description.
	 *
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	
	/**
	 * Sets the description.
	 *
	 * @param description the new description
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	
	/**
	 * Gets the organization.
	 *
	 * @return the organization
	 */
	public String getOrganization() {
		return organization;
	}
	
	/**
	 * Sets the organization.
	 *
	 * @param organization the new organization
	 */
	public void setOrganization(String organization) {
		this.organization = organization;
	}
	
	/**
	 * Gets the platform.
	 *
	 * @return the platform
	 */
	public String getPlatform() {
		return platform;
	}
	
	/**
	 * Sets the platform.
	 *
	 * @param platform the new platform
	 */
	public void setPlatform(String platform) {
		this.platform = platform;
	}
	
	/**
	 * Gets the category.
	 *
	 * @return the category
	 */
	public String getCategory() {
		return category;
	}
	
	/**
	 * Sets the category.
	 *
	 * @param category the new category
	 */
	public void setCategory(String category) {
		this.category = category;
	}
	
	/**
	 * Gets the version.
	 *
	 * @return the version
	 */
	public String getVersion() {
		return version;
	}
	
	/**
	 * Sets the version.
	 *
	 * @param version the new version
	 */
	public void setVersion(String version) {
		this.version = version;
	}
	
	/**
	 * Gets the link.
	 *
	 * @return the link
	 */
	public String getLink() {
		return link;
	}
	
	/**
	 * Sets the link.
	 *
	 * @param link the new link
	 */
	public void setLink(String link) {
		this.link = link;
	}
	
	/**
	 * Gets the img src.
	 *
	 * @return the img src
	 */
	public String getImgSrc() {
		return imgSrc;
	}
	
	/**
	 * Sets the img src.
	 *
	 * @param imgSrc the new img src
	 */
	public void setImgSrc(String imgSrc) {
		this.imgSrc = imgSrc;
	}
	
	/**
	 * Gets the screenshots.
	 *
	 * @return the screenshots
	 */
	public String getScreenshots() {
		return screenshots;
	}
	
	/**
	 * Sets the screenshots.
	 *
	 * @param screenshots the new screenshots
	 */
	public void setScreenshots(String screenshots) {
		this.screenshots = screenshots;
	}
	
	/**
	 * Gets the price.
	 *
	 * @return the price
	 */
	public double getPrice() {
		return price;
	}
	
	/**
	 * Sets the price.
	 *
	 * @param price the new price
	 */
	public void setPrice(double price) {
		this.price = price;
	}

	/**
	 * Gets the approved.
	 *
	 * @return the approved
	 */
	public boolean getApproved() {
		return approved;
	}
	
	/**
	 * Sets the approved.
	 *
	 * @param approved the new approved
	 */
	public void setApproved(boolean approved) {
		this.approved = approved;
	}
	
	/**
	 * Gets the user.
	 *
	 * @return the user
	 */
	@ManyToOne
	public User getUser() {
		return user;
	}
	
	/**
	 * Sets the user.
	 *
	 * @param user the new user
	 */
	public void setUser(User user) {
		this.user = user;
	}
	
	/**
	 * Gets the comments.
	 *
	 * @return the comments
	 */
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="application")
	@OrderBy("createdDate, id")
	public SortedSet<Comment> getComments() {
		return comments;
	}
	
	/**
	 * Sets the comments.
	 *
	 * @param comments the new comments
	 */
	public void setComments(SortedSet<Comment> comments) {
		this.comments = comments;
	}
	
	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "Application [id=" + id + ", name=" + name + ", description=" + description + ", organization="
				+ organization + ", platform=" + platform + ", category=" + category + ", version=" + version
				+ ", link=" + link + ", imgSrc=" + imgSrc + ", price=" + price + ", approved=" + approved + ", user="
				+ user + "]";
	}
}
