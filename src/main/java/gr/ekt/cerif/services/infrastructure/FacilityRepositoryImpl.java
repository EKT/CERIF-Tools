package gr.ekt.cerif.services.infrastructure;

import gr.ekt.cerif.entities.base.OrganisationUnit;
import gr.ekt.cerif.entities.infrastructure.Facility;
import gr.ekt.cerif.entities.infrastructure.FacilityList;
import gr.ekt.cerif.entities.infrastructure.FacilityView;
import gr.ekt.cerif.entities.link.Facility_Class;
import gr.ekt.cerif.entities.link.Facility_Facility;
import gr.ekt.cerif.entities.link.Facility_Funding;
import gr.ekt.cerif.entities.link.Funding_Class;
import gr.ekt.cerif.entities.link.organisationunit.OrganisationUnit_Facility;
import gr.ekt.cerif.entities.second.Country;
import gr.ekt.cerif.entities.second.PostalAddress;
import gr.ekt.cerif.features.semantics.Class;
import gr.ekt.cerif.services.link.LinkFacilityClassRepository;
import gr.ekt.cerif.services.link.LinkFacilityFacilityRepository;
import gr.ekt.cerif.services.link.LinkFacilityFundingRepository;
import gr.ekt.cerif.services.link.LinkFundingClassRepository;
import gr.ekt.cerif.services.link.organisationunit.LinkOrganisationUnitFacilityRepository;
import gr.ekt.cerif.services.link.organisationunit.LinkOrganisationUnitPostalAddressRepository;
import gr.ekt.cerif.services.second.CountryRepository;
import gr.ekt.cerif.services.second.PostalAddressRepository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class FacilityRepositoryImpl implements FacilityRepository {

	@Autowired
	FacilityCrudRepository facilityCrudRepository;
	
	@Autowired
	private LinkFacilityClassRepository linkFacilityClassRepository;
	
	@Autowired
	private LinkFundingClassRepository linkFundingClassRepository;
	
	@Autowired
	private LinkFacilityFundingRepository linkFacilityFundingRepository;
	
	@Autowired
	private CountryRepository countryRepository;
	
	@Autowired
	private PostalAddressRepository postalAddressRepository;
	
	@Autowired
	private LinkOrganisationUnitPostalAddressRepository linkOrganisationUnitPAddrRepository;
	
	@Autowired
	private LinkOrganisationUnitFacilityRepository linkOrganisationUnitFacilityRepository;
	
	@Autowired
	private LinkFacilityFacilityRepository linkFacilityFacilityRepository;
	
	public Facility findById(Long id) {
		return facilityCrudRepository.findById(id);
	}

	public Facility findByAcronym(String acronym) {
		return facilityCrudRepository.findByAcronym(acronym);
	}

	public List<FacilityList> findAllFacilities() {
		return facilityCrudRepository.findAllFacilities();
	}

	public List<FacilityList> findByCountry(String country) {
		return facilityCrudRepository.findByCountry(country);
	}

	public Object[] findOrgUnitByFacilityId(Long id) {
		return facilityCrudRepository.findOrgUnitByFacilityId(id);
	}

	public Object findOrgUnitCountryByOrgUnitId(Long id) {
		return facilityCrudRepository.findOrgUnitCountryByOrgUnitId(id);
	}

	public Object[] findPersonNameByFacilityId(Long id) {
		return facilityCrudRepository.findPersonNameByFacilityId(id);
	}

	public Object findPersonEmailByPersonId(Long id) {
		return facilityCrudRepository.findPersonEmailByPersonId(id);
	}

	public FacilityView findByFacilityId(Long id) {
		return facilityCrudRepository.findByFacilityId(id);
	}

	public Object findFacilityAcronymByFacilityId(Long id) {
		return facilityCrudRepository.findFacilityAcronymByFacilityId(id);
	}

	public FacilityView findByFacilityIdNoOrg(Long id) {
		return facilityCrudRepository.findByFacilityIdNoOrg(id);
	}

	public List<FacilityList> findByClass(String classUri) {
		return facilityCrudRepository.findByClass(classUri);
	}

	public List<FacilityList> findByFundingClass(String classUri) {
		return facilityCrudRepository.findByFundingClass(classUri);
	}

	public List<FacilityList> findByLinkFacilityFundingClass(String classUri) {
		return facilityCrudRepository.findByLinkFacilityFundingClass(classUri);
	}

	public List<FacilityList> findByClassAndLinkFacility(String classUri, String facilityURI) {
		return facilityCrudRepository.findByClassAndLinkFacility(classUri, facilityURI);
	}

	public List<FacilityList> findByTitleOrAcronymOrDescription(String query) {
		return facilityCrudRepository.findByTitleOrAcronymOrDescription(query);
	}

	public List<Object[]> countByFacilityClass(String schemeUri) {
		return facilityCrudRepository.countByFacilityClass(schemeUri);
	}

	public List<Object[]> countByFundingClass(String schemeUri) {
		return facilityCrudRepository.countByFundingClass(schemeUri);
	}

	public List<Object[]> countByLinkFacilityFundingClass(String schemeUri) {
		return facilityCrudRepository.countByLinkFacilityFundingClass(schemeUri);
	}

	public List<Object[]> countByCountry() {
		return facilityCrudRepository.countByCountry();
	}

	public List<FacilityList> findByFocusAreaAndOrigin(String focusAreaUri, String originUri) {
		return facilityCrudRepository.findByFocusAreaAndOrigin(focusAreaUri, originUri);
	}

	public List<FacilityList> findByOrigin(String originUri) {
		return facilityCrudRepository.findByOrigin(originUri);
	}

	public List<FacilityList> findByCollaborationTypeAndLinkFacilityAndFocusArea(String collaborationUri, String facilityURI, String focusAreaURI) {
		return facilityCrudRepository.findByCollaborationTypeAndLinkFacilityAndFocusArea(collaborationUri, facilityURI, focusAreaURI);
	}

	public List<FacilityList> findByCollaborationTypeAndLinkFacility(String collaborationUri, String facilityURI) {
		return facilityCrudRepository.findByCollaborationTypeAndLinkFacility(collaborationUri, facilityURI);
	}

	
	public List<Facility> findByClass(Class theClass){
		List<Facility_Class> facilities_classes = linkFacilityClassRepository.findByTheClass(theClass);
		
		List<Facility> facilities = new ArrayList<Facility>();
		for(Facility_Class fc:facilities_classes){
				facilities .add(fc.getFacility());
		}
		return facilities;
	}

	@Override
	public List<Facility> findByFundingClass(Class theClass) {
		List<Funding_Class> fundingClasses = linkFundingClassRepository.findByTheClass(theClass);
		List<Facility> facilities = new ArrayList<Facility>();
		List<Facility_Funding> facilityFundings = new ArrayList<Facility_Funding>();
		
		if(fundingClasses!=null && !fundingClasses.isEmpty()){
			for (Funding_Class fc:fundingClasses){				
				List<Facility_Funding> tmp = linkFacilityFundingRepository.findByFunding(fc.getFunding());
				
				facilityFundings.addAll(tmp);
			}
		}
		if(facilityFundings!=null && !facilityFundings.isEmpty()){
			for(Facility_Funding ff:facilityFundings){
				facilities.add(ff.getFacility());
			}
		}
		return facilities;
	}

	@Override
	public List<Facility> findByCountry2(String countryUri) {
		Country country = countryRepository.findByUri(countryUri);
		List<PostalAddress> pAddrs = postalAddressRepository.findByCountry(country);
		List<OrganisationUnit> orgs = new ArrayList<OrganisationUnit>();
		
		for(PostalAddress pa:pAddrs){
			orgs.add(linkOrganisationUnitPAddrRepository.findByPostalAddress(pa).get(0).getOrganisationUnit());
		}
		
		List<Facility> facilities = new ArrayList<Facility>();
		for(OrganisationUnit org:orgs) {
			for (OrganisationUnit_Facility ouf : linkOrganisationUnitFacilityRepository.findByOrganisationUnit(org)) {
				facilities.add(ouf.getFacility());
			}
		}
		return facilities;
	}

	@Override
	public List<Facility> findByClassAndLinkFacility(Class theClass, Facility facility) {
		List<Facility_Facility> fac_fac = linkFacilityFacilityRepository.findByTheClass(theClass);
		
		List<Facility> facilities = new ArrayList<Facility>();		
		
		for(Facility_Facility ff:fac_fac){
			
			if(ff.getFacility1().equals(facility) || ff.getFacility2().equals(facility) || ff.getFacility1().getId() == facility.getId() || ff.getFacility2().getId() == facility.getId()){
				if(ff.getFacility1().equals(facility) || ff.getFacility1().getId() == facility.getId()){
					facilities.add(ff.getFacility2());
				}
				if(ff.getFacility2().equals(facility) || ff.getFacility2().getId() == facility.getId()){
					facilities.add(ff.getFacility1());
				}
			}
		}
		
		return facilities;
	}

	@Transactional
	public void delete(Facility entity) {
		facilityCrudRepository.delete(entity);
	}

	@Transactional
	public Iterable<Facility> save(Iterable<Facility> entities) {
		return facilityCrudRepository.save(entities);
	}

	@Transactional
	public Facility save(Facility entity) {
		return facilityCrudRepository.save(entity);
	}

	public Iterable<Facility> findAll() {
		return facilityCrudRepository.findAll();
	}

}
