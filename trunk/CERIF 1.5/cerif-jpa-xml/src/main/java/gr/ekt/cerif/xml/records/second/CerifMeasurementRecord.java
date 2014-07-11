package gr.ekt.cerif.xml.records.second;

import java.util.ArrayList;
import java.util.List;

import gr.ekt.cerif.entities.second.Measurement;
import gr.ekt.transformationengine.core.Record;

public class CerifMeasurementRecord extends Record {
	
	private Measurement measurement;
	
	/**
	 * @param measurement
	 */
	public CerifMeasurementRecord(Measurement measurement) {
		super();
		this.setMeasurement(measurement);
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
	 * @return the measurement
	 */
	public Measurement getMeasurement() {
		return measurement;
	}

	/**
	 * @param measurement the measurement to set
	 */
	public void setMeasurement(Measurement measurement) {
		this.measurement = measurement;
	}

}
