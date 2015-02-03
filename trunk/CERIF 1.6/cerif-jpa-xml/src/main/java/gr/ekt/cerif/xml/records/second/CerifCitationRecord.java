package gr.ekt.cerif.xml.records.second;

import java.util.ArrayList;
import java.util.List;

import gr.ekt.cerif.entities.second.Citation;
import gr.ekt.transformationengine.core.Record;

public class CerifCitationRecord extends Record {
	
	private Citation citation;
	
	/**
	 * @param citation
	 */
	public CerifCitationRecord(Citation citation) {
		super();
		this.citation = citation;
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
	 * @return the citation
	 */
	public Citation getCitation() {
		return citation;
	}

	/**
	 * @param citation the citation to set
	 */
	public void setCitation(Citation citation) {
		this.citation = citation;
	}

}
