package gr.ekt.cerif.services.multilingual.equipment;

import gr.ekt.cerif.features.multilingual.EquipmentDescription;
import gr.ekt.cerif.features.multilingual.EquipmentKeyword;
import gr.ekt.cerif.features.multilingual.EquipmentName;

import java.util.List;

public class EquipmentMultilingualTO {

	/**
	 * The equipment id.
	 */
	private Long id;

	/**
	 * The equipment names.
	 */
	private List<EquipmentName> names;
	
	/**
	 * The equipment keywords.
	 */
	private List<EquipmentKeyword> keywords;
	
	/**
	 * The equipment descriptions.
	 */
	private List<EquipmentDescription> descriptions;

	/**
	 * @param id
	 * @param names
	 * @param keywords
	 * @param descriptions
	 */
	public EquipmentMultilingualTO(Long id, List<EquipmentName> names,
			List<EquipmentKeyword> keywords,
			List<EquipmentDescription> descriptions) {
		super();
		this.id = id;
		this.names = names;
		this.keywords = keywords;
		this.descriptions = descriptions;
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
	 * @return the names
	 */
	public List<EquipmentName> getNames() {
		return names;
	}

	/**
	 * @param names the names to set
	 */
	public void setNames(List<EquipmentName> names) {
		this.names = names;
	}

	/**
	 * @return the keywords
	 */
	public List<EquipmentKeyword> getKeywords() {
		return keywords;
	}

	/**
	 * @param keywords the keywords to set
	 */
	public void setKeywords(List<EquipmentKeyword> keywords) {
		this.keywords = keywords;
	}

	/**
	 * @return the descriptions
	 */
	public List<EquipmentDescription> getDescriptions() {
		return descriptions;
	}

	/**
	 * @param descriptions the descriptions to set
	 */
	public void setDescriptions(List<EquipmentDescription> descriptions) {
		this.descriptions = descriptions;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "EquipmentMultilingualTO [id=" + id + ", names=" + names
				+ ", keywords=" + keywords + ", descriptions=" + descriptions
				+ "]";
	}
	
	
	
}
