package gr.ekt.cerif.services.link.result;

import gr.ekt.cerif.entities.link.result.ResultPublication_DublinCore;
import gr.ekt.cerif.services.result.ResultPublicationRepository;
import gr.ekt.cerif.services.additional.DublinCoreRepository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * A repository for links between resultPublications and dublinCores.
 * 
 */
@Component
public class LinkResultPublicationDublinCoreRepository {

	@PersistenceContext(unitName="cerif-persistence-unit")
	private EntityManager entityManager;
	
	@Autowired
	private ResultPublicationRepository resultPublicationRepository;
	
	@Autowired
	private DublinCoreRepository dublinCoreRepository;
	
	@Transactional
	public void save(ResultPublication_DublinCore entity) {
		if (entity.getResultPublication() == null || entity.getDublinCore() == null) {
			throw new IllegalArgumentException("Please provide both a resultPublication and a dublinCore.");
		}
		if (entity.getResultPublication().getId() == null) {
			resultPublicationRepository.save(entity.getResultPublication());
		}
		if (entity.getDublinCore().getId() == null) {
			dublinCoreRepository.save(entity.getDublinCore());
		}
		entityManager.merge(entity);
	}
	
	@Transactional
	public void save(List<ResultPublication_DublinCore> entityList) {
		for (ResultPublication_DublinCore entity : entityList) {
			save(entity);
		}
	}
	
}
