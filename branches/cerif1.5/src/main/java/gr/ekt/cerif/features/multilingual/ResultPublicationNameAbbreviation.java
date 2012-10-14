/**
 * 
 */
package gr.ekt.cerif.features.multilingual;

import gr.ekt.cerif.entities.result.ResultPublication;
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
 * Holds the multi-lingual fields of a publication result entity.
 * 
 */
@Entity
@Table(name="cfResPublNameAbbrev", uniqueConstraints=@UniqueConstraint(columnNames={"cfResPublId","cfLangCode","cfTrans"}))
public class ResultPublicationNameAbbreviation implements ResultPublicationTranslation {

	/**
	 * Serialization version.
	 */
	private static final long serialVersionUID = 8078215183242075789L;

	/**
	 * 
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	/**
	 * The translation.
	 */
	@NotNull
	@Column(name="cfTrans")
	@Enumerated(EnumType.STRING)
	private Translation translation = Translation.MACHINE;
	
	/**
	 * The publication.
	 */
	@ManyToOne(optional=false)
	@JoinColumn(name="cfResPublId")
	private ResultPublication resultPublication;
	
	/**
	 * The language.
	 */
	@ManyToOne(optional=false)
	@JoinColumn(name="cfLangCode")
	private Language language;
	
	/**
	 * The nameAbbreviation.
	 */
	@Column(name="cfNameAbbrev")
	private String nameAbbreviation;
	
	/**
	 * Default Constructor
	 */
	public ResultPublicationNameAbbreviation() {
		
	}
	
	/**
	 * 
	 * @param translation
	 * @param resultPublication
	 * @param language
	 * @param nameAbbreviation
	 */
	public ResultPublicationNameAbbreviation(Translation translation,
			ResultPublication resultPublication, Language language,
			String nameAbbreviation) {
		this.translation = translation;
		this.resultPublication = resultPublication;
		this.language = language;
		this.nameAbbreviation = nameAbbreviation;
	}

	/**
	 * Returns the translation.
	 * @return the translation
	 */
	public Translation getTranslation() {
		return translation;
	}

	/**
	 * Sets the translation.
	 * @param translation the translation
	 */
	public void setTranslation(Translation translation) {
		this.translation = translation;
	}

	/**
	 * Returns the publication.
	 * @return the publication.
	 */
	public ResultPublication getResultPublication() {
		return resultPublication;
	}

	/**
	 * Sets the publication.
	 * @param resultPublication the publication.
	 */
	public void setResultPublication(ResultPublication resultPublication) {
		this.resultPublication = resultPublication;
	}

	/**
	 * Returns the language.
	 * @return the language.
	 */
	public Language getLanguage() {
		return language;
	}

	/**
	 * Sets the language.
	 * @param language the language.
	 */
	public void setLanguage(Language language) {
		this.language = language;
	}

	/**
	 * Returns the nameAbbreviation.
	 * @return the nameAbbreviation.
	 */
	public String getNameAbbreviation() {
		return nameAbbreviation;
	}

	/**
	 * Sets the nameAbbreviation.
	 * @param nameAbbreviation the nameAbbreviation.
	 */
	public void setNameAbbreviation(String nameAbbreviation) {
		this.nameAbbreviation = nameAbbreviation;
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
