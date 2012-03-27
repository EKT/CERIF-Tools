/**
 * 
 */
package gr.ekt.cerif.pk.organisationunit;

import gr.ekt.cerif.entities.base.OrganisationUnit;
import gr.ekt.cerif.entities.result.ResultPatent;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 */
public class OrganisationUnit_ResultPatentId implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2311791542626471321L;

	/**
	 * The organisation unit.
	 */
	private OrganisationUnit organisationUnit;
	
	/**
	 * The result patent.
	 */
	private ResultPatent resultPatent;
	
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
	 * @return the resultPatent
	 */
	public ResultPatent getResultPatent() {
		return resultPatent;
	}

	/**
	 * @param resultPatent the resultPatent to set
	 */
	public void setResultPatent(ResultPatent resultPatent) {
		this.resultPatent = resultPatent;
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
