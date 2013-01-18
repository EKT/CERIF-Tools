/**
 * 
 */
package gr.ekt.cerif.browse;

/**
 *
 */
public enum BrowseType {
	
	COUNTRY,
	
	AUDIENCE,
	
	PUBLISHER,
	
	SOURCE,
	
	CREATOR,
	
	SUBJECT,
	
	ROLE;
	
	public String toString() {
		String result = super.toString();
		if (this.equals(PUBLISHER)) {
			result = "Publisher-URI";
		} else if (this.equals(CREATOR)) {
			result = "Creator-URI";
		} else if (this.equals(SOURCE)) {
			result = "Source-URI";
		}  
		return result;
	};
	
}
