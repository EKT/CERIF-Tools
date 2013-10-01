package gr.ekt.cerif.services.link.postaladdress;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import gr.ekt.cerif.entities.link.PostalAddress_GeographicBoundingBox;

@Component
public class LinkPostalAddressGeographicBoundingBoxRepositoryImpl implements
		LinkPostalAddressGeographicBoundingBoxRepository {
	
	private static final Logger log = LoggerFactory.getLogger(LinkPostalAddressGeographicBoundingBoxRepositoryImpl.class);
	
	@Autowired
	private LinkPostalAddressGeographicBoundingBoxCrudRepository linkPostalAddressGeographicBoundingBoxCrudRepository;

	@Override
	public void delete(PostalAddress_GeographicBoundingBox entity) {
		linkPostalAddressGeographicBoundingBoxCrudRepository.delete(entity);
	}

	@Override
	public void delete(Iterable<PostalAddress_GeographicBoundingBox> entities) {
		linkPostalAddressGeographicBoundingBoxCrudRepository.save(entities);
	}

	@Override
	public Iterable<PostalAddress_GeographicBoundingBox> save(
			Iterable<PostalAddress_GeographicBoundingBox> entities) {
		return linkPostalAddressGeographicBoundingBoxCrudRepository.save(entities);
	}

	@Override
	public PostalAddress_GeographicBoundingBox save(
			PostalAddress_GeographicBoundingBox entity) {
		return linkPostalAddressGeographicBoundingBoxCrudRepository.save(entity);
	}

}
