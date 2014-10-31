package gr.ekt.cerif.services.base;

import gr.ekt.cerif.entities.base.OrganisationUnit;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface OrganisationUnitRepository {
	
	OrganisationUnit findById(Long id);
	
	OrganisationUnit findByUri(String uri);
	
	OrganisationUnit findByAcronym(String acronym);
	
	void delete(OrganisationUnit entity);
	
	void delete(Iterable<OrganisationUnit> entities);
	
	Iterable<OrganisationUnit> save(Iterable<OrganisationUnit> entities);
	
	OrganisationUnit save(OrganisationUnit entity);
	
	Iterable<OrganisationUnit> findAll();
	
	Page<OrganisationUnit> findAll(Pageable page);
	
	OrganisationUnit findByUUID(String uuid);
}
