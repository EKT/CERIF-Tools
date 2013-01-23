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

	@Autowired
	private ResultPatentRepository resultPatentRepository;
	
	@Autowired
	private ResultProductRepository resultProductRepository;
	
	@Autowired
	private ResultPublicationRepository resultPublicationRepository;
	
	/**
	 * Saves the provided result entity.
	 * @param entity The result entity.
	 */
	public CerifResultEntity save(CerifResultEntity entity) {
		if (entity instanceof ResultPatent) {
			entity = resultPatentRepository.save((ResultPatent) entity);
		} else if (entity instanceof ResultProduct) {
			entity = resultProductRepository.save((ResultProduct) entity);
		} else if (entity instanceof ResultPublication) {
			entity = resultPublicationRepository.save((ResultPublication) entity);
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
			resultPatentRepository.delete((ResultPatent) entity);
		} else if (entity instanceof ResultProduct) {
			resultProductRepository.delete((ResultProduct) entity);
		} else if (entity instanceof ResultPublication) {
			resultPublicationRepository.delete((ResultPublication) entity);
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
			entityList = resultPatentRepository.save((List<ResultPatent>) entityList);
		} else if (entity instanceof ResultProduct) {
			entityList = resultProductRepository.save((List<ResultProduct>) entityList);
		} else if (entity instanceof ResultPublication) {
			entityList = resultPublicationRepository.save((List<ResultPublication>) entityList);
		} else {
			throw new IllegalArgumentException(String.format("Invalid list of result entities provided. %s", entity));
		}
		return entityList;
	}
	
	public ResultPatentRepository getResultPatentRepository() {
		return resultPatentRepository;
	}
	
	/**
	 * @return the publicationRepository
	 */
	public ResultPublicationRepository getResultPublicationRepository() {
		return resultPublicationRepository;
	}
	
	public ResultProductRepository getResultProductRepository() {
		return resultProductRepository;
	}

}
