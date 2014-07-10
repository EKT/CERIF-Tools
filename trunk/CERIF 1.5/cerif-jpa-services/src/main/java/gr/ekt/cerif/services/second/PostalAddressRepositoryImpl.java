/**
 * 
 */
package gr.ekt.cerif.services.second;

import gr.ekt.cerif.entities.base.OrganisationUnit;
import gr.ekt.cerif.entities.base.Person;
import gr.ekt.cerif.entities.second.Country;
import gr.ekt.cerif.entities.second.PostalAddress;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

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
	public void delete(PostalAddress entity) {
		postalAddressCrudRepository.delete(entity);
	}

	/* (non-Javadoc)
	 * @see gr.ekt.cerif.services.second.PostalAddressRepository#delete(java.lang.Iterable)
	 */
	@Override
	public void delete(Iterable<PostalAddress> entities) {
		postalAddressCrudRepository.delete(entities);
	}

	/* (non-Javadoc)
	 * @see gr.ekt.cerif.services.second.PostalAddressRepository#save(java.lang.Iterable)
	 */
	@Override
	public Iterable<PostalAddress> save(Iterable<PostalAddress> entities) {
		return postalAddressCrudRepository.save(entities);
	}

	/* (non-Javadoc)
	 * @see gr.ekt.cerif.services.second.PostalAddressRepository#save(gr.ekt.cerif.entities.second.PostalAddress)
	 */
	@Override
	public PostalAddress save(PostalAddress entity) {
		return postalAddressCrudRepository.save(entity);
	}


	@Override
	public PostalAddress findByOrganisationUnitNameAndCountryCode(
			String organisationUnitName, String ccode) {
		return postalAddressCrudRepository.findByOrganisationUnitNameAndCountryCode(organisationUnitName, ccode);
	}


	@Override
	public List<PostalAddress> findByOrganisationUnit(
			OrganisationUnit organisationUnit) {
		return postalAddressCrudRepository.findByOrganisationUnit(organisationUnit);
	}


	@Override
	public PostalAddress findByOrganisationUnitAndCountryCode(
			OrganisationUnit organisationUnit, String ccode) {
		return postalAddressCrudRepository.findByOrganisationUnitAndCountryCode(organisationUnit, ccode);
	}


	@Override
	public List<PostalAddress> findByPerson(Person person) {
		return postalAddressCrudRepository.findByPerson(person);
	}


	@Override
	public PostalAddress findByOrganisationUnitName(String organisationUnitName) {
		return postalAddressCrudRepository.findByOrganisationUnitName(organisationUnitName);
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
	public PostalAddress findById(Long id) {
		return postalAddressCrudRepository.findOne(id);
	}


	@Override
	public PostalAddress findByUUID(String uuid) {
		return postalAddressCrudRepository.findByUuid(uuid);
	}

}
