package gr.ekt.cerif.xml.records.semantics;

import java.util.ArrayList;
import java.util.List;

import gr.ekt.cerif.features.semantics.ClassScheme;
import gr.ekt.transformationengine.core.Record;

public class CerifClassSchemeRecord extends Record {
	
	private ClassScheme classScheme;
	
	/**
	 * @param classScheme
	 */
	public CerifClassSchemeRecord(ClassScheme classScheme) {
		super();
		this.classScheme = classScheme;
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
	 * @return the classScheme
	 */
	public ClassScheme getClassScheme() {
		return classScheme;
	}

	/**
	 * @param classScheme the classScheme to set
	 */
	public void setClassScheme(ClassScheme classScheme) {
		this.classScheme = classScheme;
	}

}
