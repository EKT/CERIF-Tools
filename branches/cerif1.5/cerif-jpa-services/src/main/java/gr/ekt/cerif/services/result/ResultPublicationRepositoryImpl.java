package gr.ekt.cerif.services.result;

import gr.ekt.cerif.entities.link.organisationunit.OrganisationUnit_ResultPublication;
import gr.ekt.cerif.entities.link.person.Person_ResultPublication;
import gr.ekt.cerif.entities.link.project.Project_ResultPublication;
import gr.ekt.cerif.entities.link.result.ResultPublication_Class;
import gr.ekt.cerif.entities.link.result.ResultPublication_Event;
import gr.ekt.cerif.entities.link.result.ResultPublication_Medium;
import gr.ekt.cerif.entities.result.ResultPublication;
import gr.ekt.cerif.features.multilingual.ResultPublicationAbstract;
import gr.ekt.cerif.features.multilingual.ResultPublicationTitle;
import gr.ekt.cerif.services.link.organisationunit.LinkOrganisationUnitResultPublicationRepository;
import gr.ekt.cerif.services.link.person.LinkPersonResultPublicationRepository;
import gr.ekt.cerif.services.link.project.LinkProjectResultPublicationRepository;
import gr.ekt.cerif.services.link.result.LinkResultPublicationClassRepository;
import gr.ekt.cerif.services.link.result.LinkResultPublicationEventRepository;
import gr.ekt.cerif.services.link.result.LinkResultPublicationMediumRepository;
import gr.ekt.cerif.services.multilingual.resultpublication.ResultPublicationAbstractRepository;
import gr.ekt.cerif.services.multilingual.resultpublication.ResultPublicationTitleRepository;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class ResultPublicationRepositoryImpl implements ResultPublicationRepository {

	private static final Logger log = LoggerFactory.getLogger(ResultPublicationRepositoryImpl.class);
	
	@Autowired
	private ResultPublicationCrudRepository resultPublicationCrudRepository;
	
	@Autowired
	private ResultPublicationTitleRepository resultPublicationTitleRepository;
	
	@Autowired
	private ResultPublicationAbstractRepository resultPublicationAbstractRepository;
	
	@Autowired
	private LinkResultPublicationClassRepository linkResultPublicationClassRepository;
	
	@Autowired
	private LinkOrganisationUnitResultPublicationRepository linkOrganisationUnitResultPublicationRepository;
	
	@Autowired
	private LinkProjectResultPublicationRepository linkProjectResultPublicationRepository;
	
	@Autowired
	private LinkPersonResultPublicationRepository linkPersonResultPublicationRepository;
	
	@Autowired
	private LinkResultPublicationEventRepository linkResultPublicationEventRepository;
	
	@Autowired
	private LinkResultPublicationMediumRepository linkResultPublicationMediumRepository;
	
	public ResultPublication findByUri(String uri) {
		return resultPublicationCrudRepository.findByUri(uri);
	}

	public ResultPublication findById(Long id) {
		return resultPublicationCrudRepository.findById(id);
	}
	
	
	@Transactional
	public void delete(ResultPublication entity) {
		
		ResultPublicationTitle rt = resultPublicationTitleRepository.findByResultPublication(entity);
		if (rt != null) resultPublicationTitleRepository.delete(rt);
		entity.setResultPublicationTitles(null);
		
		ResultPublicationAbstract ra = resultPublicationAbstractRepository.findByResultPublication(entity);
		if (ra != null) resultPublicationAbstractRepository.delete(ra);
		entity.setResultPublicationAbstracts(null);

		List<ResultPublication_Class> rc =  linkResultPublicationClassRepository.findByResultPublication(entity);
		if (rc != null) linkResultPublicationClassRepository.delete(rc);
		entity.setResultPublications_classes(null);
		
		List<OrganisationUnit_ResultPublication> or = linkOrganisationUnitResultPublicationRepository.findByResultPublication(entity);
		if (or != null) linkOrganisationUnitResultPublicationRepository.delete(or);
		entity.setOrganisationUnit_ResultPublication(null);
		
		List<Project_ResultPublication> pr = linkProjectResultPublicationRepository.findByResultPublication(entity);
		if (pr != null) linkProjectResultPublicationRepository.delete(pr);
		entity.setProjects_resultPublications(null);
		
		List<Person_ResultPublication> prp = linkPersonResultPublicationRepository.findByResultPublication(entity);
		if (prp != null) linkPersonResultPublicationRepository.delete(prp);
		entity.setPersons_resultPublications(null);

		List<ResultPublication_Event> re = linkResultPublicationEventRepository.findByResultPublication(entity);
		if (re != null) linkResultPublicationEventRepository.delete(re);
		entity.setResultPublications_events(null);
		
		List<ResultPublication_Medium> rm = linkResultPublicationMediumRepository.findByResultPublication(entity);
		if (rm != null) linkResultPublicationMediumRepository.delete(rm);
		entity.setResultPublications_medium(null);
		
		entity = resultPublicationCrudRepository.save(entity);
		resultPublicationCrudRepository.delete(entity);
	}

	@Transactional
	public Iterable<ResultPublication> save(Iterable<ResultPublication> entities) {
		return resultPublicationCrudRepository.save(entities);
	}

	@Transactional
	public ResultPublication save(ResultPublication entity) {
		return resultPublicationCrudRepository.save(entity);
	}

	@Override
	public void delete(Iterable<ResultPublication> entities) {
		resultPublicationCrudRepository.delete(entities);		
	}

}
