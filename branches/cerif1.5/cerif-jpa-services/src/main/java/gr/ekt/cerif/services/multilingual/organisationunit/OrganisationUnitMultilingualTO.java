package gr.ekt.cerif.services.multilingual.organisationunit;

import gr.ekt.cerif.features.multilingual.OrganisationUnitKeyword;
import gr.ekt.cerif.features.multilingual.OrganisationUnitName;
import gr.ekt.cerif.features.multilingual.OrganisationUnitResearchActivity;

import java.util.List;

public class OrganisationUnitMultilingualTO {

	
	/**
	 * The organisation unique identifier.
	 */
	private Long id;
	
	/**
	 * The organisation unit names.
	 */
	private List<OrganisationUnitName> organisationUnitNames;
	
	/**
	 * The organisation unit research activities.
	 */
	private List<OrganisationUnitResearchActivity> organisationUnitResearchActivities;
	
	/**
	 * The organisation unit keywords.
	 */
	private List<OrganisationUnitKeyword> organisationUnitKeywords;

	/**
	 * @param id
	 * @param organisationUnitNames
	 * @param organisationUnitResearchActivities
	 * @param organisationUnitKeywords
	 */
	public OrganisationUnitMultilingualTO(
			Long id,
			List<OrganisationUnitName> organisationUnitNames,
			List<OrganisationUnitResearchActivity> organisationUnitResearchActivities,
			List<OrganisationUnitKeyword> organisationUnitKeywords) {
		super();
		this.id = id;
		this.organisationUnitNames = organisationUnitNames;
		this.organisationUnitResearchActivities = organisationUnitResearchActivities;
		this.organisationUnitKeywords = organisationUnitKeywords;
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
	 * @return the organisationUnitNames
	 */
	public List<OrganisationUnitName> getOrganisationUnitNames() {
		return organisationUnitNames;
	}

	/**
	 * @param organisationUnitNames the organisationUnitNames to set
	 */
	public void setOrganisationUnitNames(
			List<OrganisationUnitName> organisationUnitNames) {
		this.organisationUnitNames = organisationUnitNames;
	}

	/**
	 * @return the organisationUnitResearchActivities
	 */
	public List<OrganisationUnitResearchActivity> getOrganisationUnitResearchActivities() {
		return organisationUnitResearchActivities;
	}

	/**
	 * @param organisationUnitResearchActivities the organisationUnitResearchActivities to set
	 */
	public void setOrganisationUnitResearchActivities(
			List<OrganisationUnitResearchActivity> organisationUnitResearchActivities) {
		this.organisationUnitResearchActivities = organisationUnitResearchActivities;
	}

	/**
	 * @return the organisationUnitKeywords
	 */
	public List<OrganisationUnitKeyword> getOrganisationUnitKeywords() {
		return organisationUnitKeywords;
	}

	/**
	 * @param organisationUnitKeywords the organisationUnitKeywords to set
	 */
	public void setOrganisationUnitKeywords(
			List<OrganisationUnitKeyword> organisationUnitKeywords) {
		this.organisationUnitKeywords = organisationUnitKeywords;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "OrganisationUnitMultilingualTO [id=" + id
				+ ", organisationUnitNames=" + organisationUnitNames
				+ ", organisationUnitResearchActivities="
				+ organisationUnitResearchActivities
				+ ", organisationUnitKeywords=" + organisationUnitKeywords
				+ "]";
	}
	
	

}
