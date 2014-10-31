package gr.ekt.cerif.services.additional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import gr.ekt.cerif.features.additional.FormalisedDublinCoreRightsManagementRights;

@Component
public class FormalisedDublinCoreRightsManagementRightsRepositoryImpl implements
		FormalisedDublinCoreRightsManagementRightsRepository {
	
	private static final Logger log = LoggerFactory.getLogger(FormalisedDublinCoreRightsManagementRightsRepositoryImpl.class);
	
	@Autowired
	private FormalisedDublinCoreRightsManagementRightsCrudRepository formalisedDublinCoreRightsManagementRightsCrudRepository;

	@Override
	public void delete(FormalisedDublinCoreRightsManagementRights entity) {
		formalisedDublinCoreRightsManagementRightsCrudRepository.delete(entity);
	}

	@Override
	public void delete(
			Iterable<FormalisedDublinCoreRightsManagementRights> entities) {
		formalisedDublinCoreRightsManagementRightsCrudRepository.delete(entities);
	}

	@Override
	public Iterable<FormalisedDublinCoreRightsManagementRights> save(
			Iterable<FormalisedDublinCoreRightsManagementRights> entities) {
		return formalisedDublinCoreRightsManagementRightsCrudRepository.save(entities);
	}

	@Override
	public FormalisedDublinCoreRightsManagementRights save(
			FormalisedDublinCoreRightsManagementRights entity) {
		return formalisedDublinCoreRightsManagementRightsCrudRepository.save(entity);
	}

}
