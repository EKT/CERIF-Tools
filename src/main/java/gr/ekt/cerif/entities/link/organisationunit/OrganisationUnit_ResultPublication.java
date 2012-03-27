/**
 * 
 */
package gr.ekt.cerif.entities.link.organisationunit;

import gr.ekt.cerif.entities.base.OrganisationUnit;
import gr.ekt.cerif.entities.link.CerifLinkEntity;
import gr.ekt.cerif.entities.result.ResultPublication;
import gr.ekt.cerif.features.semantics.Class;
import gr.ekt.cerif.pk.organisationunit.OrganisationUnit_ResultPublicationId;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Links a project with an organization unit.
 * 
 */
@Entity
@Table(name="cfOrgUnit_ResPubl")
@IdClass(OrganisationUnit_ResultPublicationId.class)
public class OrganisationUnit_ResultPublication implements CerifLinkEntity {

	/**
	 * Serialization version.
	 */
	private static final long serialVersionUID = -2097944288509856L;

	/**
	 * The organisation unit.
	 */
	@Id
	@ManyToOne 
	@JoinColumn(name="cfOrgUnitId")
	private OrganisationUnit organisationUnit;
	
	/**
	 * The result publication.
	 */
	@Id
	@ManyToOne
	@JoinColumn(name="cfResPublId")
	private ResultPublication resultPublication;
	
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
	 * The copyright.
	 */
	@Column(name="cfCopyright")
	private String copyright;

	/**
	 * Returns the organisationUnit.
	 * @return the organisationUnit.
	 */
	public OrganisationUnit getOrganisationUnit() {
		return organisationUnit;
	}

	/**
	 * Sets the organisationUnit.
	 * @param organisationUnit the organisationUnit.
	 */
	public void setOrganisationUnit(OrganisationUnit organisationUnit) {
		this.organisationUnit = organisationUnit;
	}

	/**
	 * Returns the resultPublication.
	 * @return the resultPublication.
	 */
	public ResultPublication getResultPublication() {
		return resultPublication;
	}

	/**
	 * Sets the resultPublication.
	 * @param resultPublication the resultPublication.
	 */
	public void setResultPublication(ResultPublication resultPublication) {
		this.resultPublication = resultPublication;
	}

	/**
	 * Returns the class.
	 * @return the class.
	 */
	public Class getTheClass() {
		return this.theClass;
	}

	/**
	 * Sets the class.
	 * @param theClass the class.
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
	 * Returns the copyright.
	 * @return the copyright.
	 */
	public String getCopyright() {
		return copyright;
	}

	/**
	 * Sets the copyright.
	 * @param copyright the copyright.
	 */
	public void setCopyright(String copyright) {
		this.copyright = copyright;
	}
	
}
