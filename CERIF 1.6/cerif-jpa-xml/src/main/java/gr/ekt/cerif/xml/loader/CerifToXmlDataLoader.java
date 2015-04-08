package gr.ekt.cerif.xml.loader;

import gr.ekt.cerif.CerifEntity;
import gr.ekt.cerif.xml.loadingSpecs.LoadingSpecs;
import gr.ekt.cerif.xml.records.CerifRecord;
import gr.ekt.cerif.xml.service.SupportedEntities;
import gr.ekt.transformationengine.core.DataLoader;
import gr.ekt.transformationengine.core.Record;
import gr.ekt.transformationengine.core.RecordSet;

import java.util.List;

import org.springframework.stereotype.Component;

/**
 * Loader that accepts CERIF entities as input.
 * In contrast to {@link CerifToXmlDataLoader}, this loader requires no connection to a database.
 *
 * @author Nikos Pougounias <pougounias@ekt.gr>
 */
@Component
public class CerifToXmlDataLoader extends DataLoader {
	
	/*
	 * (non-Javadoc)
	 * @see gr.ekt.transformationengine.core.DataLoader#loadData()
	 */
	@Override
	public RecordSet loadData() {
		RecordSet result = new RecordSet();
		
		LoadingSpecs specs = ((LoadingSpecs)this.getLoadingSpec());
		
		List<CerifEntity> entities = specs.getEntities();
				
		if (entities != null && !entities.isEmpty()) {
			for (CerifEntity entity : entities) {
				if (!SupportedEntities.isEntitySupported(entity.getClass())) {
					throw new IllegalArgumentException(String.format("Invalid entity provided. %s is not yet supported.", entity.getClass().getName()));
				}
				Record record = new CerifRecord<CerifEntity>(entity);
				result.addRecord(record);
			}
		}
	
		return result;
	}
	
}
