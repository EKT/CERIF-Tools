/**
 * 
 */
package gr.ekt.cerif.entities.link;

import java.util.Date;

import gr.ekt.cerif.entities.infrastructure.Equipment;
import gr.ekt.cerif.features.semantics.Class;

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
@Table(name="cfEquip_Equip", uniqueConstraints=@UniqueConstraint(columnNames={"cfEquipId1","cfEquipId2", "cfClassId", "cfStartDate", "cfEndDate"}))
public class Equipment_Equipment implements CerifLinkEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4219004638327916992L;
	
	/**
	 * 
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	/**
	 * The first equipment.
	 */
	@ManyToOne(optional=false) 
	@JoinColumn(name="cfEquipId1")
	private Equipment equipment1;
	
	/**
	 * The second equipment.
	 */
	@ManyToOne(optional=false) 
	@JoinColumn(name="cfEquipId2")
	private Equipment equipment2;
	
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
	public Equipment_Equipment() { 
		
	}
	
	/**
	 * 
	 * @param equipment1
	 * @param equipment2
	 * @param theClass
	 * @param startDate
	 * @param endDate
	 * @param fraction
	 */
	public Equipment_Equipment(Equipment equipment1, Equipment equipment2,
			Class theClass, Date startDate, Date endDate, Double fraction) {
		this.equipment1 = equipment1;
		this.equipment2 = equipment2;
		this.theClass = theClass;
		this.startDate = startDate;
		this.endDate = endDate;
		this.fraction = fraction;
	}

	/**
	 * @return the equipment1
	 */
	public Equipment getEquipment1() {
		return equipment1;
	}

	/**
	 * @param equipment1 the equipment1 to set
	 */
	public void setEquipment1(Equipment equipment1) {
		this.equipment1 = equipment1;
	}

	/**
	 * @return the equipment2
	 */
	public Equipment getEquipment2() {
		return equipment2;
	}

	/**
	 * @param equipment2 the equipment2 to set
	 */
	public void setEquipment2(Equipment equipment2) {
		this.equipment2 = equipment2;
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
