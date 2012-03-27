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
 * Holds the multi-lingual name of a GeographicBoundingBox entity.
 * 
 */
@Entity
@Table(name="cfGeoBBoxName")
@IdClass(GeographicBoundingBoxTranslationId.class)
public class GeographicBoundingBoxName implements GeographicBoundingBoxTranslation {

	/**
	 * Serialization version.
	 */
	private static final long serialVersionUID = -7165918906048986591L;

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
	 * The result product name.
	 */
	@Column(name="cfName")
	private String name;
		

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
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}	
}
