/**
 * 
 */
package gr.ekt.cerif.browse;

/**
 *
 */
public class BrowseLine extends BrowseBox {
	
	/**
	 * Serialization version.
	 */
	private static final long serialVersionUID = -6705879878328783637L;

	/**
	 * The label.
	 */
	private String label;
	
	/**
	 * The size.
	 */
	private Long size;

	/**
	 * The URI.
	 */
	private String uri;
	
	/**
	 * Default Constructor
	 */
	public BrowseLine() {
		
	}
	
	/**
	 * 
	 * @param label
	 * @param size
	 * @param uri
	 */
	public BrowseLine(String label, Long size, String uri) {
		this.label = label;
		this.size = size;
		this.uri = uri;
	}

	/**
	 * Returns the label.
	 * @return the label.
	 */
	public String getLabel() {
		return label;
	}

	/**
	 * Sets the label.
	 * @param label the label.
	 */
	public void setLabel(String label) {
		this.label = label;
	}

	/**
	 * Returns the size.
	 * @return the size.
	 */
	public Long getSize() {
		return size;
	}

	/**
	 * Sets the size.
	 * @param size the size.
	 */
	public void setSize(Long size) {
		this.size = size;
	}

	/**
	 * Returns the uri.
	 * @return the uri.
	 */
	public String getUri() {
		return uri;
	}
	
	/**
	 * Sets the uri.
	 * @param uri the uri.
	 */
	public void setUri(String uri) {
		this.uri = uri;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return String.format("BrowseLine [label=%s, size=%s, uri=%s]", label,
				size, uri);
	}
	
}
