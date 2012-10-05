/**
 * 
 */
package gr.ekt.cerif.features.multilingual;

import gr.ekt.cerif.entities.result.ResultProduct;
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
 * Holds the multi-lingual description of a ResultProduct entity.
 * 
 */
@Entity
@Table(name="cfResProdDescr", uniqueConstraints=@UniqueConstraint(columnNames={"cfResProdId","cfLangCode","cfTrans"}))
public class ResultProductDescription implements ResultProductTranslation, Comparable<ResultProductDescription> {

	/**
	 * Serialization version.
	 */
	private static final long serialVersionUID = 3060075846940873942L;
	
	/**
	 * 
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	/**
	 * The result product.
	 */
	@ManyToOne(optional=false)
	@JoinColumn(name="cfResProdId")
	private ResultProduct resultProduct;
	
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
	 * The result product description.
	 */
	@Column(name="cfDescr", columnDefinition="TEXT")
	private String description;

	/**
	 * Default Constructor
	 */
	public ResultProductDescription() {
		
	}
	
	/**
	 * 
	 * @param resultProduct
	 * @param language
	 * @param translation
	 * @param description
	 */
	public ResultProductDescription(ResultProduct resultProduct,
			Language language, Translation translation, String description) {
		this.resultProduct = resultProduct;
		this.language = language;
		this.translation = translation;
		this.description = description;
	}

	/**
	 * @return the resultProduct
	 */
	public ResultProduct getResultProduct() {
		return resultProduct;
	}

	/**
	 * @param resultProduct the resultProduct to set
	 */
	public void setResultProduct(ResultProduct resultProduct) {
		this.resultProduct = resultProduct;
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

	/* (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	@Override
	public int compareTo(ResultProductDescription o) {
		return language.compareTo(o.language);
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

