package gr.ekt.exampleapp.controllers;

import gr.ekt.cerif.enumerations.semantics.ClassSchemeEnum;
import gr.ekt.cerif.services.PersistenceService;
import gr.ekt.exampleapp.middleware.ClassMiddleRepository;
import gr.ekt.exampleapp.middleware.OrganisationUnitMiddleRepository;
import gr.ekt.exampleapp.middleware.PersonMiddleRepository;
import gr.ekt.exampleapp.middleware.ProjectMiddleRepository;
import gr.ekt.exampleapp.transferobjects.ClassView;
import gr.ekt.exampleapp.transferobjects.OrganisationView;
import gr.ekt.exampleapp.transferobjects.PersonView;
import gr.ekt.exampleapp.transferobjects.ProjectView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/organisations")
public class OrganisationController {

	private static final Logger logger = LoggerFactory.getLogger(ProjectController.class);
	
	@Autowired
	private PersistenceService service;
	
	@Autowired
	private OrganisationUnitMiddleRepository organisationUnitMiddleRepository;
	
	@Autowired
	private ClassMiddleRepository classMiddleRepository;
	
	@Autowired
	private ProjectMiddleRepository projectMiddleRepository;
	
	@Autowired
	private PersonMiddleRepository personMiddleRepository;
	
	
	
	@RequestMapping(value = "/browse")
	public String browse(Model model) {
		
		List<OrganisationView> organisations = organisationUnitMiddleRepository.findAllOrganisations();
		
		logger.debug("Retrieving organisations");
		logger.debug("Num of organisations: "+organisations.size());
		
		model.addAttribute("organisations", organisations);
		
		return "/organisation/browse";
	}
	
	
	@RequestMapping(value = "/view/{id}")
	public String view(Model model, @PathVariable("id") Long id) {
		
		OrganisationView organisation = organisationUnitMiddleRepository.findOrganisationById(id);
		if (organisation!=null) {
			List<ClassView> type = classMiddleRepository.findClassByOrganisationIdAndClassScheme(id, ClassSchemeEnum.ORGANISATION_TYPES.getUuid());
			if (!type.isEmpty()) {
				organisation.setType(type.get(0));
			}
			
			Map<String,List<ProjectView>> projectsMap = new HashMap<String, List<ProjectView>>();
			
			List<ProjectView> partnerto = new ArrayList<ProjectView>();
			List<ProjectView> coordinatorto = new ArrayList<ProjectView>();
			
			List<ProjectView> projectsList = projectMiddleRepository.findProjectByOrganisationIdAndClassScheme(id, 
					ClassSchemeEnum.ORGANISATION_PROJECT_ENGAGEMENTS.getUuid());
			for (ProjectView prv:projectsList) {
				if (prv.getRoleofOrganisation().equals("Partner")) {
					partnerto.add(prv);
				} else if (prv.getRoleofOrganisation().equals("Coordinator")) {
					coordinatorto.add(prv);
				}
			}
			projectsMap.put("Partner", partnerto);
			projectsMap.put("Coordinator", coordinatorto);
			organisation.setProjects(projectsMap);
			
			List<PersonView> pers = personMiddleRepository.findPersonByOrganisationIdAndClassScheme(id,
					ClassSchemeEnum.PERSON_ORGANISATION_ROLES.getUuid());
			if (!pers.isEmpty()) {
				organisation.setPersons((ArrayList<PersonView>) pers);
			}
			
			model.addAttribute("organisation", organisation);
			
			return "/organisation/view";
		} else {
			return "/organisation/browse";
		}
	}
	
}
