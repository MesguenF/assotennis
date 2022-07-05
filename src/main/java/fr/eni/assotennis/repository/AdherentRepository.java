/*Pour communiquer avec la source de donn�es*/

/*
 * CrudRepository est une interface fournie par Spring.
 * Elle fournit des m�thodes pour manipuler votre entit�.
 * Elle utilise la g�n�ricit� pour que son code soit applicable � n�importe quelle entit�.
*/
package fr.eni.assotennis.repository;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import fr.eni.assotennis.bo.Adherent;

/*CrudRepository est une interface fournie par Spring.
Elle fournit des m�thodes pour manipuler l'entit�.
*/
public interface AdherentRepository extends CrudRepository<Adherent, Long>{
	
	/*
	 * public List<Adherent> findAll();
	 */
	// va implémenter automatiquement cette méthode qui recherche (find) les adh�rents par (By) nom (Nom)
	// attention à bien respecter les conventions de nommage :
	// https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#jpa.query-methods
	public List<Adherent> findByNomStartingWith(String nom);
}