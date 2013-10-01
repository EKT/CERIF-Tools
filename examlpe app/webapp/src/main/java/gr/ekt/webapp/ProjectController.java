package gr.ekt.webapp;

import gr.ekt.cerif.services.PersistenceService;
import gr.ekt.cerif.transferobjects.ClassView;
import gr.ekt.cerif.transferobjects.ProjectView;
import gr.ekt.cerif.transferobjects.OrganisationView;

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
	
	@RequestMapping(value = "/browse")
	public String browse(Model model) {
		
		List<ProjectView> projects =  service.getBaseService().getProjectRepository().findAllProjects();
		
		logger.info("Retrieving projects");
		logger.info("Num of projects: "+projects.size());
		
		for (ProjectView prv:projects) {
			List<ClassView> domain = service.getSemanticService().getClassRepository().findClassByProjectIdAndClassScheme(prv.getId(), "scientificdomain");
			prv.setScientificDomain(domain.get(0));
		}
				
		model.addAttribute("projects", projects);
		
		return "/project/browse";
	}
	
	
	@RequestMapping(value = "/view/{id}")
	public String view(Model model, @PathVariable("id") Long id) {
		
		ProjectView project = service.getBaseService().getProjectRepository().findProjectById(id);
		if (project!=null) {
			List<ClassView> domain = service.getSemanticService().getClassRepository().findClassByProjectIdAndClassScheme(id, "scientificdomain");
			if (!domain.isEmpty()) {
				project.setScientificDomain(domain.get(0));
			}
			
			Map<String,List<OrganisationView>> organisationsMap = new HashMap<String, List<OrganisationView>>();
			
			List<OrganisationView> partners = new ArrayList<OrganisationView>();
			List<OrganisationView> coordinators = new ArrayList<OrganisationView>();
			
			List<OrganisationView> organisationsList = service.getBaseService().getOrganisationUnitRepository().findOrganisationByProjectIdAndClassScheme(id, "org_proj_relationship");
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
