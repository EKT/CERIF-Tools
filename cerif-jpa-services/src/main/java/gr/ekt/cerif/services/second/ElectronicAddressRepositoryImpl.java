/**
 * 
 */
package gr.ekt.cerif.services.second;

import gr.ekt.cerif.entities.base.OrganisationUnit;
import gr.ekt.cerif.entities.second.ElectronicAddress;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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
	public ElectronicAddress findByOrganisationUnit(
			OrganisationUnit organisationUnit) {
		return electronicAddressCrudRepository.findByOrganisationUnit(organisationUnit);
	}

}
