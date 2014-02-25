package gr.ekt.cerif.xml.records;

import java.util.ArrayList;
import java.util.List;

import gr.ekt.cerif.entities.second.PostalAddress;
import gr.ekt.transformationengine.core.Record;

/**
 * @author bonisv
 *
 */
public class CerifPostalAddressRecord extends Record {

	private PostalAddress postalAddress;
	
	/**
	 * @param postalAddress
	 */
	public CerifPostalAddressRecord(PostalAddress postalAddress) {
		super();
		this.postalAddress = postalAddress;
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
	 * @return the postalAddress
	 */
	public PostalAddress getPostalAddress() {
		return postalAddress;
	}

	/**
	 * @param postalAddress the postalAddress to set
	 */
	public void setPostalAddress(PostalAddress postalAddress) {
		this.postalAddress = postalAddress;
	}

}
