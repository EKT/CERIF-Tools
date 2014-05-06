/**
 * 
 */
package gr.ekt.cerif.features.multilingual;

import gr.ekt.cerif.entities.second.Language;
import gr.ekt.cerif.entities.second.Prize;

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
 * Holds the multi-lingual name of a prize entity.
 * 
 */
@Entity
@Table(name="cfPrizeName", uniqueConstraints=@UniqueConstraint(columnNames={"cfPrizeId","cfLangCode","cfTrans"}))
public class PrizeName implements CerifMultipleLanguageFeature {
	
	/**
	 * Serialization version.
	 */
	private static final long serialVersionUID = -7325278088389319180L;

	/**
	 * 
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	/**
	 * The prize.
	 */
	@ManyToOne(optional=false)
	@JoinColumn(name="cfPrizeId")
	private Prize prize;
	
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
	 * The prize name.
	 */
	@NotNull
	@Column(name="cfName")
	private String name;
	
	/**
	 * Default Constructor
	 */
	public PrizeName() {
		
	}
	
	/**
	 * 
	 * @param prize
	 * @param language
	 * @param translation
	 * @param name
	 */
	public PrizeName(Prize prize, Language language, Translation translation,
			String name) {
		this.prize = prize;
		this.language = language;
		this.translation = translation;
		this.name = name;
	}

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
		return "PrizeName [id=" + id + ", language=" + language
				+ ", translation=" + translation + ", name=" + name + "]";
	}

}
