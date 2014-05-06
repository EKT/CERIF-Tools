/**
 * 
 */
package gr.ekt.cerif.features.multilingual;

import gr.ekt.cerif.entities.base.Project;
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
 * Holds the multi-lingual keyword of a project entity.
 * 
 */
@Entity
@Table(name="cfProjKeyw", uniqueConstraints=@UniqueConstraint(columnNames={"cfProjId","cfLangCode","cfTrans"}))
@Cacheable
@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
public class ProjectKeyword implements CerifMultipleLanguageFeature {
	
	/**
	 * Serialization version.
	 */
	private static final long serialVersionUID = -1475010942172770607L;

	/**
	 * 
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	
	/**
	 * The project.
	 */
	@ManyToOne(optional=false)
	@JoinColumn(name="cfProjId")
	@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
	private Project project;
	
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
	 * The project keywords.
	 */
	@NotNull
	@Column(name="cfKeyw", length=20000)
	private String keyword;

	/**
	 * Default Constructor
	 */
	public ProjectKeyword() {
		
	}
	
	/**
	 * 
	 * @param project
	 * @param language
	 * @param translation
	 * @param keyword
	 */
	public ProjectKeyword(Project project, Language language,
			Translation translation, String keyword) {
		this.project = project;
		this.language = language;
		this.translation = translation;
		this.keyword = keyword;
	}

	/**
	 * @return the project
	 */
	public Project getProject() {
		return project;
	}

	/**
	 * @param project the project to set
	 */
	public void setProject(Project project) {
		this.project = project;
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
	 * @param keywords the keywords to set
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
		return "ProjectKeyword [id=" + id + ", language=" + language
				+ ", translation=" + translation + ", keyword=" + keyword + "]";
	}
	
	
}
