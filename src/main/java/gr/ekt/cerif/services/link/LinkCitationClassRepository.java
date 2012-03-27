package gr.ekt.cerif.services.link;

import gr.ekt.cerif.entities.link.Citation_Class;
import gr.ekt.cerif.services.second.CitationRepository;
import gr.ekt.cerif.services.semantics.ClassRepository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * A repository for links between citations and classes.
 * 
 */
@Component
public class LinkCitationClassRepository {

	@PersistenceContext(unitName="cerif-persistence-unit")
	private EntityManager entityManager;
	
	@Autowired
	private CitationRepository citationRepository;
	
	@Autowired
	private ClassRepository classRepository;
	
	@Transactional
	public void save(Citation_Class entity) {
		if (entity.getCitation() == null || entity.getTheClass() == null) {
			throw new IllegalArgumentException("Please provide both a citation and a class.");
		}
		if (entity.getCitation().getId() == null) {
			citationRepository.save(entity.getCitation());
		}
		if (entity.getTheClass().getId() == null) {
			classRepository.save(entity.getTheClass());
		}
		entityManager.merge(entity);
	}
	
	@Transactional
	public void save(List<Citation_Class> entityList) {
		for (Citation_Class entity : entityList) {
			save(entity);
		}
	}
	
}
