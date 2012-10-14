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
 * Holds the multi-lingual name of a GeographicBoundingBox entity.
 * 
 */
@Entity
@Table(name="cfGeoBBoxName", uniqueConstraints=@UniqueConstraint(columnNames={"cfGeoBBoxId","cfLangCode","cfTrans"}))
public class GeographicBoundingBoxName implements GeographicBoundingBoxTranslation {

	/**
	 * Serialization version.
	 */
	private static final long serialVersionUID = -7165918906048986591L;
	
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
	 * The result product name.
	 */
	@Column(name="cfName")
	private String name;
	
	/**
	 * Default Constructor
	 */
	public GeographicBoundingBoxName() {
		
	}

	/**
	 * 
	 * @param geographicBoundingBox
	 * @param language
	 * @param translation
	 * @param name
	 */
	public GeographicBoundingBoxName(
			GeographicBoundingBox geographicBoundingBox, Language language,
			Translation translation, String name) {
		this.geographicBoundingBox = geographicBoundingBox;
		this.language = language;
		this.translation = translation;
		this.name = name;
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
}
