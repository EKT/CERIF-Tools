/**
 * 
 */
package gr.ekt.cerif.entities.link;

import gr.ekt.cerif.entities.second.Medium;
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
@Table(name="cfMedium_Medium", uniqueConstraints=@UniqueConstraint(columnNames={"cfMediumId1","cfMediumId2","cfClassId","cfStartDate","cfEndDate"}))
public class Medium_Medium implements CerifLinkEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -297680067653772140L;
	
	/**
	 * 
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	/**
	 * The first medium.
	 */
	@ManyToOne(optional=false) 
	@JoinColumn(name="cfMediumId1")
	private Medium medium1;
	
	/**
	 * The second medium.
	 */
	@ManyToOne(optional=false) 
	@JoinColumn(name="cfMediumId2")
	private Medium medium2;
	
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
	 * Default Construct
	 */
	public Medium_Medium() {
		
	}
	
	/**
	 * 
	 * @param medium1
	 * @param medium2
	 * @param theClass
	 * @param startDate
	 * @param endDate
	 * @param fraction
	 */
	public Medium_Medium(Medium medium1, Medium medium2, Class theClass,
			Date startDate, Date endDate, Double fraction) {
		this.medium1 = medium1;
		this.medium2 = medium2;
		this.theClass = theClass;
		this.startDate = startDate;
		this.endDate = endDate;
		this.fraction = fraction;
	}

	/**
	 * @return the medium1
	 */
	public Medium getMedium1() {
		return medium1;
	}

	/**
	 * @param medium1 the medium1 to set
	 */
	public void setMedium1(Medium medium1) {
		this.medium1 = medium1;
	}

	/**
	 * @return the medium2
	 */
	public Medium getMedium2() {
		return medium2;
	}

	/**
	 * @param medium2 the medium2 to set
	 */
	public void setMedium2(Medium medium2) {
		this.medium2 = medium2;
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

}
