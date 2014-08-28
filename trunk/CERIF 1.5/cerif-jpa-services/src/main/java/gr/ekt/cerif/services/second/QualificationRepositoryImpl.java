/**
 * 
 */
package gr.ekt.cerif.services.second;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import gr.ekt.cerif.entities.link.Qualification_Class;
import gr.ekt.cerif.entities.link.person.Person_Qualification;
import gr.ekt.cerif.entities.second.Qualification;
import gr.ekt.cerif.features.multilingual.QualificationDescription;
import gr.ekt.cerif.features.multilingual.QualificationKeyword;
import gr.ekt.cerif.features.multilingual.QualificationTitle;
import gr.ekt.cerif.services.link.person.LinkPersonQualificationRepository;
import gr.ekt.cerif.services.link.qualification.LinkQualificationClassRepository;
import gr.ekt.cerif.services.multilingual.qualification.QualificationDescriptionRepository;
import gr.ekt.cerif.services.multilingual.qualification.QualificationKeywordRepository;
import gr.ekt.cerif.services.multilingual.qualification.QualificationTitleRepository;

/**
 * @author bonisv
 *
 */
@Component
public class QualificationRepositoryImpl implements QualificationRepository {

	private static final Logger log = LoggerFactory.getLogger(QualificationRepositoryImpl.class);

	@Autowired
	private QualificationCrudRepository qualificationCrudRepository;
	
	@Autowired
	private LinkPersonQualificationRepository linkPersonQualificationRepository;
	
	@Autowired
	private QualificationTitleRepository qualificationTitleRepository;
	
	@Autowired
	private QualificationKeywordRepository qualificationKeywordRepository;
	
	@Autowired
	private QualificationDescriptionRepository qualificationDescriptionRepository;
	
	@Autowired
	private LinkQualificationClassRepository linkQualificationClassRepository;
	
	
	
	/* (non-Javadoc)
	 * @see gr.ekt.cerif.services.second.QualificationRepository#delete(gr.ekt.cerif.entities.second.Qualification)
	 */
	@Override
	@Transactional
	public void delete(Qualification entity) {
		List<Person_Qualification> pqual = linkPersonQualificationRepository.findByQualification(entity);
		if (pqual != null) linkPersonQualificationRepository.delete(pqual);
		entity.setPersons_qualifications(null);
		
		List<QualificationTitle> qualtitle = qualificationTitleRepository.findByQualification(entity);
		if (qualtitle != null) qualificationTitleRepository.delete(qualtitle);
		entity.setQualificationTitles(null);
		
		List<QualificationKeyword> qualkey = qualificationKeywordRepository.findByQualification(entity);
		if (qualkey != null) qualificationKeywordRepository.delete(qualkey);
		entity.setQualificationKeywords(null);
		
		List<QualificationDescription> qualdescr = qualificationDescriptionRepository.findByQualification(entity);
		if (qualdescr != null) qualificationDescriptionRepository.delete(qualdescr);
		entity.setQualificationDescriptions(null);
		
		List<Qualification_Class> qualcl = linkQualificationClassRepository.findByQualification(entity);
		if (qualcl != null) linkQualificationClassRepository.delete(qualcl);
		entity.setQualifications_classes(null);
		
		entity = qualificationCrudRepository.save(entity);
		qualificationCrudRepository.delete(entity);
	}

	/* (non-Javadoc)
	 * @see gr.ekt.cerif.services.second.QualificationRepository#delete(java.lang.Iterable)
	 */
	@Override
	public void delete(Iterable<Qualification> entities) {
		qualificationCrudRepository.delete(entities);
	}

	/* (non-Javadoc)
	 * @see gr.ekt.cerif.services.second.QualificationRepository#save(java.lang.Iterable)
	 */
	@Override
	public Iterable<Qualification> save(Iterable<Qualification> entities) {
		return qualificationCrudRepository.save(entities);
	}

	/* (non-Javadoc)
	 * @see gr.ekt.cerif.services.second.QualificationRepository#save(gr.ekt.cerif.entities.second.Qualification)
	 */
	@Override
	public Qualification save(Qualification entity) {
		return qualificationCrudRepository.save(entity);
	}

}
