/**
 * 
 */
package gr.ekt.cerif.features.multilingual;

import gr.ekt.cerif.entities.result.ResultPublication;
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
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Index;
import org.hibernate.search.annotations.Indexed;
import org.hibernate.search.annotations.Store;

/**
 * Holds the multi-lingual keyword of a publication result entity.
 * 
 */
@Entity
@Table(name="cfResPublKeyw", uniqueConstraints=@UniqueConstraint(columnNames={"cfResPublId","cfLangCode","cfTrans"}))
@Indexed(index="indexes/resultPublications/keywords")
@Cacheable
@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
public class ResultPublicationKeyword implements CerifMultipleLanguageFeature {

	/**
	 * Serialization version.
	 */
	private static final long serialVersionUID = 7782989060689236092L;

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
	@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
	private ResultPublication resultPublication;
	
	/**
	 * The language.
	 */
	@ManyToOne(optional=false)
	@JoinColumn(name="cfLangCode")
	@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
	private Language language;
	
	/**
	 * The keyword.
	 */
	@NotNull
	@Column(name="cfKeyw", length=20000)
	@Field(name="resultPublicationKeyword", index=Index.YES, store=Store.YES)
	private String keyword;

	/**
	 * Default Constructor
	 */
	public ResultPublicationKeyword() {
		
	}
	
	/**
	 * 
	 * @param translation
	 * @param resultPublication
	 * @param language
	 * @param keyword
	 */
	public ResultPublicationKeyword(Translation translation,
			ResultPublication resultPublication, Language language,
			String keyword) {
		this.translation = translation;
		this.resultPublication = resultPublication;
		this.language = language;
		this.keyword = keyword;
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
	 * Returns the keyword.
	 * @return the keyword.
	 */
	public String getKeyword() {
		return keyword;
	}

	/**
	 * Sets the keyword.
	 * @param keyword the keyword.
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
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((keyword == null) ? 0 : keyword.hashCode());
		result = prime * result
				+ ((language == null) ? 0 : language.hashCode());
		result = prime
				* result
				+ ((resultPublication == null) ? 0 : resultPublication
						.hashCode());
		result = prime * result
				+ ((translation == null) ? 0 : translation.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		if (!(obj instanceof ResultPublicationKeyword)) {
			return false;
		}
		ResultPublicationKeyword other = (ResultPublicationKeyword) obj;
		
		if (id != null && other.id != null) { //check only the ids
			if (id.equals(other.id)) {
				return true;
			} else {
				return false;
			}
		} else {
			if (resultPublication == null || other.resultPublication == null) {
				return false; //no reason to check further
			}
			if (resultPublication.equals(other.resultPublication)) {
				if (language.equals(other.language) && 
						translation.equals(other.translation) && 
						keyword.equals(other.keyword)) {
					return true;
				} else {
					return false;
				}
			} else {
				return false; //different result publications
			}
		}
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ResultPublicationKeyword [id=" + id + ", resultPublication="
				+ resultPublication + ", language=" + language + ", keyword="
				+ keyword + "]";
	}

}
