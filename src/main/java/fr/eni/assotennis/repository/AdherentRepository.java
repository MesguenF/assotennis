/*Pour communiquer avec la source de données*/

/*
 * CrudRepository est une interface fournie par Spring.
 * Elle fournit des méthodes pour manipuler votre entité.
 * Elle utilise la généricité pour que son code soit applicable à n’importe quelle entité.
*/
package fr.eni.assotennis.repository;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import fr.eni.assotennis.bo.Adherent;

/*CrudRepository est une interface fournie par Spring.
Elle fournit des méthodes pour manipuler l'entité.
*/
public interface AdherentRepository extends CrudRepository<Adherent, Long>{
	
	/*
	 * public List<Adherent> findAll();
	 */
	// va implÃ©menter automatiquement cette mÃ©thode qui recherche (find) les adhérents par (By) nom (Nom)
	// attention Ã  bien respecter les conventions de nommage :
	// https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#jpa.query-methods
	public List<Adherent> findByNomStartingWith(String nom);
}