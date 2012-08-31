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
	private ResultPublicationRepository publicationRepository;
	

	
	
	
	public void setPublicationRepository(
			ResultPublicationRepository publicationRepository) {
		this.publicationRepository = publicationRepository;
	}

	/**
	 * Saves the provided result entity.
	 * @param entity The result entity.
	 */
	public void save(CerifResultEntity entity) {
		if (entity instanceof ResultPatent) {
			patentRepository.save((ResultPatent)entity);
		} else if (entity instanceof ResultProduct) {
			productRepository.save((ResultProduct)entity);
		} else if (entity instanceof ResultPublication) {
			publicationRepository.save((ResultPublication)entity);
		} else {
			throw new IllegalArgumentException(String.format("Invalid result entity provided. %s", entity));
		}
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
			publicationRepository.delete((ResultPublication)entity);
		} else {
			throw new IllegalArgumentException(String.format("Invalid result entity provided. %s", entity));
		}
	}

	/**
	 * Saves the provided result entities.
	 * @param entity The result entities.
	 */
	@SuppressWarnings("unchecked")
	public void save(List<? extends CerifResultEntity> entityList) {
		
		final CerifResultEntity entity = (CerifResultEntity)entityList.get(0);
		
		if (entity instanceof ResultPatent) {
			patentRepository.save((List<ResultPatent>)entityList);
		} else if (entity instanceof ResultProduct) {
			productRepository.save((List<ResultProduct>)entityList);
		} else if (entity instanceof ResultPublication) {
			publicationRepository.save((List<ResultPublication>)entityList);
		} else {
			throw new IllegalArgumentException(String.format("Invalid list of result entities provided. %s", entity));
		}
		
	}

	public ResultPublicationRepository getPublicationRepository() {
		return publicationRepository;
	}
	
	public ResultPatentRepository getResultPatentRepository() {
		return patentRepository;
	}

	/**
	 * @return the publicationRepository
	 */
	public ResultPublicationRepository getResultPublicationRepository() {
		return publicationRepository;
	}

}
