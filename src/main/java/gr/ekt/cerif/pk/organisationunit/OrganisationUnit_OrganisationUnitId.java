/**
 * 
 */
package gr.ekt.cerif.pk.organisationunit;

import gr.ekt.cerif.entities.base.OrganisationUnit;
import gr.ekt.cerif.features.semantics.Class;

import java.io.Serializable;
import java.util.Date;

public class OrganisationUnit_OrganisationUnitId implements Serializable {

	/**
	 * Serialization version.
	 */
	private static final long serialVersionUID = -4987081364240754211L;

	/**
	 * The organisationUnit.
	 */
	private OrganisationUnit organisationUnit1;
	
	/**
	 * The organisationUnit connected to
	 */	
	private OrganisationUnit organisationUnit2;
	
	private Class theClass;
	
	/**
	 * The start date.
	 */
	private Date startDate;
		
	/**
	 * The end date.
	 */
	private Date endDate;

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
	

	public Class getTheClass() {
		return theClass;
	}
	
	public void setTheClass(Class theClass) {
		this.theClass = theClass;
	}

	/**
	 * @return the startDate
	 */
	public Date getStartDate() {
		return startDate;
	}

	/**
	 * @param startDate the startDate to set
	 */
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	/**
	 * @return the endDate
	 */
	public Date getEndDate() {
		return endDate;
	}

	/**
	 * @param endDate the endDate to set
	 */
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	
}
