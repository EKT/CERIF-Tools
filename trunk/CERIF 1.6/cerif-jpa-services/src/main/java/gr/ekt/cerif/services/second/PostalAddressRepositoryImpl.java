/**
 * 
 */
package gr.ekt.cerif.services.second;

import gr.ekt.cerif.entities.base.OrganisationUnit;
import gr.ekt.cerif.entities.base.Person;
import gr.ekt.cerif.entities.infrastructure.Equipment;
import gr.ekt.cerif.entities.infrastructure.Facility;
import gr.ekt.cerif.entities.infrastructure.Service;
import gr.ekt.cerif.entities.second.Country;
import gr.ekt.cerif.entities.second.PostalAddress;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author bonisv
 *
 */
@Component
public class PostalAddressRepositoryImpl implements PostalAddressRepository {
	
	private static final Logger log = LoggerFactory.getLogger(PostalAddressRepositoryImpl.class);
	
	@Autowired
	private PostalAddressCrudRepository postalAddressCrudRepository;
	

	/* (non-Javadoc)
	 * @see gr.ekt.cerif.services.second.PostalAddressRepository#findByCountry(gr.ekt.cerif.entities.second.Country)
	 */
	@Override
	public List<PostalAddress> findByCountry(Country country) {
		return postalAddressCrudRepository.findByCountry(country);
	}
	
	/* (non-Javadoc)
	 * @see gr.ekt.cerif.services.second.PostalAddressRepository#delete(gr.ekt.cerif.entities.second.PostalAddress)
	 */
	@Override
	@Transactional
	public void delete(PostalAddress entity) {
		postalAddressCrudRepository.delete(entity);
	}

	@Override
	public void delete(Iterable<PostalAddress> entities) {
		postalAddressCrudRepository.delete(entities);
	}

	@Override
	public Iterable<PostalAddress> save(Iterable<PostalAddress> entities) {
		return postalAddressCrudRepository.save(entities);
	}

	@Override
	public PostalAddress save(PostalAddress entity) {
		return postalAddressCrudRepository.save(entity);
	}

	@Override
	public Iterable<PostalAddress> findAll() {
		return postalAddressCrudRepository.findAll();
	}

	@Override
	public Page<PostalAddress> findAll(Pageable page) {
		return postalAddressCrudRepository.findAll(page);
	}

	@Override
	public PostalAddress findByUuid(String uuid) {
		return postalAddressCrudRepository.findByUuid(uuid);
	}

	@Override
	public PostalAddress findById(Long id) {
		return postalAddressCrudRepository.findById(id);
	}

	@Override
	public List<PostalAddress> findByUri(String uri) {
		return postalAddressCrudRepository.findByUri(uri);
	}

	@Override
	public List<PostalAddress> findByOrganisationUnit(
			OrganisationUnit organisationUnit) {
		return postalAddressCrudRepository.findByOrganisationUnit(organisationUnit);
	}

	@Override
	public List<PostalAddress> findByEquipment(Equipment equipment) {
		return postalAddressCrudRepository.findByEquipment(equipment);
	}

	@Override
	public List<PostalAddress> findByFacility(Facility facility) {
		return postalAddressCrudRepository.findByFacility(facility);
	}

	@Override
	public List<PostalAddress> findByService(Service service) {
		return postalAddressCrudRepository.findByService(service);
	}

	@Override
	public List<PostalAddress> findByPerson(Person person) {
		return postalAddressCrudRepository.findByPerson(person);
	}

	

}
