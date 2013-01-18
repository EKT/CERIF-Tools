/**
 * 
 */
package gr.ekt.cerif.pk.organisationunit;

import gr.ekt.cerif.entities.base.OrganisationUnit;
import gr.ekt.cerif.entities.second.Prize;
import gr.ekt.cerif.features.semantics.Class;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 */
public class OrganisationUnit_PrizeId implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1760700563910501309L;

	/**
	 * The organisation unit.
	 */
	private OrganisationUnit organisationUnit;
	
	/**
	 * The prize.
	 */
	private Prize prize;
	
	/**
	 * The class.
	 */
	private Class theClass;
	
	/**
	 * The prize date.
	 */
	private Date prizeDate;

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
	 * @return the prize
	 */
	public Prize getPrize() {
		return prize;
	}

	/**
	 * @param prize the prize to set
	 */
	public void setPrize(Prize prize) {
		this.prize = prize;
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
	 * @return the prizeDate
	 */
	public Date getPrizeDate() {
		return prizeDate;
	}

	/**
	 * @param prizeDate the prizeDate to set
	 */
	public void setPrizeDate(Date prizeDate) {
		this.prizeDate = prizeDate;
	}
	
}
