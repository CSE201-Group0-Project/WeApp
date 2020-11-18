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

/**
 * Simple domain object representing a comment
 */
@Entity
@JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="@id")
public class Comment implements Comparable<Comment>{
	
	/** The id. */
	private Integer id;
	
	/** The content. */
	private String content;
	
	/** The user. */
	private User user; 
	
	/** The application. */
	private Application application; 
	
	/** The comments. */
	private SortedSet<Comment> comments = new TreeSet<>(); 
	
	/** The comment. */
	private Comment comment; 
	
	/** The created date. */
	private Date createdDate;

	/**
	 * Instantiates a new comment.
	 */
	public Comment() {}


	/**
	 * Instantiates a new comment.
	 *
	 * @param id the id
	 * @param content the content
	 * @param user the user
	 * @param application the application
	 * @param createdDate the created date
	 */
	public Comment(Integer id, String content, User user, Application application, Date createdDate) {
		super();
		this.id = id;
		this.content = content;
		this.user = user;
		this.application = application;
		this.createdDate = createdDate;
	}


	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer getId() {
		return id;
	}
	
	/**
	 * Sets the id.
	 *
	 * @param id the new id
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * Gets the content.
	 *
	 * @return the content
	 */
	@Column(length=2000)
	public String getContent() {
		return content;
	}
	
	/**
	 * Sets the content.
	 *
	 * @param content the new content
	 */
	public void setContent(String content) {
		this.content = content;
	}

	/**
	 * Gets the user.
	 *
	 * @return the user
	 */
	@ManyToOne
	@JsonIgnore
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
	 * Gets the application.
	 *
	 * @return the application
	 */
	@ManyToOne
	@JsonIgnore
	public Application getApplication() {
		return application;
	}

	/**
	 * Sets the application.
	 *
	 * @param application the new application
	 */
	public void setApplication(Application application) {
		this.application = application;
	}

	/**
	 * Gets the created date.
	 *
	 * @return the created date
	 */
	public Date getCreatedDate() {
		return createdDate;
	}

	/**
	 * Sets the created date.
	 *
	 * @param createdDate the new created date
	 */
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	/**
	 * Gets the comments.
	 *
	 * @return the comments
	 */
	@OneToMany(cascade = CascadeType.ALL, mappedBy="comment")
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
	 * Gets the comment.
	 *
	 * @return the comment
	 */
	@ManyToOne
	@JoinColumn(name="comment_id", nullable=true)
	@JsonIgnore
	public Comment getComment() {
		return comment;
	}


	/**
	 * Sets the comment.
	 *
	 * @param comment the new comment
	 */
	public void setComment(Comment comment) {
		this.comment = comment;
	}


	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "Comment [id=" + id + ", content=" + content + "]";
	}

	/**
	 * Hash code.
	 *
	 * @return the int
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	
	/**
	 * Equals.
	 *
	 * @param obj the obj
	 * @return true, if successful
	 */
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


	/**
	 * Compare to.
	 *
	 * @param c the c
	 * @return the int
	 */
	@Override
	public int compareTo(Comment c) {
		int compare = this.createdDate.compareTo(c.createdDate); 
		if (compare == 0) {
			compare = this.id.compareTo(c.id);
		}
		return compare;
	} 

}
