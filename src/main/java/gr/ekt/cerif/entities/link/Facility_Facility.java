/**
 * 
 */
package gr.ekt.cerif.entities.link;

import java.util.Date;

import gr.ekt.cerif.entities.infrastructure.Facility;
import gr.ekt.cerif.features.semantics.Class;
import gr.ekt.cerif.pk.Facility_FacilityId;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * 
 */
@Entity
@Table(name="cfFacil_Facil")
@IdClass(Facility_FacilityId.class)
public class Facility_Facility implements CerifLinkEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7608609586280498520L;
	
	/**
	 * The first facility.
	 */
	@Id
	@ManyToOne 
	@JoinColumn(name="cfFacilId1")
	private Facility facility1;
	
	/**
	 * The second facility.
	 */
	@Id
	@ManyToOne 
	@JoinColumn(name="cfFacilId2")
	private Facility facility2;
	
	/**
	 * The Class.
	 */
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
	 * @return the facility1
	 */
	public Facility getFacility1() {
		return facility1;
	}

	/**
	 * @param facility1 the facility1 to set
	 */
	public void setFacility1(Facility facility1) {
		this.facility1 = facility1;
	}

	/**
	 * @return the facility2
	 */
	public Facility getFacility2() {
		return facility2;
	}

	/**
	 * @param facility2 the facility2 to set
	 */
	public void setFacility2(Facility facility2) {
		this.facility2 = facility2;
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
