package gr.ekt.cerif.services.link.person;

import gr.ekt.cerif.entities.base.Person;
import gr.ekt.cerif.entities.link.person.Person_ElectronicAddress;
import gr.ekt.cerif.entities.second.ElectronicAddress;
import gr.ekt.cerif.features.semantics.Class;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LinkPersonElectronicAddressRepositoryImpl implements
		LinkPersonElectronicAddressRepository {
	
	private static final Logger log = LoggerFactory.getLogger(LinkPersonElectronicAddressRepositoryImpl.class);
	
	@Autowired
	private LinkPersonElectronicAddressCrudRepository linkPersonElectronicAddressCrudRepository;

	@Override
	public List<Person_ElectronicAddress> findByPerson(Person person) {
		return linkPersonElectronicAddressCrudRepository.findByPerson(person);
	}

	@Override
	public List<Person_ElectronicAddress> findByPersonAndElectronicAddress(
			Person person, ElectronicAddress electronicAddress) {
		return linkPersonElectronicAddressCrudRepository.findByPersonAndElectronicAddress(person, electronicAddress);
	}

	@Override
	public void delete(Person_ElectronicAddress entity) {
		linkPersonElectronicAddressCrudRepository.delete(entity);
	}

	@Override
	public void delete(Iterable<Person_ElectronicAddress> entities) {
		linkPersonElectronicAddressCrudRepository.delete(entities);
	}

	@Override
	public Iterable<Person_ElectronicAddress> save(
			Iterable<Person_ElectronicAddress> entities) {
		return linkPersonElectronicAddressCrudRepository.save(entities);
	}

	@Override
	public Person_ElectronicAddress save(Person_ElectronicAddress entity) {
		return linkPersonElectronicAddressCrudRepository.save(entity);
	}

	@Override
	public List<Person_ElectronicAddress> findByElectronicAddress(
			ElectronicAddress electronicAddress) {
		return linkPersonElectronicAddressCrudRepository.findByElectronicAddress(electronicAddress);
	}

	@Override
	public List<Person_ElectronicAddress> findByPersonAndTheClass(
			Person person, Class theClass) {
		return linkPersonElectronicAddressCrudRepository.findByPersonAndTheClass(person, theClass);
	}

}
