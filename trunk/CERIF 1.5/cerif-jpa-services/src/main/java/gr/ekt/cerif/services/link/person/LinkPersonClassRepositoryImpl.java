package gr.ekt.cerif.services.link.person;

import gr.ekt.cerif.entities.base.Person;
import gr.ekt.cerif.entities.link.person.Person_Class;
import gr.ekt.cerif.features.semantics.Class;
import gr.ekt.cerif.features.semantics.ClassScheme;
import gr.ekt.cerif.services.base.PersonRepository;
import gr.ekt.cerif.services.semantics.ClassRepository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class LinkPersonClassRepositoryImpl implements LinkPersonClassRepository {
	
	private static final Logger log = LoggerFactory.getLogger(LinkPersonClassRepositoryImpl.class);
	
	@Autowired
	private LinkPersonClassCrudRepository linkPersonClassCrudRepository;
	
	@Autowired
	private PersonRepository personRepository;
	
	@Autowired
	private ClassRepository classRepository;
	
	public Person_Class findById(Long id) {
		return linkPersonClassCrudRepository.findById(id);
	}
	
	public Person_Class findByPersonClassSchemeAndClass(Person person, Class theClass, ClassScheme scheme) {
		return linkPersonClassCrudRepository.findByPersonClassSchemeAndClass(person, theClass, scheme);
	}

	public List<Person_Class> findByPersonClassScheme(Person person, ClassScheme scheme) {
		return linkPersonClassCrudRepository.findByPersonClassScheme(person, scheme);
	}
	
	public List<Person_Class> findByPerson(Person person) {
		return linkPersonClassCrudRepository.findByPerson(person);
	}

	public Person_Class findByPersonAndTheClass(Person person, Class theClass) {
		return linkPersonClassCrudRepository.findByPersonAndTheClass(person, theClass);
	}

	public Person_Class findByPersonIdAndClassId(Long personId, Long classId) {
		return linkPersonClassCrudRepository.findByPersonIdAndClassId(personId, classId);
	}
	
	public Person_Class findByPersonIdAndClassUri(Long personId, String classUri) {
		return linkPersonClassCrudRepository.findByPersonIdAndClassUri(personId, classUri);
	}
	
	public List<Person_Class> findByPersonIdClassSchemeUri(Long personId, String schemeUri) {
		return linkPersonClassCrudRepository.findByPersonIdClassSchemeUri(personId, schemeUri);
	}
	
	@Override
	public Person_Class findPersClassByPersonIdAndSchemeId(Long personId,
			Long schemeId) {
		return linkPersonClassCrudRepository.findPersClassByPersonIdAndSchemeId(personId, schemeId);
	}

	@Override
	public Person_Class findPersClassByPersonIdAndSchemeUri(Long personId,
			String schemeUri) {
		return linkPersonClassCrudRepository.findPersClassByPersonIdAndSchemeUri(personId, schemeUri);
	}

	@Override
	public Person_Class findPersonUserState(Long personId) {
		return linkPersonClassCrudRepository.findPersonUserState(personId);
	}
	
	
	@Transactional
	public Person_Class save(Person_Class entity) {
		if (entity.getPerson() == null || entity.getClass() == null) {
			throw new IllegalArgumentException("Please provide both a person and a class.");
		}
		if (entity.getPerson().getId() == null) {
			personRepository.save(entity.getPerson());
		}
		if (entity.getClass() == null) {
			classRepository.save(entity.getTheClass());
		}
		return linkPersonClassCrudRepository.save(entity);
	}
	
	@Transactional
	public Iterable<Person_Class> save(Iterable<Person_Class> entityList) {
		return linkPersonClassCrudRepository.save(entityList);
	}
	
	@Transactional
	public void delete(Person_Class entity) {
		linkPersonClassCrudRepository.delete(entity);
	}
	
	@Transactional
	public void delete(Iterable<Person_Class> entityList) {
		linkPersonClassCrudRepository.delete(entityList);
	}
	

	@Override
	public Person_Class updatePerson_Class(Person_Class personClassToSave, boolean replaceAll, Class classToReplace) {

		if (personClassToSave.getPerson()==null || personClassToSave.getTheClass()==null) {
			throw new IllegalArgumentException("Please provide both a person and a class.");
		}
		if (replaceAll && classToReplace!=null) {
			throw new IllegalArgumentException("replaceAll cannot be true if classToReplace is nut null.");
		}

		if (replaceAll) {
			List<Person_Class> lPerCl= this.findByPersonClassScheme(personClassToSave.getPerson(), personClassToSave.getTheClass().getScheme());
			this.delete(lPerCl);
		} else {
			if (classToReplace!=null) {
				Person_Class perCl=this.findByPersonAndTheClass(personClassToSave.getPerson(), personClassToSave.getTheClass());
				this.delete(perCl);
			}
		}
		
		return linkPersonClassCrudRepository.save(personClassToSave);
	}

	@Override
	public void updatePerson_ClassList(Person person, List<Long> classIds, String classSchemeUri) {	
		List<Person_Class> existingPerson_Class = this.findByPersonIdClassSchemeUri(person.getId(), classSchemeUri);
		ArrayList<Long> existingClassIds = new ArrayList<Long>();
		for (Person_Class pc : existingPerson_Class) {
			existingClassIds.add(pc.getTheClass().getId());
		}
		
		//remove the old ones
		if (existingClassIds != null) {
			for (Long existingClassId : existingClassIds) {
				if (classIds == null) {
					Person_Class npc = this.findByPersonIdAndClassId(person.getId(), existingClassId);
					this.delete(npc);
				} else {
					if (!classIds.contains(existingClassId)) {
						Person_Class npc = this.findByPersonIdAndClassId(person.getId(), existingClassId);
						this.delete(npc);
					}
				}
			}
		}
		
		//save the new ones
		if (classIds != null) {
			for (Long classId  : classIds) {
				if (!existingClassIds.contains(classId)) {
					Class cl = classRepository.findById(classId);
					Person_Class npc = new Person_Class(person, cl, new Date(),	new Date());
					this.save(npc);
				}
			}
		}
	}

}
