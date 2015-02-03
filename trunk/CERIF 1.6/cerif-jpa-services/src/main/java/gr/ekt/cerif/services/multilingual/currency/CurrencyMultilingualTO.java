package gr.ekt.cerif.services.multilingual.currency;

import gr.ekt.cerif.features.multilingual.CurrencyEntityName;
import gr.ekt.cerif.features.multilingual.CurrencyName;

import java.util.List;

public class CurrencyMultilingualTO {

	/**
	 * The currency code.
	 */
	private String code;

	/**
	 * The currency names.
	 */
	private List<CurrencyName> names;
	
	/**
	 * The currency entityNames.
	 */
	private List<CurrencyEntityName> entityNames;

	/**
	 * @param code
	 * @param names
	 * @param entityNames
	 */
	public CurrencyMultilingualTO(String code, List<CurrencyName> names,
			List<CurrencyEntityName> entityNames) {
		super();
		this.code = code;
		this.names = names;
		this.entityNames = entityNames;
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
	public List<CurrencyName> getNames() {
		return names;
	}

	/**
	 * @param names the names to set
	 */
	public void setNames(List<CurrencyName> names) {
		this.names = names;
	}

	/**
	 * @return the entityNames
	 */
	public List<CurrencyEntityName> getEntityNames() {
		return entityNames;
	}

	/**
	 * @param entityNames the entityNames to set
	 */
	public void setEntityNames(List<CurrencyEntityName> entityNames) {
		this.entityNames = entityNames;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "CurrencyMultilingualTO [code=" + code + ", names=" + names
				+ ", entityNames=" + entityNames + "]";
	}
	
	
}
