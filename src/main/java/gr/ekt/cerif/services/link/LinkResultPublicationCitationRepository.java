package gr.ekt.cerif.services.link;

import gr.ekt.cerif.entities.link.result.ResultPublication_Citation;
import gr.ekt.cerif.services.result.ResultPublicationRepository;
import gr.ekt.cerif.services.second.CitationRepository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * A repository for links between resultPublications and citations.
 * 
 */
@Component
public class LinkResultPublicationCitationRepository {

	@PersistenceContext(unitName="cerif-persistence-unit")
	private EntityManager entityManager;
	
	@Autowired
	private ResultPublicationRepository resultPublicationRepository;
	
	@Autowired
	private CitationRepository citationRepository;
	
	@Transactional
	public void save(ResultPublication_Citation entity) {
		if (entity.getResultPublication() == null || entity.getCitation() == null) {
			throw new IllegalArgumentException("Please provide both a resultPublication and a citation.");
		}
		if (entity.getResultPublication().getId() == null) {
			resultPublicationRepository.save(entity.getResultPublication());
		}
		if (entity.getCitation().getId() == null) {
			citationRepository.save(entity.getCitation());
		}
		entityManager.merge(entity);
	}
	
	@Transactional
	public void save(List<ResultPublication_Citation> entityList) {
		for (ResultPublication_Citation entity : entityList) {
			save(entity);
		}
	}
	
}
