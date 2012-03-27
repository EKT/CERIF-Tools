/**
 * 
 */
package gr.ekt.cerif.services;

import gr.ekt.cerif.CerifComponent;
import gr.ekt.cerif.entities.base.CerifBaseEntity;
import gr.ekt.cerif.entities.infrastructure.CerifInfrastructureEntity;
import gr.ekt.cerif.entities.link.CerifLinkEntity;
import gr.ekt.cerif.entities.result.CerifResultEntity;
import gr.ekt.cerif.entities.result.ResultProduct;
import gr.ekt.cerif.entities.second.CerifSecondLevelEntity;
import gr.ekt.cerif.features.additional.CerifAdditionalFeature;
import gr.ekt.cerif.features.multilingual.CerifMultipleLanguageFeature;
import gr.ekt.cerif.features.semantics.CerifSemanticFeature;
import gr.ekt.cerif.services.additional.AdditionalPersistenceService;
import gr.ekt.cerif.services.base.BasePersistenceService;
import gr.ekt.cerif.services.infrastructure.InfrastructurePersistenceService;
import gr.ekt.cerif.services.link.LinkPersistenceService;
import gr.ekt.cerif.services.multilingual.TranslationPersistenceService;
import gr.ekt.cerif.services.result.ResultPersistenceService;
import gr.ekt.cerif.services.second.SecondPersistenceService;
import gr.ekt.cerif.services.semantics.SemanticsPersistenceService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Implementation of the persistence service for CERIF entities.
 * 
 */
@Component
public class PersistenceServiceImpl implements PersistenceService {
	
	/**
	 * Service for persisting base entities.
	 */
	@Autowired
	private BasePersistenceService baseService;

	/**
	 * Service for persisting result entities.
	 */
	@Autowired
	private ResultPersistenceService resultService;
	
	/**
	 * Service for persisting 2nd level entities.
	 */
	@Autowired
	private SecondPersistenceService secondService;
	
	/**
	 * Service for persisting infrastructure entities.
	 */
	@Autowired
	private InfrastructurePersistenceService infrastructureService;
	
	/**
	 * Service for persisting semantics features.
	 */
	@Autowired
	private SemanticsPersistenceService semanticService;
	
	/**
	 * Service for persisting link entities.
	 */
	@Autowired
	private LinkPersistenceService linkService;
	
	/**
	 * Service for persisting translation feature entities.
	 */
	@Autowired
	private TranslationPersistenceService translationService;
	
	/**
	 * Service for persisting translation feature entities.
	 */
	@Autowired
	private AdditionalPersistenceService additionalService;
	
	/**
	 * Saves the provided CERIF component.
	 * @param component The CERIF component.
	 */
	@Override
	public void save(CerifComponent component) {
		
		if (component == null) {
			throw new IllegalArgumentException("Empty component provided. Save will not proceed.");
		}
		
		if (component instanceof CerifBaseEntity) {
			baseService.save((CerifBaseEntity) component);
		} else if (component instanceof CerifResultEntity) {
			resultService.save((CerifResultEntity) component);
		} else if (component instanceof CerifLinkEntity) {
			linkService.save((CerifLinkEntity) component);
		} else if (component instanceof CerifSecondLevelEntity) {
			secondService.save((CerifSecondLevelEntity) component);
		} else if (component instanceof CerifInfrastructureEntity) {
			infrastructureService.save((CerifInfrastructureEntity) component);
		} else if (component instanceof CerifMultipleLanguageFeature) {
			translationService.save( (CerifMultipleLanguageFeature) component);
		} else if (component instanceof CerifSemanticFeature) {
			semanticService.save((CerifSemanticFeature) component);
		} else if (component instanceof CerifAdditionalFeature) {
			additionalService.save((CerifAdditionalFeature) component);
		}
		
	}

	/**
	 * Saves the provided CERIF components.
	 * @param components The CERIF components.
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void save(List<? extends CerifComponent> components) {
		
		if (components == null || components.size() == 0) {
			throw new IllegalArgumentException("Empty collection provided. Save will not proceed.");
		}
		
		final CerifComponent type = components.get(0);
		
		if (type instanceof CerifBaseEntity) {
			baseService.save((List<CerifBaseEntity>) components);
		} else if (type instanceof CerifResultEntity) {
			resultService.save((List<CerifResultEntity>) components);
		} else if (type instanceof CerifLinkEntity) {
			linkService.save((List<CerifLinkEntity>) components);
		} else if (type instanceof CerifSecondLevelEntity) {
			secondService.save((List<CerifSecondLevelEntity>) components);
		} else if (type instanceof CerifInfrastructureEntity) {
			infrastructureService.save((List<CerifInfrastructureEntity>) components);
		} else if (type instanceof CerifMultipleLanguageFeature) {
			
		} else if (type instanceof CerifSemanticFeature) {
			semanticService.save((List<CerifSemanticFeature>) components);
		} else if (type instanceof CerifAdditionalFeature) {

		}
		
		
	}
	
	/* (non-Javadoc)
	 * @see gr.ekt.cerif.services.IndexService#getAllProducts()
	 */
	@Override
	public List<ResultProduct> getAllProducts() {
		return resultService.findAllProducts();
	}
	
	@Override
	public ResultProduct getProduct(Long id) {
		return resultService.findProductById(id);
	}
	
	@Override
	public List<ResultProduct> getProductsByKeyword(String keyword) {
		return resultService.findProductsByKeyword(keyword);
	}

	/* (non-Javadoc)
	 * @see gr.ekt.cerif.services.PersistenceService#findByClass(java.lang.String)
	 */
	@Override
	public List<ResultProduct> getProductsByClass(String uri) {
		return resultService.findByClass(uri);
	}

	/* (non-Javadoc)
	 * @see gr.ekt.cerif.services.PersistenceService#getProductByOrganisationClass(java.lang.String)
	 */
	@Override
	public List<ResultProduct> getProductByOrganisationClass(String uri) {
		return resultService.findByOrganisationClass(uri);
	}

	/* (non-Javadoc)
	 * @see gr.ekt.cerif.services.PersistenceService#getProductByPersonClass(java.lang.String)
	 */
	@Override
	public List<ResultProduct> getProductByPersonClass(String uri) {
		return resultService.findProductsByPersonClass(uri);
	}

	/* (non-Javadoc)
	 * @see gr.ekt.cerif.services.PersistenceService#getProductByProjectClass(java.lang.String)
	 */
	@Override
	public List<ResultProduct> getProductByProjectClass(String uri) {
		return resultService.findProductsByProjectClass(uri);
	}

	/* (non-Javadoc)
	 * @see gr.ekt.cerif.services.PersistenceService#getProductByCountry(java.lang.String)
	 */
	@Override
	public List<ResultProduct> getProductByCountry(String code) {
		return resultService.findProductsByCountry(code);
	}
	
	@Override
	public List<ResultProduct> getProductByOrganisationURI(String uri) {
		return resultService.findByOrganisationURI(uri);
	}
	
	@Override
	public List<ResultProduct> getProductByOrganisationURIClass(String orgURI, String classURI) {
		return resultService.findByOrganisationURIClass(orgURI, classURI);
	}
	
	@Override
	public List<ResultProduct> getProductByOrganisationExpanded(String input, String classURI) {
		return resultService.findByOrganisationExpanded(input, classURI);
	}
	
	@Override
	public List<ResultProduct> getProductByPersonAny(String uri) {
		return resultService.findByPersonAny(uri);
	}
	

}
