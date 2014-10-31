/**
 * 
 */
package gr.ekt.cerif.features.semantics;


import gr.ekt.cerif.entities.link.ClassScheme_Class;
import gr.ekt.cerif.entities.link.ClassScheme_ClassScheme;
import gr.ekt.cerif.entities.link.ClassScheme_OrganisationUnit;
import gr.ekt.cerif.entities.second.FederatedIdentifier;
import gr.ekt.cerif.features.multilingual.ClassSchemeDescription;
import gr.ekt.cerif.features.multilingual.ClassSchemeName;

import java.util.List;
import java.util.Set;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

/**
 * Represents a classification scheme semantic.
 * 
 */
@Entity
@Table (name = "cfClassScheme")
@Cacheable
@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
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
	 * The UUID.
	 */
	@Column(name="cfUUID")
	private String uuid;
	
	
	/**
	 * Multilingual.
	 */
	@OneToMany(mappedBy="scheme")
	private Set<ClassSchemeDescription> descriptions;
	
	@OneToMany(mappedBy="scheme")
	@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
	private Set<ClassSchemeName> names;
	

	/**
	 * Links.
	 */
	@OneToMany (mappedBy = "scheme")
	@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
	private Set<Class> classes;
	
	@OneToMany(mappedBy="scheme")
	private Set<FederatedIdentifier> inFedfederatedIdentifiers;
	
	@OneToMany(mappedBy="scheme")
	private Set<ClassScheme_OrganisationUnit> classScheme_organisationUnits;
	
	@OneToMany(mappedBy="classScheme1")
	private Set<ClassScheme_ClassScheme> classSchemes_classSchemes1;
	
	@OneToMany(mappedBy="classScheme2")
	private Set<ClassScheme_ClassScheme> classSchemes_classSchemes2;
	
	@OneToMany(mappedBy="relatedClassScheme")
	private Set<ClassScheme_Class> classScheme_classes;
	
	
	/**
	 * FederatedIdentifier entities related to ClassScheme instance.
	 */
	@Transient
	private List<FederatedIdentifier> federatedIdentifiers;	
	
	// ---------------------------------------------------------------------- //
	

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
	 * @return the uuid
	 */
	public String getUuid() {
		return uuid;
	}

	/**
	 * @param uuid the uuid to set
	 */
	public void setUuid(String uuid) {
		this.uuid = uuid;
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

	/**
	 * @return the classScheme_organisationUnits
	 */
	public Set<ClassScheme_OrganisationUnit> getClassScheme_organisationUnits() {
		return classScheme_organisationUnits;
	}

	/**
	 * @param classScheme_organisationUnits the classScheme_organisationUnits to set
	 */
	public void setClassScheme_organisationUnits(
			Set<ClassScheme_OrganisationUnit> classScheme_organisationUnits) {
		this.classScheme_organisationUnits = classScheme_organisationUnits;
	}

	/**
	 * @return the classSchemes_classSchemes1
	 */
	public Set<ClassScheme_ClassScheme> getClassSchemes_classSchemes1() {
		return classSchemes_classSchemes1;
	}

	/**
	 * @param classSchemes_classSchemes1 the classSchemes_classSchemes1 to set
	 */
	public void setClassSchemes_classSchemes1(
			Set<ClassScheme_ClassScheme> classSchemes_classSchemes1) {
		this.classSchemes_classSchemes1 = classSchemes_classSchemes1;
	}

	/**
	 * @return the classSchemes_classSchemes2
	 */
	public Set<ClassScheme_ClassScheme> getClassSchemes_classSchemes2() {
		return classSchemes_classSchemes2;
	}

	/**
	 * @param classSchemes_classSchemes2 the classSchemes_classSchemes2 to set
	 */
	public void setClassSchemes_classSchemes2(
			Set<ClassScheme_ClassScheme> classSchemes_classSchemes2) {
		this.classSchemes_classSchemes2 = classSchemes_classSchemes2;
	}

	/**
	 * @return the classScheme_classes
	 */
	public Set<ClassScheme_Class> getClassScheme_classes() {
		return classScheme_classes;
	}

	/**
	 * @param classScheme_classes the classScheme_classes to set
	 */
	public void setClassScheme_classes(Set<ClassScheme_Class> classScheme_classes) {
		this.classScheme_classes = classScheme_classes;
	}

	/**
	 * @return the inFedfederatedIdentifiers
	 */
	public Set<FederatedIdentifier> getInFedfederatedIdentifiers() {
		return inFedfederatedIdentifiers;
	}

	/**
	 * @param inFedfederatedIdentifiers the inFedfederatedIdentifiers to set
	 */
	public void setInFedfederatedIdentifiers(
			Set<FederatedIdentifier> inFedfederatedIdentifiers) {
		this.inFedfederatedIdentifiers = inFedfederatedIdentifiers;
	}

	/**
	 * @return the federatedIdentifiers
	 */
	public List<FederatedIdentifier> getFederatedIdentifiers() {
		return federatedIdentifiers;
	}

	/**
	 * @param federatedIdentifiers the federatedIdentifiers to set
	 */
	public void setFederatedIdentifiers(
			List<FederatedIdentifier> federatedIdentifiers) {
		this.federatedIdentifiers = federatedIdentifiers;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ClassScheme other = (ClassScheme) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ClassScheme [id=" + id + ", uri=" + uri + ", uuid=" + uuid
				+ "]";
	}	
	
}
