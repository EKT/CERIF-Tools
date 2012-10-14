package gr.ekt.cerif.services.link.result;

import gr.ekt.cerif.entities.link.result.ResultPatent_ResultPatent;
import gr.ekt.cerif.services.result.ResultPatentRepository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * A repository for links between resultPatents.
 * 
 */
@Component
public class LinkResultPatentResultPatentRepository {

	@PersistenceContext(unitName="cerif-persistence-unit")
	private EntityManager entityManager;
	
	@Autowired
	private ResultPatentRepository resultPatentRepository;
	
	@Transactional
	public void save(ResultPatent_ResultPatent entity) {
		if (entity.getResultPatent1() == null || entity.getResultPatent2() == null) {
			throw new IllegalArgumentException("Please provide both resultPatents.");
		}
		if (entity.getResultPatent1().getId() == null) {
			resultPatentRepository.save(entity.getResultPatent1());
		}
		if (entity.getResultPatent2().getId() == null) {
			resultPatentRepository.save(entity.getResultPatent2());
		}
		entityManager.merge(entity);
	}
	
	@Transactional
	public void save(List<ResultPatent_ResultPatent> entityList) {
		for (ResultPatent_ResultPatent entity : entityList) {
			save(entity);
		}
	}
	
}
