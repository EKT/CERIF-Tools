package gr.ekt.cerif.services.multilingual.theclass;

import gr.ekt.cerif.features.multilingual.ClassDefinition;
import gr.ekt.cerif.features.multilingual.ClassDescription;
import gr.ekt.cerif.features.multilingual.ClassEx;
import gr.ekt.cerif.features.multilingual.ClassTerm;

import java.util.List;

public class ClassMultilingualTO {

	/**
	 * The classification unique identifier.
	 */
	private Long id;
	
	/**
	 * The classification descriptions.
	 */
	private List<ClassDescription> descriptions;
	
	/**
	 * The classification terms.
	 */
	private List<ClassTerm> terms;
	
	/**
	 * The classification exs.
	 */
	private List<ClassEx> exs;
	
	/**
	 * The classification definitions.
	 */
	private List<ClassDefinition> definitions;

	/**
	 * @param id
	 * @param descriptions
	 * @param terms
	 * @param exs
	 * @param definitions
	 */
	public ClassMultilingualTO(Long id, List<ClassDescription> descriptions,
			List<ClassTerm> terms, List<ClassEx> exs,
			List<ClassDefinition> definitions) {
		super();
		this.id = id;
		this.descriptions = descriptions;
		this.terms = terms;
		this.exs = exs;
		this.definitions = definitions;
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
	public List<ClassDescription> getDescriptions() {
		return descriptions;
	}

	/**
	 * @param descriptions the descriptions to set
	 */
	public void setDescriptions(List<ClassDescription> descriptions) {
		this.descriptions = descriptions;
	}

	/**
	 * @return the terms
	 */
	public List<ClassTerm> getTerms() {
		return terms;
	}

	/**
	 * @param terms the terms to set
	 */
	public void setTerms(List<ClassTerm> terms) {
		this.terms = terms;
	}

	/**
	 * @return the exs
	 */
	public List<ClassEx> getExs() {
		return exs;
	}

	/**
	 * @param exs the exs to set
	 */
	public void setExs(List<ClassEx> exs) {
		this.exs = exs;
	}

	/**
	 * @return the definitions
	 */
	public List<ClassDefinition> getDefinitions() {
		return definitions;
	}

	/**
	 * @param definitions the definitions to set
	 */
	public void setDefinitions(List<ClassDefinition> definitions) {
		this.definitions = definitions;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ClassMultilingualTO [id=" + id + ", descriptions="
				+ descriptions + ", terms=" + terms + ", exs=" + exs
				+ ", definitions=" + definitions + "]";
	}
	
	

}
