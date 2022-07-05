package fr.eni.assotennis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*
 * L’annotation @SpringBootApplication est la concaténation de plusieurs annotations,
 * et son objectif est de déclencher toute la mécanique interne de Spring.
 * */
@SpringBootApplication
public class AssotennisV61Application {

	public static void main(String[] args) {
		SpringApplication.run(AssotennisV61Application.class, args);
	}
}