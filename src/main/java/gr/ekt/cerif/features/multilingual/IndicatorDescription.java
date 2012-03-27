/**
 * 
 */
package gr.ekt.cerif.features.multilingual;

import gr.ekt.cerif.entities.second.Indicator;
import gr.ekt.cerif.entities.second.Language;
import gr.ekt.cerif.pk.IndicatorTranslationId;

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
 * Holds the multi-lingual description of a indicator entity.
 * 
 */
@Entity
@Table(name="cfIndicDescr")
@IdClass(IndicatorTranslationId.class)
public class IndicatorDescription implements IndicatorTranslation {
	
	/**
	 * Serialization version.
	 */
	private static final long serialVersionUID = -982789291669126629L;

	/**
	 * The indicator.
	 */
	@Id
	@ManyToOne
	@JoinColumn(name="cfIndicId")
	private Indicator indicator;
	
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
	 * The indicator description.
	 */
	@Column(name="cfDescr")
	private String description;
	
	/**
	 * @return the indicator
	 */
	public Indicator getIndicator() {
		return indicator;
	}
	
	/**
	 * @param indicator the indicator to set
	 */
	public void setIndicator(Indicator indicator) {
		this.indicator = indicator;
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
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

}
