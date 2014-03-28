package gr.ekt.cerif.xml.records.infrastructure;

import java.util.ArrayList;
import java.util.List;

import gr.ekt.cerif.entities.infrastructure.Equipment;
import gr.ekt.transformationengine.core.Record;

public class CerifEquipmentRecord extends Record {
	
	private Equipment equipment;
	
	/**
	 * @param equipment
	 */
	public CerifEquipmentRecord(Equipment equipment) {
		super();
		this.setEquipment(equipment);
	}
	
	/**
	 * @return the equipment
	 */
	public Equipment getEquipment() {
		return equipment;
	}

	/**
	 * @param equipment the equipment to set
	 */
	public void setEquipment(Equipment equipment) {
		this.equipment = equipment;
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
