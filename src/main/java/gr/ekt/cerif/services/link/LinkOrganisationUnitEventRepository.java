package gr.ekt.cerif.services.link;

import gr.ekt.cerif.entities.link.organisationunit.OrganisationUnit_Event;
import gr.ekt.cerif.services.base.OrganisationUnitRepository;
import gr.ekt.cerif.services.second.EventRepository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * A repository for links between organisations and events.
 * 
 */
@Component
public class LinkOrganisationUnitEventRepository {
	
	@PersistenceContext(unitName="cerif-persistence-unit")
	EntityManager entityManager;
	
	@Autowired
	OrganisationUnitRepository organisationRepository;
	
	@Autowired
	EventRepository eventRepository;
	
	@Transactional
	public void save(OrganisationUnit_Event entity) {
		if (entity.getOrganisationUnit() == null || entity.getEvent() == null) {
			throw new IllegalArgumentException("Please provide both an organisation and an event.");
		}
		if (entity.getOrganisationUnit().getId() == null) {
			organisationRepository.save(entity.getOrganisationUnit());
		}
		if (entity.getEvent().getId() == null) {
			eventRepository.save(entity.getEvent());
		}
		entityManager.merge(entity);
	}
	
	@Transactional
	public void save(List<OrganisationUnit_Event> entityList) {
		for (OrganisationUnit_Event entity : entityList) {
			save(entity);
		}
	}

}
