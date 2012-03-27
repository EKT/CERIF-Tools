/**
 * 
 */
package gr.ekt.cerif.features.multilingual;

import gr.ekt.cerif.entities.base.Project;
import gr.ekt.cerif.entities.second.Language;
import gr.ekt.cerif.pk.project.ProjectTranslationId;

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
 * Holds the multi-lingual keyword of a project entity.
 * 
 */
@Entity
@Table(name="cfProjKeyw")
@IdClass(ProjectTranslationId.class)
public class ProjectKeyword implements ProjectTranslation {
	
	/**
	 * Serialization version.
	 */
	private static final long serialVersionUID = -1475010942172770607L;

	/**
	 * The project.
	 */
	@Id
	@ManyToOne
	@JoinColumn(name="cfProjId")
	private Project project;
	
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
	 * The project keywords.
	 */
	@Column(name="cfKeyw")
	private String keyword;

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
}
