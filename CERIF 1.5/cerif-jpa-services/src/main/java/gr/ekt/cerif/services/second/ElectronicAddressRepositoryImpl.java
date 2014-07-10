/**
 * 
 */
package gr.ekt.cerif.services.second;

import java.util.List;

import gr.ekt.cerif.entities.base.OrganisationUnit;
import gr.ekt.cerif.entities.base.Person;
import gr.ekt.cerif.entities.second.ElectronicAddress;

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
public class ElectronicAddressRepositoryImpl implements ElectronicAddressRepository {
	
	private static final Logger log = LoggerFactory.getLogger(ElectronicAddressRepositoryImpl.class);
	
	@Autowired
	private ElectronicAddressCrudRepository electronicAddressCrudRepository;

	@Override
	public void delete(ElectronicAddress entity) {
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
	public ElectronicAddress findByUUID(String uuid) {
		return electronicAddressCrudRepository.findByUuid(uuid);
	}

	@Override
	public List<ElectronicAddress> findByPerson(Person person) {
		return electronicAddressCrudRepository.findByPerson(person);
	}

}
