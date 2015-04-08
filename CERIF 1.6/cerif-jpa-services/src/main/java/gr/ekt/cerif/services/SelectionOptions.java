package gr.ekt.cerif.services;

import gr.ekt.cerif.enumerations.semantics.ClassEnum;

import java.util.ArrayList;
import java.util.List;

/**
 * Selection options.
 */
public class SelectionOptions {

	/**
	 * Entities to be included.
	 */
	private List<String> listOfEntitiesIncluded = new ArrayList<String>();
	
	/**
	 * Entities to excluded.
	 */
	private List<String> listOfEntitiesExcluded = new ArrayList<String>();
	
	/**
	 * Entities.
	 */
	private List<ClassEnum> entities = new ArrayList<ClassEnum>();
	
	/**
	 * Embedded entities.
	 */
	private List<ClassEnum> embeddedEntities = new ArrayList<ClassEnum>();
	
	/**
	 * Link entities.
	 */
	private List<ClassEnum> linkEntities = new ArrayList<ClassEnum>();
	
	/**
	 * Window size.
	 */
	private Integer windowSize = 0;
	
	/**
	 * Window offset.
	 */
	private Integer windowOffset = 0;
	
	/**
	 * Whether to include linked fields.
	 */
	private boolean linksIncluded = false;
	
	/**
	 * Whether to include federated identifiers.
	 */
	private boolean federatedIncluded = false;
	
	/**
	 * Whether to include multilingual fields
	 */
	private boolean multilingualIncluded = true;
	
	/**
	 * Identifier of a single object.
	 */
	private Object id;
	
	/**
	 * How to select identifiers.
	 */
	private SelectionIdentifiersType identifiersMode = SelectionIdentifiersType.IDS_ONLY;
	
	/**
	 * @return the entities
	 */
	public List<ClassEnum> getEntities() {
		return entities;
	}

	/**
	 * @param entities the entities to set
	 */
	public void setEntities(List<ClassEnum> entities) {
		this.entities = entities;
	}

	/**
	 * @return the embeddedEntities
	 */
	public List<ClassEnum> getEmbeddedEntities() {
		return embeddedEntities;
	}

	/**
	 * @param embeddedEntities the embeddedEntities to set
	 */
	public void setEmbeddedEntities(List<ClassEnum> embeddedEntities) {
		this.embeddedEntities = embeddedEntities;
	}

	/**
	 * @return the id
	 */
	public Object getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Object id) {
		this.id = id;
	}

	/**
	 * @return the listOfEntitiesIncluded
	 */
	public List<String> getListOfEntitiesIncluded() {
		return listOfEntitiesIncluded;
	}

	/**
	 * @param listOfEntitiesIncluded the listOfEntitiesIncluded to set
	 */
	public void setListOfEntitiesIncluded(List<String> listOfEntitiesIncluded) {
		this.listOfEntitiesIncluded = listOfEntitiesIncluded;
	}

	/**
	 * @return the listOfEntitiesExcluded
	 */
	public List<String> getListOfEntitiesExcluded() {
		return listOfEntitiesExcluded;
	}

	/**
	 * @param listOfEntitiesExcluded the listOfEntitiesExcluded to set
	 */
	public void setListOfEntitiesExcluded(List<String> listOfEntitiesExcluded) {
		this.listOfEntitiesExcluded = listOfEntitiesExcluded;
	}

	/**
	 * @return the windowOffset
	 */
	public Integer getWindowOffset() {
		return windowOffset;
	}

	/**
	 * @param windowOffset the windowOffset to set
	 */
	public void setWindowOffset(Integer windowOffset) {
		this.windowOffset = windowOffset;
	}

	/**
	 * @return the windowSize
	 */
	public Integer getWindowSize() {
		return windowSize;
	}

	/**
	 * @param windowSize the windowSize to set
	 */
	public void setWindowSize(Integer windowSize) {
		this.windowSize = windowSize;
	}

	/**
	 * @return the links
	 */
	public boolean isLinksIncluded() {
		return linksIncluded;
	}

	/**
	 * @return the showFedIds
	 */
	public boolean isFederatedIncluded() {
		return federatedIncluded;
	}

	/**
	 * @param showFedIds the showFedIds to set
	 */
	public void setFederatedIncluded(boolean showFedIds) {
		this.federatedIncluded = showFedIds;
	}
	
	/**
	 * Returns whether multilingual fields are included.
	 * @return false/true
	 */
	public boolean isMultilingualIncluded() {
		return multilingualIncluded;
	}
	
	/**
	 * Sets whether to include multilingual fields.
	 * @param includeMultiLingualFields false/true
	 */
	public void setMultilingualIncluded(boolean includeMultiLingualFields) {
		this.multilingualIncluded = includeMultiLingualFields;
	}

	/**
	 * @param links the links to set
	 */
	public void setLinksIncluded(boolean links) {
		this.linksIncluded = links;
	}
	
	public boolean isSingleEntity() {
		return id != null;
	}
	
	public boolean isFindById() {
		return isSingleEntity() && Utilities.isValidIdentifier(id.toString());
	}
	
	public boolean isFindByUUID() {
		return isSingleEntity() && Utilities.isValidUUID(id.toString());
	}
	
	public boolean isFindByCode() {
		return isSingleEntity() && !isFindById() && !isFindByUUID();
	}
	
	public List<ClassEnum> getLinkEntities() {
		return linkEntities;
	}
	
	public void setLinkEntities(List<ClassEnum> parallelLinkEntities) {
		this.linkEntities = parallelLinkEntities;
	}
	
	public SelectionIdentifiersType getIdentifiersMode() {
		return identifiersMode;
	}
	
	public void setIdentifiersMode(SelectionIdentifiersType selectionIdentifiersType) {
		this.identifiersMode = selectionIdentifiersType;
	}



	
}
