package gr.ekt.cerif.services.link;

import gr.ekt.cerif.entities.link.Service_Funding;
import gr.ekt.cerif.services.infrastructure.ServiceRepository;
import gr.ekt.cerif.services.second.FundingRepository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * A repository for links between services and fundings.
 * 
 */
@Component
public class LinkServiceFundingRepository {

	@PersistenceContext(unitName="cerif-persistence-unit")
	private EntityManager entityManager;
	
	@Autowired
	private ServiceRepository serviceRepository;
	
	@Autowired
	private FundingRepository fundingRepository;
	
	@Transactional
	public void save(Service_Funding entity) {
		if (entity.getService() == null || entity.getFunding() == null) {
			throw new IllegalArgumentException("Please provide both a service and a funding.");
		}
		if (entity.getService().getId() == null) {
			serviceRepository.save(entity.getService());
		}
		if (entity.getFunding().getId() == null) {
			fundingRepository.save(entity.getFunding());
		}
		entityManager.merge(entity);
	}
	
	@Transactional
	public void save(List<Service_Funding> entityList) {
		for (Service_Funding entity : entityList) {
			save(entity);
		}
	}
	
}
