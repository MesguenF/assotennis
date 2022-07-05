package fr.eni.assotennis.repository;

import org.springframework.data.repository.CrudRepository;

import fr.eni.assotennis.bo.StatusBadge;

/*CrudRepository est une interface fournie par Spring.
Elle fournit des méthodes pour manipuler l'entité.
*/

public interface StatusBadgeRepository extends CrudRepository<StatusBadge, Long>{

		
}