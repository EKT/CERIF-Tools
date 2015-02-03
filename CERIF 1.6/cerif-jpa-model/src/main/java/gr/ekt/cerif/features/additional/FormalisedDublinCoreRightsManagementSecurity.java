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
 * Represents a FormalisedDublinCoreSecurityManagementSecurity entity.
 * 
 */
@Deprecated
@Entity
@Table(name="cfFDCSecurityMmSecurity", uniqueConstraints=@UniqueConstraint(columnNames={"cfDCId","cfDCScheme","cfDCLangTag","cfDCTrans"}))
public class FormalisedDublinCoreRightsManagementSecurity implements CerifAdditionalFeature {
	
	/**
	 * Serialization version.
	 */
	private static final long serialVersionUID = 7791516269083238557L;

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
	@Column(name="cfFDCSecurityConstraint")
	private String securityConstraint;
		
	/**
	 * Default Constructor
	 */
	public FormalisedDublinCoreRightsManagementSecurity() {
		
	}
	
	/**
	 * 
	 * @param scheme
	 * @param language
	 * @param translation
	 * @param securityConstraint
	 */
	public FormalisedDublinCoreRightsManagementSecurity(String scheme,
			String language, String translation, String securityConstraint) {
		this.scheme = scheme;
		this.language = language;
		this.translation = translation;
		this.securityConstraint = securityConstraint;
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
	 * @return the securityConstraint
	 */
	public String getSecurityConstraint() {
		return securityConstraint;
	}

	/**
	 * @param securityConstraint the securityConstraint to set
	 */
	public void setSecurityConstraint(String securityConstraint) {
		this.securityConstraint = securityConstraint;
	}
	
}
