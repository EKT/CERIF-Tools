package gr.ekt.cerif.xml.records.second;

import gr.ekt.cerif.entities.second.Prize;
import gr.ekt.transformationengine.core.Record;

import java.util.ArrayList;
import java.util.List;

/**
 * Record for a prize.
 *
 * @author Nikos Pougounias <pougounias@ekt.gr>
 */
public class CerifPrizeRecord extends Record {
	
	/**
	 * The prize.
	 */
	private Prize prize;

	/**
	 * Constructor.
	 * @param prize The prize.
	 */
	public CerifPrizeRecord(Prize prize) {
		super();
		this.prize = prize;
	}

	/**
	 * Returns the prize.
	 * @return the prize.
	 */
	public Prize getPrize() {
		return prize;
	}

	/**
	 * Sets the prize.
	 * @param prize the prize.
	 */
	public void setPrize(Prize prize) {
		this.prize = prize;
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
