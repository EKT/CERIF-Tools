/**
 * 
 */
package gr.ekt.cerif.entities.result;

import gr.ekt.cerif.entities.base.OrganisationUnit;
import gr.ekt.cerif.entities.link.organisationunit.OrganisationUnit_ResultProduct;
import gr.ekt.cerif.entities.link.person.Person_ResultProduct;
import gr.ekt.cerif.entities.link.project.Project_ResultProduct;
import gr.ekt.cerif.entities.link.result.ResultProduct_Class;
import gr.ekt.cerif.entities.link.result.ResultProduct_Country;
import gr.ekt.cerif.entities.link.result.ResultProduct_Facility;
import gr.ekt.cerif.entities.link.result.ResultProduct_Funding;
import gr.ekt.cerif.entities.link.result.ResultProduct_GeographicBoundingBox;
import gr.ekt.cerif.entities.link.result.ResultProduct_Measurement;
import gr.ekt.cerif.entities.link.result.ResultProduct_ResultProduct;
import gr.ekt.cerif.entities.link.result.ResultProduct_Service;
import gr.ekt.cerif.entities.link.result.ResultPublication_ResultProduct;
import gr.ekt.cerif.entities.second.Country;
import gr.ekt.cerif.entities.second.Language;
import gr.ekt.cerif.features.multilingual.ResultProductDescription;
import gr.ekt.cerif.features.multilingual.ResultProductKeyword;
import gr.ekt.cerif.features.multilingual.ResultProductName;
import gr.ekt.cerif.features.semantics.Class;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.util.StringUtils;

/**terms
 * Represents a result product entity.
 * 
 */
@Entity
@Table(name="cfResProd")
public class ResultProduct implements CerifResultEntity {
	
	/**
	 * Serialization version.
	 */
	private static final long serialVersionUID = 381701392808153472L;

	/**
	 * The product unique identifier.
	 */
	@Id
	@Column(name="cfResProdId")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;

	/**
	 * The URI.
	 */
	@Column(name="cfURI")
	private String uri;
	
	/**
	 * The result product descriptions.
	 */
	@OneToMany(mappedBy="resultProduct")
	private Set<ResultProductDescription> resultProductDescriptions;
	
	/**
	 * The result product names.
	 */
	@OneToMany(mappedBy="resultProduct")
	private Set<ResultProductName> resultProductNames;
	
	/**
	 * The result product keywords.
	 */
	@OneToMany(mappedBy="resultProduct")
	private Set<ResultProductKeyword> resultProductKeywords;
	
	/**
	 * The result product version infos.
	 */
	@OneToMany(mappedBy="resultProduct")
	private Set<ResultProductKeyword> resultProductVersionInfos;
	
	/**
	 * The organization units.
	 */
	@OneToMany (mappedBy = "resultProduct")
	private Set<OrganisationUnit_ResultProduct> organisationUnits_resultProducts;
	
	@OneToMany(mappedBy="resultProduct")
	private Set<Person_ResultProduct> persons_resultProducts;
	
	@OneToMany(mappedBy="resultProduct")
	private Set<ResultPublication_ResultProduct> resultPublications;
	
	@OneToMany(mappedBy="resultProduct")
	private Set<ResultProduct_Service> resultProducts_services;
	
	@OneToMany(mappedBy="resultProduct")
	private Set<ResultProduct_Facility> resultProducts_facilities;
	
	/**
	 * The class
	 */
	
	@OneToMany(mappedBy = "resultProduct")
	private Set<ResultProduct_Class> classes;
	
	/**
	 * The projects.
	 */
	@OneToMany(mappedBy="resultProduct")
	private Set<Project_ResultProduct> projects_resultProducts;	
	
	/**
	 * The country
	 */
	@OneToMany(mappedBy="resultProduct")
	private Set<ResultProduct_Country> countries;
	
	
	/**
	 * The geographic bounding box
	 */
	@OneToMany(mappedBy="resultProduct")
	private Set<ResultProduct_GeographicBoundingBox> geographicBoundingBox;
	
	@OneToMany(mappedBy="resultProduct")
	private Set<ResultProduct_Funding> resultProducts_fundings;
	
	@OneToMany(mappedBy="resultProduct")
	private Set<ResultProduct_Funding> resultProducts_indicators;

	@OneToMany(mappedBy="resultProduct")
	private Set<ResultProduct_Measurement> resultProducts_measurements;
	
	@OneToMany(mappedBy="resultProduct1")
	private Set<ResultProduct_ResultProduct> resultProducts1_resultProducts;
	
	@OneToMany(mappedBy="resultProduct2")
	private Set<ResultProduct_ResultProduct> resultProducts2_resultProducts;
	
	/**
	 * Default Constructors
	 */
	public ResultProduct(){
		
	}
	
