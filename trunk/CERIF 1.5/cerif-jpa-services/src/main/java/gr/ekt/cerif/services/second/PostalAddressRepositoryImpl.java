/**
 * 
 */
package gr.ekt.cerif.services.second;

import gr.ekt.cerif.entities.base.OrganisationUnit;
import gr.ekt.cerif.entities.base.Person;
import gr.ekt.cerif.entities.infrastructure.Equipment;
import gr.ekt.cerif.entities.infrastructure.Facility;
import gr.ekt.cerif.entities.infrastructure.Service;
import gr.ekt.cerif.entities.link.Equipment_PostalAddress;
import gr.ekt.cerif.entities.link.Facility_PostalAddress;
import gr.ekt.cerif.entities.link.PostalAddress_Class;
import gr.ekt.cerif.entities.link.Service_PostalAddress;
import gr.ekt.cerif.entities.link.organisationunit.OrganisationUnit_PostalAddress;
import gr.ekt.cerif.entities.link.person.Person_ElectronicAddress;
import gr.ekt.cerif.entities.link.person.Person_PostalAddress;
import gr.ekt.cerif.entities.second.Country;
import gr.ekt.cerif.entities.second.ElectronicAddress;
import gr.ekt.cerif.entities.second.PostalAddress;
import gr.ekt.cerif.services.link.equipment.LinkEquipmentPostalAddressRepository;
import gr.ekt.cerif.services.link.facility.LinkFacilityPostalAddressRepository;
import gr.ekt.cerif.services.link.organisationunit.LinkOrganisationUnitPostalAddressRepository;
import gr.ekt.cerif.services.link.person.LinkPersonPostalAddressRepository;
import gr.ekt.cerif.services.link.postaladdress.LinkPostalAddressClassRepository;
import gr.ekt.cerif.services.link.service.LinkServicePostalAddressRepository;

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
	
	@Autowired
	private LinkPostalAddressClassRepository linkPostalAddressClassRepository;
	
	@Autowired
	private LinkOrganisationUnitPostalAddressRepository linkOrganisationUnitPostalAddressRepository;
	
	@Autowired
	private LinkPersonPostalAddressRepository linkPersonPostalAddressRepository;
	
	@Autowired
	private LinkEquipmentPostalAddressRepository linkEquipmentPostalAddressRepository;
	
	@Autowired
	private LinkFacilityPostalAddressRepository linkFacilityPostalAddressRepository;
	
	@Autowired
	private LinkServicePostalAddressRepository linkServicePostalAddressRepository;
	

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
		List<PostalAddress_Class> paddrcl = linkPostalAddressClassRepository.findByPostalAddress(entity);
		if (paddrcl != null) linkPostalAddressClassRepository.delete(paddrcl);
		entity.setPostalAddresses_classes(null);
		
		List<OrganisationUnit_PostalAddress> oup = linkOrganisationUnitPostalAddressRepository.findByPostalAddress(entity);
		if (oup != null) linkOrganisationUnitPostalAddressRepository.delete(oup);
		entity.setOrganisationUnits_postalAddresses(null);	
		
		List<Person_PostalAddress> pp = linkPersonPostalAddressRepository.findByPostalAddress(entity);
		if (pp != null) linkPersonPostalAddressRepository.delete(pp);
		entity.setPersons_postalAddresses(null);	
		
		List<Equipment_PostalAddress> equipaddr = linkEquipmentPostalAddressRepository.findByPostalAddress(entity);
		if (equipaddr != null) linkEquipmentPostalAddressRepository.delete(equipaddr);
		entity.setEquipments_postalAddresses(null);
		
		List<Facility_PostalAddress> facpaddr = linkFacilityPostalAddressRepository.findByPostalAddress(entity);
		if (facpaddr != null) linkFacilityPostalAddressRepository.delete(facpaddr);
		entity.setFacilities_postalAddresses(null);
		
		List<Service_PostalAddress> servpaddr = linkServicePostalAddressRepository.findByPostalAddress(entity);
		if (servpaddr != null) linkServicePostalAddressRepository.delete(servpaddr);
		entity.setServices_postalAddresses(null);
		
		entity = postalAddressCrudRepository.save(entity);
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
		return postalAddressCrudRepository.findByService(null);
	}

}
