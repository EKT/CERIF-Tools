package gr.ekt.exampleapp.controllers;

import gr.ekt.cerif.enumerations.semantics.ClassSchemeEnum;
import gr.ekt.cerif.services.PersistenceService;
import gr.ekt.exampleapp.middleware.ClassMiddleRepository;
import gr.ekt.exampleapp.middleware.OrganisationUnitMiddleRepository;
import gr.ekt.exampleapp.middleware.ProjectMiddleRepository;
import gr.ekt.exampleapp.transferobjects.ClassView;
import gr.ekt.exampleapp.transferobjects.OrganisationView;
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
@RequestMapping(value = "/projects")
public class ProjectController {

	private static final Logger logger = LoggerFactory.getLogger(ProjectController.class);
	
	@Autowired
	private PersistenceService service;
	
	@Autowired
	private ProjectMiddleRepository projectMiddleRepository;
	
	@Autowired
	private ClassMiddleRepository classMiddleRepository;
	
	@Autowired
	private OrganisationUnitMiddleRepository organisationUnitMiddleRepository;
	
	
	@RequestMapping(value = "/browse")
	public String browse(Model model) {
		
		List<ProjectView> projects =  projectMiddleRepository.findAllProjects();
		
		logger.debug("Retrieving projects");
		logger.debug("Num of projects: "+projects.size());
		
		for (ProjectView prv:projects) {
			List<ClassView> status = classMiddleRepository.findClassByProjectIdAndClassScheme(prv.getId(), ClassSchemeEnum.ACTIVITY_STATUSES.getUuid());
			if (!status.isEmpty()) {
				prv.setStatus(status.get(0));
			}
		}
				
		model.addAttribute("projects", projects);
		
		return "/project/browse";
	}
	
	
	@RequestMapping(value = "/view/{id}")
	public String view(Model model, @PathVariable("id") Long id) {
		
		ProjectView project = projectMiddleRepository.findProjectById(id);
		if (project!=null) {
			List<ClassView> status = classMiddleRepository.findClassByProjectIdAndClassScheme(id, ClassSchemeEnum.ACTIVITY_STATUSES.getUuid());
			if (!status.isEmpty()) {
				project.setStatus(status.get(0));
			}
			
			Map<String,List<OrganisationView>> organisationsMap = new HashMap<String, List<OrganisationView>>();
			
			List<OrganisationView> partners = new ArrayList<OrganisationView>();
			List<OrganisationView> coordinators = new ArrayList<OrganisationView>();
			
			List<OrganisationView> organisationsList = organisationUnitMiddleRepository.findOrganisationByProjectIdAndClassScheme(id,
					ClassSchemeEnum.ORGANISATION_PROJECT_ENGAGEMENTS.getUuid());
			for (OrganisationView orgv:organisationsList) {
				if (orgv.getRoleinProject().equals("Partner")) {
					partners.add(orgv);
				} else if (orgv.getRoleinProject().equals("Coordinator")) {
					coordinators.add(orgv);
				}
			}
			organisationsMap.put("Partner", partners);
			organisationsMap.put("Coordinator", coordinators);
			project.setOrganisations(organisationsMap);
			
			model.addAttribute("project", project);
			
			return "/project/view";
		} else {
			return "/project/browse";
		}
		
	}
	
}
