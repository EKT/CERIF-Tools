/**
 * 
 */
package gr.ekt.cerif.features.additional;

import gr.ekt.cerif.entities.link.person.Person_DublinCore;
import java.util.Set;

import gr.ekt.cerif.entities.link.result.ResultPublication_DublinCore;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

/**
 * Represents a DublinCore entity.
 * 
 */
@Deprecated
@Entity
@Table(name="cfDC", uniqueConstraints=@UniqueConstraint(columnNames={"cfDCId","cfDCScheme"}))
public class DublinCore implements CerifAdditionalFeature {
	
	/**
	 * Serialization version.
	 */
	private static final long serialVersionUID = -7712918719526142889L;	

	/**
	 * The citation id.
	 */
	@Id
	@Column(name="cfDCId")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;

	/**
	 * The dc scheme.
	 */
	@NotNull
	@Column(name="cfDCScheme")
	private String scheme;
	
	/**
	 * The dc scheme URI.
	 */
	@Column(name="cfDCSchemeURI")
	private String schemeURI;
	
	@OneToMany(mappedBy="dublinCore")
	private Set<Person_DublinCore> persons_dublinCores;
	
	@OneToMany(mappedBy="dublinCore")
	private Set<ResultPublication_DublinCore> resultPublications_dublinCores;

	/**
	 * Default Constructor
	 */
	public DublinCore() {
		
	}
	
	/**
	 * 
	 * @param scheme
	 * @param schemeURI
	 * @param persons_dublinCores
	 * @param resultPublications_dublinCores
	 */
	public DublinCore(String scheme, String schemeURI,
			Set<Person_DublinCore> persons_dublinCores,
			Set<ResultPublication_DublinCore> resultPublications_dublinCores) {
		this.scheme = scheme;
		this.schemeURI = schemeURI;
		this.persons_dublinCores = persons_dublinCores;
		this.resultPublications_dublinCores = resultPublications_dublinCores;
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

	public String getScheme() {
		return scheme;
	}

	public void setScheme(String scheme) {
		this.scheme = scheme;
	}

	public String getSchemeURI() {
		return schemeURI;
	}

	public void setSchemeURI(String schemeURI) {
		this.schemeURI = schemeURI;
	}

	/**
	 * @return the persons_dublinCores
	 */
	public Set<Person_DublinCore> getPersons_dublinCores() {
		return persons_dublinCores;
	}

	/**
	 * @param persons_dublinCores the persons_dublinCores to set
	 */
	public void setPersons_dublinCores(Set<Person_DublinCore> persons_dublinCores) {
		this.persons_dublinCores = persons_dublinCores;
	}	

//	/**
//	 * @return the persons_dublinCores
//	 */
//	public Set<Person_DublinCore> getPersons_dublinCores() {
//		return persons_dublinCores;
//	}
//
//	/**
//	 * @param persons_dublinCores the persons_dublinCores to set
//	 */
//	public void setPersons_dublinCores(Set<Person_DublinCore> persons_dublinCores) {
//		this.persons_dublinCores = persons_dublinCores;
//	}

	/**
	 * @return the resultPublications_dublinCores
	 */
	public Set<ResultPublication_DublinCore> getResultPublications_dublinCores() {
		return resultPublications_dublinCores;
	}
	
	/**
	 * @param resultPublications_dublinCores the resultPublications_dublinCores to set
	 */
	public void setResultPublications_dublinCores(
			Set<ResultPublication_DublinCore> resultPublications_dublinCores) {
		this.resultPublications_dublinCores = resultPublications_dublinCores;
	}
	
}
