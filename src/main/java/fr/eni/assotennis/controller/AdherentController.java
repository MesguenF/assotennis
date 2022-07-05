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
import org.springframework.web.bind.annotation.RequestParam;
import fr.eni.assotennis.bo.Adherent;
import fr.eni.assotennis.service.AdherentService;
import fr.eni.assotennis.service.BadgeService;
import fr.eni.assotennis.service.TypeCotisationService;
import fr.eni.assotennis.service.TypeLicenceService;

/* @Controller permet de d�clarer un bean Web, c'est � dire de la couche pr�sentation.*/
@Controller

/*
 * @Service permet de d�clarer un bean de service, c�est � dire de la couche
 * m�tier.
 */
@Service

@RequestMapping()
public class AdherentController {

	/*
	 * L�annotation @Autowired permet d�activer l�injection automatique de
	 * d�pendance.Le Spring Framework va chercher le bean du contexte d�application .
	 */
	@Autowired(required = false)
	AdherentService adherentService;

	@Autowired(required = false)
	TypeCotisationService typeCotisationService;

	@Autowired(required = false)
	TypeLicenceService typeLicenceService;
	
	@Autowired(required = false)
	BadgeService badgeService;

	// Pour pr�parer formulaire d'ajout d'un nouvel adherent
	// GET sur /ajoutAdherent} => renvoie sur le formulaire ajout-adherent.html
	// @GetMapping est une annotation compos�e qui agit comme un raccourci pour
	// @RequestMapping(method = RequestMethod.GET).
	@GetMapping("/ajoutAdherent")
	public String getAjoutAdherent(Model model) {
		/** j'ajoute au modele : **/
		// 1 - un objet adherent que je vais remplir dans mon formulaire
		model.addAttribute("adherent", new Adherent());

		// 2 - la liste des types de cotisation (utilisable par le template pour le
		// choix du statut)
		model.addAttribute("listeTypeCotisation", typeCotisationService.getTypeCotisations());

		// 3 - la liste des types de licence (utilisable par le template pour le choix
		// du statut)
		model.addAttribute("listeTypeLicence", typeLicenceService.getTypeLicences());

		return "ajout-adherent.html";
	}

	// Pour valider et ajouter un adherent
	// POST sur /ajoutAdherent => recup�re et affiche les param�tres
	// @Valid Adherent adherent : on veut un objet adherent valide selon nos
	// crit�res de validation (contraintes) mis sur la classe Adherent
	// BindingResult bindingResult : ATTENTION, doit �tre en 2�me position (avant
	// l'argument mod�le) :
	// permet de recup�rer le statut (avec erreurs ou non) de mon objet adh�rent
	// @PostMapping est une annotation compos�e qui agit comme un raccourci pour
	// @RequestMapping(method = RequestMethod.POST).
	@PostMapping("/ajoutAdherent")
	public String postAjoutAdherent(@Valid Adherent adherent, BindingResult br, Model model) {
		// si jamais l'adherent envoyé par le formulaire n'est pas valide
		if (br.hasErrors()) {
			return "ajout-adherent.html"; // alors on redirige vers le formulaire sans ajouter l'adherent
		}

		// 2 - la liste des types de cotisation (utilisable par le template pour le
		// choix du statut)
		model.addAttribute("listeTypeCotisation", typeCotisationService.getTypeCotisations());

		// 3 - la liste des types de licence (utilisable par le template pour le choix
		// du statut)
		model.addAttribute("listeTypeLicence", typeLicenceService.getTypeLicences());
		
		// sinon
		// je l'ajoute � ma liste d'adh�rents en m�moire
		this.adherentService.addAdherent(adherent);
		/*
		 * model.addAttribute("confirmationMessage",
		 * "l'adhérent a été ajouté avec succès");
		 */
		return "redirect:adherents"; // je redirige vers la route /adherents du controleur en GET (redirect:/.br..)
		}

