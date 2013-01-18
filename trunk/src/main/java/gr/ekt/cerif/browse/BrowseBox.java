/**
 * 
 */
package gr.ekt.cerif.browse;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class BrowseBox implements Serializable {
	

	/**
	 * Serialization version.
	 */
	private static final long serialVersionUID = 4354128533855685199L;

	/**
	 * The title.
	 */
	private String title;
	
	/**
	 * The type.
	 */
	private BrowseType type;
	
	/**
	 * The lines.
	 */
	private List<BrowseLine> lines;

	/**
	 * Default Constructor
	 */
	public BrowseBox() {
		
	}
	
	/**
	 * 
	 * @param title
	 * @param type
	 * @param lines
	 */
	public BrowseBox(String title, BrowseType type, List<BrowseLine> lines) {
		this.title = title;
		this.type = type;
		this.lines = lines;
	}
	
	/**
	 * Returns the title.
	 * @return the title.
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * Sets the title.
	 * @param title the title.
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * Returns the type.
	 * @return the type.
	 */
	public String getType() {
		return type.toString();
	}

	/**
	 * Sets the type.
	 * @param type the type.
	 */
	public void setType(BrowseType type) {
		this.type = type;
	}

	/**
	 * Returns the lines.
	 * @return the lines.
	 */
	public List<BrowseLine> getLines() {
		return lines;
	}

	/**
	 * Sets the lines.
	 * @param lines the lines.
	 */
	public void setLines(List<BrowseLine> lines) {
		this.lines = lines;
	}
	
	/**
	 * Adds a line.
	 * @param line The line.
	 */
	public void addLine(BrowseLine line) {
		if (lines == null) {
			lines = new ArrayList<BrowseLine>();
		}
		lines.add(line);
	}
	
	/**
	 * Returns whether this box is not empty.
	 * @return whether this box is not empty.
	 */
	public boolean hasValue() {
		return lines != null && lines.size() > 0;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return String.format("BrowseBox [title=%s, type=%s, lines=%s]", title, type, lines);
	}

}
