/*
 * Thanks to Trevor Page for the equals method for the Comment entity
 * https://github.com/tp02ga/FreshVotes/blob/master/FreshVotes/src/main/java/com/freshvotes/domain/Comment.java
 * 
 * Thanks to Jackson Annotations - @JsonIdentityInfo for explaining the use of @JsonIdentityInfo
 * https://www.tutorialspoint.com/jackson_annotations/jackson_annotations_jsonidentityinfo.htm
 * 
 * Thanks to Baeldung for Overview of JPA/Hibernate Cascade Types
 * https://www.baeldung.com/jpa-cascade-types
 */
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
 * Simple domain object representing a comment.
 * @JsonIdentityInfo is used when there is a parent-child relationship
 * and that the entity will be used for serialization/deserialization
 * @Entity is used to indicate that it is a JPA entity
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
	 */
	public Comment(Integer id, String content) {
		this.id = id;
		this.content = content;
	}


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
	 * GenerationType.IDENTITY allows for auto-incremented of id 
	 * 
	 * Thanks to Baeldung for Overview of JPA/Hibernate Cascade Types
	 * https://www.baeldung.com/jpa-cascade-types
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
	 * @ManyToOne indicate a many-to-one relationship 
	 * @JsonIgnore is used to ignore this field during serialization to JSON
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
	 * @ManyToOne indicate a many-to-one relationship
	 * @JsonIgnore is used to ignore this field during serialization to JSON
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
	 * The sorted set of comment is referencing the owner comment 
	 * @OneToMany indicate a one-to-many relationship 
	 * 
	 * CascadeType.ALL make the parent's operations to propagate from a parent to all child entity
	 * 
	 * Thanks to Baeldung for Overview of JPA/Hibernate Cascade Types
	 * https://www.baeldung.com/jpa-cascade-types
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
	 * @JoinColumn indicates that comment_id column in the owner 
	 * comment refers to a primary key in the reference comment
	 * @ManyToOne indicate a many-to-one relationship 
	 * @JsonIgnore is used to ignore this field during serialization to JSON
	 * 
	 * Thanks to Baeldung for the explanation of @JoinColumn annotation
	 * https://www.baeldung.com/jpa-join-column
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
		int hash = 1;
		hash = hash * prime + ((id == null) ? 0 : id.hashCode());
		return hash;
	}
	
	/**
	 * Equals method.
	 *
	 * @param obj the obj
	 * @return true, if successful
	 */
	@Override
	public boolean equals(Object obj) {
		// check if obj equals this obj (same ref) 
		if (this == obj)
			return true;
		// check if obj is null 
		if (obj == null)
			return false;
		// check if obj is different class 
		if (getClass() != obj.getClass())
			return false;
		// Cast compared object to Comment 
		Comment other = (Comment) obj;
		// compare inner id 
		if (id == null) {
			// check if object id is null and if the compared obj is not null 
			if (other.id != null)
				return false;
			// check if compared object and inner id is not equal 
		} else if (!id.equals(other.id))
			return false;
		return true;
	}


	/**
	 * Compare to comment based on createdDate
	 * If created dates of the two comments are equal 
	 * Compare by id.
	 *
	 * @param c the comment being compared 
	 * @return the int compare value
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
