/**
 * 
 */
package gr.ekt.cerif.services.second;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import gr.ekt.cerif.entities.link.Prize_Class;
import gr.ekt.cerif.entities.link.organisationunit.OrganisationUnit_Prize;
import gr.ekt.cerif.entities.link.person.Person_Prize;
import gr.ekt.cerif.entities.link.project.Project_Prize;
import gr.ekt.cerif.entities.second.Prize;
import gr.ekt.cerif.features.multilingual.PrizeDescription;
import gr.ekt.cerif.features.multilingual.PrizeKeyword;
import gr.ekt.cerif.features.multilingual.PrizeName;
import gr.ekt.cerif.services.link.organisationunit.LinkOrganisationUnitPrizeRepository;
import gr.ekt.cerif.services.link.person.LinkPersonPrizeRepository;
import gr.ekt.cerif.services.link.prize.LinkPrizeClassRepository;
import gr.ekt.cerif.services.link.project.LinkProjectPrizeRepository;
import gr.ekt.cerif.services.multilingual.prize.PrizeDescriptionRepository;
import gr.ekt.cerif.services.multilingual.prize.PrizeKeywordRepository;
import gr.ekt.cerif.services.multilingual.prize.PrizeNameRepository;

/**
 * @author bonisv
 *
 */
@Component
public class PrizeRepositoryImpl implements PrizeRepository {

	private static final Logger log = LoggerFactory.getLogger(PrizeRepositoryImpl.class);
	
	@Autowired
	private PrizeCrudRepository prizeCrudRepository;
	
	@Autowired
	private LinkOrganisationUnitPrizeRepository linkOrganisationUnitPrizeRepository;
	
	@Autowired
	private LinkPersonPrizeRepository linkPersonPrizeRepository;
	
	@Autowired
	private LinkProjectPrizeRepository linkProjectPrizeRepository;
	
	@Autowired
	private PrizeNameRepository prizeNameRepository;
	
	@Autowired
	private PrizeKeywordRepository prizeKeywordRepository;
	
	@Autowired
	private PrizeDescriptionRepository prizeDescriptionRepository;
	
	@Autowired
	private LinkPrizeClassRepository linkPrizeClassRepository;
	
	
	/* (non-Javadoc)
	 * @see gr.ekt.cerif.services.second.PrizeRepository#delete(gr.ekt.cerif.entities.second.Prize)
	 */
	@Override
	@Transactional
	public void delete(Prize entity) {
		List<OrganisationUnit_Prize> priz = linkOrganisationUnitPrizeRepository.findByPrize(entity);
		if (priz != null) linkOrganisationUnitPrizeRepository.delete(priz);
		entity.setOrganisationUnits_prizes(null);
		
		List<Person_Prize> ppr = linkPersonPrizeRepository.findByPrize(entity);
		if (ppr != null) linkPersonPrizeRepository.delete(ppr);
		entity.setPersons_prizes(null);
		
		List<Project_Prize> projpr = linkProjectPrizeRepository.findByPrize(entity);
		if (projpr != null) linkProjectPrizeRepository.delete(projpr);
		entity.setProjects_prizes(null);
		
		List<PrizeName> prizname = prizeNameRepository.findByPrize(entity);
		if (prizname != null) prizeNameRepository.delete(prizname);
		entity.setPrizeNames(null);
		
		List<PrizeKeyword> prizkey = prizeKeywordRepository.findByPrize(entity);
		if (prizkey != null) prizeKeywordRepository.delete(prizkey);
		entity.setPrizeKeywords(null);
		
		List<PrizeDescription> prizdescr = prizeDescriptionRepository.findByPrize(entity);
		if (prizdescr != null) prizeDescriptionRepository.delete(prizdescr);
		entity.setPrizeDescriptions(null);
		
		List<Prize_Class> prizcl = linkPrizeClassRepository.findByPrize(entity);
		if (prizcl != null) linkPrizeClassRepository.delete(prizcl);
		entity.setPrizes_classes(null);
		
		entity = prizeCrudRepository.save(entity);
		prizeCrudRepository.delete(entity);
	}

	/* (non-Javadoc)
	 * @see gr.ekt.cerif.services.second.PrizeRepository#delete(java.lang.Iterable)
	 */
	@Override
	public void delete(Iterable<Prize> entities) {
		prizeCrudRepository.delete(entities);
	}

	/* (non-Javadoc)
	 * @see gr.ekt.cerif.services.second.PrizeRepository#save(java.lang.Iterable)
	 */
	@Override
	public Iterable<Prize> save(Iterable<Prize> entities) {
		return prizeCrudRepository.save(entities);
	}

	/* (non-Javadoc)
	 * @see gr.ekt.cerif.services.second.PrizeRepository#save(gr.ekt.cerif.entities.second.Prize)
	 */
	@Override
	public Prize save(Prize entity) {
		return prizeCrudRepository.save(entity);
	}

	@Override
	public List<Prize> findAll() {
		return prizeCrudRepository.findAll();
	}

	@Override
	public Page<Prize> findAll(Pageable page) {
		return prizeCrudRepository.findAll(page);
	}

	@Override
	public Prize findById(Long id) {
		return prizeCrudRepository.findById(id);
	}

	@Override
	public List<Prize> findByUri(String uri) {
		return prizeCrudRepository.findByUri(uri);
	}

	@Override
	public Prize findByUuid(String uuid) {
		return prizeCrudRepository.findByUuid(uuid);
	}

}
