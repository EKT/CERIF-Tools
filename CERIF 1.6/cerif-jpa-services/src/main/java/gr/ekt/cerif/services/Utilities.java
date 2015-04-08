package gr.ekt.cerif.services;

import gr.ekt.cerif.CerifEntity;
import gr.ekt.cerif.entities.second.Country;
import gr.ekt.cerif.entities.second.Currency;
import gr.ekt.cerif.entities.second.Language;

import java.util.UUID;

import org.apache.commons.lang.StringUtils;

/**
 * Some utilities.
 * 
 * @author pougounias
 */
public final class Utilities {
	
	/**
	 * Constructor.
	 */
	private Utilities() {
		// nothing to implement here
	}
	
	/**
	 * Checks whether the input is a valid UUID.
	 * @param input The input.
	 * @return false/true
	 */
	public static boolean isValidUUID(String input) {
		boolean result = true;
		try {
			UUID.fromString(input).toString().equals(input);
		} catch (Exception e) {
			result = false;
		}
		return result;
	}
	
	public static boolean isValidIdentifier(String input) {
		return org.apache.commons.lang.math.NumberUtils.isDigits(input);
	}
	
	public static boolean isValidCode(String input) {
		return StringUtils.isAlpha(input);
	}
	
	public static <T> boolean entityHasCodePrimaryKey(java.lang.Class<T> entityClass) {
		return entityClass.equals(Language.class) || entityClass.equals(Currency.class) || entityClass.equals(Country.class);
	}

	public static <T> String getPrimaryKeyReadMethodName(java.lang.Class<T> entityClass) {
		String result = "getId";
		if (entityHasCodePrimaryKey(entityClass)) {
			result = "getCode";
		}
		return result;
	}
	
	public static <T> String getPrimaryKeyFieldName(java.lang.Class<T> entityClass) {
		String result = "id";
		if (entityHasCodePrimaryKey(entityClass)) {
			result = "code";
		}
		return result;
	}
	
}
