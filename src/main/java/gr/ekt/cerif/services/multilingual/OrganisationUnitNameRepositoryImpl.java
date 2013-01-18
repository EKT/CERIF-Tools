package gr.ekt.cerif.services.multilingual;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import gr.ekt.cerif.entities.base.OrganisationUnit;
import gr.ekt.cerif.features.multilingual.OrganisationUnitName;

@Component
public class OrganisationUnitNameRepositoryImpl implements OrganisationUnitNameRepository{

	@Autowired
	private OrganisationUnitNameCrudRepository organisationUnitNameCrudRepository;
	
	public OrganisationUnitName findByOrganisationUnit(	OrganisationUnit organisationUnit) {
		return organisationUnitNameCrudRepository.findByOrganisationUnit(organisationUnit);
	}

	@Transactional
	public OrganisationUnitName save(OrganisationUnitName entity) {
		return organisationUnitNameCrudRepository.save(entity);
	}

	@Transactional
	public Iterable<? extends OrganisationUnitName> save(Iterable<? extends OrganisationUnitName> entities) {
		return organisationUnitNameCrudRepository.save(entities);
	}

	@Transactional
	public void delete(OrganisationUnitName entity) {
		organisationUnitNameCrudRepository.delete(entity);
	}

}
