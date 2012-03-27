/**
 * 
 */
package gr.ekt.cerif.features.additional;

import java.util.Date;

import gr.ekt.cerif.pk.DublinCoreRelationId;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

/**
 * Represents a DublinCoreRelation entity.
 * 
 */
@Entity
@Table(name="cfDCRelation")
@IdClass(DublinCoreRelationId.class)
public class DublinCoreRelation implements CerifAdditionalFeature {
	
	/**
	 * Serialization version.
	 */
	private static final long serialVersionUID = -6244475539548543386L;	

	/**
	 * The id1.
	 */
	@Column(name="cfDCId1")
	private Long id1;
	
	/**
	 * The id2.
	 */
	@Id
	@Column(name="cfDCId2")
	private Long id2;	

	/**
	 * The dc scheme1.
	 */
	@Id
	@Column(name="cfDCScheme1")
	private String scheme1;
	
	/**
	 * The dc scheme2.
	 */
	@Id
	@Column(name="cfDCScheme2")
	private String scheme2;
	
	/**
	 * The dc language.
	 */
	@Id
	@Column(name="cfDCLangTag", length=5)
	private String language;
	
	/**
	 * The dc translation.
	 */
	@Id
	@Column(name="cfDCTrans", length=1)
	private String translation;
	
	/**
	 * The dc dateBegin.
	 */
	@Id
	@Column(name="cfDCStartDate")
	private Date startDate;
	
	/**
	 * The dc dateEnd.
	 */
	@Id
	@Column(name="cfDCEndDate")
	private Date endDate;
	
	/**
	 * The dc type.
	 */	
	@Column(name="cfDCType")
	private String type;
	
	/**
	 * The dc value.
	 */
	@Column(name="cfDCValue")
	private String value;	

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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	

	
}
