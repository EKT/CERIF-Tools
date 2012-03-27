/**
 * 
 */
package gr.ekt.cerif.entities.link;

import java.util.Date;

import gr.ekt.cerif.entities.second.GeographicBoundingBox;
import gr.ekt.cerif.features.semantics.Class;
import gr.ekt.cerif.pk.GeographicBoundingBox_GeographicBoundingBoxId;

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
@Table(name="cfGeoBBox_GeoBBox")
@IdClass(GeographicBoundingBox_GeographicBoundingBoxId.class)
public class GeographicBoundingBox_GeographicBoundingBox implements CerifLinkEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7158677551745514198L;
	
	/**
	 * The first geographic bounding box.
	 */
	@Id
	@ManyToOne 
	@JoinColumn(name="cfGeoBBoxId1")
	private GeographicBoundingBox geographicBoundingBox1;
	
	/**
	 * The second geographic bounding box.
	 */
	@Id
	@ManyToOne 
	@JoinColumn(name="cfGeoBBoxId2")
	private GeographicBoundingBox geographicBoundingBox2;
	
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
	 * @return the geographicBoundingBox1
	 */
	public GeographicBoundingBox getGeographicBoundingBox1() {
		return geographicBoundingBox1;
	}

	/**
	 * @param geographicBoundingBox1 the geographicBoundingBox1 to set
	 */
	public void setGeographicBoundingBox1(
			GeographicBoundingBox geographicBoundingBox1) {
		this.geographicBoundingBox1 = geographicBoundingBox1;
	}

	/**
	 * @return the geographicBoundingBox2
	 */
	public GeographicBoundingBox getGeographicBoundingBox2() {
		return geographicBoundingBox2;
	}

	/**
	 * @param geographicBoundingBox2 the geographicBoundingBox2 to set
	 */
	public void setGeographicBoundingBox2(
			GeographicBoundingBox geographicBoundingBox2) {
		this.geographicBoundingBox2 = geographicBoundingBox2;
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
