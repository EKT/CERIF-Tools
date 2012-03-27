package gr.ekt.cerif.services.link;

import gr.ekt.cerif.entities.link.Funding_Measurement;
import gr.ekt.cerif.services.second.FundingRepository;
import gr.ekt.cerif.services.second.MeasurementRepository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * A repository for links between fundings and measurements.
 * 
 */
@Component
public class LinkFundingMeasurementRepository {

	@PersistenceContext(unitName="cerif-persistence-unit")
	private EntityManager entityManager;
	
	@Autowired
	private FundingRepository fundingRepository;
	
	@Autowired
	private MeasurementRepository measurementRepository;
	
	@Transactional
	public void save(Funding_Measurement entity) {
		if (entity.getFunding() == null || entity.getMeasurement() == null) {
			throw new IllegalArgumentException("Please provide both a funding and a measurement.");
		}
		if (entity.getFunding().getId() == null) {
			fundingRepository.save(entity.getFunding());
		}
		if (entity.getMeasurement().getId() == null) {
			measurementRepository.save(entity.getMeasurement());
		}
		entityManager.merge(entity);
	}
	
	@Transactional
	public void save(List<Funding_Measurement> entityList) {
		for (Funding_Measurement entity : entityList) {
			save(entity);
		}
	}
	
}
