package fr.eni.assotennis.controller;

import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/* @Controller permet de déclarer un bean Web, c'est à  dire de la couche présentation.*/
@Controller

/*@Service permet de déclarer un bean de service, c’est à dire de la couche métier.*/
@Service

@RequestMapping("/")
public class PageAccueilController {

	  @GetMapping("/")
	  public String home() {
		  return "page-accueil.html";
		  }
}