/**
 * 
 */
package gr.ekt.cerif.services.multilingual.organisationunit;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import gr.ekt.cerif.entities.base.OrganisationUnit;
import gr.ekt.cerif.features.multilingual.OrganisationUnitKeyword;


/**
 * @author bonisv
 *
 */
@Component
public class OrganisationUnitKeywordRepositoryImpl implements OrganisationUnitKeywordRepository{
	
	private static final Logger log = LoggerFactory.getLogger(OrganisationUnitKeywordRepositoryImpl.class);
	
	@Autowired
	private OrganisationUnitKeywordCrudRepository organisationUnitKeywordCrudRepository;

	@Override
	public void delete(OrganisationUnitKeyword entity) {
		organisationUnitKeywordCrudRepository.delete(entity);
	}

	@Override
	public void delete(Iterable<OrganisationUnitKeyword> entities) {
		organisationUnitKeywordCrudRepository.delete(entities);
	}

	@Override
	public Iterable<OrganisationUnitKeyword> save(Iterable<OrganisationUnitKeyword> entities) {
		return organisationUnitKeywordCrudRepository.save(entities);
	}

	@Override
	public OrganisationUnitKeyword save(OrganisationUnitKeyword entity) {
		return organisationUnitKeywordCrudRepository.save(entity);
	}

	@Override
	public List<OrganisationUnitKeyword> findByOrganisationUnit(
			OrganisationUnit organisationUnit) {
		return organisationUnitKeywordCrudRepository.findByOrganisationUnit(organisationUnit);
	}

}
