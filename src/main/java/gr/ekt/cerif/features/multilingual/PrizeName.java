/**
 * 
 */
package gr.ekt.cerif.features.multilingual;

import gr.ekt.cerif.entities.second.Prize;
import gr.ekt.cerif.entities.second.Language;
import gr.ekt.cerif.pk.PrizeTranslationId;

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
 * Holds the multi-lingual name of a prize entity.
 * 
 */
@Entity
@Table(name="cfPrizeName")
@IdClass(PrizeTranslationId.class)
public class PrizeName implements PrizeTranslation {
	
	/**
	 * Serialization version.
	 */
	private static final long serialVersionUID = -7325278088389319180L;

	/**
	 * The prize.
	 */
	@Id
	@ManyToOne
	@JoinColumn(name="cfPrizeId")
	private Prize prize;
	
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
	 * The prize name.
	 */
	@Column(name="cfName")
	private String name;
	
	/**
	 * @return the prize
	 */
	public Prize getPrize() {
		return prize;
	}
	
	/**
	 * @param prize the prize to set
	 */
	public void setPrize(Prize prize) {
		this.prize = prize;
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
