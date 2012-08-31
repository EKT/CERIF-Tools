package gr.ekt.cerif.services.link.result;

import gr.ekt.cerif.entities.link.result.ResultPublication_ResultPublication;
import gr.ekt.cerif.services.result.ResultPublicationRepository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * A repository for links between resultPublications and resultPublications.
 * 
 */
@Component
public class LinkResultPublicationResultPublicationRepository {

	@PersistenceContext(unitName="cerif-persistence-unit")
	private EntityManager entityManager;
	
	@Autowired
	private ResultPublicationRepository resultPublicationRepository;
	
	@Transactional
	public void save(ResultPublication_ResultPublication entity) {
		if (entity.getResultPublication1() == null || entity.getResultPublication2() == null) {
			throw new IllegalArgumentException("Please provide both a resultPublication and a resultPublication.");
		}
		if (entity.getResultPublication1().getId() == null) {
			resultPublicationRepository.save(entity.getResultPublication1());
		}
		if (entity.getResultPublication2().getId() == null) {
			resultPublicationRepository.save(entity.getResultPublication2());
		}
		entityManager.merge(entity);
	}
	
	@Transactional
	public void save(List<ResultPublication_ResultPublication> entityList) {
		for (ResultPublication_ResultPublication entity : entityList) {
			save(entity);
		}
	}
	
}
