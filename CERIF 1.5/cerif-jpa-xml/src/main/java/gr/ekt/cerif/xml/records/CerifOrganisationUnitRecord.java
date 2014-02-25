package gr.ekt.cerif.xml.records;

import java.util.ArrayList;
import java.util.List;

import gr.ekt.cerif.entities.base.OrganisationUnit;
import gr.ekt.transformationengine.core.Record;

/**
 * @author bonisv
 *
 */
public class CerifOrganisationUnitRecord extends Record {

	private OrganisationUnit organisationUnit;
	
	/**
	 * @param organisationUnit
	 */
	public CerifOrganisationUnitRecord(OrganisationUnit organisationUnit) {
		super();
		this.organisationUnit = organisationUnit;
	}

	@Override
	public List<Object> getByName(String fieldName) {
		return null;
	}

	@Override
	public void printByName(String fieldName) {
	}

	@Override
	public void removeField(String fieldName) {
	}

	@Override
	public void removeValueFromField(String fieldName, Object value) {
	}

	@Override
	public void addField(String fieldName, ArrayList<Object> fieldValues) {
	}

	@Override
	public void addValueToField(String fieldName, Object fieldValue) {
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

}
