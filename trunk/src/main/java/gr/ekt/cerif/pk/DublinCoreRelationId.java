/**
 * 
 */
package gr.ekt.cerif.pk;

import java.io.Serializable;
import java.util.Date;

/**
 * Compound key for DublinCoreRelation
 * 
 */
public class DublinCoreRelationId implements Serializable  {

	/**
	 * Serialization version.
	 */
	private static final long serialVersionUID = -3627131743816010103L;

	private Long id1;
	
	private Long id2;	
	
	private String scheme1;
	
	private String scheme2;
	
	private String language;
	
	private String translation;
	
	private Date startDate;
	
	private Date endDate;

	/**
	 * @return the id1
	 */
	public Long getId1() {
		return id1;
	}

	/**
	 * @param id1 the id1 to set
	 */
	public void setId1(Long id1) {
		this.id1 = id1;
	}	

	/**
	 * @return the id2
	 */
	public Long getId2() {
		return id2;
	}

	/**
	 * @param id2 the id2 to set
	 */
	public void setId2(Long id2) {
		this.id2 = id2;
	}

	/**
	 * @return the scheme1
	 */
	public String getScheme1() {
		return scheme1;
	}

	/**
	 * @param scheme1 the scheme1 to set
	 */
	public void setScheme1(String scheme1) {
		this.scheme1 = scheme1;
	}

	/**
	 * @return the scheme2
	 */
	public String getScheme2() {
		return scheme2;
	}

	/**
	 * @param scheme2 the scheme2 to set
	 */
	public void setScheme2(String scheme2) {
		this.scheme2 = scheme2;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getTranslation() {
		return translation;
	}

	public void setTranslation(String translation) {
		this.translation = translation;
	}

	/**
	 * @return the startDate
	 */
	public Date getStartDate() {
		return startDate;
	}

	/**
	 * @param startDate the startDate to set
	 */
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	/**
	 * @return the endDate
	 */
	public Date getEndDate() {
		return endDate;
	}

	/**
	 * @param endDate the endDate to set
	 */
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	
	
}
