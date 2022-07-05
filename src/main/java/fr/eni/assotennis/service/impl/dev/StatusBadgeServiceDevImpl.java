package fr.eni.assotennis.service.impl.dev;

import java.util.ArrayList;
import java.util.List;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import fr.eni.assotennis.bo.StatusBadge;
import fr.eni.assotennis.service.StatusBadgeService;

/*@Service permet de déclarer un bean de service, c’est à dire de la couche métier.*/
@Service

/*
 * La notion de profile permet d’activer ou désactiver des beans en fonction du contexte de déploiement.
 * 
 * Un bean annoté avec @Profile ne sera valable que si le profil spécifié est actif dans le contexte Spring.
 */
@Profile("dev")	// ne sert que en mode dev (on n'Ã©crit pas dans la base de donnÃ©e mais en mÃ©moire)
public class StatusBadgeServiceDevImpl implements StatusBadgeService {

	// Pour le dev, on gère nos status de badge dans une liste en memoire
	private List<StatusBadge> statusBadges = new ArrayList<>();
	
	/**
	 * On initialise la liste des types de cotisation dans le constructeur
	 */
	public StatusBadgeServiceDevImpl() {
		statusBadges.add(new StatusBadge(1,"EMPRUNTE"));

		statusBadges.add(new StatusBadge(2,"DISPONIBLE"));

		statusBadges.add(new StatusBadge(3,"PERDU"));

		statusBadges.add(new StatusBadge(4,"CASSE"));
	}

	@Override
	public List<StatusBadge> getStatusBadges() {
		return statusBadges;
	}
	
	@Override
	public StatusBadge getStatusBadge(long id) {
		// on fait une boucle sur notre liste de status de badge
		for (StatusBadge statusBadge : statusBadges) {
			// si jamais le status correspond à l'id demande, on le retourne
			if (statusBadge.getIdStatusBadge()== id) {
				return statusBadge;
				}
			}
		return null; // si jamais on a pas trouvÃ© le genre, on retourne null
	}
}