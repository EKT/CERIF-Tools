/**
 * 
 */
package gr.ekt.cerif.entities.link.organisationunit;

import gr.ekt.cerif.entities.base.OrganisationUnit;
import gr.ekt.cerif.entities.link.CerifLinkEntity;
import gr.ekt.cerif.entities.second.PostalAddress;
import gr.ekt.cerif.features.semantics.Class;

import java.util.Date;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
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

/**
 * Links an organization unit with a postal address.
 * 
 */
@Entity
@Table(name="cfOrgUnit_PAddr", uniqueConstraints=@UniqueConstraint(columnNames={"cfOrgUnitId","cfPAddrId","cfClassId","cfStartDate","cfEndDate"}))
@Cacheable
@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
public class OrganisationUnit_PostalAddress implements CerifLinkEntity {
	
	/**
	 * Serialization version.
	 */
	private static final long serialVersionUID = -389578971645571064L;
	
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
	 * The postal address.
	 */
	@ManyToOne(optional=false)
	@JoinColumn(name="cfPAddrId")
	@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
	private PostalAddress postalAddress;

	/**
	 * The class.
	 */
	@ManyToOne(optional=false)
	@JoinColumn(name="cfClassId")
	@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
	private Class theClass;
	
	/**
	 * The start date.
	 */
	@NotNull
	@Column (name="cfStartDate")
	private Date startDate;
	
	/**
	 * The end date.
	 */
	@NotNull
	@Column (name="cfEndDate")
	private Date endDate;
	
	/**
	 * The fraction.
	 */
	@Column(name="cfFraction")
	private Double fraction;
	
	/**
	 * Default Constructor
	 */
	public OrganisationUnit_PostalAddress() { 
	
	}
	
	/**
	 * 
	 * @param organisationUnit
	 * @param postalAddress
	 * @param theClass
	 * @param startDate
	 * @param endDate
	 * @param fraction
	 */
	public OrganisationUnit_PostalAddress(OrganisationUnit organisationUnit,
			PostalAddress postalAddress, Class theClass, Date startDate,
			Date endDate, Double fraction) {
		this.organisationUnit = organisationUnit;
		this.postalAddress = postalAddress;
		this.theClass = theClass;
		this.startDate = startDate;
		this.endDate = endDate;
		this.fraction = fraction;
	}
	
	/**
	 * 
	 * @param organisationUnit
	 * @param postalAddress
	 * @param theClass
	 * @param startDate
	 * @param endDate
	 */
	public OrganisationUnit_PostalAddress(OrganisationUnit organisationUnit,
			PostalAddress postalAddress, Class theClass, Date startDate,
			Date endDate) {
		this.organisationUnit = organisationUnit;
		this.postalAddress = postalAddress;
		this.theClass = theClass;
		this.startDate = startDate;
		this.endDate = endDate;
	}
	
	/**
	 * 
	 * @param organisationUnit
	 * @param postalAddress
	 * @param startDate
	 * @param endDate
	 */
	public OrganisationUnit_PostalAddress(OrganisationUnit organisationUnit,
			PostalAddress postalAddress, Date startDate,
			Date endDate) {
		this.organisationUnit = organisationUnit;
		this.postalAddress = postalAddress;
		this.startDate = startDate;
		this.endDate = endDate;
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
	 * @return the postalAddress
	 */
	public PostalAddress getPostalAddress() {
		return postalAddress;
	}

	/**
	 * @param postalAddress the postalAddress to set
	 */
	public void setPostalAddress(PostalAddress postalAddress) {
		this.postalAddress = postalAddress;
	}

	/**
	 * @return the theClass
	 */
	public Class getTheClass() {
		return theClass;
	}

	/**
	 * @param theClass the theClass to set
	 */
	public void setTheClass(Class theClass) {
		this.theClass = theClass;
	}

	/**
	 * Returns the start date.
	 * @return the start date.
	 */
	public Date getStartDate() {
		return startDate;
	}

	/**
	 * Sets the start date.
	 * @param startDate the start date.
	 */
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	/**
	 * Returns the end date.
	 * @return the end date.
	 */
	public Date getEndDate() {
		return endDate;
	}

	/**
	 * Sets the end date.
	 * @param endDate the end date.
	 */
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	/**
	 * Returns the fraction.
	 * @return the fraction.
	 */
	public Double getFraction() {
		return fraction;
	}

	/**
	 * Sets the fraction.
	 * @param fraction the fraction.
	 */
	public void setFraction(Double fraction) {
		this.fraction = fraction;
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
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "OrganisationUnit_PostalAddress [id=" + id
				+ ", organisationUnit=" + organisationUnit + ", postalAddress="
				+ postalAddress + ", theClass=" + theClass + ", startDate="
				+ startDate + ", endDate=" + endDate + ", fraction=" + fraction
				+ "]";
	}


}
