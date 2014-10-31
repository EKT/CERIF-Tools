package gr.ekt.cerif.services.link.facility;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import gr.ekt.cerif.entities.infrastructure.Facility;
import gr.ekt.cerif.entities.link.Facility_PostalAddress;
import gr.ekt.cerif.entities.second.PostalAddress;

@Component
public class LinkFacilityPostalAddressRepositoryImpl implements
		LinkFacilityPostalAddressRepository {
	
	private static final Logger log = LoggerFactory.getLogger(LinkFacilityPostalAddressRepositoryImpl.class);
	
	@Autowired
	private LinkFacilityPostalAddressCrudRepository linkFacilityPostalAddressCrudRepository;

	@Override
	public void delete(Facility_PostalAddress entity) {
		linkFacilityPostalAddressCrudRepository.delete(entity);
	}

	@Override
	public void delete(Iterable<Facility_PostalAddress> entities) {
		linkFacilityPostalAddressCrudRepository.save(entities);
	}

	@Override
	public Iterable<Facility_PostalAddress> save(
			Iterable<Facility_PostalAddress> entities) {
		return linkFacilityPostalAddressCrudRepository.save(entities);
	}

	@Override
	public Facility_PostalAddress save(Facility_PostalAddress entity) {
		return linkFacilityPostalAddressCrudRepository.save(entity);
	}

	@Override
	public List<Facility_PostalAddress> findByPostalAddress(
			PostalAddress postalAddress) {
		return linkFacilityPostalAddressCrudRepository.findByPostalAddress(postalAddress);
	}

	@Override
	public List<Facility_PostalAddress> findByFacility(Facility facility) {
		return linkFacilityPostalAddressCrudRepository.findByFacility(facility);
	}

}
