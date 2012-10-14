package gr.ekt.cerif.services.additional;

import gr.ekt.cerif.features.additional.DublinCoreCoverageTemporal;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * A repository for dublin core coverage temporal.
 * 
 */
@Component
public class DublinCoreCoverageTemporalRepository {

	@PersistenceContext(unitName="cerif-persistence-unit")
	EntityManager entityManager;
	
	@Transactional
	public void save(DublinCoreCoverageTemporal entity) {
		if (entity.getId() == null || entity.getScheme() == null || entity.getTranslation() == null || entity.getLanguage() == null) {
			throw new IllegalArgumentException("Please provide a dc, a translation and a language.");
		}
		
		entityManager.merge(entity);
	}
	
	@Transactional
	public void save(List<DublinCoreCoverageTemporal> entityList) {
		for (DublinCoreCoverageTemporal entity : entityList) {
			save(entity);
		}
	}
}

