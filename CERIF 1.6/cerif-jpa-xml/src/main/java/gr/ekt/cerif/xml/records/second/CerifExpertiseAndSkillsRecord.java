package gr.ekt.cerif.xml.records.second;

import gr.ekt.cerif.entities.second.ExpertiseAndSkills;
import gr.ekt.transformationengine.core.Record;

import java.util.ArrayList;
import java.util.List;

/**
 * Record for a expertise and skills.
 *
 * @author Nikos Pougounias <pougounias@ekt.gr>
 */
public class CerifExpertiseAndSkillsRecord extends Record {

	/**
	 * The expertise and skills.
	 */
	private ExpertiseAndSkills expertiseAndSkills;

	/**
	 * Constructor.
	 * @param expertiseAndSkills The expertise and skills.
	 */
	public CerifExpertiseAndSkillsRecord(ExpertiseAndSkills expertiseAndSkills) {
		super();
		this.expertiseAndSkills = expertiseAndSkills;
	}

	/**
	 * Returns the expertise and skills.
	 * @return the expertise and skills.
	 */
	public ExpertiseAndSkills getExpertiseAndSkills() {
		return expertiseAndSkills;
	}

	/**
	 * Sets the expertise and skills.
	 * @param expertiseAndSkills the expertise and skills.
	 */
	public void setExpertiseAndSkills(ExpertiseAndSkills expertiseAndSkills) {
		this.expertiseAndSkills = expertiseAndSkills;
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

