package gr.ekt.cerif.xml.records.second;

import java.util.ArrayList;
import java.util.List;

import gr.ekt.cerif.entities.second.FederatedIdentifier;
import gr.ekt.transformationengine.core.Record;

public class CerifFederatedIdentifierRecord extends Record {
	
	private FederatedIdentifier federatedIdentifier;
	
	/**
	 * @param federatedIdentifier
	 */
	public CerifFederatedIdentifierRecord(
			FederatedIdentifier federatedIdentifier) {
		super();
		this.federatedIdentifier = federatedIdentifier;
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
	 * @return the federatedIdentifier
	 */
	public FederatedIdentifier getFederatedIdentifier() {
		return federatedIdentifier;
	}

	/**
	 * @param federatedIdentifier the federatedIdentifier to set
	 */
	public void setFederatedIdentifier(FederatedIdentifier federatedIdentifier) {
		this.federatedIdentifier = federatedIdentifier;
	}

}
