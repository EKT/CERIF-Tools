package gr.ekt.cerif.services.link.postaladdress;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import gr.ekt.cerif.entities.link.PostalAddress_Class;
import gr.ekt.cerif.entities.second.PostalAddress;
import gr.ekt.cerif.features.semantics.Class;

@Component
public class LinkPostalAddressClassRepositoryImpl implements
		LinkPostalAddressClassRepository {
	
	private static final Logger log = LoggerFactory.getLogger(LinkPostalAddressClassRepositoryImpl.class);
	
	@Autowired
	private LinkPostalAddressClassCrudRepository linkPostalAddressClassCrudRepository;

	@Override
	public void delete(PostalAddress_Class entity) {
		linkPostalAddressClassCrudRepository.delete(entity);
	}

	@Override
	public void delete(Iterable<PostalAddress_Class> entities) {
		linkPostalAddressClassCrudRepository.delete(entities);
	}

	@Override
	public Iterable<PostalAddress_Class> save(
			Iterable<PostalAddress_Class> entities) {
		return linkPostalAddressClassCrudRepository.save(entities);
	}

	@Override
	public PostalAddress_Class save(PostalAddress_Class entity) {
		return linkPostalAddressClassCrudRepository.save(entity);
	}

	@Override
	public List<PostalAddress_Class> findByPostalAddress(
			PostalAddress postalAddress) {
		return linkPostalAddressClassCrudRepository.findByPostalAddress(postalAddress);
	}

	@Override
	public List<PostalAddress_Class> findByTheClass(Class theClass) {
		return linkPostalAddressClassCrudRepository.findByTheClass(theClass);
	}

}
