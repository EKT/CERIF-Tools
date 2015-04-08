package gr.ekt.cerif.services;

import gr.ekt.cerif.CerifEntity;

import java.util.ArrayList;
import java.util.List;

/**
 * Selection result.
 *
 * @author Nikos Pougounias <pougounias@ekt.gr>
 */
public class SelectionResult {
	
	/**
	 * The CERIF entities.
	 */
	private List<CerifEntity> entities;
	
	/**
	 * The identifiers.
	 */
	private List<Object> identifiers;
	
	private List<String> uuids;
	
	/**
	 * Offset index.
	 */
	private Integer offset;
	
	/**
	 * Size of current page.
	 */
	private Integer pageSize;
	
	/**
	 * Number of elements in current result.
	 */
	private Integer numberOfElements;
	
	/**
	 * Total number of elements.
	 */
	private Long totalNumberOfElements;

	/**
	 * Returns the CERIF entities.
	 * @return some entities.
	 */
	public List<CerifEntity> getEntities() {
		return entities;
	}

	/**
	 * Sets the CERIF entities.
	 * @param entities the entities.
	 */
	public void setEntities(List<CerifEntity> entities) {
		this.entities = entities;
	}

	/**
	 * Returns the offset.
	 * @return the offset.
	 */
	public Integer getOffset() {
		return offset;
	}

	/**
	 * Sets the offset.
	 * @param offset the offset.
	 */
	public void setOffset(Integer offset) {
		this.offset = offset;
	}

	/**
	 * Returns the size of current page.
	 * @return a number.
	 */
	public Integer getPageSize() {
		return pageSize;
	}

	/**
	 * Sets the size of current page.
	 * @param pageSize the page size.
	 */
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	/**
	 * Returns the number of elements in current result.
	 * @return a number.
	 */
	public Integer getNumberOfElements() {
		return numberOfElements;
	}

	/**
	 * Sets the number of elements in current result.
	 * @param numberOfElements the number of elements.
	 */
	public void setNumberOfElements(Integer numberOfElements) {
		this.numberOfElements = numberOfElements;
	}

	/**
	 * Returns the total number of elements.
	 * @return a number.
	 */
	public Long getTotalNumberOfElements() {
		return totalNumberOfElements;
	}

	/**
	 * Sets the the total number of elements.
	 * @param totalNumberOfElements the total number of elements.
	 */
	public void setTotalNumberOfElements(Long totalNumberOfElements) {
		this.totalNumberOfElements = totalNumberOfElements;
	}
	
	public List<Object> getIdentifiers() {
		return identifiers;
	}
	
	public void setIdentifiers(List<Object> identifiers) {
		this.identifiers = identifiers;
	}
	
	public List<String> getUuids() {
		return uuids;
	}
	
	public void setUuids(List<String> uuids) {
		this.uuids = uuids;
	}
	
	public void addIdentifier(Object identifier) {
		if (identifiers == null) {
			identifiers = new ArrayList<Object>();
		}
		identifiers.add(identifier);
	}
	
	public void addUUID(String uuid) {
		if (uuids == null) {
			uuids = new ArrayList<String>();
		}
		uuids.add(uuid);
	}
	
}
