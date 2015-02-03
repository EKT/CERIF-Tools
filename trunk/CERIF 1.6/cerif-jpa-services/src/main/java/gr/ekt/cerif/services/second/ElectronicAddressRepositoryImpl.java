/**
 * 
 */
package gr.ekt.cerif.services.second;

import java.util.List;

import gr.ekt.cerif.entities.base.OrganisationUnit;
import gr.ekt.cerif.entities.base.Person;
import gr.ekt.cerif.entities.link.ElectronicAddress_Class;
import gr.ekt.cerif.entities.link.organisationunit.OrganisationUnit_ElectronicAddress;
import gr.ekt.cerif.entities.link.person.Person_ElectronicAddress;
import gr.ekt.cerif.entities.second.ElectronicAddress;
import gr.ekt.cerif.services.link.electronicaddress.LinkElectronicAddressClassRepository;
import gr.ekt.cerif.services.link.organisationunit.LinkOrganisationUnitElectronicAddressRepository;
import gr.ekt.cerif.services.link.person.LinkPersonElectronicAddressRepository;

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
public class ElectronicAddressRepositoryImpl implements ElectronicAddressRepository {
	
	private static final Logger log = LoggerFactory.getLogger(ElectronicAddressRepositoryImpl.class);
	
	@Autowired
	private ElectronicAddressCrudRepository electronicAddressCrudRepository;

	@Autowired
	private LinkOrganisationUnitElectronicAddressRepository linkOrganisationUnitElectronicAddressRepository;
	
	@Autowired
	private LinkPersonElectronicAddressRepository linkPersonElectronicAddressRepository;
	
	@Autowired
	private LinkElectronicAddressClassRepository linkElectronicAddressClassRepository;
	

	@Override
	@Transactional
	public void delete(ElectronicAddress entity) {
		List<OrganisationUnit_ElectronicAddress> oue = linkOrganisationUnitElectronicAddressRepository.findByElectronicAddress(entity);
		if (oue != null) linkOrganisationUnitElectronicAddressRepository.delete(oue);
		entity.setOrganisationUnits_electronicAddresses(null);	
		
		List<Person_ElectronicAddress> pe = linkPersonElectronicAddressRepository.findByElectronicAddress(entity);
		if (pe != null) linkPersonElectronicAddressRepository.delete(pe);
		entity.setPersons_electronicAddresses(null);	
		
		List<ElectronicAddress_Class> eaddrcl = linkElectronicAddressClassRepository.findByElectronicAddress(entity);
		if (eaddrcl != null) linkElectronicAddressClassRepository.delete(eaddrcl);
		entity.setPersons_electronicAddresses(null);
		
		entity = electronicAddressCrudRepository.save(entity);
		electronicAddressCrudRepository.delete(entity);		
	}

	@Override
	public void delete(Iterable<ElectronicAddress> entities) {
		electronicAddressCrudRepository.delete(entities);		
	}

	@Override
	public Iterable<ElectronicAddress> save(Iterable<ElectronicAddress> entities) {
		return electronicAddressCrudRepository.save(entities);
	}

	@Override
	public ElectronicAddress save(ElectronicAddress entity) {
		return electronicAddressCrudRepository.save(entity);
	}

	@Override
	public ElectronicAddress findByUri(String uri) {
		return electronicAddressCrudRepository.findByUri(uri);
	}

	@Override
	public List<ElectronicAddress> findByOrganisationUnit(
			OrganisationUnit organisationUnit) {
		return electronicAddressCrudRepository.findByOrganisationUnit(organisationUnit);
	}

	@Override
	public Iterable<ElectronicAddress> findAll() {
		return electronicAddressCrudRepository.findAll();
	}

	@Override
	public Page<ElectronicAddress> findAll(Pageable page) {
		return electronicAddressCrudRepository.findAll(page);
	}

	@Override
	public ElectronicAddress findById(Long id) {
		return electronicAddressCrudRepository.findOne(id);
	}

	@Override
	public ElectronicAddress findByUuid(String uuid) {
		return electronicAddressCrudRepository.findByUuid(uuid);
	}

	@Override
	public List<ElectronicAddress> findByPerson(Person person) {
		return electronicAddressCrudRepository.findByPerson(person);
	}

}
