/**
 * 
 */
package gr.ekt.cerif.entities.link;

import gr.ekt.cerif.entities.second.ElectronicAddress;
import gr.ekt.cerif.features.semantics.Class;
import gr.ekt.cerif.pk.ElectronicAddress_ClassId;

import java.util.Date;

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
@Table(name="cfEAddr_Class")
@IdClass(ElectronicAddress_ClassId.class)
public class ElectronicAddress_Class implements CerifLinkEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2805489636889130539L;
	
	/**
	 * The electronic address.
	 */
	@Id
	@ManyToOne 
	@JoinColumn(name="cfEAddrId")
	private ElectronicAddress electronicAddress;
	
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
	 * @return the electronicAddress
	 */
	public ElectronicAddress getElectronicAddress() {
		return electronicAddress;
	}

	/**
	 * @param electronicAddress the electronicAddress to set
	 */
	public void setElectronicAddress(ElectronicAddress electronicAddress) {
		this.electronicAddress = electronicAddress;
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
