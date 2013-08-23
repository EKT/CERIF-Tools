package gr.ekt.cerif.services.additional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import gr.ekt.cerif.features.additional.FormalisedDublinCoreRightsManagementPrivacy;

@Component
public class FormalisedDublinCoreRightsManagementPrivacyRepositoryImpl
		implements FormalisedDublinCoreRightsManagementPrivacyRepository {
	
	private static final Logger log = LoggerFactory.getLogger(FormalisedDublinCoreRightsManagementPrivacyRepositoryImpl.class);
	
	@Autowired
	private FormalisedDublinCoreRightsManagementPrivacyCrudRepository formalisedDublinCoreRightsManagementPrivacyCrudRepository;

	@Override
	public void delete(FormalisedDublinCoreRightsManagementPrivacy entity) {
		formalisedDublinCoreRightsManagementPrivacyCrudRepository.delete(entity);
	}

	@Override
	public void delete(
			Iterable<FormalisedDublinCoreRightsManagementPrivacy> entities) {
		formalisedDublinCoreRightsManagementPrivacyCrudRepository.delete(entities);
	}

	@Override
	public Iterable<FormalisedDublinCoreRightsManagementPrivacy> save(
			Iterable<FormalisedDublinCoreRightsManagementPrivacy> entities) {
		return formalisedDublinCoreRightsManagementPrivacyCrudRepository.save(entities);
	}

	@Override
	public FormalisedDublinCoreRightsManagementPrivacy save(
			FormalisedDublinCoreRightsManagementPrivacy entity) {
		return formalisedDublinCoreRightsManagementPrivacyCrudRepository.save(entity);
	}

}
