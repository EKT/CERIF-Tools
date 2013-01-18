package gr.ekt.cerif.services.infrastructure;

import gr.ekt.cerif.entities.infrastructure.Facility;
import gr.ekt.cerif.entities.infrastructure.FacilityList;
import gr.ekt.cerif.entities.infrastructure.FacilityView;
import gr.ekt.cerif.features.semantics.Class;

import java.util.List;

public interface FacilityRepository {

	Facility findById(Long id);
	
	Facility findByAcronym(String acronym);
	
	List<FacilityList> findAllFacilities();
	
	List<FacilityList> findByCountry(String country);
	
	Object[] findOrgUnitByFacilityId(Long id);
	
	Object findOrgUnitCountryByOrgUnitId(Long id);
	
	Object[] findPersonNameByFacilityId(Long id);
	
	Object findPersonEmailByPersonId(Long id);
	
	FacilityView findByFacilityId(Long id);
	
	Object findFacilityAcronymByFacilityId(Long id);
	
	FacilityView findByFacilityIdNoOrg(Long id);
	
	List<FacilityList> findByClass(String classUri);
	
	List<FacilityList> findByFundingClass(String classUri);	
	
	List<FacilityList> findByLinkFacilityFundingClass(String classUri);
	
	List<FacilityList> findByClassAndLinkFacility(String classUri, String facilityURI);
	
	List<FacilityList> findByTitleOrAcronymOrDescription(String query);
	
	List<Object[]> countByFacilityClass(String schemeUri);
	
	List<Object[]> countByFundingClass(String schemeUri);
	
	List<Object[]> countByLinkFacilityFundingClass(String schemeUri);
	
	List<Object[]> countByCountry();
	
	List<FacilityList> findByFocusAreaAndOrigin(String focusAreaUri, String originUri);
	
	List<FacilityList> findByOrigin(String originUri);
	
	List<FacilityList> findByCollaborationTypeAndLinkFacilityAndFocusArea(String collaborationUri, String facilityURI, String focusAreaURI);
	
	List<FacilityList> findByCollaborationTypeAndLinkFacility(String collaborationUri, String facilityURI);
	
	public List<Facility> findByClass(Class theClass);

	public List<Facility> findByFundingClass(Class theClass);
	
	public List<Facility> findByCountry2(String countryUri);
	
	public List<Facility> findByClassAndLinkFacility(Class theClass, Facility facility);
	
	void delete(Facility entity);
	
	Iterable<Facility> save(Iterable<Facility> entities);
	
	Facility save(Facility entity);
	
	public Iterable<Facility> findAll();
	
}
