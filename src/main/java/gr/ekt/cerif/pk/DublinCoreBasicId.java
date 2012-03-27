/**
 * 
 */
package gr.ekt.cerif.pk;

import java.io.Serializable;

/**
 * Compound key for DublinCoreAudience translations.
 * 
 */
public class DublinCoreBasicId implements Serializable  {

	/**
	 * Serialization version.
	 */
	private static final long serialVersionUID = -1096521374615015545L;

	/**
	 * The id.
	 */
	private Long id;
	
	/**
	 * The scheme.
	 */
	private String scheme;
	
	private String language;
	
	private String translation;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getScheme() {
		return scheme;
	}

	public void setScheme(String scheme) {
		this.scheme = scheme;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getTranslation() {
		return translation;
	}

	public void setTranslation(String translation) {
		this.translation = translation;
	}
	
	
}
