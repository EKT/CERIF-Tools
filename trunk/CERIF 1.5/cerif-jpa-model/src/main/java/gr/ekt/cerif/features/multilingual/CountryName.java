/**
 * 
 */
package gr.ekt.cerif.features.multilingual;

import gr.ekt.cerif.entities.second.Country;
import gr.ekt.cerif.entities.second.Language;

import javax.persistence.Cacheable;
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

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

/**
 * Holds the multi-lingual name of a country entity.
 * 
 */
@Entity
@Table(name="cfCountryName", uniqueConstraints=@UniqueConstraint(columnNames={"cfCountryCode","cfLangCode","cfTrans"}))
@Cacheable
@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
public class CountryName implements CerifMultipleLanguageFeature {
	
	/**
	 * Serialization version.
	 */
	private static final long serialVersionUID = 2434897846250953784L;

	/**
	 * 
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;

	/**
	 * The country.
	 */
	@ManyToOne(optional=false)
	@JoinColumn(name="cfCountryCode")
	@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
	private Country country;
	
	/**
	 * The language.
	 */
	@ManyToOne(optional=false)
	@JoinColumn(name="cfLangCode")
	@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
	private Language language;
	
	/**
	 * The translation.
	 */
	@NotNull
	@Column(name="cfTrans")
	@Enumerated(EnumType.STRING)
	private Translation translation;
	
	/**
	 * The country name.
	 */
	@NotNull
	@Column(name="cfName")
	private String name;
	
	/**
	 * Default Constructor
	 */
	public CountryName() {
		
	}
	
	/**
	 * 
	 * @param country
	 * @param language
	 * @param translation
	 * @param name
	 */
	public CountryName(Country country, Language language,
			Translation translation, String name) {
		this.country = country;
		this.language = language;
		this.translation = translation;
		this.name = name;
	}

	/**
	 * @return the country
	 */
	public Country getCountry() {
		return country;
	}
	
	/**
	 * @param country the country to set
	 */
	public void setCountry(Country country) {
		this.country = country;
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
		return "CountryName [id=" + id + ", language=" + language
				+ ", translation=" + translation + ", name=" + name + "]";
	}

}
