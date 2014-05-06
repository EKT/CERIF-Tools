/**
 * 
 */
package gr.ekt.cerif.features.multilingual;

import gr.ekt.cerif.entities.second.Metrics;
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
 * Holds the multi-lingual keyword of a metrics entity.
 * 
 */
@Entity
@Table(name="cfMetricsKeyw", uniqueConstraints=@UniqueConstraint(columnNames={"cfMetricsId","cfLangCode","cfTrans"}))
public class MetricsKeyword implements CerifMultipleLanguageFeature {
	
	/**
	 * Serialization version.
	 */
	private static final long serialVersionUID = -7159497724417392497L;

	/**
	 * 
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	/**
	 * The metrics.
	 */
	@ManyToOne(optional=false)
	@JoinColumn(name="cfMetricsId")
	private Metrics metrics;
	
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
	 * The metrics keyword.
	 */
	@NotNull
	@Column(name="cfKeyw", length=20000)
	private String keyword;
	
	/**
	 * Default Constructor
	 */
	public MetricsKeyword() {
		
	}
	
	/**
	 * 
	 * @param metrics
	 * @param language
	 * @param translation
	 * @param keyword
	 */
	public MetricsKeyword(Metrics metrics, Language language,
			Translation translation, String keyword) {
		this.metrics = metrics;
		this.language = language;
		this.translation = translation;
		this.keyword = keyword;
	}

	/**
	 * @return the metrics
	 */
	public Metrics getMetrics() {
		return metrics;
	}
	
	/**
	 * @param metrics the metrics to set
	 */
	public void setMetrics(Metrics metrics) {
		this.metrics = metrics;
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
		return "MetricsKeyword [id=" + id + ", language=" + language
				+ ", translation=" + translation + ", keyword=" + keyword + "]";
	}

}
