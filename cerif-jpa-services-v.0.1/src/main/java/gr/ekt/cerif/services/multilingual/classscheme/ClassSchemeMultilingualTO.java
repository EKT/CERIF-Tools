package gr.ekt.cerif.services.multilingual.classscheme;

import gr.ekt.cerif.features.multilingual.ClassSchemeDescription;
import gr.ekt.cerif.features.multilingual.ClassSchemeName;

import java.util.List;


public class ClassSchemeMultilingualTO {

	/**
	 * The classification scheme unique identifier.
	 */
	private Long id;
	
	/**
	 * The classification scheme descriptions.
	 */
	private List<ClassSchemeDescription> descriptions;
	
	/**
	 * The classification scheme names.
	 */
	private List<ClassSchemeName> names;

	
	public ClassSchemeMultilingualTO(Long id,
			List<ClassSchemeDescription> descriptions,
			List<ClassSchemeName> names) {
		super();
		this.id = id;
		this.descriptions = descriptions;
		this.names = names;
	}


	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}


	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}


	/**
	 * @return the descriptions
	 */
	public List<ClassSchemeDescription> getDescriptions() {
		return descriptions;
	}


	/**
	 * @param descriptions the descriptions to set
	 */
	public void setDescriptions(List<ClassSchemeDescription> descriptions) {
		this.descriptions = descriptions;
	}


	/**
	 * @return the names
	 */
	public List<ClassSchemeName> getNames() {
		return names;
	}


	/**
	 * @param names the names to set
	 */
	public void setNames(List<ClassSchemeName> names) {
		this.names = names;
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ClassSchemeMultilingualTO [id=" + id + ", descriptions="
				+ descriptions + ", names=" + names + "]";
	}
	
	
	
}
