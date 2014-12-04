package gr.ekt.cerif.services.link.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import gr.ekt.cerif.entities.infrastructure.Service;
import gr.ekt.cerif.entities.link.Service_PostalAddress;
import gr.ekt.cerif.entities.second.PostalAddress;

@Component
public class LinkServicePostalAddressRepositoryImpl implements
		LinkServicePostalAddressRepository {
	
	private static final Logger log = LoggerFactory.getLogger(LinkServicePostalAddressRepositoryImpl.class);
	
	@Autowired
	private LinkServicePostalAddressCrudRepository linkServicePostalAddressCrudRepository;

	@Override
	public void delete(Service_PostalAddress entity) {
		linkServicePostalAddressCrudRepository.delete(entity);
	}

	@Override
	public void delete(Iterable<Service_PostalAddress> entities) {
		linkServicePostalAddressCrudRepository.delete(entities);
	}

	@Override
	public Iterable<Service_PostalAddress> save(
			Iterable<Service_PostalAddress> entities) {
		return linkServicePostalAddressCrudRepository.save(entities);
	}

	@Override
	public Service_PostalAddress save(Service_PostalAddress entity) {
		return linkServicePostalAddressCrudRepository.save(entity);
	}

	@Override
	public List<Service_PostalAddress> findByPostalAddress(
			PostalAddress postalAddress) {
		return linkServicePostalAddressCrudRepository.findByPostalAddress(postalAddress);
	}

	@Override
	public List<Service_PostalAddress> findByService(Service service) {
		return linkServicePostalAddressCrudRepository.findByService(service);
	}

}
