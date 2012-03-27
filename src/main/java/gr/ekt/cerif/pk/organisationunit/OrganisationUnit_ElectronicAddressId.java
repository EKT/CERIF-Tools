/**
 * 
 */
package gr.ekt.cerif.pk.organisationunit;

import java.io.Serializable;
import java.util.Date;

import gr.ekt.cerif.entities.base.OrganisationUnit;
import gr.ekt.cerif.entities.second.ElectronicAddress;
import gr.ekt.cerif.features.semantics.Class;

/**
 * Compound key for associating an organisation with a postal address.
 * @see OrganisationUnit
 * @see PostalAddress
 * 
 */
public class OrganisationUnit_ElectronicAddressId implements Serializable {

	/**
	 * Serialization version.
	 */
	private static final long serialVersionUID = 87479075305217612L;

	/**
	 * The organisation unit.
	 */
	private OrganisationUnit organisationUnit;

	/**
	 * The electronic address.
	 */
	private ElectronicAddress electronicAddress;

	/**
	 * The class.
	 */
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
	 * @return the electronicAddress
	 */
	public ElectronicAddress getElectronicAddress() {
		return electronicAddress;
	}

	/**
	 * @param electronicAddress the electronicAddress to set
	 */
	public void setElectronicAddress(ElectronicAddress electronicAddress) {
		this.electronicAddress = electronicAddress;
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
