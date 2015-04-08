/**
 * 
 */
package gr.ekt.cerif.entities.result;

import gr.ekt.cerif.entities.link.organisationunit.OrganisationUnit_ResultProduct;
import gr.ekt.cerif.entities.link.person.Person_ResultProduct;
import gr.ekt.cerif.entities.link.project.Project_ResultProduct;
import gr.ekt.cerif.entities.link.result.ResultProduct_Class;
import gr.ekt.cerif.entities.link.result.ResultProduct_Equipment;
import gr.ekt.cerif.entities.link.result.ResultProduct_Facility;
import gr.ekt.cerif.entities.link.result.ResultProduct_Funding;
import gr.ekt.cerif.entities.link.result.ResultProduct_GeographicBoundingBox;
import gr.ekt.cerif.entities.link.result.ResultProduct_Indicator;
import gr.ekt.cerif.entities.link.result.ResultProduct_Measurement;
import gr.ekt.cerif.entities.link.result.ResultProduct_Medium;
import gr.ekt.cerif.entities.link.result.ResultProduct_ResultPatent;
import gr.ekt.cerif.entities.link.result.ResultProduct_ResultProduct;
import gr.ekt.cerif.entities.link.result.ResultProduct_Service;
import gr.ekt.cerif.entities.link.result.ResultPublication_ResultProduct;
import gr.ekt.cerif.entities.second.FederatedIdentifier;
import gr.ekt.cerif.features.multilingual.ResultProductAlternateName;
import gr.ekt.cerif.features.multilingual.ResultProductDescription;
import gr.ekt.cerif.features.multilingual.ResultProductKeyword;
import gr.ekt.cerif.features.multilingual.ResultProductName;
import gr.ekt.cerif.features.multilingual.ResultProductVersionInfo;

import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;


