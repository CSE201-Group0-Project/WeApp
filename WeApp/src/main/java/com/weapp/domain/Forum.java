package com.weapp.domain;

import java.util.*;

public class Forum {
	private int forumId;
	private String title;
	private String content;
	
	public int getId() {
		return forumId;
	}
	
	public String getTitle() {
		return title;
	}
	
	public String getContent() {
		return content;
	}
	
	public String author(String RegisteredUser) {
		return RegisteredUser;
	}
	
	public void created() {
		//TimeStamp
		//Created Time
	}
	
	public void lastModified() {
		//The lastModified Date
	}
			
}
