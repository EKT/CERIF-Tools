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

import gr.ekt.cerif.entities.link.Citation_Class;
import gr.ekt.cerif.entities.link.Citation_Medium;
import gr.ekt.cerif.entities.link.result.ResultPublication_Citation;
import gr.ekt.cerif.entities.second.Citation;
import gr.ekt.cerif.features.multilingual.CitationDescription;
import gr.ekt.cerif.features.multilingual.CitationTitle;
import gr.ekt.cerif.services.link.citation.LinkCitationClassRepository;
import gr.ekt.cerif.services.link.citation.LinkCitationMediumRepository;
import gr.ekt.cerif.services.link.result.LinkResultPublicationCitationRepository;
import gr.ekt.cerif.services.multilingual.citation.CitationDescriptionRepository;
import gr.ekt.cerif.services.multilingual.citation.CitationTitleRepository;

/**
 * @author bonisv
 *
 */
@Component
public class CitationRepositoryImpl implements CitationRepository {

	private static final Logger log = LoggerFactory.getLogger(CitationRepositoryImpl.class);
	
	@Autowired
	private CitationCrudRepository citationCrudRepository;
	
	@Autowired
	private CitationDescriptionRepository citationDescriptionRepository;
	
	@Autowired
	private CitationTitleRepository citationTitleRepository;
	
	@Autowired
	private LinkResultPublicationCitationRepository linkResultPublicationCitationRepository;
	
	@Autowired
	private LinkCitationClassRepository linkCitationClassRepository;
	
	@Autowired
	private LinkCitationMediumRepository linkCitationMediumRepository;
	
	
	
	@Override
	@Transactional
	public void delete(Citation entity) {		
		List<CitationDescription> citdescr = citationDescriptionRepository.findByCitation(entity);
		if (citdescr != null) citationDescriptionRepository.delete(citdescr);
		entity.setCitationDescriptions(null);
		
		List<CitationTitle> cittitle = citationTitleRepository.findByCitation(entity);
		if (cittitle != null) citationTitleRepository.delete(cittitle);
		entity.setCitationTitles(null);
		
		List<ResultPublication_Citation> respublcite = linkResultPublicationCitationRepository.findByCitation(entity);
		if (respublcite != null) linkResultPublicationCitationRepository.delete(respublcite);
		entity.setResultPublications_citations(null);
		
		List<Citation_Class> citcl = linkCitationClassRepository.findByCitation(entity);
		if (citcl != null) linkCitationClassRepository.delete(citcl);
		entity.setCitations_classes(null);
		
		List<Citation_Medium> citmed = linkCitationMediumRepository.findByCitation(entity);
		if (citmed != null) linkCitationMediumRepository.delete(citmed);
		entity.setCitations_mediums(null);
		
		entity = citationCrudRepository.save(entity);
		citationCrudRepository.delete(entity);		
	}

	@Override
	public void delete(Iterable<Citation> entities) {
		citationCrudRepository.delete(entities);		
	}

	@Override
	public Iterable<Citation> save(Iterable<Citation> entities) {
		return citationCrudRepository.save(entities);
	}

	@Override
	public Citation save(Citation entity) {
		return citationCrudRepository.save(entity);
	}

}
