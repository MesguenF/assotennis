package fr.eni.assotennis.service.impl.dev;

import java.util.ArrayList;
import java.util.List;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import fr.eni.assotennis.bo.StatusBadge;
import fr.eni.assotennis.service.StatusBadgeService;

/*@Service permet de d�clarer un bean de service, c�est � dire de la couche m�tier.*/
@Service

/*
 * La notion de profile permet d�activer ou d�sactiver des beans en fonction du contexte de d�ploiement.
 * 
 * Un bean annot� avec @Profile ne sera valable que si le profil sp�cifi� est actif dans le contexte Spring.
 */
@Profile("dev")	// ne sert que en mode dev (on n'écrit pas dans la base de donnée mais en mémoire)
public class StatusBadgeServiceDevImpl implements StatusBadgeService {

	// Pour le dev, on g�re nos status de badge dans une liste en memoire
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
			// si jamais le status correspond � l'id demande, on le retourne
			if (statusBadge.getIdStatusBadge()== id) {
				return statusBadge;
				}
			}
		return null; // si jamais on a pas trouvé le genre, on retourne null
	}
}