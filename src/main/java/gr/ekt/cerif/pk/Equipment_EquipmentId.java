/**
 * 
 */
package gr.ekt.cerif.pk;

import gr.ekt.cerif.entities.infrastructure.Equipment;
import gr.ekt.cerif.features.semantics.Class;

import java.io.Serializable;
import java.util.Date;

/**
 * 
*/
public class Equipment_EquipmentId implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8041233196607129785L;

	/**
	 * The first equipment.
	 */
	private Equipment equipment1;
	
	/**
	 * The second equipment.
	 */
	private Equipment equipment2;
	
	/**
	 * The Class.
	 */
	private Class theClass;
	
	/**
	 * The start date.
	 */
	private Date startDate;
	
	/**
	 * The end date.
	 */
	private Date endDate;

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
	
}
