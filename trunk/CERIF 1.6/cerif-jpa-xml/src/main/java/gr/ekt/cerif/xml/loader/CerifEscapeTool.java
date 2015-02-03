package gr.ekt.cerif.xml.loader;

import org.apache.commons.lang3.StringEscapeUtils;
import org.apache.velocity.tools.config.DefaultKey;
import org.apache.velocity.tools.generic.SafeConfig;
import org.apache.velocity.tools.generic.ValueParser;


/**
 * Custom escape tool for CERIF XML production.
 * Delegates to {@link StringEscapeUtils#escapeXml(String)}.
 *
 * @author Nikos Pougounias <pougounias@ekt.gr>
 */
@DefaultKey("cerif")
public final class CerifEscapeTool extends SafeConfig {
	
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
   
}
