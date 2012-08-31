package gr.ekt.cerif.services.link.result;

import gr.ekt.cerif.entities.link.result.ResultPublication_ResultPatent;
import gr.ekt.cerif.services.result.ResultPublicationRepository;
import gr.ekt.cerif.services.result.ResultPatentRepository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * A repository for links between resultPublications and resultPatents.
 * 
 */
@Component
public class LinkResultPublicationResultPatentRepository {

	@PersistenceContext(unitName="cerif-persistence-unit")
	private EntityManager entityManager;
	
	@Autowired
	private ResultPublicationRepository resultPublicationRepository;
	
	@Autowired
	private ResultPatentRepository resultPatentRepository;
	
	@Transactional
	public void save(ResultPublication_ResultPatent entity) {
		if (entity.getResultPublication() == null || entity.getResultPatent() == null) {
			throw new IllegalArgumentException("Please provide both a resultPublication and a resultPatent.");
		}
		if (entity.getResultPublication().getId() == null) {
			resultPublicationRepository.save(entity.getResultPublication());
		}
		if (entity.getResultPatent().getId() == null) {
			resultPatentRepository.save(entity.getResultPatent());
		}
		entityManager.merge(entity);
	}
	
	@Transactional
	public void save(List<ResultPublication_ResultPatent> entityList) {
		for (ResultPublication_ResultPatent entity : entityList) {
			save(entity);
		}
	}
	
}
