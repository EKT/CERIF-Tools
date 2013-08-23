/**
 * 
 */
package gr.ekt.cerif.entities.link.organisationunit;

import gr.ekt.cerif.entities.base.OrganisationUnit;
import gr.ekt.cerif.entities.link.CerifLinkEntity;
import gr.ekt.cerif.features.additional.DublinCore;

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
 * 
 */
@Entity
@Table(name="cfOrgUnit_DC", uniqueConstraints=@UniqueConstraint(columnNames={"cfOrgUnitId","cfDCId","cfDCScheme","cfStartDate","cfEndDate"}))
public class OrganisationUnit_DublinCore implements CerifLinkEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3281743362364049870L;

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
	private OrganisationUnit organisationUnit;
	
	/**
	 * The Dublin Core.
	 */
	@ManyToOne(optional=false)
//	@JoinColumns({
//        @JoinColumn(name="cfDCId"),
//        @JoinColumn(name="cfDCScheme")
//    })
	@JoinColumn(name="cfDCId")
	private DublinCore dublinCore;
	
	/**
	 * The dc scheme.
	 */
	@NotNull
	@Column(name="cfDCScheme")
	private String scheme;
	
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
	 * Default Constructor
	 */
	public OrganisationUnit_DublinCore() {
		
	}
	
	/**
	 * 
	 * @param organisationUnit
	 * @param dublinCore
	 * @param startDate
	 * @param endDate
	 * @param fraction
	 */
	public OrganisationUnit_DublinCore(OrganisationUnit organisationUnit,
			DublinCore dublinCore, Date startDate, Date endDate, Double fraction) {
		this.organisationUnit = organisationUnit;
		this.dublinCore = dublinCore;
		this.startDate = startDate;
		this.endDate = endDate;
		this.fraction = fraction;
	}

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
	 * @return the scheme
	 */
	public String getScheme() {
		return scheme;
	}

	/**
	 * @param scheme the scheme to set
	 */
	public void setScheme(String scheme) {
		this.scheme = scheme;
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
