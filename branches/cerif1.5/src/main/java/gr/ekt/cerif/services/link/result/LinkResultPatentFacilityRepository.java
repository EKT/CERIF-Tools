package gr.ekt.cerif.services.link.result;

import gr.ekt.cerif.entities.link.result.ResultPatent_Facility;
import gr.ekt.cerif.services.result.ResultPatentRepository;
import gr.ekt.cerif.services.infrastructure.FacilityRepository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * A repository for links between resultPatents and facilitys.
 * 
 */
@Component
public class LinkResultPatentFacilityRepository {

	@PersistenceContext(unitName="cerif-persistence-unit")
	private EntityManager entityManager;
	
	@Autowired
	private ResultPatentRepository resultPatentRepository;
	
	@Autowired
	private FacilityRepository facilityRepository;
	
	@Transactional
	public void save(ResultPatent_Facility entity) {
		if (entity.getResultPatent() == null || entity.getFacility() == null) {
			throw new IllegalArgumentException("Please provide both a resultPatent and a facility.");
		}
		if (entity.getResultPatent().getId() == null) {
			resultPatentRepository.save(entity.getResultPatent());
		}
		if (entity.getFacility().getId() == null) {
			facilityRepository.save(entity.getFacility());
		}
		entityManager.merge(entity);
	}
	
	@Transactional
	public void save(List<ResultPatent_Facility> entityList) {
		for (ResultPatent_Facility entity : entityList) {
			save(entity);
		}
	}
	
}
