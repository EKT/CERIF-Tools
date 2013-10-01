package gr.ekt.cerif.services.link.result;

import gr.ekt.cerif.entities.link.result.ResultPublication_Service;
import gr.ekt.cerif.entities.result.ResultPublication;
import gr.ekt.cerif.services.result.ResultPublicationRepository;
import gr.ekt.cerif.services.infrastructure.ServiceCrudRepository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * A repository for links between resultPublications and services.
 * 
 */
public interface LinkResultPublicationServiceRepository {

	public void delete(ResultPublication_Service entity); 
	
	public void delete(Iterable<ResultPublication_Service> entities); 

	public Iterable<ResultPublication_Service> save(Iterable<ResultPublication_Service> entities); 
	
	public ResultPublication_Service save(ResultPublication_Service entity);
	
}
