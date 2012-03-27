package gr.ekt.cerif.services.link;

import gr.ekt.cerif.entities.link.Qualification_Class;
import gr.ekt.cerif.services.second.QualificationRepository;
import gr.ekt.cerif.services.semantics.ClassRepository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * A repository for links between qualifications and classes.
 * 
 */
@Component
public class LinkQualificationClassRepository {

	@PersistenceContext(unitName="cerif-persistence-unit")
	private EntityManager entityManager;
	
	@Autowired
	private QualificationRepository qualificationRepository;
	
	@Autowired
	private ClassRepository classRepository;
	
	@Transactional
	public void save(Qualification_Class entity) {
		if (entity.getQualification() == null || entity.getTheClass() == null) {
			throw new IllegalArgumentException("Please provide both a qualification and a class.");
		}
		if (entity.getQualification().getId() == null) {
			qualificationRepository.save(entity.getQualification());
		}
		if (entity.getTheClass().getId() == null) {
			classRepository.save(entity.getTheClass());
		}
		entityManager.merge(entity);
	}
	
	@Transactional
	public void save(List<Qualification_Class> entityList) {
		for (Qualification_Class entity : entityList) {
			save(entity);
		}
	}
	
}
