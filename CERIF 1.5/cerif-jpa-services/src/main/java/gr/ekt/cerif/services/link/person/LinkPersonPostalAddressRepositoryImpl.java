package gr.ekt.cerif.services.link.person;

import gr.ekt.cerif.entities.base.Person;
import gr.ekt.cerif.entities.link.person.Person_PostalAddress;
import gr.ekt.cerif.entities.second.PostalAddress;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LinkPersonPostalAddressRepositoryImpl implements
		LinkPersonPostalAddressRepository {
	
	private static final Logger log = LoggerFactory.getLogger(LinkPersonPostalAddressRepositoryImpl.class);
	
	@Autowired
	private LinkPersonPostalAddressCrudRepository linkPersonPostalAddressCrudRepository;

	@Override
	public Person_PostalAddress findByPersonName(String personName) {
		return linkPersonPostalAddressCrudRepository.findByPersonName(personName);
	}

	@Override
	public List<Person_PostalAddress> findByPerson(Person person) {
		return linkPersonPostalAddressCrudRepository.findByPerson(person);
	}

	@Override
	public List<Person_PostalAddress> findByPerson2(Person person) {
		return linkPersonPostalAddressCrudRepository.findByPerson2(person);
	}

	@Override
	public Person_PostalAddress findByPersonAndPostalAddress(Person person,
			PostalAddress postalAddress) {
		return linkPersonPostalAddressCrudRepository.findByPersonAndPostalAddress(person, postalAddress);
	}

	@Override
	public void delete(Person_PostalAddress entity) {
		linkPersonPostalAddressCrudRepository.delete(entity);
	}

	@Override
	public void delete(Iterable<Person_PostalAddress> entities) {
		linkPersonPostalAddressCrudRepository.delete(entities);
	}

	@Override
	public Iterable<Person_PostalAddress> save(
			Iterable<Person_PostalAddress> entities) {
		return linkPersonPostalAddressCrudRepository.save(entities);
	}

	@Override
	public Person_PostalAddress save(Person_PostalAddress entity) {
		return linkPersonPostalAddressCrudRepository.save(entity);
	}

}
