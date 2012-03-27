/**
 * 
 */
package gr.ekt.cerif.features.multilingual;

import gr.ekt.cerif.entities.second.GeographicBoundingBox;
import gr.ekt.cerif.entities.second.Language;
import gr.ekt.cerif.pk.GeographicBoundingBoxTranslationId;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Holds the multi-lingual Keyword of a GeographicBoundingBox entity.
 * 
 */
@Entity
@Table(name="cfGeoBBoxKeyw")
@IdClass(GeographicBoundingBoxTranslationId.class)
public class GeographicBoundingBoxKeyword implements GeographicBoundingBoxTranslation {

	/**
	 * Serialization version.
	 */
	private static final long serialVersionUID = -3070001859572613664L;

	/**
	 * The geographic bounding box.
	 */
	@Id
	@ManyToOne
	@JoinColumn(name="cfGeoBBoxId")
	private GeographicBoundingBox geographicBoundingBox;
	
	/**
	 * The language.
	 */
	@Id
	@ManyToOne
	@JoinColumn(name="cfLangCode")
	private Language language;
	
	/**
	 * The translation.
	 */
	@Id
	@Column(name="cfTrans")
	@Enumerated(EnumType.STRING)
	private Translation translation;
	
	/**
	 * The result product keyword.
	 */
	@Column(name="cfKeyw")
	private String keyword;

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
}
