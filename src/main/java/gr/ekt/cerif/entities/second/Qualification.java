/**
 * 
 */
package gr.ekt.cerif.entities.second;

import gr.ekt.cerif.entities.link.person.Person_Qualification;
import gr.ekt.cerif.features.multilingual.QualificationDescription;
import gr.ekt.cerif.features.multilingual.QualificationKeyword;
import gr.ekt.cerif.features.multilingual.QualificationTitle;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Represents a Qualification second level entity.
 * 
 */
@Entity
@Table(name="cfQual")
public class Qualification implements CerifSecondLevelEntity {
	
	/**
	 * Serialization version.
	 */
	private static final long serialVersionUID = -862947308643033005L;

	/**
	 * The citation id.
	 */
	@Id
	@Column(name="cfQualId")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;

	/**
	 * The URI.
	 */
	@Column(name="cfURI")
	private String uri;
	
	@OneToMany(mappedBy="qualification")
	private Set<QualificationTitle> titles;
	
	@OneToMany(mappedBy="qualification")
	private Set<QualificationKeyword> keywords;
	
	@OneToMany(mappedBy="qualification")
	private Set<QualificationDescription> descriptions;
	
	@OneToMany(mappedBy="person")
	private Set<Person_Qualification> persons_qualifications;

	/**
	 * Default constructor
	 */
	public Qualification() {
		
	}
	
	/**
	 * 
	 * @param uri
	 * @param titles
	 * @param keywords
	 * @param descriptions
	 */
	public Qualification(String uri, Set<QualificationTitle> titles,
			Set<QualificationKeyword> keywords,
			Set<QualificationDescription> descriptions) {
		this.uri = uri;
		this.titles = titles;
		this.keywords = keywords;
		this.descriptions = descriptions;
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

	public Set<QualificationTitle> getTitles() {
		return titles;
	}

	public void setTitles(Set<QualificationTitle> titles) {
		this.titles = titles;
	}

	public Set<QualificationKeyword> getKeywords() {
		return keywords;
	}

	public void setKeywords(Set<QualificationKeyword> keywords) {
		this.keywords = keywords;
	}

	public Set<QualificationDescription> getDescriptions() {
		return descriptions;
	}

	public void setDescriptions(Set<QualificationDescription> descriptions) {
		this.descriptions = descriptions;
	}
	
	/**
	 * @return the persons_qualifications
	 */
	public Set<Person_Qualification> getPersons_qualifications() {
		return persons_qualifications;
	}
	
	/**
	 * @param persons_qualifications the persons_qualifications to set
	 */
	public void setPersons_qualifications(
			Set<Person_Qualification> persons_qualifications) {
		this.persons_qualifications = persons_qualifications;
	}
	
}
