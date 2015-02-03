/**
 * 
 */
package gr.ekt.cerif.features.additional;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

/**
 * Represents a DublinCoreRightsManagementLicence entity.
 * 
 */
@Deprecated
@Entity
@Table(name="cfDCRightsMmLicense", uniqueConstraints=@UniqueConstraint(columnNames={"cfDCId","cfDCScheme","cfDCLangTag","cfDCTrans"}))
public class DublinCoreRightsManagementLicence implements CerifAdditionalFeature {
	
	/**
	 * Serialization version.
	 */
	private static final long serialVersionUID = 954935112142812372L;

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
	@NotNull
	@Column(name="cfDCScheme")
	private String scheme;
	
	/**
	 * The dc language.
	 */
	@NotNull
	@Column(name="cfDCLangTag")
	private String language;
	
	/**
	 * The dc translation.
	 */
	@NotNull
	@Column(name="cfDCTrans")
	private String translation;	
	
	/**
	 * The dc value.
	 */
	@Column(name="cfDCValue")
	private String value;

	/**
	 * Default Constructor
	 */
	public DublinCoreRightsManagementLicence() {
		
	}
	
	/**
	 * 
	 * @param scheme
	 * @param language
	 * @param translation
	 * @param value
	 */
	public DublinCoreRightsManagementLicence(String scheme, String language,
			String translation, String value) {
		this.scheme = scheme;
		this.language = language;
		this.translation = translation;
		this.value = value;
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

	

	
}
