/**
 * 
 */
package gr.ekt.cerif.entities.link.organisationunit;

import gr.ekt.cerif.entities.base.OrganisationUnit;
import gr.ekt.cerif.entities.link.CerifLinkEntity;
import gr.ekt.cerif.entities.result.ResultPublication;
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
 * Links a project with an organization unit.
 * 
 */
@Entity
@Table(name="cfOrgUnit_ResPubl", uniqueConstraints=@UniqueConstraint(columnNames={"cfOrgUnitId","cfResPublId","cfClassId","cfStartDate","cfEndDate"}))
@Cacheable
@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
public class OrganisationUnit_ResultPublication implements CerifLinkEntity {

	/**
	 * Serialization version.
	 */
	private static final long serialVersionUID = -2097944288509856L;
	
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
	 * The result publication.
	 */
	@ManyToOne(optional=false)
	@JoinColumn(name="cfResPublId")
	@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
	private ResultPublication resultPublication;
	
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
	 * The copyright.
	 */
	@Column(name="cfCopyright")
	private String copyright;

	/**
	 * Default Constructor
	 */
	public OrganisationUnit_ResultPublication() {
		
	}
	
	/**
	 * 
	 * @param organisationUnit
	 * @param resultPublication
	 * @param theClass
	 * @param startDate
	 * @param endDate
	 * @param fraction
	 * @param copyright
	 */
	public OrganisationUnit_ResultPublication(
			OrganisationUnit organisationUnit,
			ResultPublication resultPublication, Class theClass,
			Date startDate, Date endDate, Double fraction, String copyright) {
		this.organisationUnit = organisationUnit;
		this.resultPublication = resultPublication;
		this.theClass = theClass;
		this.startDate = startDate;
		this.endDate = endDate;
		this.fraction = fraction;
		this.copyright = copyright;
	}
	
	/**
	 * 
	 * @param organisationUnit
	 * @param resultPublication
	 * @param theClass
	 * @param startDate
	 * @param endDate
	 * @param fraction
	 */
	public OrganisationUnit_ResultPublication(
			OrganisationUnit organisationUnit,
			ResultPublication resultPublication, Class theClass,
			Date startDate, Date endDate, Double fraction) {
		this.organisationUnit = organisationUnit;
		this.resultPublication = resultPublication;
		this.theClass = theClass;
		this.startDate = startDate;
		this.endDate = endDate;
		this.fraction = fraction;
	}
	
	/**
	 * 
	 * @param organisationUnit
	 * @param resultPublication
	 * @param theClass
	 * @param startDate
	 * @param endDate
	 */
	public OrganisationUnit_ResultPublication(
			OrganisationUnit organisationUnit,
			ResultPublication resultPublication, Class theClass,
			Date startDate, Date endDate) {
		this.organisationUnit = organisationUnit;
		this.resultPublication = resultPublication;
		this.theClass = theClass;
		this.startDate = startDate;
		this.endDate = endDate;
	}

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
	
}
