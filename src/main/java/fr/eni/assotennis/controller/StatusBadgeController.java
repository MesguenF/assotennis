package fr.eni.assotennis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import fr.eni.assotennis.service.StatusBadgeService;

/* @Controller permet de déclarer un bean Web, c'est à  dire de la couche présentation.*/
@Controller

/*@Service permet de déclarer un bean de service, c’est à dire de la couche métier.*/
@Service

@RequestMapping()
public class StatusBadgeController {
	
	/*
	 * L’annotation @Autowired permet d’activer l’injection automatique de
	 * dépendance.Le Spring Framework va chercher le bean du contexte d’application .
	 */
	@Autowired(required = false)
	StatusBadgeService statusBadgeService;
	
	@GetMapping("/statusbadges")
	public String getStatusBadges(Model model) {
		
		/** j'ajoute au modéle la liste des status d'un badge pour pouvoir l'afficher dans mon template**/
		model.addAttribute("statusbadges", statusBadgeService.getStatusBadges()); 
	  
	  return "statusbadge.html";
	}
}