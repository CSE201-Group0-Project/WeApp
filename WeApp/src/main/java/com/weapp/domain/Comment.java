package com.weapp.domain;

import java.util.*;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="@id")
public class Comment implements Comparable<Comment>{
	private Integer id;
	private String content;
	private User user; 
	private Application application; 
	private SortedSet<Comment> comments = new TreeSet<>(); 
	private Comment comment; 
	private Date createdDate;

	public Comment() {}


	public Comment(Integer id, String content, User user, Application application, Date createdDate) {
		super();
		this.id = id;
		this.content = content;
		this.user = user;
		this.application = application;
		this.createdDate = createdDate;
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

	@Column(length=2000)
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}

	@ManyToOne
	@JsonIgnore
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}

	@ManyToOne
	@JsonIgnore
	public Application getApplication() {
		return application;
	}

	public void setApplication(Application application) {
		this.application = application;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	@OneToMany(cascade = CascadeType.ALL, mappedBy="comment")
	@OrderBy("createdDate, id")
	public SortedSet<Comment> getComments() {
		return comments;
	}


	public void setComments(SortedSet<Comment> comments) {
		this.comments = comments;
	}

	@ManyToOne
	@JoinColumn(name="comment_id", nullable=true)
	@JsonIgnore
	public Comment getComment() {
		return comment;
	}


	public void setComment(Comment comment) {
		this.comment = comment;
	}


	@Override
	public String toString() {
		return "Comment [id=" + id + ", content=" + content + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Comment other = (Comment) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}


	@Override
	public int compareTo(Comment c) {
		int compare = this.createdDate.compareTo(c.createdDate); 
		if (compare == 0) {
			compare = this.id.compareTo(c.id);
		}
		return compare;
	} 

}
