/**
 * 
 */
package gr.ekt.cerif.pk;

import java.io.Serializable;

import gr.ekt.cerif.entities.infrastructure.Service;
import gr.ekt.cerif.entities.second.Language;
import gr.ekt.cerif.features.multilingual.Translation;

/**
 * Compound key for service translations.
 * 
 */
public class ServiceTranslationId implements Serializable  {

	/**
	 * Serialization version.
	 */
	private static final long serialVersionUID = 4644618555908656485L;

	/**
	 * The service.
	 */
	private Service service;
	
	/**
	 * The language.
	 */
	private Language language;
	
	/**
	 * The translation.
	 */
	private Translation translation;

	/**
	 * @return the Service
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
}
