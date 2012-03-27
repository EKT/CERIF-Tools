/**
 * 
 */
package gr.ekt.cerif.pk;

import gr.ekt.cerif.entities.base.OrganisationUnit;
import gr.ekt.cerif.entities.second.ElectronicAddress;

public class Test extends Abstract{
	/**
	 * The organisation unit.
	 */
	private static final long serialVersionUID = -9011238703693516402L;

	
	private OrganisationUnit organisationUnit;

	/**
	 * The electronic address.
	 */
	private ElectronicAddress electronicAddress;
	
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


}
