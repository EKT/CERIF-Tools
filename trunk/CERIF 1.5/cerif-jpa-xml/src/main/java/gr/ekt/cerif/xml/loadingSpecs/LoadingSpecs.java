package gr.ekt.cerif.xml.loadingSpecs;

import java.util.ArrayList;
import java.util.List;

import gr.ekt.transformationengine.dataloaders.DataLoadingSpec;

/**
 * @author bonisv
 *
 */
public class LoadingSpecs extends DataLoadingSpec {
	
	private List<String> listOfEntitiesExported = new ArrayList<String>();
	private Integer windowSize = 0;
	private Integer windowOffset = 0;
	private boolean links = true;
	private boolean showFedIds = false;

	@Override
	public DataLoadingSpec generateNextLoadingSpec() {
		return this;
	}

	/**
	 * @return the listOfEntitiesExported
	 */
	public List<String> getListOfEntitiesExported() {
		return listOfEntitiesExported;
	}

	/**
	 * @param listOfEntitiesExported the listOfEntitiesExported to set
	 */
	public void setListOfEntitiesExported(List<String> listOfEntitiesExported) {
		this.listOfEntitiesExported = listOfEntitiesExported;
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

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "LoadingSpecs [listOfEntitiesExported=" + listOfEntitiesExported
				+ ", windowSize=" + windowSize + ", windowOffset="
				+ windowOffset + ", links=" + links + ", showFedIds="
				+ showFedIds + "]";
	}

	
}
