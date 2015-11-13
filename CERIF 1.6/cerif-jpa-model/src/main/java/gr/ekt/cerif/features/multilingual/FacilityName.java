/**
 * 
 */
package gr.ekt.cerif.features.multilingual;

import gr.ekt.cerif.entities.infrastructure.Facility;
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
 * Holds the multi-lingual name of a facility entity.
 * 
 */
@Entity
@Table(name="cfFacilName", uniqueConstraints=@UniqueConstraint(columnNames={"cfFacilId","cfLangCode","cfTrans"}))
public class FacilityName implements CerifMultipleLanguageFeature {
	
	/**
	 * Serialization version.
	 */
	private static final long serialVersionUID = 5221481151344418915L;

	/**
	 * 
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	/**
	 * The facility.
	 */
	@ManyToOne(optional=false)
	@JoinColumn(name="cfFacilId")
	private Facility facility;
	
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
	 * The facility name.
	 */
	@NotNull
	@Column(name="cfName")
	private String name;
	
	/**
	 * Default Constructor
	 */
	public FacilityName() {
		
	}
	/**
	 * 
	 * @param facility
	 * @param language
	 * @param translation
	 * @param name
	 */
	public FacilityName(Facility facility, Language language,
			Translation translation, String name) {
		this.facility = facility;
		this.language = language;
		this.translation = translation;
		this.name = name;
	}

	/**
	 * @return the facility
	 */
	public Facility getFacility() {
		return facility;
	}
	
	/**
	 * @param facility the facility to set
	 */
	public void setFacility(Facility facility) {
		this.facility = facility;
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
		result = prime * result
				+ ((facility == null) ? 0 : facility.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result
				+ ((language == null) ? 0 : language.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		if (!(obj instanceof FacilityName)) {
			return false;
		}
		
		FacilityName other = (FacilityName) obj;
		
		if (id != null && other.id != null) { //check only the ids
			if (id.equals(other.id)) {
				return true;
			} else {
				return false;
			}
		} else {
			if (facility == null || other.facility == null) {
				return false; //no reason to check further
			}
			if (facility.equals(other.facility)) {
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
		return "FacilityName [id=" + id + ", language=" + language
				+ ", translation=" + translation + ", name=" + name + "]";
	}

	
}
