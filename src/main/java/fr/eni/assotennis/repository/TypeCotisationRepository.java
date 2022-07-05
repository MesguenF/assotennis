/*Pour communiquer avec la source de données*/

/*
 * CrudRepository est une interface fournie par Spring.
 * Elle fournit des méthodes pour manipuler votre entité.
 * Elle utilise la généricité pour que son code soit applicable à n’importe quelle entité.
*/
package fr.eni.assotennis.repository;

import org.springframework.data.repository.CrudRepository;

import fr.eni.assotennis.bo.TypeCotisation;

/*CrudRepository est une interface fournie par Spring.
Elle fournit des méthodes pour manipuler l'entité.
*/

public interface TypeCotisationRepository extends CrudRepository<TypeCotisation, Long>{
	
	/* public List<TypeCotisation> findAll(); */
	
}