/**
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
	 * The UUID.
	 */
	@Column(name="cfUUID")
	private String uuid;
	
	
	/**
	 * Multilingual.
	 */
	@OneToMany(mappedBy="resultProduct")
	private Set<ResultProductDescription> resultProductDescriptions;
	
	@OneToMany(mappedBy="resultProduct")
	private Set<ResultProductName> resultProductNames;
	
	@OneToMany(mappedBy="resultProduct")
	private Set<ResultProductAlternateName> resultProductAlternateNames;
	
	@OneToMany(mappedBy="resultProduct")
	private Set<ResultProductKeyword> resultProductKeywords;
	
	@OneToMany(mappedBy="resultProduct")
	private Set<ResultProductVersionInfo> resultProductVersionInfos;
	
	
	/**
	 * Links.
	 */
	@OneToMany (mappedBy = "resultProduct")
	private Set<OrganisationUnit_ResultProduct> organisationUnits_resultProducts;
	
	@OneToMany(mappedBy="resultProduct")
	private Set<Person_ResultProduct> persons_resultProducts;
	
	@OneToMany(mappedBy="resultProduct")
	private Set<ResultPublication_ResultProduct> resultPublications_resultProducts;
	
	@OneToMany(mappedBy="resultProduct")
	private Set<ResultProduct_Service> resultProducts_services;
	
	@OneToMany(mappedBy="resultProduct")
	private Set<ResultProduct_Facility> resultProducts_facilities;
	
	@OneToMany(mappedBy="resultProduct")
	private Set<ResultProduct_Class> resultProducts_classes;
	
	@OneToMany(mappedBy="resultProduct")
	private Set<Project_ResultProduct> projects_resultProducts;	
	
	@OneToMany(mappedBy="resultProduct")
	private Set<ResultProduct_GeographicBoundingBox> resultProducts_geographicBoundingBoxes;
	
	@OneToMany(mappedBy="resultProduct")
	private Set<ResultProduct_Funding> resultProducts_fundings;
	
	@OneToMany(mappedBy="resultProduct")
	private Set<ResultProduct_Indicator> resultProducts_indicators;

	@OneToMany(mappedBy="resultProduct")
	private Set<ResultProduct_Measurement> resultProducts_measurements;
	
	@OneToMany(mappedBy="resultProduct1")
	private Set<ResultProduct_ResultProduct> resultProducts_resultProducts1;
	
	@OneToMany(mappedBy="resultProduct2")
	private Set<ResultProduct_ResultProduct> resultProducts_resultProducts2;
	
	@OneToMany(mappedBy="resultProduct")
	private Set<ResultProduct_Equipment> resultProducts_equipments;
	
	@OneToMany(mappedBy="resultProduct")
	private Set<ResultProduct_Medium> resultProducts_mediums;
	
	@OneToMany(mappedBy="resultProduct")
	private Set<ResultProduct_ResultPatent> resultProducts_resultPatents;
	
	
	/**
	 * FederatedIdentifier entities related to ResultProduct instance.
	 */
	@Transient
	private List<FederatedIdentifier> federatedIdentifiers;	
	
	// ---------------------------------------------------------------------- //
	
	
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
			Set<ResultProductVersionInfo> resultProductVersionInfos) {
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
	
	/**
	 * Returns the resultProductAlternateNames.
	 * @return the resultProductAlternateNames.
	 */
	public Set<ResultProductAlternateName> getResultProductAlternateNames() {
		return resultProductAlternateNames;
	}

	/**
	 * Sets the resultProductAlternateNames.
	 * @param resultProductAlternateNames the resultProductAlternateNames.
	 */
	public void setResultProductAlternateNames(Set<ResultProductAlternateName> resultProductAlternateNames) {
		this.resultProductAlternateNames = resultProductAlternateNames;
	}

	public Set<ResultProductKeyword> getResultProductKeywords() {
		return resultProductKeywords;
	}

	public void setResultProductKeywords(Set<ResultProductKeyword> resultProductKeywords) {
		this.resultProductKeywords = resultProductKeywords;
	}

	public Set<ResultProductVersionInfo> getResultProductVersionInfos() {
		return resultProductVersionInfos;
	}

	public void setResultProductVersionInfos(
			Set<ResultProductVersionInfo> resultProductVersionInfos) {
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
	 * @return the resultPublications_resultProducts
	 */
	public Set<ResultPublication_ResultProduct> getResultPublications_resultProducts() {
		return resultPublications_resultProducts;
	}

	/**
	 * @param resultPublications_resultProducts the resultPublications_resultProducts to set
	 */
	public void setResultPublications_resultProducts(
			Set<ResultPublication_ResultProduct> resultPublications_resultProducts) {
		this.resultPublications_resultProducts = resultPublications_resultProducts;
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
	public Set<ResultProduct_Indicator> getResultProducts_indicators() {
		return resultProducts_indicators;
	}

	/**
	 * @param resultProducts_indicators the resultProducts_indicators to set
	 */
	public void setResultProducts_indicators(
			Set<ResultProduct_Indicator> resultProducts_indicators) {
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
	 * @return the resultProducts_classes
	 */
	public Set<ResultProduct_Class> getResultProducts_classes() {
		return resultProducts_classes;
	}

	/**
	 * @param resultProducts_classes the resultProducts_classes to set
	 */
	public void setResultProducts_classes(
			Set<ResultProduct_Class> resultProducts_classes) {
		this.resultProducts_classes = resultProducts_classes;
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

	/**
	 * @return the resultProducts_equipments
	 */
	public Set<ResultProduct_Equipment> getResultProducts_equipments() {
		return resultProducts_equipments;
	}

	/**
	 * @param resultProducts_equipments the resultProducts_equipments to set
	 */
	public void setResultProducts_equipments(
			Set<ResultProduct_Equipment> resultProducts_equipments) {
		this.resultProducts_equipments = resultProducts_equipments;
	}

	/**
	 * @return the resultProducts_resultProducts1
	 */
	public Set<ResultProduct_ResultProduct> getResultProducts_resultProducts1() {
		return resultProducts_resultProducts1;
	}

	/**
	 * @param resultProducts_resultProducts1 the resultProducts_resultProducts1 to set
	 */
	public void setResultProducts_resultProducts1(
			Set<ResultProduct_ResultProduct> resultProducts_resultProducts1) {
		this.resultProducts_resultProducts1 = resultProducts_resultProducts1;
	}

	/**
	 * @return the resultProducts_resultProducts2
	 */
	public Set<ResultProduct_ResultProduct> getResultProducts_resultProducts2() {
		return resultProducts_resultProducts2;
	}

	/**
	 * @param resultProducts_resultProducts2 the resultProducts_resultProducts2 to set
	 */
	public void setResultProducts_resultProducts2(
			Set<ResultProduct_ResultProduct> resultProducts_resultProducts2) {
		this.resultProducts_resultProducts2 = resultProducts_resultProducts2;
	}

	/**
	 * @return the resultProducts_mediums
	 */
	public Set<ResultProduct_Medium> getResultProducts_mediums() {
		return resultProducts_mediums;
	}

	/**
	 * @param resultProducts_mediums the resultProducts_mediums to set
	 */
	public void setResultProducts_mediums(
			Set<ResultProduct_Medium> resultProducts_mediums) {
		this.resultProducts_mediums = resultProducts_mediums;
	}
	
	/**
	 * Returns the resultProducts_resultPatents.
	 * @return the resultProducts_resultPatents.
	 */
	public Set<ResultProduct_ResultPatent> getResultProducts_resultPatents() {
		return resultProducts_resultPatents;
	}

	/**
	 * Sets the resultProducts_resultPatents.
	 * @param resultProducts_resultPatents the resultProducts_resultPatents.
	 */
	public void setResultProducts_resultPatents(Set<ResultProduct_ResultPatent> resultProducts_resultPatents) {
		this.resultProducts_resultPatents = resultProducts_resultPatents;
	}

	/**
	 * @return the resultProducts_geographicBoundingBoxes
	 */
	public Set<ResultProduct_GeographicBoundingBox> getResultProducts_geographicBoundingBoxes() {
		return resultProducts_geographicBoundingBoxes;
	}

	/**
	 * @param resultProducts_geographicBoundingBoxes the resultProducts_geographicBoundingBoxes to set
	 */
	public void setResultProducts_geographicBoundingBoxes(
			Set<ResultProduct_GeographicBoundingBox> resultProducts_geographicBoundingBoxes) {
		this.resultProducts_geographicBoundingBoxes = resultProducts_geographicBoundingBoxes;
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
		ResultProduct other = (ResultProduct) obj;
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
		return "ResultProduct [id=" + id + ", uri=" + uri + ", uuid=" + uuid
				+ "]";
	}

	
}
