package gr.ekt.cerif.services.link.funding;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import gr.ekt.cerif.entities.link.Funding_Measurement;

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

}
