package com.weapp.domain;

import java.util.*;

public class Comment {
	private int commentId;
	private String content;
	
	public int getId() {
		return commentId;
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
	
	public void lastEdit() {
		//TimeStamp
		//lastEdit Time
	}
}
