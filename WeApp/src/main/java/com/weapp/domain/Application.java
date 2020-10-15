package com.weapp.domain;

import java.util.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="applications")
public class Application {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id; 
	private String description; 
	private String organization; 
	private ArrayList<String> platform; 
	private String version; 
	private String link; 
	private double price; 
	

	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public ArrayList<String> getPlatform() {
		return platform;
	}
	public void setPlatform(ArrayList<String> platform) {
		this.platform = platform;
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
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
}
