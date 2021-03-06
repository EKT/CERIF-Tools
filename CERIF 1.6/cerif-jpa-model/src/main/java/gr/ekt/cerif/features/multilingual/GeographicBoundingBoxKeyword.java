/**
 * 
 */
package gr.ekt.cerif.features.multilingual;

import gr.ekt.cerif.entities.second.GeographicBoundingBox;
import gr.ekt.cerif.entities.second.Language;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

/**
 * Holds the multi-lingual Keyword of a GeographicBoundingBox entity.
 * 
 */
@Entity
@Table(name="cfGeoBBoxKeyw", uniqueConstraints=@UniqueConstraint(columnNames={"cfGeoBBoxId","cfLangCode","cfTrans"}))
public class GeographicBoundingBoxKeyword implements CerifMultipleLanguageFeature {

	/**
	 * Serialization version.
	 */
	private static final long serialVersionUID = -3070001859572613664L;

	/**
	 * 
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	/**
	 * The geographic bounding box.
	 */
	@ManyToOne(optional=false)
	@JoinColumn(name="cfGeoBBoxId")
	private GeographicBoundingBox geographicBoundingBox;
	
	/**
	 * The language.
	 */
	@ManyToOne(optional=false)
	@JoinColumn(name="cfLangCode")
	private Language language;
	
	/**
	 * The translation.
	 */
	@NotNull
	@Column(name="cfTrans")
	@Enumerated(EnumType.STRING)
	private Translation translation;
	
	/**
	 * The result product keyword.
	 */
	@NotNull
	@Column(name="cfKeyw", length=20000)
	private String keyword;

	/**
	 * Default Constructor
	 */
	public GeographicBoundingBoxKeyword() {
		
	}
	
	/**
	 * 
	 * @param geographicBoundingBox
	 * @param language
	 * @param translation
	 * @param keyword
	 */
	public GeographicBoundingBoxKeyword(
			GeographicBoundingBox geographicBoundingBox, Language language,
			Translation translation, String keyword) {
		this.geographicBoundingBox = geographicBoundingBox;
		this.language = language;
		this.translation = translation;
		this.keyword = keyword;
	}

	/**
	 * @return the geographicBoundingBox
	 */
	public GeographicBoundingBox getGeographicBoundingBox() {
		return geographicBoundingBox;
	}

	/**
	 * @param geographicBoundingBox the geographicBoundingBox to set
	 */
	public void setGeographicBoundingBox(GeographicBoundingBox geographicBoundingBox) {
		this.geographicBoundingBox = geographicBoundingBox;
	}

	/**
	 * @return the language
	 */
	public Language getLanguage() {
		return language;
	}

	/**
	 * @param language the language to set
	 */
	public void setLanguage(Language language) {
		this.language = language;
	}

	/**
	 * @return the translation
	 */
	public Translation getTranslation() {
		return translation;
	}

	/**
	 * @param translation the translation to set
	 */
	public void setTranslation(Translation translation) {
		this.translation = translation;
	}

	/**
	 * @return the keyword
	 */
	public String getKeyword() {
		return keyword;
	}

	/**
	 * @param keyword the keyword to set
	 */
	public void setKeyword(String keyword) {
		this.keyword = keyword;
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

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "GeographicBoundingBoxKeyword [id=" + id + ", language="
				+ language + ", translation=" + translation + ", keyword="
				+ keyword + "]";
	}
	
	
}
