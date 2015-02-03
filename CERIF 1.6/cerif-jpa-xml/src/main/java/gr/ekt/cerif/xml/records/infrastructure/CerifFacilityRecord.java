package gr.ekt.cerif.xml.records.infrastructure;

import java.util.ArrayList;
import java.util.List;

import gr.ekt.cerif.entities.infrastructure.Facility;
import gr.ekt.transformationengine.core.Record;

/**
 * @author bonisv
 *
 */
public class CerifFacilityRecord extends Record {
	
	private Facility facility;
	
	/**
	 * @param facility
	 */
	public CerifFacilityRecord(Facility facility) {
		super();
		this.facility = facility;
	}

	/**
	 * @return the facility
	 */
	public Facility getFacility() {
		return facility;
	}

	/**
	 * @param facility the facility to set
	 */
	public void setFacility(Facility facility) {
		this.facility = facility;
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

}
