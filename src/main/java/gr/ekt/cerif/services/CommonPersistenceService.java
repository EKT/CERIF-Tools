package gr.ekt.cerif.services;


public interface CommonPersistenceService<Entity> {
	
	Entity save(Entity entity);	
	
	Iterable<? extends Entity> save(Iterable<? extends Entity> entities);
	
	void delete(Entity entity);

}
