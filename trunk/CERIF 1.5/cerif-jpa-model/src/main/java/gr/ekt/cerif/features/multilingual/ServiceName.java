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
import javax.validation.constraints.NotNull;

/**
 * Holds the multi-lingual name of a service entity.
 * 
 */
@Entity
@Table(name="cfSrvName")
public class ServiceName implements CerifMultipleLanguageFeature {
	
	/**
	 * Serialization version.
	 */
	private static final long serialVersionUID = -6297452190494479146L;

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
	 * The service name.
	 */
	@NotNull
	@Column(name="cfName")
	private String name;
	
	/**
	 * Default Constructor
	 */
	public ServiceName() {
		
	}
	
	/**
	 * 
	 * @param service
	 * @param language
	 * @param translation
	 * @param name
	 */
	public ServiceName(Service service, Language language,
			Translation translation, String name) {
		this.service = service;
		this.language = language;
		this.translation = translation;
		this.name = name;
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
		return "ServiceName [id=" + id + ", language=" + language
				+ ", translation=" + translation + ", name=" + name + "]";
	}

}
