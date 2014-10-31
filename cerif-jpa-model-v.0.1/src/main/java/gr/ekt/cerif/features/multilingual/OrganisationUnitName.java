/**
 * 
 */
package gr.ekt.cerif.features.multilingual;

import gr.ekt.cerif.entities.base.OrganisationUnit;
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
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Index;
import org.hibernate.search.annotations.Indexed;
import org.hibernate.search.annotations.Store;

/**
 * Holds the multi-lingual name of an OrganisationUnit entity.
 * 
 */
@Entity
@Table(name="cfOrgUnitName", uniqueConstraints=@UniqueConstraint(columnNames={"cfOrgUnitId","cfLangCode","cfTrans"}))
@Indexed(index="indexes/organisationUnits/names")
@Cacheable
@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
public class OrganisationUnitName implements CerifMultipleLanguageFeature {

	/**
	 * Serialization version.
	 */
	private static final long serialVersionUID = -6331361709646864041L;
	
	
	/**
	 * 
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	/**
	 * The organisation unit.
	 */
	@ManyToOne(optional=false)
	@JoinColumn(name="cfOrgUnitId")
	@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
	private OrganisationUnit organisationUnit;
	
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
	 * The organisation unit name.
	 */
	@NotNull
	@Column(name="cfName")
	@Field(name="organisationUnitName", index=Index.YES, store=Store.YES)
	private String name;	

	/**
	 * Default Constructor
	 */
	public OrganisationUnitName() { 
		
	}
	
	/**
	 * 
	 * @param organisationUnit
	 * @param language
	 * @param translation
	 * @param name
	 */
	public OrganisationUnitName(OrganisationUnit organisationUnit,
			Language language, Translation translation, String name) {
		this.organisationUnit = organisationUnit;
		this.language = language;
		this.translation = translation;
		this.name = name;
	}

	/**
	 * @return the organisationUnit
	 */
	public OrganisationUnit getOrganisationUnit() {
		return organisationUnit;
	}

	/**
	 * @param organisationUnit the organisationUnit to set
	 */
	public void setOrganisationUnit(OrganisationUnit organisationUnit) {
		this.organisationUnit = organisationUnit;
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
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result
				+ ((language == null) ? 0 : language.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime
				* result
				+ ((organisationUnit == null) ? 0 : organisationUnit.hashCode());
		result = prime * result
				+ ((translation == null) ? 0 : translation.hashCode());
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
		if (!(obj instanceof OrganisationUnitName)) {
			return false;
		}
		
		OrganisationUnitName other = (OrganisationUnitName) obj;
		
		if (id != null && other.id != null) { //check only the ids
			if (id.equals(other.id)) {
				return true;
			} else {
				return false;
			}
		} else {
			if (organisationUnit == null || other.organisationUnit == null) {
				return false; //no reason to check further
			}
			if (organisationUnit.equals(other.organisationUnit)) {
				if (language.equals(other.language) && 
						translation.equals(other.translation) && 
						name.equals(other.name)) {
					return true;
				} else {
					return false;
				}
			} else {
				return false; //different organisations
			}
		}
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "OrganisationUnitName [id=" + id + ", language=" + language
				+ ", translation=" + translation + ", name=" + name + "]";
	}	
	
	
}
