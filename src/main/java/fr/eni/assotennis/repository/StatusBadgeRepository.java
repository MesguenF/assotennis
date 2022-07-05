package fr.eni.assotennis.repository;

import org.springframework.data.repository.CrudRepository;

import fr.eni.assotennis.bo.StatusBadge;

/*CrudRepository est une interface fournie par Spring.
Elle fournit des m�thodes pour manipuler l'entit�.
*/

public interface StatusBadgeRepository extends CrudRepository<StatusBadge, Long>{

		
}