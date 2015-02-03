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
 * Represents a FormalisedDublinCoreRightsManagementPrivacy entity.
 * 
 */
@Deprecated
@Entity
@Table(name="cfFDCRightsMmPrivacy", uniqueConstraints=@UniqueConstraint(columnNames={"cfDCId","cfDCScheme","cfDCLangTag","cfDCTrans"}))
public class FormalisedDublinCoreRightsManagementPrivacy implements CerifAdditionalFeature {
	
	/**
	 * Serialization version.
	 */
	private static final long serialVersionUID = -3018927119137749738L;	

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
	@Column(name="cfFDCPrivacyConstraint")
	private String privacyConstraint;
		

	/**
	 * Default Constructor
	 */
	public FormalisedDublinCoreRightsManagementPrivacy() {
		
	}
	
	/**
	 * 
	 * @param scheme
	 * @param language
	 * @param translation
	 * @param privacyConstraint
	 */
	public FormalisedDublinCoreRightsManagementPrivacy(String scheme,
			String language, String translation, String privacyConstraint) {
		this.scheme = scheme;
		this.language = language;
		this.translation = translation;
		this.privacyConstraint = privacyConstraint;
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

	/**
	 * @return the privacyConstraint
	 */
	public String getPrivacyConstraint() {
		return privacyConstraint;
	}

	/**
	 * @param privacyConstraint the privacyConstraint to set
	 */
	public void setPrivacyConstraint(String privacyConstraint) {
		this.privacyConstraint = privacyConstraint;
	}
	
}
