package gr.ekt.cerif.services.link.organisationunit;

import java.util.List;

import gr.ekt.cerif.entities.base.OrganisationUnit;
import gr.ekt.cerif.entities.link.organisationunit.OrganisationUnit_PostalAddress;
import gr.ekt.cerif.entities.second.PostalAddress;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class LinkOrganisationUnitPostalAddressRepositoryImpl implements LinkOrganisationUnitPostalAddressRepository {
	
	@Autowired
	LinkOrganisationUnitPostalAddressCrudRepository linkOrganisationUnitPAddrCrudRepository;
	
	@Transactional
	public OrganisationUnit_PostalAddress save(OrganisationUnit_PostalAddress entity) {
		return linkOrganisationUnitPAddrCrudRepository.save(entity);
	}
	
	@Transactional
	public Iterable<OrganisationUnit_PostalAddress> save(Iterable<OrganisationUnit_PostalAddress> entities) {
		return linkOrganisationUnitPAddrCrudRepository.save(entities);
	}
	
	@Transactional
	public void delete(OrganisationUnit_PostalAddress entity) {
		linkOrganisationUnitPAddrCrudRepository.delete(entity);
	}

	@Transactional
	public void delete(Iterable<? extends OrganisationUnit_PostalAddress> entityList) {
		linkOrganisationUnitPAddrCrudRepository.delete(entityList);
	}

	@Override
	public List<OrganisationUnit_PostalAddress> findByPostalAddress(
			PostalAddress postalAddress) {
		return linkOrganisationUnitPAddrCrudRepository.findByPostalAddress(postalAddress);
	}

	@Override
	public List<OrganisationUnit_PostalAddress> findByOrganisationUnit(
			OrganisationUnit organisationUnit) {
		return linkOrganisationUnitPAddrCrudRepository.findByOrganisationUnit(organisationUnit);
	}

}
