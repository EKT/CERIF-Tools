/**
 * 
 */
package gr.ekt.cerif.pk;

import java.io.Serializable;

/**
 * Compound key for DublinCore translations.
 * 
 */
public class DublinCoreId implements Serializable  {

	/**
	 * Serialization version.
	 */
	private static final long serialVersionUID = -1029609633363599051L;

	/**
	 * The id.
	 */
	private Long id;
	
	/**
	 * The scheme.
	 */
	private String scheme;

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
	
	
}
