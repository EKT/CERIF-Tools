package gr.ekt.cerif.xml.records.second;

import gr.ekt.cerif.entities.second.GeographicBoundingBox;
import gr.ekt.transformationengine.core.Record;

import java.util.ArrayList;
import java.util.List;

/**
 * Record for a geographic bounding box.
 *
 * @author Nikos Pougounias <pougounias@ekt.gr>
 */
public class CerifGeographicBoundingBoxRecord extends Record {
	
	/**
	 * The geographic bounding box.
	 */
	private GeographicBoundingBox geographicBoundingBox;
	
	/**
	 * Constructor.
	 * @param geographicBoundingBox The geographic bounding box.
	 */
	public CerifGeographicBoundingBoxRecord(GeographicBoundingBox geographicBoundingBox) {
		super();
		this.geographicBoundingBox = geographicBoundingBox;
	}
	
	/**
	 * Returns the geographic bounding box.
	 * @return the geographic bounding box.
	 */
	public GeographicBoundingBox getGeographicBoundingBox() {
		return geographicBoundingBox;
	}

	/**
	 * Sets the geographic bounding box.
	 * @param geographicBoundingBox the geographic bounding box.
	 */
	public void setGeographicBoundingBox(GeographicBoundingBox geographicBoundingBox) {
		this.geographicBoundingBox = geographicBoundingBox;
	}

	/*
	 * (non-Javadoc)
	 * @see gr.ekt.transformationengine.core.Record#getByName(java.lang.String)
	 */
	@Override
	public List<Object> getByName(String fieldName) {
		return null;
	}

	/*
	 * (non-Javadoc)
	 * @see gr.ekt.transformationengine.core.Record#printByName(java.lang.String)
	 */
	@Override
	public void printByName(String fieldName) {
		// nothing to implement here.
	}

	/*
	 * (non-Javadoc)
	 * @see gr.ekt.transformationengine.core.Record#removeField(java.lang.String)
	 */
	@Override
	public void removeField(String fieldName) {
		// nothing to implement here.
		
	}

	/*
	 * (non-Javadoc)
	 * @see gr.ekt.transformationengine.core.Record#removeValueFromField(java.lang.String, java.lang.Object)
	 */
	@Override
	public void removeValueFromField(String fieldName, Object value) {
		// nothing to implement here.
	}

	/*
	 * (non-Javadoc)
	 * @see gr.ekt.transformationengine.core.Record#addField(java.lang.String, java.util.ArrayList)
	 */
	@Override
	public void addField(String fieldName, ArrayList<Object> fieldValues) {
		// nothing to implement here.
	}

	/*
	 * (non-Javadoc)
	 * @see gr.ekt.transformationengine.core.Record#addValueToField(java.lang.String, java.lang.Object)
	 */
	@Override
	public void addValueToField(String fieldName, Object fieldValue) {
		// nothing to implement here.
	}

}
