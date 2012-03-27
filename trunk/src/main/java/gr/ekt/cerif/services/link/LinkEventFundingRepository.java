package gr.ekt.cerif.services.link;

import gr.ekt.cerif.entities.link.Event_Funding;
import gr.ekt.cerif.services.second.EventRepository;
import gr.ekt.cerif.services.second.FundingRepository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * A repository for links between events and fundings.
 * 
 */
@Component
public class LinkEventFundingRepository {

	@PersistenceContext(unitName="cerif-persistence-unit")
	private EntityManager entityManager;
	
	@Autowired
	private EventRepository eventRepository;
	
	@Autowired
	private FundingRepository fundingRepository;
	
	@Transactional
	public void save(Event_Funding entity) {
		if (entity.getEvent() == null || entity.getFunding() == null) {
			throw new IllegalArgumentException("Please provide both a event and a funding.");
		}
		if (entity.getEvent().getId() == null) {
			eventRepository.save(entity.getEvent());
		}
		if (entity.getFunding().getId() == null) {
			fundingRepository.save(entity.getFunding());
		}
		entityManager.merge(entity);
	}
	
	@Transactional
	public void save(List<Event_Funding> entityList) {
		for (Event_Funding entity : entityList) {
			save(entity);
		}
	}
	
}
