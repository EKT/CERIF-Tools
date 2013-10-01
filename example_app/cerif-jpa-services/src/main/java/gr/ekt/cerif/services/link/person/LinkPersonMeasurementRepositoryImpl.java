package gr.ekt.cerif.services.link.person;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import gr.ekt.cerif.entities.link.person.Person_Measurement;

@Component
public class LinkPersonMeasurementRepositoryImpl implements
		LinkPersonMeasurementRepository {
	
	private static final Logger log = LoggerFactory.getLogger(LinkPersonMeasurementRepositoryImpl.class);
	
	@Autowired
	private LinkPersonMeasurementCrudRepository linkPersonMeasurementCrudRepository;

	@Override
	public void delete(Person_Measurement entity) {
		linkPersonMeasurementCrudRepository.delete(entity);
	}

	@Override
	public void delete(Iterable<Person_Measurement> entities) {
		linkPersonMeasurementCrudRepository.delete(entities);
	}

	@Override
	public Iterable<Person_Measurement> save(
			Iterable<Person_Measurement> entities) {
		return linkPersonMeasurementCrudRepository.save(entities);
	}

	@Override
	public Person_Measurement save(Person_Measurement entity) {
		return linkPersonMeasurementCrudRepository.save(entity);
	}

}
