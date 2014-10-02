package gr.ekt.cerif.services.link.funding;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import gr.ekt.cerif.entities.link.Funding_Measurement;
import gr.ekt.cerif.entities.second.Funding;
import gr.ekt.cerif.entities.second.Measurement;

@Component
public class LinkFundingMeasurementRepositoryImpl implements
		LinkFundingMeasurementRepository {
	
	private static final Logger log = LoggerFactory.getLogger(LinkFundingMeasurementRepositoryImpl.class);
	
	@Autowired
	private LinkFundingMeasurementCrudRepository linkFundingMeasurementCrudRepository;

	@Override
	public void delete(Funding_Measurement entity) {
		linkFundingMeasurementCrudRepository.delete(entity);
	}

	@Override
	public void delete(Iterable<Funding_Measurement> entities) {
		linkFundingMeasurementCrudRepository.delete(entities);
	}

	@Override
	public Iterable<Funding_Measurement> save(
			Iterable<Funding_Measurement> entities) {
		return linkFundingMeasurementCrudRepository.save(entities);
	}

	@Override
	public Funding_Measurement save(Funding_Measurement entity) {
		return linkFundingMeasurementCrudRepository.save(entity);
	}

	@Override
	public List<Funding_Measurement> findByFunding(Funding funding) {
		return linkFundingMeasurementCrudRepository.findByFunding(funding);
	}

	@Override
	public List<Funding_Measurement> findByMeasurement(Measurement measurement) {
		return linkFundingMeasurementCrudRepository.findByMeasurement(measurement);
	}

}
