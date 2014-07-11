package gr.ekt.cerif.xml.loadingSpecs;

import java.util.ArrayList;
import java.util.List;

import gr.ekt.cerif.CerifEntity;
import gr.ekt.cerif.xml.loader.CerifToXmlObjectDataLoader;
import gr.ekt.transformationengine.dataloaders.DataLoadingSpec;

/**
 * Loading specifications for the {@link CerifToXmlObjectDataLoader}.
 *
 * @author Nikos Pougounias <pougounias@ekt.gr>
 */
public class ObjectLoadingSpecs extends DataLoadingSpec {
	
	/**
	 * The input CERIF entities.
	 */
	private List<CerifEntity> entities;
	
	/*
	 * (non-Javadoc)
	 * @see gr.ekt.transformationengine.dataloaders.DataLoadingSpec#generateNextLoadingSpec()
	 */
	@Override
	public DataLoadingSpec generateNextLoadingSpec() {
		return this;
	}

	/**
	 * Retrieves the CERIF entities.
	 * @return a list.
	 */
	public List<CerifEntity> getEntities() {
		return entities;
	}
	
	/**
	 * Sets the CERIF entities.
	 * @param entities a list.
	 */
	public void setEntities(List<CerifEntity> entities) {
		this.entities = entities;
	}
	
	/**
	 * Adds a CERIF entity to the input.
	 * @param entity An entity.
	 */
	public void addEntity(CerifEntity entity) {
		if (entities == null) {
			entities = new ArrayList<CerifEntity>();
		}
	}

}
