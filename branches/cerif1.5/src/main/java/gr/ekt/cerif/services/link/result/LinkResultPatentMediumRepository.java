package gr.ekt.cerif.services.link.result;

import gr.ekt.cerif.entities.link.result.ResultPatent_Medium;
import gr.ekt.cerif.services.result.ResultPatentRepository;
import gr.ekt.cerif.services.second.MediumRepository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * A repository for links between resultPatents and mediums.
 * 
 */
@Component
public class LinkResultPatentMediumRepository {

	@PersistenceContext(unitName="cerif-persistence-unit")
	private EntityManager entityManager;
	
	@Autowired
	private ResultPatentRepository resultPatentRepository;
	
	@Autowired
	private MediumRepository mediumRepository;
	
	@Transactional
	public void save(ResultPatent_Medium entity) {
		if (entity.getResultPatent() == null || entity.getMedium() == null) {
			throw new IllegalArgumentException("Please provide both a resultPatent and a medium.");
		}
		if (entity.getResultPatent().getId() == null) {
			resultPatentRepository.save(entity.getResultPatent());
		}
		if (entity.getMedium().getId() == null) {
			mediumRepository.save(entity.getMedium());
		}
		entityManager.merge(entity);
	}
	
	@Transactional
	public void save(List<ResultPatent_Medium> entityList) {
		for (ResultPatent_Medium entity : entityList) {
			save(entity);
		}
	}
	
}
