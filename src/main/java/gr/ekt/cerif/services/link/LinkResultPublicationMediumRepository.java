package gr.ekt.cerif.services.link;

import gr.ekt.cerif.entities.link.result.ResultPublication_Medium;
import gr.ekt.cerif.services.result.ResultPublicationRepository;
import gr.ekt.cerif.services.second.MediumRepository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * A repository for links between resultPublications and mediums.
 * 
 */
@Component
public class LinkResultPublicationMediumRepository {

	@PersistenceContext(unitName="cerif-persistence-unit")
	private EntityManager entityManager;
	
	@Autowired
	private ResultPublicationRepository resultPublicationRepository;
	
	@Autowired
	private MediumRepository mediumRepository;
	
	@Transactional
	public void save(ResultPublication_Medium entity) {
		if (entity.getResultPublication() == null || entity.getMedium() == null) {
			throw new IllegalArgumentException("Please provide both a resultPublication and a medium.");
		}
		if (entity.getResultPublication().getId() == null) {
			resultPublicationRepository.save(entity.getResultPublication());
		}
		if (entity.getMedium().getId() == null) {
			mediumRepository.save(entity.getMedium());
		}
		entityManager.merge(entity);
	}
	
	@Transactional
	public void save(List<ResultPublication_Medium> entityList) {
		for (ResultPublication_Medium entity : entityList) {
			save(entity);
		}
	}
	
}
