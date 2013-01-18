/**
 * 
 */
package gr.ekt.cerif.services.result;

import gr.ekt.cerif.entities.result.CerifResultEntity;
import gr.ekt.cerif.entities.result.ResultPatent;
import gr.ekt.cerif.entities.result.ResultProduct;
import gr.ekt.cerif.entities.result.ResultPublication;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Persistence service for CERIF Result Entities.
 * 
 */
@Component
public class ResultPersistenceService {

	/**
	 * The organisation repository.
	 */
	@Autowired
	private ResultPatentRepository patentRepository;
	
	/**
	 * The person repository.
	 */
	@Autowired
	private ResultProductRepository productRepository;
	
	/**
	 * The project repository.
	 */
	@Autowired
	private ResultPublicationRepository resultPublicationRepository;
	
	
	public ResultPublicationRepository getPublicationRepository() {
		return resultPublicationRepository;
	}

	public void setPublicationRepository(ResultPublicationRepository publicationRepository) {
		this.resultPublicationRepository = publicationRepository;
	}

	/**
	 * Saves the provided result entity.
	 * @param entity The result entity.
	 */
	public CerifResultEntity save(CerifResultEntity entity) {
		if (entity instanceof ResultPatent) {
			entity = patentRepository.save((ResultPatent)entity);
		} else if (entity instanceof ResultProduct) {
			entity = productRepository.save((ResultProduct)entity);
		} else if (entity instanceof ResultPublication) {
			entity = resultPublicationRepository.save((ResultPublication)entity);
		} else {
			throw new IllegalArgumentException(String.format("Invalid result entity provided. %s", entity));
		}
		return entity;
	}
	
	/**
	 * Deletes the provided result entity.
	 * @param entity The result entity.
	 */
	public void delete(CerifResultEntity entity) {
		if (entity instanceof ResultPatent) {
			patentRepository.delete((ResultPatent)entity);
		} else if (entity instanceof ResultProduct) {
			productRepository.save((ResultProduct)entity);
		} else if (entity instanceof ResultPublication) {
			resultPublicationRepository.delete((ResultPublication)entity);
		} else {
			throw new IllegalArgumentException(String.format("Invalid result entity provided. %s", entity));
		}
	}

	/**
	 * Saves the provided result entities.
	 * @param entity The result entities.
	 */
	@SuppressWarnings("unchecked")
	public Iterable<? extends CerifResultEntity> save(Iterable<? extends CerifResultEntity> entityList) {
		
		final CerifResultEntity entity = (CerifResultEntity) entityList.iterator().next();
		
		if (entity instanceof ResultPatent) {
			entityList = patentRepository.save((List<ResultPatent>)entityList);
		} else if (entity instanceof ResultProduct) {
			entityList = productRepository.save((List<ResultProduct>)entityList);
		} else if (entity instanceof ResultPublication) {
			entityList = resultPublicationRepository.save((List<ResultPublication>)entityList);
		} else {
			throw new IllegalArgumentException(String.format("Invalid list of result entities provided. %s", entity));
		}
		return entityList;
	}

	/**
	 * @return
	 */
	public List<ResultProduct> findAllProducts() {
		return productRepository.getAllProducts();
	}

	/**
	 * @param id
	 * @return
	 */
	public ResultProduct findProductById(Long id) {
		return productRepository.getProduct(id);
	}

	/**
	 * @param keyword
	 * @return
	 */
	public List<ResultProduct> findProductsByKeyword(String keyword) {
		return productRepository.findByKeyword(keyword);
	}
	
	public List<ResultProduct> findByClass(String uri) {
		return productRepository.findByClass(uri);
	}
	
	public List<ResultProduct> findByOrganisationClass(String uri) {
		return productRepository.findByOrganisationClass(uri);
	}

	/**
	 * @param uri
	 * @return
	 */
	public List<ResultProduct> findProductsByPersonClass(String uri) {
		return productRepository.findByPersonClass(uri);
	}

	/**
	 * @param uri
	 * @return
	 */
	public List<ResultProduct> findProductsByProjectClass(String uri) {
		return productRepository.findByProjectClass(uri);
	}
	
	public List<ResultProduct> findProductsByCountry(String code) {
		return productRepository.findByCountry(code);
	}
	
	public List<ResultProduct> findByOrganisationURI(String uri) {
		return productRepository.findByOrganisationURI(uri);
	}
	
	public List<ResultProduct> findByOrganisationURIClass(String orgURI, String classURI) {
		return productRepository.findByOrganisationURIClass(orgURI, classURI);
	}
	
	public List<ResultProduct> findByOrganisationExpanded(String input, String classURI) {
		return productRepository.findByOrganisationExpanded(input, classURI);
	}
	
	public List<ResultProduct> findByPersonAny(String input) {
		return productRepository.findByPersonComplete(input);
	}
	
	/**
	 * @return the publicationRepository
	 */
	public ResultPublicationRepository getResultPublicationRepository() {
		return resultPublicationRepository;
	}

}
