package gr.ekt.cerif.xml.records;

import java.util.ArrayList;
import java.util.List;

import gr.ekt.cerif.features.semantics.Class;

import gr.ekt.transformationengine.core.Record;

public class CerifClassRecord extends Record {

	private Class theClass;
	
	/**
	 * @param theClass
	 */
	public CerifClassRecord(Class theClass) {
		super();
		this.theClass = theClass;
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

}
