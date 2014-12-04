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
	 * Window size.
	 */
	private Integer windowSize = 0;
	
	/**
	 * Window offset.
	 */
	private Integer windowOffset = 0;
	
	/**
	 * Whether to include linked information.
	 */
	private boolean links = true;
	
	/**
	 * Whether to include federated identifiers.
	 */
	private boolean showFedIds = false;
	
	/**
	 * Debug.
	 */
	private boolean debug;
	
	/**
	 * Identifier of a single object.
	 */
	private Object id;
	
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
	 * @return the debug
	 */
	public boolean isDebug() {
		return debug;
	}

	/**
	 * @param debug the debug to set
	 */
	public void setDebug(boolean debug) {
		this.debug = debug;
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
	public boolean isLinks() {
		return links;
	}

	/**
	 * @return the showFedIds
	 */
	public boolean isShowFedIds() {
		return showFedIds;
	}

	/**
	 * @param showFedIds the showFedIds to set
	 */
	public void setShowFedIds(boolean showFedIds) {
		this.showFedIds = showFedIds;
	}

	/**
	 * @param links the links to set
	 */
	public void setLinks(boolean links) {
		this.links = links;
	}
	
	public boolean isSingleEntity() {
		return id != null;
	}
	
	public boolean isFindById() {
		return isSingleEntity() && org.apache.commons.lang.math.NumberUtils.isDigits(id.toString());
	}
	
	public boolean isFindByUUID() {
		return isSingleEntity() && !isFindById();
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "SelectionOptions [listOfEntitiesIncluded="
				+ listOfEntitiesIncluded + ", listOfEntitiesExcluded="
				+ listOfEntitiesExcluded + ", entities=" + entities
				+ ", embeddedEntities=" + embeddedEntities + ", windowSize="
				+ windowSize + ", windowOffset=" + windowOffset + ", links="
				+ links + ", showFedIds=" + showFedIds + ", debug=" + debug
				+ ", id=" + id + "]";
	}

	
}
