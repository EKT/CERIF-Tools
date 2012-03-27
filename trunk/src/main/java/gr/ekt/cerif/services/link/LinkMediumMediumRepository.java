package gr.ekt.cerif.services.link;

import gr.ekt.cerif.entities.link.Medium_Medium;
import gr.ekt.cerif.services.second.MediumRepository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * A repository for links between mediums.
 * 
 */
@Component
public class LinkMediumMediumRepository {

	@PersistenceContext(unitName="cerif-persistence-unit")
	private EntityManager entityManager;
	
	@Autowired
	private MediumRepository mediumRepository;
	
	@Transactional
	public void save(Medium_Medium entity) {
		if (entity.getMedium1() == null || entity.getMedium2() == null) {
			throw new IllegalArgumentException("Please provide both mediums.");
		}
		if (entity.getMedium1().getId() == null) {
			mediumRepository.save(entity.getMedium1());
		}
		if (entity.getMedium2().getId() == null) {
			mediumRepository.save(entity.getMedium2());
		}
		entityManager.merge(entity);
	}
	
	@Transactional
	public void save(List<Medium_Medium> entityList) {
		for (Medium_Medium entity : entityList) {
			save(entity);
		}
	}
	
}
