package gr.ekt.cerif.xml.records.second;

import java.util.ArrayList;
import java.util.List;

import gr.ekt.cerif.entities.second.CV;
import gr.ekt.transformationengine.core.Record;

/**
 * Record for a curriculum vitae.
 *
 * @author Nikos Pougounias <pougounias@ekt.gr>
 */
public class CerifCurriculumVitaeRecord extends Record {
	
	/**
	 * Curriculum vitae.
	 */
	private CV curriculumVitae;
	
	/**
	 * Constructor.
	 * @param curriculumVitae A curriculum vitae.
	 */
	public CerifCurriculumVitaeRecord(CV curriculumVitae) {
		super();
		this.curriculumVitae = curriculumVitae;
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

	/**
	 * Returns the curriculum vitae.
	 * @return a CV.
	 */
	public CV getCurriculumVitae() {
		return curriculumVitae;
	}

	/**
	 * Sets the curriculum Vitae.
	 * @param curriculumVitae The CV.
	 */
	public void setCurriculumVitae(CV curriculumVitae) {
		this.curriculumVitae = curriculumVitae;
	}
	
}
