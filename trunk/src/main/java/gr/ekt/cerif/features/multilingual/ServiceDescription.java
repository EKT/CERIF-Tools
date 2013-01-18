/**
 * 
 */
package gr.ekt.cerif.features.multilingual;

import gr.ekt.cerif.entities.infrastructure.Service;
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
 * Holds the multi-lingual description of a service entity.
 * 
 */
@Entity
@Table(name="cfSrvDescr", uniqueConstraints=@UniqueConstraint(columnNames={"cfSrvId","cfLangCode","cfTrans"}))
public class ServiceDescription implements CerifMultipleLanguageFeature {
	
	/**
	 * Serialization version.
	 */
	private static final long serialVersionUID = 4283681800783597977L;

	/**
	 * 
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	/**
	 * The service.
	 */
	@ManyToOne(optional=false)
	@JoinColumn(name="cfSrvId")
	private Service service;
	
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
	 * The service description.
	 */
	@Column(name="cfDescr")
	private String description;
	
	/**
	 * Default Constructor
	 */
	public ServiceDescription() {
		
	}
	
	/**
	 * 
	 * @param service
	 * @param language
	 * @param translation
	 * @param description
	 */
	public ServiceDescription(Service service, Language language,
			Translation translation, String description) {
		this.service = service;
		this.language = language;
		this.translation = translation;
		this.description = description;
	}

	/**
	 * @return the service
	 */
	public Service getService() {
		return service;
	}
	
	/**
	 * @param service the service to set
	 */
	public void setService(Service service) {
		this.service = service;
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
