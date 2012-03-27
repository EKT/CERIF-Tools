/**
 * 
 */
package gr.ekt.cerif.features.additional;

import java.util.Date;

import gr.ekt.cerif.pk.DublinCoreBasicId;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

/**
 * Represents a DublinCoreCoverageTemporal entity.
 * 
 */
@Entity
@Table(name="cfDCCoverageTemporal")
@IdClass(DublinCoreBasicId.class)
public class DublinCoreCoverageTemporal implements CerifAdditionalFeature {
	
	/**
	 * Serialization version.
	 */
	private static final long serialVersionUID = 2922890823330685903L;

	/**
	 * The citation id.
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
	@Column(name="cfDCValue")
	private String value;
		
	/**
	 * The dc type.
	 */	
	@Column(name="cfFDCStartDateTime")
	private Date startDate;
	
	/**
	 * The dc type.
	 */	
	@Column(name="cfFDCEndDateTime")
	private Date endDate;
	
	/**
	 * The dc precision.
	 */
	@Column(name="cfFDCPrecision")
	private Double precision;

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

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public Date getStartDate() {
		return startDate;
	}

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

	/**
	 * @return the precision
	 */
	public Double getPrecision() {
		return precision;
	}

	/**
	 * @param precision the precision to set
	 */
	public void setPrecision(Double precision) {
		this.precision = precision;
	}

	

	
}
