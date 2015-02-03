package gr.ekt.cerif.services.multilingual.event;

import gr.ekt.cerif.features.multilingual.EventDescription;
import gr.ekt.cerif.features.multilingual.EventKeyword;
import gr.ekt.cerif.features.multilingual.EventName;

import java.util.Set;

public class EventMultilingualTO {

	/**
	 * The event unique identifier.
	 */
	private Long id;

	/**
	 * The event unique names.
	 */
	private Set<EventName> names;
	
	/**
	 * The event unique keywords.
	 */
	private Set<EventKeyword> keywords;
	
	/**
	 * The event unique descriptions.
	 */
	private Set<EventDescription> descriptions;

	/**
	 * @param id
	 * @param names
	 * @param keywords
	 * @param descriptions
	 */
	public EventMultilingualTO(Long id, Set<EventName> names,
			Set<EventKeyword> keywords, Set<EventDescription> descriptions) {
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
	public Set<EventName> getNames() {
		return names;
	}

	/**
	 * @param names the names to set
	 */
	public void setNames(Set<EventName> names) {
		this.names = names;
	}

	/**
	 * @return the keywords
	 */
	public Set<EventKeyword> getKeywords() {
		return keywords;
	}

	/**
	 * @param keywords the keywords to set
	 */
	public void setKeywords(Set<EventKeyword> keywords) {
		this.keywords = keywords;
	}

	/**
	 * @return the descriptions
	 */
	public Set<EventDescription> getDescriptions() {
		return descriptions;
	}

	/**
	 * @param descriptions the descriptions to set
	 */
	public void setDescriptions(Set<EventDescription> descriptions) {
		this.descriptions = descriptions;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "EventMultilingualTO [id=" + id + ", names=" + names
				+ ", keywords=" + keywords + ", descriptions=" + descriptions
				+ "]";
	}

	
}