	// Pour modifier un adherent et pr�parer formulaire de modification de 
	// l'adh�rent
	// GET sur /adherentModification/{idAdherent} => renvoie sur le formulaire
	// ajout-adherent.html
	// @GetMapping est une annotation compos�e qui agit comme un raccourci pour
	// @RequestMapping(method = RequestMethod.GET).
	@GetMapping("/modificationAdherent/{idAdherent}")
	public String getModificationAdherent(@PathVariable long idAdherent, Model model) {
		// j'initialise mon objet genre qui va �tre rempli dans mon formulaire
		Adherent adherent = new Adherent();
		adherent = adherentService.getAdherentById(idAdherent);

		// 1 je l'ajoute au mod�le afin qu'il soit accessible dans mon template
		model.addAttribute("adherent", adherent);

		// 2 - la liste des types de cotisation (utilisable par le template pour le
		// choix du statut)
		model.addAttribute("listeTypeCotisation", typeCotisationService.getTypeCotisations());

		// 3 - la liste des types de licence (utilisable par le template pour le choix
		// d'un adherent)
		model.addAttribute("listeTypeLicence", typeLicenceService.getTypeLicences());

		return "modification-adherent.html";
	}

	
	// @PostMapping est une annotation compos�e qui agit comme un raccourci pour
	// @RequestMapping(method = RequestMethod.POST).

	@PostMapping("/modificationAdherent") 
	public String postModificationAdherent(@Valid Adherent adherent, BindingResult br, Model model) {
		// si jamais l'adherent envoyé par le formulaire n'est pas valide
		if (br.hasErrors()) { 
			return "modification-adherent.html"; // alors on redirige vers le formulaire sans ajouter l'adherent }
		}

		// 2 - la liste des types de cotisation (utilisable par le template pour le choix du statut)
		model.addAttribute("listeTypeCotisation", typeCotisationService.getTypeCotisations());

		// 3 - la liste des types de licence (utilisable par le template pour le choix d'un adherent)
		model.addAttribute("listeTypeLicence", typeLicenceService.getTypeLicences());

		// sinon je l'ajoute � ma liste d'adh�rents en m�moire
		this.adherentService.updateAdherent(adherent);
		/*
		 * model.addAttribute(
		 * "confirmationMessage","l'adhérent a été ajouté avec succès");
		 */
		return "redirect:/adherents"; //je redirige vers la route /adherents du controleur en GET (redirect:/.br..)
		
	}
	 

	//Pour recuperer le detail d'un adherent
	@GetMapping("/detailAdherent/{idAdherent}")
	// @PathVariable : permet d'acc�der �la variable qui a le nom d�finit entre {} 
	// dans l'url (ici : {idAdhrent}
	public String getAdherent(@PathVariable long idAdherent, Model model) { 
		// j'ajoute au mod�le le film qui correspond �l'id du chemin
		model.addAttribute("adherent", adherentService.getAdherentById(idAdherent));
		return "detail-adherent.html";
	}

	// Pour recuperer la liste des adherents
	@GetMapping("/adherents")
	public String getAdherents(Model model, @RequestParam(required = false) String nom) {
		// si j'ai un param�re de recherche (nom=?)
		if (nom != null) {
			// alors j'ajoute au mod�lela liste des adh�rents filtr�s
			model.addAttribute("adherents", adherentService.getAdherentByName(nom));
			// si pas de param�re de recherche (nom=?)
		} else if (nom == null) {
			// on ajoute au modele la liste des adherents pour pouvoir l'afficher dans le
			// template
			model.addAttribute("adherents", adherentService.getAdherents());
		} else {
			// on ajoute au modele la liste des adherents pour pouvoir l'afficher dans le
			// template
			model.addAttribute("adherents", adherentService.getAdherents());
		}
		return "adherents.html"; // pas obligÃ© de rajouter l'extension .html
	}

	// Pour supprimer un adherent
	@GetMapping("/suppressionAdherent/{idAdherent}")
	public String removeAdherent(@PathVariable long idAdherent, Model model) { 
		adherentService.removeAdherentById(idAdherent);
		return "redirect:/adherents"; // je redirige vers la route /adherents du controleur en GET (redirect:/.br..)
	}
}