package gr.ekt.cerif.services.second;

import gr.ekt.cerif.entities.second.Medium;

public interface MediumRepository {
	
	public Medium findById(Long id);
	
	public Medium findByUri(String uri);
	
	public void delete(Medium entity);
	
	public void delete(Iterable<Medium> entityList);
	
	public Iterable<Medium> save(Iterable<Medium> entities);
	
	public Medium save(Medium entity);
	
	Medium findMediumByProjectIdAndClassUUID(Long id, String uuid);
	
	Medium findMediumByOrgIdAndClassUUID(Long id, String uuid);
	
	Medium findMediumByPersonIdAndClassUUID(Long id, String uuid);
}
