package gr.ekt.cerif.services.base;

import gr.ekt.cerif.entities.base.OrganisationUnit;
import gr.ekt.cerif.entities.base.OrganisationUnitList;
import gr.ekt.cerif.entities.base.OrganisationUnitView;
import gr.ekt.cerif.features.multilingual.OrganisationUnitName;

import java.util.List;

public interface OrganisationUnitRepository {
	
	OrganisationUnit updatePersonsByRole(Long organisationUnitId, List<Long> personIds, String classUri);
	
	OrganisationUnit updatePostalAddress(Long organisationUnitId, String address, String countryCode);
	
	OrganisationUnit updateOrganisationUnitName (Long organisationUnitId, String name);
	
	OrganisationUnit updateProjectsByRelation(Long organisationUnitId, List<Long> newPartnerProjectIds, String classUri);
	
	OrganisationUnit updatePartnerProjects(Long organisationUnitId, List<Long> partnerProjectIds);
	
	OrganisationUnit updateCoordinatorProjects(Long organisationUnitId, List<Long> coordinatorProjectIds);
	
	OrganisationUnit findById(Long id);
	
	OrganisationUnit findByUri(String uri);
	
	OrganisationUnit findByAcronym(String acronym);
	
	OrganisationUnit findByOrganisationUnitName(String organisationUnitName);
	
	OrganisationUnit findByOrganisationUnitNameAndOrgUri(String organisationUnitName, String orgUri);

	OrganisationUnit findByOrganisationUnitNameAndCountryCode(String organisationUnitName, String countryCode);

	OrganisationUnitName findByOrganisationUnitName2(String organisationUnitName);
	
	OrganisationUnitName findOrganisationUnitNamesById(Long id);
	
	List<OrganisationUnitView> findOrganisationUnitsByProjectId(Long Id);
	
	List<OrganisationUnitView> findOrganisationUnitsByProjectId(Long Id, String organisationstatus);
	
	List<OrganisationUnitView> findAllOrgs();
	
	List<OrganisationUnitView> findFavouriteOrgs(Long id);
	
	OrganisationUnitView findOrgById(Long id);
	
	List<OrganisationUnitList> findByPersonId(Long Id);
	
	List<OrganisationUnitList> findOrganisationUnitsByCountryCode(String code);
	
	List<OrganisationUnitList> findAllOrgs2();
	
	List<OrganisationUnitList> findCountryCodesForOrganisationUnits();
	
	List<OrganisationUnitList> findRINCP();
	
	List<OrganisationUnitList> findRIPolicyBody();
	
	List<OrganisationUnitList> findOtherSource();
	
	List<OrganisationUnitList> findEuropeanCommission();
	
	List<OrganisationUnitList> findAllSources();
	
	List<Object[]> findAllOrgsForAjax(String term);
	
	Object[] findOrgByIdForAjax(Long id);
	
	void delete(OrganisationUnit entity);
	
	Iterable<OrganisationUnit> save(Iterable<OrganisationUnit> entities);
	
	OrganisationUnit save(OrganisationUnit entity);
	
	Iterable<OrganisationUnit> findAll();
	
}
