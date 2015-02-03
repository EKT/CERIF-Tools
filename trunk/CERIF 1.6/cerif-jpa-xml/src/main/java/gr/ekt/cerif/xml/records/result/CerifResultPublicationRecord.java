package gr.ekt.cerif.xml.records.result;

import java.util.ArrayList;
import java.util.List;

import gr.ekt.cerif.entities.result.ResultPublication;
import gr.ekt.transformationengine.core.Record;

/**
 * @author bonisv
 *
 */
public class CerifResultPublicationRecord extends Record {

	private ResultPublication resultPublication;
	
	
	/**
	 * @param resultPublication
	 */
	public CerifResultPublicationRecord(ResultPublication resultPublication) {
		super();
		this.setResultPublication(resultPublication);
	}

	/**
	 * @return the resultPublication
	 */
	public ResultPublication getResultPublication() {
		return resultPublication;
	}

	/**
	 * @param resultPublication the resultPublication to set
	 */
	public void setResultPublication(ResultPublication resultPublication) {
		this.resultPublication = resultPublication;
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
