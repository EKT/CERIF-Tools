package gr.ekt.cerif.features.additional;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;

@Entity
@Table(name="Feedback")
public class Feedback implements CerifAdditionalFeature {

	/**
	 * 
	 */
	private static final long serialVersionUID = -43621784312612349L;
	
	/**
	 * The id.
	 */
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;

	/**
	 * The user name.
	 */
	@Column(name="name")
	private String name;
	
	/**
	 * The user email.
	 */
	@Column(name="email")
	private String email;
	
	/**
	 * The user comments.
	 */
	@Column(name="comments")
	private String comments;

	/**
	 * The timestamp.
	 */
	@Column(name="created")
	private Date created;
	
	public Feedback() {
	
	}
	
	public Feedback(String name, String email, String comments) {
		super();
		this.name = name;
		this.email = email;
		this.comments = comments;
	}

	@PrePersist
	protected void onCreate() {
		created = new Date();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}
}
