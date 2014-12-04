package gr.ekt.cerif.services.link.organisationunit;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import gr.ekt.cerif.entities.base.OrganisationUnit;
import gr.ekt.cerif.entities.link.organisationunit.OrganisationUnit_ResultProduct;
import gr.ekt.cerif.entities.result.ResultProduct;

@Component
public class LinkOrganisationUnitResultProductRepositoryImpl implements LinkOrganisationUnitResultProductRepository {
	
	private static final Logger log = LoggerFactory.getLogger(LinkOrganisationUnitResultProductRepositoryImpl.class);
	
	@Autowired
	private LinkOrganisationUnitResultProductCrudRepository linkOrganisationUnitResultProductCrudRepository;

	@Override
	public void delete(OrganisationUnit_ResultProduct entity) {
		linkOrganisationUnitResultProductCrudRepository.delete(entity);		
	}

	@Override
	public void delete(Iterable<OrganisationUnit_ResultProduct> entities) {
		linkOrganisationUnitResultProductCrudRepository.delete(entities);		
	}

	@Override
	public Iterable<OrganisationUnit_ResultProduct> save(
			Iterable<OrganisationUnit_ResultProduct> entities) {
		return linkOrganisationUnitResultProductCrudRepository.save(entities);
	}

	@Override
	public OrganisationUnit_ResultProduct save(
			OrganisationUnit_ResultProduct entity) {
		return linkOrganisationUnitResultProductCrudRepository.save(entity);
	}

	@Override
	public List<OrganisationUnit_ResultProduct> findByOrganisationUnit(
			OrganisationUnit orgUnit) {
		return linkOrganisationUnitResultProductCrudRepository.findByOrganisationUnit(orgUnit);
	}

	@Override
	public List<OrganisationUnit_ResultProduct> findByResultProduct(
			ResultProduct resultProduct) {
		return linkOrganisationUnitResultProductCrudRepository.findByResultProduct(resultProduct);
	}

}