	/**
	 * 
	 * @param id
	 * @param uri
	 * @param version
	 * @param resultProductDescriptions
	 * @param resultProductNames
	 * @param resultProductKeywords
	 * @param resultProductVersionInfos
	 */
	public ResultProduct(String uri, Set<ResultProductDescription> resultProductDescriptions,
			Set<ResultProductName> resultProductNames,
			Set<ResultProductKeyword> resultProductKeywords,
			Set<ResultProductKeyword> resultProductVersionInfos) {
		this.uri = uri;
		this.resultProductDescriptions = resultProductDescriptions;
		this.resultProductNames = resultProductNames;
		this.resultProductKeywords = resultProductKeywords;
		this.resultProductVersionInfos = resultProductVersionInfos;
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

	public Set<ResultProductDescription> getResultProductDescriptions() {
		return resultProductDescriptions;
	}

	public void setResultProductDescriptions(
			Set<ResultProductDescription> resultProductDescriptions) {
		this.resultProductDescriptions = resultProductDescriptions;
	}

	public Set<ResultProductName> getResultProductNames() {
		return resultProductNames;
	}

	public void setResultProductNames(Set<ResultProductName> resultProductNames) {
		this.resultProductNames = resultProductNames;
	}

	public Set<ResultProductKeyword> getResultProductKeywords() {
		return resultProductKeywords;
	}

	public void setResultProductKeywords(Set<ResultProductKeyword> resultProductKeywords) {
		this.resultProductKeywords = resultProductKeywords;
	}

	public Set<ResultProductKeyword> getResultProductVersionInfos() {
		return resultProductVersionInfos;
	}

	public void setResultProductVersionInfos(
			Set<ResultProductKeyword> resultProductVersionInfos) {
		this.resultProductVersionInfos = resultProductVersionInfos;
	}

	/**
	 * @return the persons_resultProducts
	 */
	public Set<Person_ResultProduct> getPersons_resultProducts() {
		return persons_resultProducts;
	}
	
	/**
	 * @param persons_resultProducts the persons_resultProducts to set
	 */
	public void setPersons_resultProducts(
			Set<Person_ResultProduct> persons_resultProducts) {
		this.persons_resultProducts = persons_resultProducts;
	}

	/**
	 * @return the organisationUnits_resultProducts
	 */
	public Set<OrganisationUnit_ResultProduct> getOrganisationUnits_resultProducts() {
		return organisationUnits_resultProducts;
	}

	/**
	 * @param organisationUnits_resultProducts the organisationUnits_resultProducts to set
	 */
	public void setOrganisationUnits_resultProducts(
			Set<OrganisationUnit_ResultProduct> organisationUnits_resultProducts) {
		this.organisationUnits_resultProducts = organisationUnits_resultProducts;
	}

	/**
	 * @return the resultPublications
	 */
	public Set<ResultPublication_ResultProduct> getResultPublications() {
		return resultPublications;
	}

	/**
	 * @param resultPublications the resultPublications to set
	 */
	public void setResultPublications(
			Set<ResultPublication_ResultProduct> resultPublications) {
		this.resultPublications = resultPublications;
	}
			
	/**
	 * @return the countries
	 */
	public Set<ResultProduct_Country> getCountries() {
		return countries;
	}

	/**
	 * @param countries the countries to set
	 */
	public void setCountries(Set<ResultProduct_Country> countries) {
		this.countries = countries;
	}

	/**
	 * @return the geographic bounding box
	 */
	public Set<ResultProduct_GeographicBoundingBox> getGeographicBoundingBox() {
		return geographicBoundingBox;
	}

	/**
	 * @param geographicBoundingBox the geographicBoundingBox to set
	 */
	public void setGeographicBoundingBox(Set<ResultProduct_GeographicBoundingBox> geographicBoundingBoxes) {
		this.geographicBoundingBox = geographicBoundingBoxes;
	}
	
	
	/**
	 * @return the resultProducts_fundings
	 */
	public Set<ResultProduct_Funding> getResultProducts_fundings() {
		return resultProducts_fundings;
	}

	/**
	 * @param resultProducts_fundings the resultProducts_fundings to set
	 */
	public void setResultProducts_fundings(
			Set<ResultProduct_Funding> resultProducts_fundings) {
		this.resultProducts_fundings = resultProducts_fundings;
	}

	/**
	 * @return the resultProducts_indicators
	 */
	public Set<ResultProduct_Funding> getResultProducts_indicators() {
		return resultProducts_indicators;
	}

	/**
	 * @param resultProducts_indicators the resultProducts_indicators to set
	 */
	public void setResultProducts_indicators(
			Set<ResultProduct_Funding> resultProducts_indicators) {
		this.resultProducts_indicators = resultProducts_indicators;
	}

	/**
	 * @return the resultProducts_measurements
	 */
	public Set<ResultProduct_Measurement> getResultProducts_measurements() {
		return resultProducts_measurements;
	}

	/**
	 * @param resultProducts_measurements the resultProducts_measurements to set
	 */
	public void setResultProducts_measurements(
			Set<ResultProduct_Measurement> resultProducts_measurements) {
		this.resultProducts_measurements = resultProducts_measurements;
	}

	/**
	 * @return the resultProducts1_resultProducts
	 */
	public Set<ResultProduct_ResultProduct> getResultProducts1_resultProducts() {
		return resultProducts1_resultProducts;
	}

	/**
	 * @param resultProducts1_resultProducts the resultProducts1_resultProducts to set
	 */
	public void setResultProducts1_resultProducts(
			Set<ResultProduct_ResultProduct> resultProducts1_resultProducts) {
		this.resultProducts1_resultProducts = resultProducts1_resultProducts;
	}

	/**
	 * @return the resultProducts2_resultProducts
	 */
	public Set<ResultProduct_ResultProduct> getResultProducts2_resultProducts() {
		return resultProducts2_resultProducts;
	}

	/**
	 * @param resultProducts2_resultProducts the resultProducts2_resultProducts to set
	 */
	public void setResultProducts2_resultProducts(
			Set<ResultProduct_ResultProduct> resultProducts2_resultProducts) {
		this.resultProducts2_resultProducts = resultProducts2_resultProducts;
	}

	/**
	 * Returns the number of linked organisations.
	 * @return the number of linked organisations.
	 */
	public int getOrganisationCount() {
		int result = 0;
		if (organisationUnits_resultProducts != null) {
			result = organisationUnits_resultProducts.size();
		}
		return result;
	}
	
	/**
	 * Returns the number of linked persons.
	 * @return the number of linked persons.
	 */
	public int getPersonCount() {
		int result = 0;
		if (persons_resultProducts != null) {
			result = persons_resultProducts.size();
		}
		return result;
	}
	
	/**
	 * Returns the number of linked publications.
	 * @return the number of linked publications.
	 */
	public int getPublicationCount() {
		int result = 0;
		if (resultPublications != null) {
			result = resultPublications.size();
		}
		return result;
	}
	
	/**
	 * Returns the number of linked classes.
	 * @return the number of linked classes.
	 */
	public int getClassesCount() {
		int result = 0;
		if (classes != null) {
			result = classes.size();
		}
		return result;
	}
	
	
	public ResultProductName getFirstTranslationName() {
		ResultProductName result = null;
		if (resultProductNames != null && resultProductNames.size() > 0) {
			for (ResultProductName translation : resultProductNames) {
				if (StringUtils.hasText(translation.getName())) {
					result = translation;
					break;
				}
			}
		}
		return result;
	}
	
	public ResultProductDescription getFirstTranslationDescription() {
		ResultProductDescription result = null;
		if (resultProductDescriptions != null && resultProductDescriptions.size() > 0) {
			for (ResultProductDescription translation : resultProductDescriptions) {
				if (StringUtils.hasText(translation.getDescription())) {
					result = translation;
					break;
				}
			}
		}
		return result;
	}
	
	public ResultProductKeyword getFirstTranslationKeywords() {
		ResultProductKeyword result = null;
		if (resultProductKeywords != null && resultProductKeywords.size() > 0) {
			for (ResultProductKeyword translation : resultProductKeywords) {
				if (StringUtils.hasText(translation.getKeyword()) && translation.getLanguage().equals(Language.ENGLISH)) {
					result = translation;
					break;
				}
			}
			if (result == null) {
				for (ResultProductKeyword translation : resultProductKeywords) {
					if (StringUtils.hasText(translation.getKeyword())) {
						result = translation;
						break;
					}
				}
			}
			
		}
		return result;
	}
	
	/**
	 * Returns the owner.
	 * @return the owner.
	 */
	public OrganisationUnit getOwner() {
		OrganisationUnit result = null;
		if (organisationUnits_resultProducts != null && organisationUnits_resultProducts.size() > 0) {
			for (OrganisationUnit_ResultProduct organisation : organisationUnits_resultProducts) {
				if (organisation.isSource()) {
					result = organisation.getOrganisationUnit();
					break;
				}
			}
		}
		return result;
	}
	
	/**
	 * Returns the country code.
	 * @return the country code.
	 */
	public String getCountryCode() {
		String result = null;
		if (countries != null && countries.size() > 0) {
			result = countries.iterator().next().getCountry().getCode().toLowerCase();
		}
		return result;
	}
	
	/**
	 * Returns the country code.
	 * @return the country code.
	 */
	public String getCountryName() {
		String result = null;
		if (countries != null && countries.size() > 0) {
			result = countries.iterator().next().getCountry().getUri();
		}
		return result;
	}
	
	/**
	 * Returns the country code.
	 * @return the country code.
	 */
	public Country getFirstCountry() {
		Country result = null;
		if (countries != null && countries.size() > 0) {
			result = countries.iterator().next().getCountry();
		}
		return result;
	}
	
	public Class getTemporalCoverageClass() {
		Class result = null;
		if (classes != null) {
			for (ResultProduct_Class element : classes) {
				if (element.getTemporalCoverage()) {
					result = element.getTheClass();
					break;
				}
			}
		}
		return result;
	}
	
	public Set<Class> getNormalClasses() {
		Set<Class> result = new LinkedHashSet<Class>();
		if (classes != null) {
			for (ResultProduct_Class element : classes) {
				if (!element.getTemporalCoverage()) {
					result.add(element.getTheClass());
				}
			}
		}
		return result;
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
		if (!(obj instanceof ResultProduct)) {
			return false;
		}
		ResultProduct other = (ResultProduct) obj;
		if (uri == null) {
			if (other.uri != null) {
				return false;
			}
		} else if (!uri.equals(other.uri)) {
			return false;
		}
		return true;
	}
	
	/**
	 * Groups links between products and classes by scheme.
	 * @return a map.
	 */
	public Map<String, List<ResultProduct_Class>> getUniqueClassSchemes() {
		Map<String, List<ResultProduct_Class>> map = new HashMap<String, List<ResultProduct_Class>>();
		if (getClasses() != null) {
			for (ResultProduct_Class element : getClasses()) {
				final String uri = element.getTheClass().getScheme().getUri();
				if (!"Temporal Coverage".equals(uri)) {
					if (!map.containsKey(uri)) {
						map.put(uri, new ArrayList<ResultProduct_Class>());
					}
					map.get(uri).add(element);
				}
			}
		}
		return map;
	}
	
	/**
	 * Groups links between products and persons by class.
	 * @return a map.
	 */
	public Map<String, List<Person_ResultProduct>> getUniquePersonClasses() {
		Map<String, List<Person_ResultProduct>> map = new HashMap<String, List<Person_ResultProduct>>();
		if (persons_resultProducts != null) {
			for (Person_ResultProduct element : persons_resultProducts) {
				final String uri = element.getTheClass().getOriginalTranslation().getTerm();
				if (!map.containsKey(uri)) {
					map.put(uri, new ArrayList<Person_ResultProduct>());
				}
				map.get(uri).add(element);
			}
		}
		return map;
	}
	
	/**
	 * Groups links between products and projects by class.
	 * @return a map.
	 */
	public Map<String, List<Project_ResultProduct>> getUniqueProjectClasses() {
		Map<String, List<Project_ResultProduct>> map = new HashMap<String, List<Project_ResultProduct>>();
		if (projects_resultProducts != null) {
			for (Project_ResultProduct element : projects_resultProducts) {
				final String uri = element.getTheClass().getOriginalTranslation().getTerm();
				if (!map.containsKey(uri)) {
					map.put(uri, new ArrayList<Project_ResultProduct>());
				}
				map.get(uri).add(element);
			}
		}
		return map;
	}

	/**
	 * @return the resultProducts_services
	 */
	public Set<ResultProduct_Service> getResultProducts_services() {
		return resultProducts_services;
	}

	/**
	 * @param resultProducts_services the resultProducts_services to set
	 */
	public void setResultProducts_services(
			Set<ResultProduct_Service> resultProducts_services) {
		this.resultProducts_services = resultProducts_services;
	}

	/**
	 * @return the resultProducts_facilities
	 */
	public Set<ResultProduct_Facility> getResultProducts_facilities() {
		return resultProducts_facilities;
	}

	/**
	 * @param resultProducts_facilities the resultProducts_facilities to set
	 */
	public void setResultProducts_facilities(
			Set<ResultProduct_Facility> resultProducts_facilities) {
		this.resultProducts_facilities = resultProducts_facilities;
	}

	/**
	 * @return the classes
	 */
	public Set<ResultProduct_Class> getClasses() {
		return classes;
	}

	/**
	 * @param classes the classes to set
	 */
	public void setClasses(Set<ResultProduct_Class> classes) {
		this.classes = classes;
	}

	/**
	 * @return the projects_resultProducts
	 */
	public Set<Project_ResultProduct> getProjects_resultProducts() {
		return projects_resultProducts;
	}

	/**
	 * @param projects_resultProducts the projects_resultProducts to set
	 */
	public void setProjects_resultProducts(
			Set<Project_ResultProduct> projects_resultProducts) {
		this.projects_resultProducts = projects_resultProducts;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ResultProduct [id=" + id + ", uri="
				+ uri + "]";
	}
	
	
	
}
