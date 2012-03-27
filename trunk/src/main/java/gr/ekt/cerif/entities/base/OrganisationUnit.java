/**
 * 
 */
package gr.ekt.cerif.entities.base;


import gr.ekt.cerif.entities.link.organisationunit.OrganisationUnit_ElectronicAddress;
import gr.ekt.cerif.entities.link.organisationunit.OrganisationUnit_OrganisationUnit;
import gr.ekt.cerif.entities.link.organisationunit.OrganisationUnit_PostalAddress;
import gr.ekt.cerif.entities.link.organisationunit.OrganisationUnit_ResultProduct;
import gr.ekt.cerif.entities.link.person.Person_OrganisationUnit;
import gr.ekt.cerif.entities.link.project.Project_OrganisationUnit;
import gr.ekt.cerif.entities.second.Currency;
import gr.ekt.cerif.entities.second.Language;
import gr.ekt.cerif.features.multilingual.OrganisationUnitKeyword;
import gr.ekt.cerif.features.multilingual.OrganisationUnitName;
import gr.ekt.cerif.features.multilingual.OrganisationUnitResearchActivity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Index;
import org.hibernate.search.annotations.Indexed;
import org.springframework.util.StringUtils;

/**
 * Represents an organization unit base entity.
 */
@Entity
@Table(name="cfOrgUnit")
@Indexed
public class OrganisationUnit implements CerifBaseEntity {
	
	/**
	 * Serialization version.
	 */
	private static final long serialVersionUID = 4703858171074790007L;

