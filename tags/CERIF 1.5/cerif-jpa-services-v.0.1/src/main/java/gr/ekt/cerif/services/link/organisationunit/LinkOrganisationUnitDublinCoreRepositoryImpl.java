package gr.ekt.cerif.services.link.organisationunit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import gr.ekt.cerif.entities.link.organisationunit.OrganisationUnit_DublinCore;

@Component
public class LinkOrganisationUnitDublinCoreRepositoryImpl implements
		LinkOrganisationUnitDublinCoreRepository {
	
	private static final Logger log = LoggerFactory.getLogger(LinkOrganisationUnitDublinCoreRepositoryImpl.class);
	
	@Autowired
	private LinkOrganisationUnitDublinCoreCrudRepository linkOrganisationUnitDublinCoreCrudRepository;

	@Override
	public void delete(OrganisationUnit_DublinCore entity) {
		linkOrganisationUnitDublinCoreCrudRepository.delete(entity);
	}

	@Override
	public void delete(Iterable<OrganisationUnit_DublinCore> entities) {
		linkOrganisationUnitDublinCoreCrudRepository.delete(entities);
	}

	@Override
	public Iterable<OrganisationUnit_DublinCore> save(
			Iterable<OrganisationUnit_DublinCore> entities) {
		return linkOrganisationUnitDublinCoreCrudRepository.save(entities);
	}

	@Override
	public OrganisationUnit_DublinCore save(OrganisationUnit_DublinCore entity) {
		return linkOrganisationUnitDublinCoreCrudRepository.save(entity);
	}

}
