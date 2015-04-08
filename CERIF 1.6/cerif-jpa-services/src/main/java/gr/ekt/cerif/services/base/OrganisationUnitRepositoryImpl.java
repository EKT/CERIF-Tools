/**
 * 
 */
package gr.ekt.cerif.services.base;

import gr.ekt.cerif.entities.base.OrganisationUnit;
import gr.ekt.cerif.enumerations.semantics.ClassEnum;
import gr.ekt.cerif.services.second.SecondPersistenceService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * 
 */
@Component
public class OrganisationUnitRepositoryImpl implements OrganisationUnitRepository {
	
	private static final Logger log = LoggerFactory.getLogger(OrganisationUnitRepositoryImpl.class);
	
	@Autowired
	private OrganisationUnitCrudRepository organisationUnitCrudRepository;
	
	@Autowired
	private SecondPersistenceService secondService;
	
	
	@Override
	@Transactional
	public OrganisationUnit save(OrganisationUnit organisation) {
		return organisationUnitCrudRepository.save(organisation);
	}

	@Override
	@Transactional
	public Iterable<OrganisationUnit> save(Iterable<OrganisationUnit> entities) {
		return organisationUnitCrudRepository.save(entities);
	}
	
	@Override
	public OrganisationUnit findById(Long id) {
		return organisationUnitCrudRepository.findById(id);
	}
	
	@Override
	public OrganisationUnit findByUri(String uri) {
		return organisationUnitCrudRepository.findByUri(uri);
	}

	@Override
	public OrganisationUnit findByAcronym(String acronym) {
		return organisationUnitCrudRepository.findByAcronym(acronym);
	}
	

	@Override
	@Transactional
	public void delete(OrganisationUnit entity) {
		organisationUnitCrudRepository.delete(entity);
	}

	@Override
	public Iterable<OrganisationUnit> findAll() {
		return organisationUnitCrudRepository.findAll();
	}
	
	@Override
	public void delete(Iterable<OrganisationUnit> entities) {
		organisationUnitCrudRepository.delete(entities);		
	}

	@Override
	public Page<OrganisationUnit> findAll(Pageable page) {
		return organisationUnitCrudRepository.findAll(page);
	}

	@Override
	public OrganisationUnit findByUuid(String uuid) {
		return organisationUnitCrudRepository.findByUuid(uuid);
	}

	/*
	 * (non-Javadoc)
	 * @see gr.ekt.cerif.services.base.OrganisationUnitRepository#findByUuidFetchMultilingual(java.lang.String)
	 */
	@Override
	public OrganisationUnit findByUuidFetchMultilingual(String uuid) {
		return organisationUnitCrudRepository.findByUuidFetchMultilingual(uuid);
	}
	
	/*
	 * (non-Javadoc)
	 * @see gr.ekt.cerif.services.base.OrganisationUnitRepository#findByUuidFetchMultilingualAndFederatedIds(java.lang.String)
	 */
	@Override
	public OrganisationUnit findByUuidFetchMultilingualAndFederatedIds(String uuid) {
		OrganisationUnit organisation = findByUuidFetchMultilingual(uuid);
		if (organisation != null) {
			organisation.setFederatedIdentifiers(secondService.getFederatedIdentifiersForEntity(ClassEnum.ORGANISATION.getUuid(), organisation.getId()));
		}
		return organisation;
	}

}
