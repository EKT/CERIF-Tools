/**
 * 
 */
package gr.ekt.cerif.entities.link.organisationunit;

import gr.ekt.cerif.entities.base.OrganisationUnit;
import gr.ekt.cerif.entities.link.CerifLinkEntity;
import gr.ekt.cerif.features.semantics.Class;
import gr.ekt.cerif.pk.organisationunit.OrganisationUnit_OrganisationUnitId;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Links a organisationUnit with an organization unit.
 * 
 */
@Entity
@Table(name="cfOrgUnit_OrgUnit")
@IdClass(OrganisationUnit_OrganisationUnitId.class)
public class OrganisationUnit_OrganisationUnit implements CerifLinkEntity {
	
	/**
	 * Serialization version.
	 */
	private static final long serialVersionUID = 1260922487608052569L;

	/**
	 * The organisationUnit.
	 */
	@Id
	@ManyToOne
	@JoinColumn(name="cfProjId1")
	private OrganisationUnit organisationUnit1;
	
	/**
	 * The organisationUnit connected to
	 */
	@Id	
	@ManyToOne
	@JoinColumn(name="cfProjId2")
	private OrganisationUnit organisationUnit2;
	
	@Id
	@ManyToOne
	@JoinColumn(name="cfClassId")
	private Class theClass;
	
	/**
	 * The start date.
	 */
	@Id
	@Column (name="cfStartDate")
	private Date startDate;
		
	/**
	 * The end date.
	 */
	@Id
	@Column (name="cfEndDate")
	private Date endDate;
	
	/**
	 * The fraction.
	 */
	@Column(name="cfFraction")
	private Double fraction;
	
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
	
}