	/**
	 * The organisation unique identifier.
	 */
	@Id
	@Column(name="cfOrgUnitId")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	/**
	 * The currency code.
	 */
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="cfCurrCode")
	private Currency currency;
	
	/**
	 * The acronym.
	 */
	@Column(name="cfAcro")
	@Field(index=Index.TOKENIZED)
	private String acronym;

	/**
	 * The count of working staff.
	 */
	@Column(name="cfHeadcount")
	private Integer headCount;
	
	/**
	 * The number of times an asset is replaced during a financial period.
	 */
	@Column(name="cfTurn")
	private Double turn;

	/**
	 * The URI.
	 */
	@Column(name="cfURI")
	private String uri;
	
	/**
	 * The products.
	 */
	@OneToMany(mappedBy="organisationUnit")
	private Set<OrganisationUnit_ResultProduct> resultProducts;

	/**
	 * The projects.
	 */
	@OneToMany(mappedBy="organisationUnit")
	private Set<Project_OrganisationUnit> projects;
	
	/**
	 * The postal addresses.
	 */
	@OneToMany(mappedBy="organisationUnit")
	private Set<OrganisationUnit_PostalAddress> postalAddresses;
	
	/**
	 * The electronic addresses.
	 */
	@OneToMany(mappedBy="organisationUnit")
	private Set<OrganisationUnit_ElectronicAddress> electronicAddresses;	
	
	/**
	 * The OrganisationUnits.
	 */
	@OneToMany(mappedBy="organisationUnit1")
	private Set<OrganisationUnit_OrganisationUnit> organisationUnits1;
	
	/**
	 * The OrganisationUnits.
	 */
	@OneToMany(mappedBy="organisationUnit2")
	private Set<OrganisationUnit_OrganisationUnit> organisationUnits2;	
	
	/**
	 * The organisation unit names.
	 */
	@OneToMany(mappedBy="organisationUnit", fetch=FetchType.EAGER)
	private Set<OrganisationUnitName> organisationUnitNames;
	
	/**
	 * The organisation unit research activities.
	 */
	@OneToMany(mappedBy="organisationUnit", fetch=FetchType.EAGER)
	private Set<OrganisationUnitResearchActivity> organisationUnitResearchActivities;
	
	/**
	 * The organisation unit keywords.
	 */
	@OneToMany(mappedBy="organisationUnit", fetch=FetchType.EAGER)
	private Set<OrganisationUnitKeyword> organisationUnitKeywords;
	
	@OneToMany(mappedBy="organisationUnit")
	private Set<Person_OrganisationUnit> persons_organisationUnits;
	
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
	 * Returns the currency.
	 * @return the currency.
	 */
	public Currency getCurrency() {
		return currency;
	}

	/**
	 * Sets the currency.
	 * @param currency the currency.
	 */
	public void setCurrency(Currency currency) {
		this.currency = currency;
	}

	/**
	 * Returns the acronym.
	 * @return the acronym.
	 */
	public String getAcronym() {
		return acronym;
	}

	/**
	 * Sets the acronym.
	 * @param acronym the acronym.
	 */
	public void setAcronym(String acronym) {
		this.acronym = acronym;
	}

	/**
	 * Returns the count of working staff.
	 * @return the count of working staff.
	 */
	public Integer getHeadCount() {
		return headCount;
	}

	/**
	 * Sets the count of working staff.
	 * @param headCount the count of working staff.
	 */
	public void setHeadCount(Integer headCount) {
		this.headCount = headCount;
	}

	/**
	 * Returns the number of times an asset is replaced during a financial period.
	 * @return the number of times an asset is replaced during a financial period.
	 */
	public Double getTurn() {
		return turn;
	}

	/**
	 * Sets the number of times an asset is replaced during a financial period.
	 * @param turn the number of times an asset is replaced during a financial period.
	 */
	public void setTurn(Double turn) {
		this.turn = turn;
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
	 * Returns the result products.
	 * @return the result products.
	 */
	public Set<OrganisationUnit_ResultProduct> getResultProducts() {
		return resultProducts;
	}

	/**
	 * Sets the result products.
	 * @param resultProducts the result products.
	 */
	public void setResultProducts(Set<OrganisationUnit_ResultProduct> resultProducts) {
		this.resultProducts = resultProducts;
	}

	/**
	 * Returns the projects.
	 * @return the projects.
	 */
	public Set<Project_OrganisationUnit> getProjects() {
		return projects;
	}

	/**
	 * Sets the projects.
	 * @param projects the projects.
	 */
	public void setProjects(Set<Project_OrganisationUnit> projects) {
		this.projects = projects;
	}

	/**
	 * @return the postalAddresses
	 */
	public Set<OrganisationUnit_PostalAddress> getPostalAddresses() {
		return postalAddresses;
	}

	/**
	 * @param postalAddresses the postalAddresses to set
	 */
	public void setPostalAddresses(
			Set<OrganisationUnit_PostalAddress> postalAddresses) {
		this.postalAddresses = postalAddresses;
	}

	/**
	 * @return the electronicAddresses
	 */
	public Set<OrganisationUnit_ElectronicAddress> getElectronicAddresses() {
		return electronicAddresses;
	}

	/**
	 * @param electronicAddresses the electronicAddresses to set
	 */
	public void setElectronicAddresses(
			Set<OrganisationUnit_ElectronicAddress> electronicAddresses) {
		this.electronicAddresses = electronicAddresses;
	}

	
	
	/**
	 * @return the organisationUnits1
	 */
	public Set<OrganisationUnit_OrganisationUnit> getOrganisationUnits1() {
		return organisationUnits1;
	}

	/**
	 * @param organisationUnits1 the organisationUnits1 to set
	 */
	public void setOrganisationUnits1(Set<OrganisationUnit_OrganisationUnit> organisationUnits1) {
		this.organisationUnits1 = organisationUnits1;
	}

	/**
	 * @return the organisationUnits2
	 */
	public Set<OrganisationUnit_OrganisationUnit> getOrganisationUnits2() {
		return organisationUnits2;
	}

	/**
	 * @param organisationUnits2 the organisationUnits2 to set
	 */
	public void setOrganisationUnits2(Set<OrganisationUnit_OrganisationUnit> organisationUnits2) {
		this.organisationUnits2 = organisationUnits2;
	}

	/**
	 * Returns the organisation names.
	 * @return the organisation names.
	 */
	public Set<OrganisationUnitName> getOrganisationUnitNames() {
		return organisationUnitNames;
	}

	/**
	 * Sets the organisation names.
	 * @param organisationUnitNames the organisation names.
	 */
	public void setOrganisationUnitNames(Set<OrganisationUnitName> organisationUnitNames) {
		this.organisationUnitNames = organisationUnitNames;
	}
	
	/**
	 * @return the persons_organisationUnits
	 */
	public Set<Person_OrganisationUnit> getPersons_organisationUnits() {
		return persons_organisationUnits;
	}
	
	/**
	 * @param persons_organisationUnits the persons_organisationUnits to set
	 */
	public void setPersons_organisationUnits(
			Set<Person_OrganisationUnit> persons_organisationUnits) {
		this.persons_organisationUnits = persons_organisationUnits;
	}
	
	/**
	 * Returns the organisation translations.
	 * @return the organisation translations.
	 */
	public OrganisationUnitName getOrganisationUnitNameTranslation(Language language) {
		OrganisationUnitName result = null; 
		if (organisationUnitNames != null) {
			for (OrganisationUnitName translation : organisationUnitNames) {
				if (language.equals(translation.getLanguage())) {
					result = translation;
					break;
				}
			}
		}
		return result;
	}
	
	public OrganisationUnitName getFirstTranslationName() {
		OrganisationUnitName name = null;
		if (organisationUnitNames != null && organisationUnitNames.size() > 0) {
			for (OrganisationUnitName translation : organisationUnitNames) {
				if (StringUtils.hasText(translation.getName())) {
					name = translation;
					break;
				}
			}
		}
		return name;
	}
	
	/**
	 * Returns the organisation Research Activities.
	 * @return the organisation Research Activities.
	 */
	public Set<OrganisationUnitResearchActivity> getOrganisationUnitResearchActivities() {
		return organisationUnitResearchActivities;
	}

	/**
	 * Sets the organisation  Research Activities.
	 * @param organisationUnitResearchActivities the organisation  Research Activities.
	 */
	public void setOrganisationUnitResearchActivities(Set<OrganisationUnitResearchActivity> organisationUnitResearchActivities) {
		this.organisationUnitResearchActivities = organisationUnitResearchActivities;
	}
	
	/**
	 * Returns the organisation Research Activities translations.
	 * @return the organisation Research Activities translations.
	 */
	public OrganisationUnitResearchActivity getOrganisationUnitResearchActivityTranslation(Language language) {
		OrganisationUnitResearchActivity result = null; 
		if (organisationUnitResearchActivities != null) {
			for (OrganisationUnitResearchActivity translation : organisationUnitResearchActivities) {
				if (language.equals(translation.getLanguage())) {
					result = translation;
					break;
				}
			}
		}
		return result;
	}
	
	public OrganisationUnitResearchActivity getFirstTranslationResearchActivity() {
		OrganisationUnitResearchActivity result = null;
		if (organisationUnitResearchActivities != null && organisationUnitResearchActivities.size() > 0) {
			for (OrganisationUnitResearchActivity translation : organisationUnitResearchActivities) {
				if (StringUtils.hasText(translation.getResearchActivity())) {
					result = translation;
					break;
				}
			}
		}
		return result;
	}
	
	/**
	 * Returns the organisation Keywords.
	 * @return the organisation Keywords.
	 */
	public Set<OrganisationUnitKeyword> getOrganisationUnitKeywords() {
		return organisationUnitKeywords;
	}

	/**
	 * Sets the organisation Keywords.
	 * @param organisationUnitResearchActivities the organisation Keywords.
	 */
	public void setOrganisationUnitKeywords(Set<OrganisationUnitKeyword> organisationUnitKeywords) {
		this.organisationUnitKeywords = organisationUnitKeywords;
	}
	
	/**
	 * Returns the organisation Keywords translations.
	 * @return the organisation Keywords translations.
	 */
	public OrganisationUnitKeyword getOrganisationUnitKeywordsTranslation(Language language) {
		OrganisationUnitKeyword result = null; 
		if (organisationUnitKeywords != null) {
			for (OrganisationUnitKeyword translation : organisationUnitKeywords) {
				if (language.equals(translation.getLanguage())) {
					result = translation;
					break;
				}
			}
		}
		return result;
	}
	
	public OrganisationUnitKeyword getFirstTranslationKeyword() {
		OrganisationUnitKeyword result = null;
		if (organisationUnitKeywords != null && organisationUnitKeywords.size() > 0) {
			for (OrganisationUnitKeyword translation : organisationUnitKeywords) {
				if (StringUtils.hasText(translation.getKeyword())) {
					result = translation;
					break;
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
		if (!(obj instanceof OrganisationUnit)) {
			return false;
		}
		OrganisationUnit other = (OrganisationUnit) obj;
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
