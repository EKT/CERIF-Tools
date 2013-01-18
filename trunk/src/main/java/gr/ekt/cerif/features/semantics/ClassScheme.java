/**
 * 
 */
package gr.ekt.cerif.features.semantics;


import gr.ekt.cerif.features.multilingual.ClassSchemeDescription;
import gr.ekt.cerif.features.multilingual.ClassSchemeName;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Represents a classification scheme semantic.
 * 
 */
@Entity
@Table (name = "cfClassScheme")
public class ClassScheme implements CerifSemanticFeature {
	
	/**
	 * Serialization version.
	 */
	private static final long serialVersionUID = -5535104821697671822L;

	/**
	 * The classification scheme unique identifier.
	 */
	@Id
	@Column (name = "cfClassSchemeId")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	/**
	 * The URI.
	 */
	@Column (name = "cfURI")
	private String uri;

	/**
	 * The classification classes.
	 */
	@OneToMany (mappedBy = "scheme")
	private Set<Class> classes;
	
	@OneToMany(mappedBy="scheme")
	private Set<ClassSchemeDescription> descriptions;
	
	@OneToMany(mappedBy="scheme")
	private Set<ClassSchemeName> names;

	/**
	 * Default Constructor
	 */
	public ClassScheme() {
		
	}
	
	/**
	 * 
	 * @param uri
	 * @param classes
	 * @param descriptions
	 * @param names
	 */
	public ClassScheme(String uri, Set<Class> classes,
			Set<ClassSchemeDescription> descriptions, Set<ClassSchemeName> names) {
		this.uri = uri;
		this.classes = classes;
		this.descriptions = descriptions;
		this.names = names;
	}

	/**
	 * Returns the unique identifier.
	 * @return the unique identifier.
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Sets the unique identifier.
	 * @param id the unique identifier.
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * Returns the URI.
	 * @return the URI.
	 */
	public String getUri() {
		return uri;
	}

	/**
	 * Sets the URI.
	 * @param uri the URI.
	 */
	public void setUri(String uri) {
		this.uri = uri;
	}

	/**
	 * Returns the classes.
	 * @return the classes.
	 */
	public Set<Class> getClasses() {
		return classes;
	}

	/**
	 * Sets the classes.
	 * @param classes the classes.
	 */
	public void setClasses(Set<Class> classes) {
		this.classes = classes;
	}

	public Set<ClassSchemeDescription> getDescriptions() {
		return descriptions;
	}

	public void setDescriptions(Set<ClassSchemeDescription> descriptions) {
		this.descriptions = descriptions;
	}

	public Set<ClassSchemeName> getNames() {
		return names;
	}

	public void setNames(Set<ClassSchemeName> names) {
		this.names = names;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((uri == null) ? 0 : uri.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof ClassScheme)) {
			return false;
		}
		ClassScheme other = (ClassScheme) obj;
		if (uri == null) {
			if (other.uri != null) {
				return false;
			}
		} else if (!uri.equals(other.uri)) {
			return false;
		}
		return true;
	}

	
	
}
