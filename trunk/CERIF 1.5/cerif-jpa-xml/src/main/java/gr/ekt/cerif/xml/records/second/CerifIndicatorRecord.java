package gr.ekt.cerif.xml.records.second;

import java.util.ArrayList;
import java.util.List;

import gr.ekt.cerif.entities.second.Indicator;
import gr.ekt.transformationengine.core.Record;

public class CerifIndicatorRecord  extends Record {
	
	private Indicator indicator;
		
	/**
	 * @param indicator
	 */
	public CerifIndicatorRecord(Indicator indicator) {
		super();
		this.indicator = indicator;
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
	 * @return the indicator
	 */
	public Indicator getIndicator() {
		return indicator;
	}

	/**
	 * @param indicator the indicator to set
	 */
	public void setIndicator(Indicator indicator) {
		this.indicator = indicator;
	}
	

}
