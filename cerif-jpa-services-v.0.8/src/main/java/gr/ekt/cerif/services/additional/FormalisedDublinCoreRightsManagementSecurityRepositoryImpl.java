package gr.ekt.cerif.services.additional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import gr.ekt.cerif.features.additional.FormalisedDublinCoreRightsManagementSecurity;

@Component
public class FormalisedDublinCoreRightsManagementSecurityRepositoryImpl
		implements FormalisedDublinCoreRightsManagementSecurityRepository {
	
	private static final Logger log = LoggerFactory.getLogger(FormalisedDublinCoreRightsManagementSecurityRepositoryImpl.class);
	
	@Autowired
	private FormalisedDublinCoreRightsManagementSecurityCrudRepository formalisedDublinCoreRightsManagementSecurityCrudRepository;

	@Override
	public void delete(FormalisedDublinCoreRightsManagementSecurity entity) {
		formalisedDublinCoreRightsManagementSecurityCrudRepository.delete(entity);
	}

	@Override
	public void delete(
			Iterable<FormalisedDublinCoreRightsManagementSecurity> entities) {
		formalisedDublinCoreRightsManagementSecurityCrudRepository.delete(entities);
	}

	@Override
	public Iterable<FormalisedDublinCoreRightsManagementSecurity> save(
			Iterable<FormalisedDublinCoreRightsManagementSecurity> entities) {
		return formalisedDublinCoreRightsManagementSecurityCrudRepository.save(entities);
	}

	@Override
	public FormalisedDublinCoreRightsManagementSecurity save(
			FormalisedDublinCoreRightsManagementSecurity entity) {
		return formalisedDublinCoreRightsManagementSecurityCrudRepository.save(entity);
	}

}
