package gr.ekt.cerif.xml.loader;

import gr.ekt.cerif.features.multilingual.Translation;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang3.StringEscapeUtils;
import org.apache.velocity.tools.config.DefaultKey;
import org.apache.velocity.tools.generic.SafeConfig;
import org.apache.velocity.tools.generic.ValueParser;
import org.springframework.util.StringUtils;


/**
 * Custom escape tool for CERIF XML production.
 * Delegates to {@link StringEscapeUtils#escapeXml(String)}.
 *
 * @author Nikos Pougounias <pougounias@ekt.gr>
 */
@DefaultKey("cerif")
public final class CerifEscapeTool extends SafeConfig {
	
	private static final String DEFAULT_DATE_FORMAT = "yyyy-MM-dd";
	
	private static final String DEFAULT_TIME_FORMAT = "HH:mm:ss";

	/**
	 * Default key.
	 */
    public static final String DEFAULT_KEY = "cerif";
    
    /**
     * The key.
     */
    private String key = DEFAULT_KEY;

    /**
     * Does the actual configuration. This is protected, so
     * subclasses may share the same ValueParser and call configure
     * at any time, while preventing templates from doing so when 
     * configure(Map) is locked.
     */
    protected void configure(ValueParser values)  {
        String altkey = values.getString("key");
        if (altkey != null) {
            setKey(altkey);
        }
    }

    /**
     * Sets the key under which this tool has been configured.
     */
    protected void setKey(String key) {
        if (key == null) {
            throw new NullPointerException("Key cannot be null");
        }
        this.key = key;
    }

    /**
     * Returns the key under which this tool has been configured.
     */
    public String getKey() {
        return this.key;
    }

    /**
     * Escapes the characters in a <code>String</code> using XML entities.
     * <br />
     * Delegates the process to {@link StringEscapeUtils#escapeXml(String)}.
     *
     * @param string the string to escape, may be null
     * @return a new escaped <code>String</code>, <code>null</code> if null string input
     *
     * @see StringEscapeUtils#escapeXml(String)
     */
    public String xml(Object string) {
        if (string == null) {
            return null;
        }
        return StringEscapeUtils.escapeXml(String.valueOf(string));
    }
    
    public String build(String label, Object value) {
    	return build(label, value, 1);
    }
    
    public String build(String label, Date date) {
    	return build(label, new SimpleDateFormat(DEFAULT_DATE_FORMAT).format(date), 1);
    }
    
    public String multi(String label, String code, Translation translation, String value) {
    	return String.format("<%s cfLangCode='%s' cfTrans='%s'>%s</%s>", label, code, translation, xml(value), label);
    }
    
    public String build(String label, Object value, int tabs) {
    	StringBuilder result = new StringBuilder();
		if (value != null && StringUtils.hasText(value.toString())) {
			tab(result, tabs);
			element(result, label, value.toString(), false);
		}
    	return result.toString();
    }
    
    /**
     * Basic link #1.
     * @param label The label.
     * @param classUuid The classification UUID.
     * @param schemeUuid The scheme UUID.
     * @param startDate The start date.
     * @param endDate The end date.
     * @param fraction The fraction.
     * @return an XML element.
     */
    public String link(String label, String classUuid, String schemeUuid, Date startDate, Date endDate, Double fraction) {
    	return link(label, null, null, classUuid, schemeUuid, startDate, endDate, fraction, null, null, null, null, null, null);
    }
    
    /**
     * Basic link  #2.
     * @param label The label.
     * @param firstElementLabel Label for the first element.
     * @param firstElementValue The identifier.
     * @param classUuid The classification UUID.
     * @param schemeUuid The scheme UUID.
     * @param startDate The start date.
     * @param endDate The end date.
     * @param fraction The fraction.
     * @return an XML element.
     */
    public String link(String label, String firstElementLabel, Long firstElementValue, String classUuid, String schemeUuid, Date startDate, Date endDate, Double fraction) {
    	return link(label, firstElementLabel, firstElementValue, classUuid, schemeUuid, startDate, endDate, fraction, null, null, null, null, null, null);
    }
    
    /**
     * Link with copyright.
     * @param label The label.
     * @param firstElementLabel Label for the first element.
     * @param firstElementValue The identifier.
     * @param classUuid The classification UUID.
     * @param schemeUuid The scheme UUID.
     * @param startDate The start date.
     * @param endDate The end date.
     * @param fraction The fraction.
     * @param copyright The copyright
     * @return an XML element.
     */
    public String link(String label, String firstElementLabel, Long firstElementValue, String classUuid, String schemeUuid, Date startDate, Date endDate, Double fraction, String copyright) {
    	return link(label, firstElementLabel, firstElementValue, classUuid, schemeUuid, startDate, endDate, fraction, null, null, null, null, null, copyright);
    }
    
    /**
     * Link with amount.
     * @param label
     * @param firstElementLabel Label for the first element.
     * @param firstElementValue The identifier.
     * @param classUuid The classification UUID.
     * @param schemeUuid The scheme UUID.
     * @param startDate The start date.
     * @param endDate The end date.
     * @param fraction The fraction.
     * @param amount The amount.
     * @param currencyCode The currency code.
     * @return an XML element.
     */
    public String link(String label, String firstElementLabel, Long firstElementValue, String classUuid, String schemeUuid, Date startDate, Date endDate, Double fraction, Double amount, String currencyCode) {
    	return link(label, firstElementLabel, firstElementValue, classUuid, schemeUuid, startDate, endDate, fraction, null, null, null, amount, currencyCode, null);
    }
    
