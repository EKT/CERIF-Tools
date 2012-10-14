/**
 * 
 */
package gr.ekt.cerif.entities.second;

import gr.ekt.cerif.features.multilingual.PrizeDescription;
import gr.ekt.cerif.features.multilingual.PrizeKeyword;
import gr.ekt.cerif.features.multilingual.PrizeName;

import gr.ekt.cerif.entities.link.person.Person_Prize;

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
 * Represents a prize second level entity.
 * 
 */
@Entity
@Table(name="cfPrize")
public class Prize implements CerifSecondLevelEntity {
	
	/**
	 * Serialization version.
	 */
	private static final long serialVersionUID = -7660981404694663002L;

	/**
	 * The citation id.
	 */
	@Id
	@Column(name="cfPrizeId")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;

	/**
	 * The URI.
	 */
	@Column(name="cfURI")
	private String uri;
	
	@OneToMany(mappedBy="prize")
	private Set<PrizeName> names;
	
	@OneToMany(mappedBy="prize")
	private Set<PrizeKeyword> keywords;
	
	@OneToMany(mappedBy="prize")
	private Set<PrizeDescription> descriptions;
	
	@OneToMany(mappedBy="person")
	private Set<Person_Prize> persons_prizes;

	/**
	 * Default Constructor
	 */
	public Prize() {
		
	}
	
	/**
	 * 
	 * @param uri
	 * @param names
	 * @param keywords
	 * @param descriptions
	 * @param persons_prizes
	 */
	public Prize(String uri, Set<PrizeName> names, Set<PrizeKeyword> keywords,
			Set<PrizeDescription> descriptions, Set<Person_Prize> persons_prizes) {
		this.uri = uri;
		this.names = names;
		this.keywords = keywords;
		this.descriptions = descriptions;
		this.persons_prizes = persons_prizes;
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

	public Set<PrizeName> getNames() {
		return names;
	}

	public void setNames(Set<PrizeName> names) {
		this.names = names;
	}

	public Set<PrizeKeyword> getKeywords() {
		return keywords;
	}

	public void setKeywords(Set<PrizeKeyword> keywords) {
		this.keywords = keywords;
	}

	public Set<PrizeDescription> getDescriptions() {
		return descriptions;
	}

	public void setDescriptions(Set<PrizeDescription> descriptions) {
		this.descriptions = descriptions;
	}
	
	/**
	 * @return the persons_prizes
	 */
	public Set<Person_Prize> getPersons_prizes() {
		return persons_prizes;
	}
	
	/**
	 * @param persons_prizes the persons_prizes to set
	 */
	public void setPersons_prizes(Set<Person_Prize> persons_prizes) {
		this.persons_prizes = persons_prizes;
	}
	
}
