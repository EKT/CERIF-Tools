/**
 * 
 */
package gr.ekt.cerif.features.multilingual;

import gr.ekt.cerif.entities.infrastructure.Service;
import gr.ekt.cerif.entities.second.Language;
import gr.ekt.cerif.pk.ServiceTranslationId;

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
 * Holds the multi-lingual description of a service entity.
 * 
 */
@Entity
@Table(name="cfSrvDescr")
@IdClass(ServiceTranslationId.class)
public class ServiceDescription implements ServiceTranslation {
	
	/**
	 * Serialization version.
	 */
	private static final long serialVersionUID = 4283681800783597977L;

	/**
	 * The service.
	 */
	@Id
	@ManyToOne
	@JoinColumn(name="cfSrvId")
	private Service service;
	
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
	 * The service description.
	 */
	@Column(name="cfDescr")
	private String description;
	
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

}
