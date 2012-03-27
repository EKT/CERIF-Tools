/**
 * 
 */
package gr.ekt.cerif.entities.link.organisationunit;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import gr.ekt.cerif.entities.base.OrganisationUnit;
import gr.ekt.cerif.entities.link.CerifLinkEntity;
import gr.ekt.cerif.entities.second.Prize;
import gr.ekt.cerif.features.semantics.Class;
import gr.ekt.cerif.pk.organisationunit.OrganisationUnit_PrizeId;

/**
 * 
 */
@Entity
@Table(name="cfOrgUnit_Prize")
@IdClass(OrganisationUnit_PrizeId.class)
public class OrganisationUnit_Prize implements CerifLinkEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3963197941839110302L;

	/**
	 * The organisation unit.
	 */
	@Id
	@ManyToOne 
	@JoinColumn(name="cfOrgUnitId")
	private OrganisationUnit organisationUnit;
	
	/**
	 * The prize.
	 */
	@Id
	@ManyToOne 
	@JoinColumn(name="cfPrizeId")
	private Prize prize;
	
	/**
	 * The class.
	 */
	@Id
	@ManyToOne
	@JoinColumn(name="cfClassId")	
	private Class theClass;
	
	/**
	 * The prize date.
	 */
	@Id
	@Column (name="cfPrizeDate")
	private Date prizeDate;
	
	/**
	 * The fraction.
	 */
	@Column(name="cfFraction")
	private Double fraction;

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

	/**
	 * @return the fraction
	 */
	public Double getFraction() {
		return fraction;
	}

	/**
	 * @param fraction the fraction to set
	 */
	public void setFraction(Double fraction) {
		this.fraction = fraction;
	}
	
}
