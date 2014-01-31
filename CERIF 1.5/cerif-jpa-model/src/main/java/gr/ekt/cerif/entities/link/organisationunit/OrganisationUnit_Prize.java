/**
 * 
 */
package gr.ekt.cerif.entities.link.organisationunit;

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

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import gr.ekt.cerif.entities.base.OrganisationUnit;
import gr.ekt.cerif.entities.link.CerifLinkEntity;
import gr.ekt.cerif.entities.second.Prize;
import gr.ekt.cerif.features.semantics.Class;

/**
 * 
 */
@Entity
@Table(name="cfOrgUnit_Prize", uniqueConstraints=@UniqueConstraint(columnNames={"cfOrgUnitId","cfPrizeId","cfClassId","cfClassId","cfPrizeDate"}))
public class OrganisationUnit_Prize implements CerifLinkEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3963197941839110302L;

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
	 * The prize.
	 */
	@ManyToOne(optional=false)
	@JoinColumn(name="cfPrizeId")
	@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
	private Prize prize;
	
	/**
	 * The class.
	 */
	@ManyToOne(optional=false)
	@JoinColumn(name="cfClassId")	
	@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
	private Class theClass;
	
	/**
	 * The prize date.
	 */
	@NotNull
	@Column (name="cfPrizeDate")
	private Date prizeDate;
	
	/**
	 * The fraction.
	 */
	@Column(name="cfFraction")
	private Double fraction;

	/**
	 * Default Constructor
	 */
	public OrganisationUnit_Prize() {
		
	}
	
	/**
	 * 
	 * @param organisationUnit
	 * @param prize
	 * @param theClass
	 * @param prizeDate
	 * @param fraction
	 */
	public OrganisationUnit_Prize(OrganisationUnit organisationUnit,
			Prize prize, Class theClass, Date prizeDate, Double fraction) {
		this.organisationUnit = organisationUnit;
		this.prize = prize;
		this.theClass = theClass;
		this.prizeDate = prizeDate;
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

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "OrganisationUnit_Prize [id=" + id + ", organisationUnit="
				+ organisationUnit + ", prize=" + prize + ", theClass="
				+ theClass + ", prizeDate=" + prizeDate + ", fraction="
				+ fraction + "]";
	}
	
}
