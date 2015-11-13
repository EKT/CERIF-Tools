/**
 * 
 */
package gr.ekt.cerif.entities.link;

import gr.ekt.cerif.entities.second.GeographicBoundingBox;
import gr.ekt.cerif.features.semantics.Class;

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
@Table(name="cfGeoBBox_GeoBBox", uniqueConstraints=@UniqueConstraint(columnNames={"cfGeoBBoxId1","cfGeoBBoxId2","cfClassId","cfStartDate","cfEndDate"}))
public class GeographicBoundingBox_GeographicBoundingBox implements CerifLinkEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7158677551745514198L;
	
	/**
	 * 
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	/**
	 * The first geographic bounding box.
	 */
	@ManyToOne(optional=false) 
	@JoinColumn(name="cfGeoBBoxId1")
	private GeographicBoundingBox geographicBoundingBox1;
	
	/**
	 * The second geographic bounding box.
	 */
	@ManyToOne(optional=false) 
	@JoinColumn(name="cfGeoBBoxId2")
	private GeographicBoundingBox geographicBoundingBox2;
	
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
	 * Default Constructor
	 */
	public GeographicBoundingBox_GeographicBoundingBox() {
		
	}
	
	/**
	 * 
	 * @param geographicBoundingBox1
	 * @param geographicBoundingBox2
	 * @param theClass
	 * @param startDate
	 * @param endDate
	 * @param fraction
	 */
	public GeographicBoundingBox_GeographicBoundingBox(
			GeographicBoundingBox geographicBoundingBox1,
			GeographicBoundingBox geographicBoundingBox2, Class theClass,
			Date startDate, Date endDate, Double fraction) {
		this.geographicBoundingBox1 = geographicBoundingBox1;
		this.geographicBoundingBox2 = geographicBoundingBox2;
		this.theClass = theClass;
		this.startDate = startDate;
		this.endDate = endDate;
		this.fraction = fraction;
	}

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
		return "GeographicBoundingBox_GeographicBoundingBox [id=" + id
				+ ", geographicBoundingBox1=" + geographicBoundingBox1
				+ ", geographicBoundingBox2=" + geographicBoundingBox2
				+ ", theClass=" + theClass + ", startDate=" + startDate
				+ ", endDate=" + endDate + ", fraction=" + fraction + "]";
	}
	
	
}
