package gr.ekt.cerif.services.multilingual.organisationunit;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import gr.ekt.cerif.entities.base.OrganisationUnit;
import gr.ekt.cerif.features.multilingual.OrganisationUnitName;

@Component
public class OrganisationUnitNameRepositoryImpl implements OrganisationUnitNameRepository{

	@Autowired
	private OrganisationUnitNameCrudRepository organisationUnitNameCrudRepository;
	
	public List<OrganisationUnitName> findByOrganisationUnit(	OrganisationUnit organisationUnit) {
		return organisationUnitNameCrudRepository.findByOrganisationUnit(organisationUnit);
	}

	@Transactional
	public OrganisationUnitName save(OrganisationUnitName entity) {
		return organisationUnitNameCrudRepository.save(entity);
	}

	@Transactional
	public void delete(OrganisationUnitName entity) {
		organisationUnitNameCrudRepository.delete(entity);
	}

	@Override
	public void delete(Iterable<OrganisationUnitName> entities) {
		organisationUnitNameCrudRepository.delete(entities);		
	}

	@Override
	public Iterable<OrganisationUnitName> save(Iterable<OrganisationUnitName> entities) {
		return organisationUnitNameCrudRepository.save(entities);
	}

}
