package fr.eni.assotennis.controller;

import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/* @Controller permet de d�clarer un bean Web, c'est � dire de la couche pr�sentation.*/
@Controller

/*@Service permet de d�clarer un bean de service, c�est � dire de la couche m�tier.*/
@Service

@RequestMapping("/")
public class PageAccueilController {

	  @GetMapping("/")
	  public String home() {
		  return "page-accueil.html";
		  }
}