package gr.ekt.cerif.services.multilingual.country;

import gr.ekt.cerif.features.multilingual.CountryName;

import java.util.List;

public class CountryMultilingualTO {

	/**
	 * The country code.
	 */
	private String code;

	/**
	 * The country names.
	 */
	private List<CountryName> names;

	
	/**
	 * @param code
	 * @param names
	 */
	public CountryMultilingualTO(String code, List<CountryName> names) {
		super();
		this.code = code;
		this.names = names;
	}


	/**
	 * @return the code
	 */
	public String getCode() {
		return code;
	}


	/**
	 * @param code the code to set
	 */
	public void setCode(String code) {
		this.code = code;
	}


	/**
	 * @return the names
	 */
	public List<CountryName> getNames() {
		return names;
	}


	/**
	 * @param names the names to set
	 */
	public void setNames(List<CountryName> names) {
		this.names = names;
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "CountryMultilingualTO [code=" + code + ", names=" + names + "]";
	}
	
	
	
}
