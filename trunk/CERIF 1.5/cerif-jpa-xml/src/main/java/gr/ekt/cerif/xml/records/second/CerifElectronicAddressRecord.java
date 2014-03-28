package gr.ekt.cerif.xml.records.second;

import java.util.ArrayList;
import java.util.List;

import gr.ekt.cerif.entities.second.ElectronicAddress;
import gr.ekt.transformationengine.core.Record;

public class CerifElectronicAddressRecord extends Record {
	
	private ElectronicAddress electronicAddress;
	
	/**
	 * @param electronicAddress
	 */
	public CerifElectronicAddressRecord(ElectronicAddress electronicAddress) {
		super();
		this.electronicAddress = electronicAddress;
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