    /**
     * Link with availability, conditions and price.
     * @param label
     * @param firstElementLabel Label for the first element.
     * @param firstElementValue The identifier.
     * @param classUuid The classification UUID.
     * @param schemeUuid The scheme UUID.
     * @param startDate The start date.
     * @param endDate The end date.
     * @param fraction The fraction.
     * @param availability The availability.
     * @param conditions The conditions.
     * @param price The price.
     * @param currencyCode The currency code.
     * @return an XML element.
     */
    public String link(String label, String firstElementLabel, Long firstElementValue, String classUuid, String schemeUuid, Date startDate, Date endDate, Double fraction, String availability, String conditions, Double price, String currencyCode) {
    	return link(label, firstElementLabel, firstElementValue, classUuid, schemeUuid, startDate, endDate, fraction, availability, conditions, price, null, currencyCode, null);
    }
    
    
    
    public String link(String label, String firstElementLabel, Long firstElementValue, String classUuid, String schemeUuid, Date startDate, Date endDate, Double fraction, String availability, String conditions, Double price, Double amount, String currencyCode, String copyright) {
    	StringBuilder result = new StringBuilder();
    	result.append(String.format("<%s>%n", label));
    	if (firstElementValue != null) {
    		tab(result, 2);
    		element(result, firstElementLabel, String.valueOf(firstElementValue));
    	}
    	if (StringUtils.hasText(classUuid)) {
    		tab(result, 2);
    		element(result, "cfClassId", classUuid);
    	}
    	if (StringUtils.hasText(schemeUuid)) {
    		tab(result, 2);
    		element(result, "cfClassSchemeId", schemeUuid);
    	}
    	if (startDate != null) {
    		tab(result, 2);
    		element(result, "cfStartDate", String.format("%sT%s", new SimpleDateFormat(DEFAULT_DATE_FORMAT).format(startDate), new SimpleDateFormat(DEFAULT_TIME_FORMAT).format(startDate)));
    	}
    	if (endDate != null) {
    		tab(result, 2);
    		element(result, "cfEndDate", String.format("%sT%s", new SimpleDateFormat(DEFAULT_DATE_FORMAT).format(endDate), new SimpleDateFormat(DEFAULT_TIME_FORMAT).format(endDate)));
    	}
    	if (fraction != null) {
    		tab(result, 2);
    		element(result, "cfFraction", String.valueOf(fraction));
    	}
    	if (StringUtils.hasText(availability)) {
    		tab(result, 2);
    		element(result, "cfAvailability", availability);
    	}
    	if (StringUtils.hasText(conditions)) {
    		tab(result, 2);
    		element(result, "cfConditions", conditions);
    	}
    	if (price != null) {
    		tab(result, 2);
    		String code = currencyCode;
    		if (!StringUtils.hasText(code)) {
    			code = "default";
    		}
    		result.append(String.format("<cfPrice cfCurrCode='%s'>%s</cfPrice>%n", code, String.valueOf(price)));
    	}
    	if (amount != null) {
    		tab(result, 2);
    		String code = currencyCode;
    		if (!StringUtils.hasText(code)) {
    			code = "default";
    		}
    		result.append(String.format("<cfAmount cfCurrCode='%s'>%s</cfAmount>%n", code, String.valueOf(amount)));
    	}
    	if (StringUtils.hasText(copyright)) {
    		tab(result, 2);
    		element(result, "cfCopyright", xml(copyright));
    	}
    	tab(result, 1);
    	result.append(String.format("</%s>", label));
    	return result.toString();
    }
    
    public String fed(Long id, String federatedId, String classUuid, String schemeUuid, Date startDate, Date endDate) {
    	StringBuilder result = new StringBuilder();
    	if (id != null) {
    		tab(result, 2);
    		element(result, "cfFedIdId", String.valueOf(id));
    	}
    	if (StringUtils.hasText(federatedId)) {
    		tab(result, 2);
    		element(result, "cfFedId", federatedId);
    	}
    	if (StringUtils.hasText(classUuid)) {
    		tab(result, 2);
    		element(result, "cfClassId", classUuid);
    	}
    	if (StringUtils.hasText(schemeUuid)) {
    		tab(result, 2);
    		element(result, "cfClassSchemeId", schemeUuid);
    	}
    	if (startDate != null) {
    		tab(result, 2);
    		element(result, "cfStartDate", String.format("%sT%s", new SimpleDateFormat(DEFAULT_DATE_FORMAT).format(startDate), new SimpleDateFormat(DEFAULT_TIME_FORMAT).format(startDate)));
    	}
    	if (endDate != null) {
    		tab(result, 2);
    		element(result, "cfEndDate", String.format("%sT%s", new SimpleDateFormat(DEFAULT_DATE_FORMAT).format(endDate), new SimpleDateFormat(DEFAULT_TIME_FORMAT).format(endDate)));
    	}
    	return result.toString();
    }
    
    private void element(StringBuilder result, String label, String value) {
    	element(result, label, value, true);
    }
    
    private void element(StringBuilder result, String label, String value, boolean newLine) {
    	result.append(String.format("<%s>%s</%s>", label, value, label));
    	if (newLine) {
    		result.append(String.format("%n"));
    	}
    }
    
    private void tab(StringBuilder result, int number) {
    	for (int index = 0; index < number; index++) {
			result.append('\t');
		}
    }
    
}
