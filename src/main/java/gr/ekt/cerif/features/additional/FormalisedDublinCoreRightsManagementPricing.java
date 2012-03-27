/**
 * 
 */
package gr.ekt.cerif.features.additional;

import gr.ekt.cerif.pk.DublinCoreBasicId;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

/**
 * Represents a FormalisedDublinCoreRightsManagementPricing entity.
 * 
 */
@Entity
@Table(name="cfFDCRightsMmPricing")
@IdClass(DublinCoreBasicId.class)
public class FormalisedDublinCoreRightsManagementPricing implements CerifAdditionalFeature {
	
	/**
	 * Serialization version.
	 */
	private static final long serialVersionUID = -8844386719992207726L;

	/**
	 * The id.
	 */
	@Id
	@Column(name="cfDCId")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;

	/**
	 * The dc scheme.
	 */
	@Id
	@Column(name="cfDCScheme")
	private String scheme;
	
	/**
	 * The dc language.
	 */
	@Id
	@Column(name="cfDCLangTag")
	private String language;
	
	/**
	 * The dc translation.
	 */
	@Id
	@Column(name="cfDCTrans")
	private String translation;	
	
	/**
	 * The dc value.
	 */
	@Column(name="cfFDCPriceConstraint")
	private String priceConstraint;
		

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

	public String getScheme() {
		return scheme;
	}

	public void setScheme(String scheme) {
		this.scheme = scheme;
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
	 * @return the priceConstraint
	 */
	public String getPriceConstraint() {
		return priceConstraint;
	}

	/**
	 * @param priceConstraint the priceConstraint to set
	 */
	public void setPriceConstraint(String priceConstraint) {
		this.priceConstraint = priceConstraint;
	}

	

	
}
