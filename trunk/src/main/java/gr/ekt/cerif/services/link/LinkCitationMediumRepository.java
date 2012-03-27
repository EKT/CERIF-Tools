package gr.ekt.cerif.services.link;

import gr.ekt.cerif.entities.link.Citation_Medium;
import gr.ekt.cerif.services.second.CitationRepository;
import gr.ekt.cerif.services.second.MediumRepository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * A repository for links between citations and mediums.
 * 
 */
@Component
public class LinkCitationMediumRepository {

	@PersistenceContext(unitName="cerif-persistence-unit")
	private EntityManager entityManager;
	
	@Autowired
	private CitationRepository citationRepository;
	
	@Autowired
	private MediumRepository mediumRepository;
	
	@Transactional
	public void save(Citation_Medium entity) {
		if (entity.getCitation() == null || entity.getMedium() == null) {
			throw new IllegalArgumentException("Please provide both a citation and a medium.");
		}
		if (entity.getCitation().getId() == null) {
			citationRepository.save(entity.getCitation());
		}
		if (entity.getMedium().getId() == null) {
			mediumRepository.save(entity.getMedium());
		}
		entityManager.merge(entity);
	}
	
	@Transactional
	public void save(List<Citation_Medium> entityList) {
		for (Citation_Medium entity : entityList) {
			save(entity);
		}
	}
	
}
