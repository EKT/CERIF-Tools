package gr.ekt.cerif.services.link.result;

import gr.ekt.cerif.entities.link.result.ResultPublication_Facility;
import gr.ekt.cerif.services.result.ResultPublicationRepository;
import gr.ekt.cerif.services.infrastructure.FacilityRepository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * A repository for links between resultPublications and facilities.
 * 
 */
@Component
public class LinkResultPublicationFacilityRepository {

	@PersistenceContext(unitName="cerif-persistence-unit")
	private EntityManager entityManager;
	
	@Autowired
	private ResultPublicationRepository resultPublicationRepository;
	
	@Autowired
	private FacilityRepository facilityRepository;
	
	@Transactional
	public void save(ResultPublication_Facility entity) {
		if (entity.getResultPublication() == null || entity.getFacility() == null) {
			throw new IllegalArgumentException("Please provide both a resultPublication and a facility.");
		}
		if (entity.getResultPublication().getId() == null) {
			resultPublicationRepository.save(entity.getResultPublication());
		}
		if (entity.getFacility().getId() == null) {
			facilityRepository.save(entity.getFacility());
		}
		entityManager.merge(entity);
	}
	
	@Transactional
	public void save(List<ResultPublication_Facility> entityList) {
		for (ResultPublication_Facility entity : entityList) {
			save(entity);
		}
	}
	
}
