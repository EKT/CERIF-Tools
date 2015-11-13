/**
 * 
 */
package gr.ekt.cerif.entities.link.organisationunit;

import gr.ekt.cerif.entities.base.OrganisationUnit;
import gr.ekt.cerif.entities.link.CerifLinkEntity;
import gr.ekt.cerif.features.semantics.Class;

import java.util.Date;

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

/**
 * Links a organisationUnit with an organization unit.
 * 
 */
@Entity
@Table(name="cfOrgUnit_OrgUnit", uniqueConstraints=@UniqueConstraint(columnNames={"cfOrgUnitId1","cfOrgUnitId2","cfClassId","cfStartDate","cfEndDate"}))
public class OrganisationUnit_OrganisationUnit implements CerifLinkEntity {
	
	/**
	 * Serialization version.
	 */
	private static final long serialVersionUID = 1260922487608052569L;

	/**
	 * 
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	/**
	 * The organisationUnit.
	 */
	@ManyToOne(optional=false)
	@JoinColumn(name="cfOrgUnitId1")
	private OrganisationUnit organisationUnit1;
	
	/**
	 * The organisationUnit connected to
	 */
	@ManyToOne(optional=false)
	@JoinColumn(name="cfOrgUnitId2")
	private OrganisationUnit organisationUnit2;
	
	/**
	 * The class.
	 */
	@ManyToOne(optional=false)
	@JoinColumn(name="cfClassId")
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
	 * Default constructor
	 */
	public OrganisationUnit_OrganisationUnit() {
		
	}
	
	/**
	 * 
	 * @param organisationUnit1
	 * @param organisationUnit2
	 * @param theClass
	 * @param startDate
	 * @param endDate
	 * @param fraction
	 */
	public OrganisationUnit_OrganisationUnit(
			OrganisationUnit organisationUnit1,
			OrganisationUnit organisationUnit2, Class theClass, Date startDate,
			Date endDate, Double fraction) {
		this.organisationUnit1 = organisationUnit1;
		this.organisationUnit2 = organisationUnit2;
		this.theClass = theClass;
		this.startDate = startDate;
		this.endDate = endDate;
		this.fraction = fraction;
	}
	
	/**
	 * 
	 * @param organisationUnit1
	 * @param organisationUnit2
	 * @param theClass
	 * @param startDate
	 * @param endDate
	 */
	public OrganisationUnit_OrganisationUnit(
			OrganisationUnit organisationUnit1,
			OrganisationUnit organisationUnit2, Class theClass, Date startDate,
			Date endDate) {
		this.organisationUnit1 = organisationUnit1;
		this.organisationUnit2 = organisationUnit2;
		this.theClass = theClass;
		this.startDate = startDate;
		this.endDate = endDate;
	}

	/**
	 * @return the organisationUnit1
	 */
	public OrganisationUnit getOrganisationUnit1() {
		return organisationUnit1;
	}

	/**
	 * @param organisationUnit1 the organisationUnit1 to set
	 */
	public void setOrganisationUnit1(OrganisationUnit organisationUnit1) {
		this.organisationUnit1 = organisationUnit1;
	}

	/**
	 * @return the organisationUnit2
	 */
	public OrganisationUnit getOrganisationUnit2() {
		return organisationUnit2;
	}

	/**
	 * @param organisationUnit2 the organisationUnit2 to set
	 */
	public void setOrganisationUnit2(OrganisationUnit organisationUnit2) {
		this.organisationUnit2 = organisationUnit2;
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
	 * Returns the class.
	 * @return the class.
	 */
	public Class getTheClass() {
		return theClass;
	}

	/**
	 * Sets the class.
	 * @param theClass the class.
	 */
	public void setTheClass(Class theClass) {
		this.theClass = theClass;
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
		return "OrganisationUnit_OrganisationUnit [id=" + id
				+ ", organisationUnit1=" + organisationUnit1
				+ ", organisationUnit2=" + organisationUnit2 + ", theClass="
				+ theClass + ", startDate=" + startDate + ", endDate="
				+ endDate + ", fraction=" + fraction + "]";
	}
	
}
