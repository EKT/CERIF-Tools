package gr.ekt.cerif.services;

import java.util.List;

public interface CommonPersistenceService<Entity> {
	void save(Entity entity);	
	
	void save(List<? extends Entity> entities);		

}
