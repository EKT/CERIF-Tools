package gr.ekt.cerif.services;

/**
 * The various modes for selecting identifiers.
 *
 * @author Nikos Pougounias <pougounias@ekt.gr>
 */
public enum SelectionIdentifiersType {
	
	/**
	 * Retrieves the primary keys only.
	 */
	IDS_ONLY,
	
	/**
	 * Retrieves the UUIDs only.
	 */
	UUIDS_ONLY,
	
	/**
	 * Retrieves the UUIDs, but in case a record has no UUID, then its primary key is returned instead.
	 */
	UUIDS_AND_IDS;

}
