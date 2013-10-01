package gr.ekt.cerif.services.base;

import gr.ekt.cerif.entities.base.OrganisationUnit;
import gr.ekt.cerif.transferobjects.OrganisationView;

import java.util.List;

public interface OrganisationUnitRepository {
	
	OrganisationUnit findById(Long id);
	
	List<OrganisationUnit> findById(List<Long> ids);
	
	OrganisationUnit findByUri(String uri);
	
	OrganisationUnit findByAcronym(String acronym);
	
	OrganisationUnit findByOrganisationUnitName(String organisationUnitName);
	
	void delete(OrganisationUnit entity);
	
	void delete(Iterable<OrganisationUnit> entities);
	
	Iterable<OrganisationUnit> save(Iterable<OrganisationUnit> entities);
	
	OrganisationUnit save(OrganisationUnit entity);
	
	Iterable<OrganisationUnit> findAll();
	
	List<OrganisationView> findAllOrganisations();
	
	List<OrganisationView> findOrganisationByProjectIdAndClassScheme(Long id, String classSchemeUri);
	
	OrganisationView findOrganisationById(Long Id);
	
	
}
