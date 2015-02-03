package gr.ekt.cerif.xml.records.second;

import java.util.ArrayList;
import java.util.List;

import gr.ekt.cerif.entities.second.Qualification;
import gr.ekt.transformationengine.core.Record;

/**
 * Record for a qualification.
 *
 * @author Nikos Pougounias <pougounias@ekt.gr>
 */
public class CerifQualificationRecord extends Record {

	/**
	 * The qualification.
	 */
	private Qualification qualification;
	
	/**
	 * Constructor.
	 * @param qualification The qualification.
	 */
	public CerifQualificationRecord(Qualification qualification) {
		super();
		this.qualification = qualification;
	}
	
	/**
	 * Returns the qualification.
	 * @return the qualification.
	 */
	public Qualification getQualification() {
		return qualification;
	}

	/**
	 * Sets the qualification.
	 * @param qualification the qualification.
	 */
	public void setQualification(Qualification qualification) {
		this.qualification = qualification;
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
