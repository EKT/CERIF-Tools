package gr.ekt.cerif.services.infrastructure;

import gr.ekt.cerif.entities.infrastructure.Facility;
import gr.ekt.cerif.entities.link.Facility_Class;
import gr.ekt.cerif.entities.link.Facility_Funding;
import gr.ekt.cerif.entities.link.Funding_Class;
import gr.ekt.cerif.features.semantics.Class;
import gr.ekt.cerif.services.link.facility.LinkFacilityClassRepository;
import gr.ekt.cerif.services.link.facility.LinkFacilityFacilityRepository;
import gr.ekt.cerif.services.link.facility.LinkFacilityFundingRepository;
import gr.ekt.cerif.services.link.funding.LinkFundingClassRepository;
import gr.ekt.cerif.services.link.organisationunit.LinkOrganisationUnitFacilityRepository;
import gr.ekt.cerif.services.link.organisationunit.LinkOrganisationUnitPostalAddressRepository;
import gr.ekt.cerif.services.second.CountryRepository;
import gr.ekt.cerif.services.second.PostalAddressRepository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

	public List<Facility> findAll() {
		return facilityCrudRepository.findAll();
	}

	@Override
	public void delete(Iterable<Facility> entities) {
		facilityCrudRepository.delete(entities);		
	}

	@Override
	public Page<Facility> findAll(Pageable page) {
		return facilityCrudRepository.findAll(page);
	}

	@Override
	public Facility findByUUID(String uuid) {
		return facilityCrudRepository.findByUuid(uuid);
	}

}
