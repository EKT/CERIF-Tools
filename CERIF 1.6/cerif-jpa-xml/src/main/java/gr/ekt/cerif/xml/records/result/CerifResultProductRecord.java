package gr.ekt.cerif.xml.records.result;

import java.util.ArrayList;
import java.util.List;

import gr.ekt.cerif.entities.result.ResultProduct;
import gr.ekt.transformationengine.core.Record;


/**
 * @author bonisv
 *
 */
public class CerifResultProductRecord extends Record {
	
	private ResultProduct resultProduct;
	
	/**
	 * @param resultProduct
	 */
	public CerifResultProductRecord(ResultProduct resultProduct) {
		super();
		this.resultProduct = resultProduct;
	}

	/**
	 * @return the resultProduct
	 */
	public ResultProduct getResultProduct() {
		return resultProduct;
	}

	/**
	 * @param resultProduct the resultProduct to set
	 */
	public void setResultProduct(ResultProduct resultProduct) {
		this.resultProduct = resultProduct;
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
