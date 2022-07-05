/*Pour communiquer avec la source de donn�es*/

/*
 * CrudRepository est une interface fournie par Spring.
 * Elle fournit des m�thodes pour manipuler votre entit�.
 * Elle utilise la g�n�ricit� pour que son code soit applicable � n�importe quelle entit�.
*/
package fr.eni.assotennis.repository;

import org.springframework.data.repository.CrudRepository;

import fr.eni.assotennis.bo.TypeLicence;

/*CrudRepository est une interface fournie par Spring.
Elle fournit des m�thodes pour manipuler l'entit�.
*/

public interface TypeLicenceRepository extends CrudRepository<TypeLicence, Long>{

	/* public List<TypeLicence> findAll(); */
	
}