
package gr.ekt.cerif.features.additional;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * An entity to save the sent emails (NO CERIF ENTITY).
 * 
 */
@Entity
@Table(name="SentEmails")
public class SentEmails implements CerifAdditionalFeature {
	

	/**
	 * 
	 */
	private static final long serialVersionUID = -1754013789601164804L;

	/**
	 * The id.
	 */
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;

	/**
	 * The sender name.
	 */
	@Column(name="senderName")
	private String senderName;
	
	/**
	 * The sender organisation.
	 */
	@Column(name="senderOrg")
	private String senderOrganisation;
	
	/**
	 * The sender email.
	 */
	@Column(name="senderEmail")
	private String senderEmail;
	
	/**
	 * The Subject.
	 */
	@Column(name="subject")
	private String subject;
	
	/**
	 * The sender Subject.
	 */
	@Column(name="message")
	private String message;
	
	/**
	 * The receiverName.
	 */
	@Column(name="receiverName")
	private String receiverName;
	
	/**
	 * The receiverEmail.
	 */
	@Column(name="receiverEmail")
	private String receiverEmail;
	
	/**
	 * The date.
	 */
	@Column (name="date")
	private Date date;
	
	
	/**
	 * Default Constructor
	 */
	public SentEmails() {
		
	}

	public SentEmails(String senderName, String senderOrganisation,
			String senderEmail, String subject, String message, String receiverName, String receiverEmail, Date date) {
		super();
		this.senderName = senderName;
		this.senderOrganisation = senderOrganisation;
		this.senderEmail = senderEmail;
		this.subject = subject;
		this.message = message;
		this.receiverName = receiverName;
		this.receiverEmail = receiverEmail;
		this.date = date;
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the senderName
	 */
	public String getSenderName() {
		return senderName;
	}

	/**
	 * @param senderName the senderName to set
	 */
	public void setSenderName(String senderName) {
		this.senderName = senderName;
	}

	/**
	 * @return the senderOrganisation
	 */
	public String getSenderOrganisation() {
		return senderOrganisation;
	}

	/**
	 * @param senderOrganisation the senderOrganisation to set
	 */
	public void setSenderOrganisation(String senderOrganisation) {
		this.senderOrganisation = senderOrganisation;
	}

	/**
	 * @return the senderEmail
	 */
	public String getSenderEmail() {
		return senderEmail;
	}

	/**
	 * @param senderEmail the senderEmail to set
	 */
	public void setSenderEmail(String senderEmail) {
		this.senderEmail = senderEmail;
	}

	/**
	 * @return the subject
	 */
	public String getSubject() {
		return subject;
	}

	/**
	 * @param senderSubject the subject to set
	 */
	public void setSubject(String subject) {
		this.subject = subject;
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}	

	/**
	 * @return the receiverName
	 */
	public String getReceiverName() {
		return receiverName;
	}

	/**
	 * @param receiverName the receiverName to set
	 */
	public void setReceiverName(String receiverName) {
		this.receiverName = receiverName;
	}

	/**
	 * @return the receiverEmail
	 */
	public String getReceiverEmail() {
		return receiverEmail;
	}

	/**
	 * @param receiverEmail the receiverEmail to set
	 */
	public void setReceiverEmail(String receiverEmail) {
		this.receiverEmail = receiverEmail;
	}

	/**
	 * @return the date
	 */
	public Date getDate() {
		return date;
	}

	/**
	 * @param date the date to set
	 */
	public void setDate(Date date) {
		this.date = date;
	}
	
	
	

}