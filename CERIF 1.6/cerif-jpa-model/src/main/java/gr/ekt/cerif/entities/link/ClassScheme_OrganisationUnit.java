package gr.ekt.cerif.entities.link;

import gr.ekt.cerif.entities.base.OrganisationUnit;
import gr.ekt.cerif.features.semantics.Class;
import gr.ekt.cerif.features.semantics.ClassScheme;

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


@Entity
@Table(name="cfClassScheme_OrgUnit" , uniqueConstraints=@UniqueConstraint(columnNames={"cfClassSchemeId","cfOrgUnitId","cfClassId", "cfStartDate", "cfEndDate"}))
public class ClassScheme_OrganisationUnit implements CerifLinkEntity {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4473062168084881360L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	/**
	 * The class scheme.
	 */
	@ManyToOne(optional=false) 
	@JoinColumn(name="cfClassSchemeId")
	private ClassScheme scheme;
	
	/**
	 * The organisation unit.
	 */
	@ManyToOne(optional=false)
	@JoinColumn(name="cfOrgUnitId")
	private OrganisationUnit organisationUnit;
	
	/**
	 * The Class.
	 */
	@ManyToOne(optional=false)
	@JoinColumn(name="cfClassId")
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
	 * 
	 */
	public ClassScheme_OrganisationUnit() {
		super();
	}
	
	/**
	 * @param classScheme
	 * @param organisationUnit
	 * @param theClass
	 * @param startDate
	 * @param endDate
	 */
	public ClassScheme_OrganisationUnit(ClassScheme classScheme,
			OrganisationUnit organisationUnit, Class theClass, Date startDate,
			Date endDate) {
		super();
		this.scheme = classScheme;
		this.organisationUnit = organisationUnit;
		this.theClass = theClass;
		this.startDate = startDate;
		this.endDate = endDate;
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

	/**
	 * @return the classScheme
	 */
	public ClassScheme getClassScheme() {
		return scheme;
	}

	/**
	 * @param classScheme the classScheme to set
	 */
	public void setClassScheme(ClassScheme classScheme) {
		this.scheme = classScheme;
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
	
	/**
	 * @return the scheme
	 */
	public ClassScheme getScheme() {
		return scheme;
	}

	/**
	 * @param scheme the scheme to set
	 */
	public void setScheme(ClassScheme scheme) {
		this.scheme = scheme;
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

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ClassScheme_OrgUnit [classScheme=" + scheme
				+ ", organisationUnit=" + organisationUnit + ", theClass="
				+ theClass + ", startDate=" + startDate + ", endDate="
				+ endDate + "]";
	}
	
	

}
