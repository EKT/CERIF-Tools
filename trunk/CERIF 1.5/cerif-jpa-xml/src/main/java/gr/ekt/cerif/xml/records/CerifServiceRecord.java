package gr.ekt.cerif.xml.records;

import java.util.ArrayList;
import java.util.List;

import gr.ekt.cerif.entities.infrastructure.Service;
import gr.ekt.transformationengine.core.Record;

public class CerifServiceRecord extends Record {

	private Service service;
	
	/**
	 * @param service
	 */
	public CerifServiceRecord(Service service) {
		super();
		this.setService(service);
	}
	
	/**
	 * @return the service
	 */
	public Service getService() {
		return service;
	}

	/**
	 * @param service the service to set
	 */
	public void setService(Service service) {
		this.service = service;
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
