package fr.eni.assotennis.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import fr.eni.assotennis.formatter.LocalDateFormatter;

public class AppliConfigurer implements WebMvcConfigurer {

	/*
	 * L’annotation @Autowired permet d’activer l’injection automatique de dépendance.
	 * Le Spring Framework va chercher le bean du contexte d’application.
	 */
	@Autowired LocalDateFormatter localDateFormatter;

	/**
	 * C'est ici qu'on specifie les formatters qu'on utilisera dans notre application
	 */
	@Override public void addFormatters(FormatterRegistry registry) {
		registry.addFormatter(localDateFormatter); }
			 
}