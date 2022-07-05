package fr.eni.assotennis.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import fr.eni.assotennis.bo.Badge;
import fr.eni.assotennis.service.AdherentService;
import fr.eni.assotennis.service.BadgeService;
import fr.eni.assotennis.service.StatusBadgeService;

/* @Controller permet de d�clarer un bean Web, c'est � dire de la couche pr�sentation.*/
@Controller

/*@Service permet de d�clarer un bean de service, c�est � dire de la couche m�tier.*/
@Service

@RequestMapping()
public class BadgeController {

	/*
	 * L�annotation @Autowired permet d�activer l�injection automatique de
	 * d�pendance.Le Spring Framework va chercher le bean du contexte d�application .
	 */
	@Autowired(required = false)
	BadgeService badgeService;

	@Autowired(required = false)
	StatusBadgeService statusBadgeService;

	@Autowired(required = false)
	AdherentService adherentService;

	// Pour préparer formulaire d'ajout d'un nouveau badge
	// GET sur /ajoutBadge} => renvoie sur le formulaire ajout-badge.html
	// @GetMapping est une annotation composée qui agit comme un raccourci pour @RequestMapping(method = RequestMethod.GET).
	@GetMapping("/ajoutBadge")
	public String getAjoutBadge(Model model) {
		/** j'ajoute au modéle : **/
		// 1 - un objet badge que je vais remplir dans mon formulaire
		model.addAttribute("badge",new Badge());
		
		// 2 - la liste des status d'un badge (utilisable par le template pour le choix du statut)		
		model.addAttribute("listeStatus",statusBadgeService.getStatusBadges());
		
		// 3 - la liste des adherents (utilisable par le template pour le choix d'un adherent)
		model.addAttribute("listeAdherentPossesseurDuBadge",adherentService.getAdherents());
		
		return "ajout-badge.html"; 
	}
	
	// Pour valider et ajouter un badge
	// POST sur  /ajoutBadge => recupére et affiche les paramètres
	// @Valid Badge badge : on veut un objet badge valide selon nos critères de validation (contraintes) mis sur la classe Badge
	// BindingResult bindingResult : ATTENTION, doit �tre en 2�me position (avant l'argument mod�le) : permet de recup�rer le statut (avec erreurs ou non) de mon objet badge
	// @PostMapping est une annotation compos�e qui agit comme un raccourci pour @RequestMapping(method = RequestMethod.POST).
	@PostMapping("/ajoutBadge")
	public String postAjoutBadge(@Valid Badge badge, BindingResult br, Model model) {
		// si jamais le badge envoyé par le formulaire n'est pas valide
		if (br.hasErrors()) {
			return "ajout-badge.html"; // alors on redirige vers le formulaire sans ajouter le badge
		}
		/** J'ajoute au modèle pour affichage **/
		// 1 - la liste des status d'un badge (utilisable par le template pour le choix du statut)
		model.addAttribute("listeStatus", statusBadgeService.getStatusBadges());
		// 2 - la liste des adherents (utilisable par le template pour le choix d'un adherent)
		model.addAttribute("listeAdherentPossesseurDuBadge", adherentService.getAdherents());

		// sinon je l'ajoute à  ma liste de badges en mémoire
		this.badgeService.addBadge(badge);
		model.addAttribute("confirmationMessage", "le badge a été ajouté avec succès");
		return "redirect:badges"; // je redirige vers la route /badges du controller en GET (redirect:/.br..)
	}
	
	//Pour modifier un badge
	// GET sur /badgeModification/{numeroBadge} => renvoie sur le formulaire ajout-badge.html
	// @GetMapping est une annotation compos�e qui agit comme un raccourci pour @RequestMapping(method = RequestMethod.GET).
	// @PathVariable : permet d'acceder à la variable qui a le nom définit entre {} dans l'url (ici : {numeroBadge}
	@GetMapping("/badgeModification/{numeroBadge}")
	public String getAjoutBadge(@PathVariable long numeroBadge, Model model) {
		// j'initialise mon objet genre qui va Ãªtre rempli dans mon formulaire
		Badge badge = new Badge();
		badge = badgeService.getBadge(numeroBadge);

		// je l'ajoute au modèle afin qu'il soit accessible dans mon template
		model.addAttribute("badge", badge);

		// 1 - la liste des status d'un badge (utilisable par le template pour le choix du statut)
		model.addAttribute("listeStatus",statusBadgeService.getStatusBadges());
		// 2 - la liste des adherents (utilisable par le template pour le choix d'un adherent)
		model.addAttribute("listeAdherentPossesseurDuBadge",adherentService.getAdherents());

		return "ajout-badge.html";
	}
	
	//Pour recuperer la liste des badges
	@GetMapping("/badges")
	public String getBadges(Model model) {
		// on ajoute au modele la liste des badges pour pouvoir l'afficher dans le template
		model.addAttribute("badges", badgeService.getBadges());
		return "badges.html"; // pas obligÃ© de rajouter l'extension .html
	}

	//Pour recuperer le detail d'un badge
	// @PathVariable : permet d'acceder à la variable qui a le nom définit entre {} dans l'url (ici : {numeroBadge}
	@GetMapping("/badgeDetail/{numeroBadge}")
	public String getBadge(@PathVariable long numeroBadge, Model model) { 
		// j'ajoute au modele le badge qui correspond à l'id du chemin
		model.addAttribute("badge", badgeService.getBadge(numeroBadge));
		
		return "detail-badge.html";
	}

	//Pour supprimer un badge
	// @PathVariable : permet d'acceder à la variable qui a le nom définit entre {} dans l'url (ici : {numeroBadge}
	@GetMapping("/badgeSuppression/{numeroBadge}")
	public String removeBadge(@PathVariable long numeroBadge) { 
		badgeService.removeBadge(numeroBadge);
		return "redirect:badges"; // je redirige vers la route /badges du controller en GET (redirect:/.br..)
	}
}