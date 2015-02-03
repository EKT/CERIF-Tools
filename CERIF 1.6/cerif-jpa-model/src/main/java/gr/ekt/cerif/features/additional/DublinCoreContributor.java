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
 * Represents a DublinCoreContributor entity.
 * 
 */
@Deprecated
@Entity
@Table(name="cfDCContributor", uniqueConstraints=@UniqueConstraint(columnNames={"cfDCId","cfDCScheme","cfDCLangTag","cfDCTrans"}))
public class DublinCoreContributor implements CerifAdditionalFeature {
	
	/**
	 * Serialization version.
	 */
	private static final long serialVersionUID = 6519153957836420918L;	

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
	 * Default Constructor
	 */
	public DublinCoreContributor() {
		
	}
	
	/**
	 * 
	 * @param scheme
	 * @param language
	 * @param translation
	 * @param type
	 * @param value
	 */
	public DublinCoreContributor(String scheme, String language,
			String translation, String type, String value) {
		this.scheme = scheme;
		this.language = language;
		this.translation = translation;
		this.type = type;
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
