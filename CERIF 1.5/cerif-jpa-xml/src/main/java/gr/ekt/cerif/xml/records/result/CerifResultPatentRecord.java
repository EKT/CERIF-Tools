package gr.ekt.cerif.xml.records.result;

import java.util.ArrayList;
import java.util.List;

import gr.ekt.cerif.entities.result.ResultPatent;
import gr.ekt.transformationengine.core.Record;

/**
 * @author bonisv
 *
 */
public class CerifResultPatentRecord extends Record {
	
	private ResultPatent resultPatent;
	
	/**
	 * @param resultPatent
	 */
	public CerifResultPatentRecord(ResultPatent resultPatent) {
		super();
		this.resultPatent = resultPatent;
	}
		
	/**
	 * @return the resultPatent
	 */
	public ResultPatent getResultPatent() {
		return resultPatent;
	}

	/**
	 * @param resultPatent the resultPatent to set
	 */
	public void setResultPatent(ResultPatent resultPatent) {
		this.resultPatent = resultPatent;
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
