package gr.ekt.cerif.services.multilingual.expertiseandskills;

import gr.ekt.cerif.features.multilingual.ExpertiseAndSkillsDescription;
import gr.ekt.cerif.features.multilingual.ExpertiseAndSkillsKeyword;
import gr.ekt.cerif.features.multilingual.ExpertiseAndSkillsName;

import java.util.List;

public class ExpertiseAndSkillsMultilingualTO {

	/**
	 * The expertise and skill id.
	 */
	private Long id;

	/**
	 * The expertise and skill names.
	 */
	private List<ExpertiseAndSkillsName> names;
	
	/**
	 * The expertise and skill keywords.
	 */
	private List<ExpertiseAndSkillsKeyword> keywords;
	
	/**
	 * The expertise and skill descriptions.
	 */
	private List<ExpertiseAndSkillsDescription> descriptions;

	/**
	 * @param id
	 * @param names
	 * @param keywords
	 * @param descriptions
	 */
	public ExpertiseAndSkillsMultilingualTO(Long id,
			List<ExpertiseAndSkillsName> names,
			List<ExpertiseAndSkillsKeyword> keywords,
			List<ExpertiseAndSkillsDescription> descriptions) {
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
	public List<ExpertiseAndSkillsName> getNames() {
		return names;
	}

	/**
	 * @param names the names to set
	 */
	public void setNames(List<ExpertiseAndSkillsName> names) {
		this.names = names;
	}

	/**
	 * @return the keywords
	 */
	public List<ExpertiseAndSkillsKeyword> getKeywords() {
		return keywords;
	}

	/**
	 * @param keywords the keywords to set
	 */
	public void setKeywords(List<ExpertiseAndSkillsKeyword> keywords) {
		this.keywords = keywords;
	}

	/**
	 * @return the descriptions
	 */
	public List<ExpertiseAndSkillsDescription> getDescriptions() {
		return descriptions;
	}

	/**
	 * @param descriptions the descriptions to set
	 */
	public void setDescriptions(List<ExpertiseAndSkillsDescription> descriptions) {
		this.descriptions = descriptions;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ExpertiseAndSkillsMultilingualTO [id=" + id + ", names="
				+ names + ", keywords=" + keywords + ", descriptions="
				+ descriptions + "]";
	}
	
	
}
