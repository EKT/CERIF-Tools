/**
 * 
 */
package gr.ekt.cerif.pk.organisationunit;

import gr.ekt.cerif.entities.base.OrganisationUnit;
import gr.ekt.cerif.features.additional.DublinCore;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 */
public class OrganisationUnit_DublinCoreId implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3659540884274350970L;

	/**
	 * The organisation unit.
	 */
	private OrganisationUnit organisationUnit;
	
	/**
	 * The Dublin Core.
	 */
	private DublinCore dublinCore;
	
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
	 * @return the dublinCore
	 */
	public DublinCore getDublinCore() {
		return dublinCore;
	}

	/**
	 * @param dublinCore the dublinCore to set
	 */
	public void setDublinCore(DublinCore dublinCore) {
		this.dublinCore = dublinCore;
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
