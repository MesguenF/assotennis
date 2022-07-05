package fr.eni.assotennis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import fr.eni.assotennis.service.TypeCotisationService;

/* @Controller permet de d�clarer un bean Web, c'est � dire de la couche pr�sentation.*/
@Controller

/*@Service permet de d�clarer un bean de service, c�est � dire de la couche m�tier.*/
@Service

@RequestMapping
public class TypeCotisationController {

	/*
	 * L�annotation @Autowired permet d�activer l�injection automatique de
	 * d�pendance.Le Spring Framework va chercher le bean du contexte d�application .
	 */
	@Autowired(required=false)
	TypeCotisationService typeCotisationService;

	@GetMapping("/typecotisations")
	public String getTypeCotisations(Model model) {
		
		/** j'ajoute au mod�le la liste des types de cotisation pour pouvoir l'afficher dans mon template**/
		model.addAttribute("typecotisations",typeCotisationService.getTypeCotisations());

		return "typecotisations.html";
	}
}