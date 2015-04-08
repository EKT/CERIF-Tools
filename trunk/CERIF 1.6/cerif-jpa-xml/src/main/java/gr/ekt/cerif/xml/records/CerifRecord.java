package gr.ekt.cerif.xml.records;

import gr.ekt.cerif.CerifEntity;
import gr.ekt.transformationengine.core.Record;

import java.util.ArrayList;
import java.util.List;

/**
 * Record for CERIF entities.
 *
 * @author Nikos Pougounias <pougounias@ekt.gr>
 */
public class CerifRecord<T extends CerifEntity> extends Record {

	/**
	 * The CERIF entity.
	 */
	private T entity;
	
	/**
	 * Constructor.
	 * @param entity The CERIF entity.
	 */
	public CerifRecord(T entity) {
		this.entity = entity;
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
		// nothing to implement here
	}

	/*
	 * (non-Javadoc)
	 * @see gr.ekt.transformationengine.core.Record#removeField(java.lang.String)
	 */
	@Override
	public void removeField(String fieldName) {
		// nothing to implement here
	}

	/*
	 * (non-Javadoc)
	 * @see gr.ekt.transformationengine.core.Record#removeValueFromField(java.lang.String, java.lang.Object)
	 */
	@Override
	public void removeValueFromField(String fieldName, Object value) {
		// nothing to implement here
	}

	/*
	 * (non-Javadoc)
	 * @see gr.ekt.transformationengine.core.Record#addField(java.lang.String, java.util.ArrayList)
	 */
	@Override
	public void addField(String fieldName, ArrayList<Object> fieldValues) {
		// nothing to implement here
	}

	/*
	 * (non-Javadoc)
	 * @see gr.ekt.transformationengine.core.Record#addValueToField(java.lang.String, java.lang.Object)
	 */
	@Override
	public void addValueToField(String fieldName, Object fieldValue) {
		// nothing to implement here
	}
	
	/**
	 * Returns the CERIF entity.
	 * @return a CERIF entity.
	 */
	public T getEntity() {
		return entity;
	}
	
	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return entity.toString();
	}

}
