package fr.eni.assotennis.service.impl.jpa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import fr.eni.assotennis.bo.StatusBadge;
import fr.eni.assotennis.repository.StatusBadgeRepository;
import fr.eni.assotennis.service.StatusBadgeService;


/*@Service permet de d�clarer un bean de service, c�est � dire de la couche m�tier.*/
@Service

/*
 * La notion de profile permet d�activer ou d�sactiver des beans en fonction du contexte de d�ploiement.
 * 
 * Un bean annot� avec @Profile ne sera valable que si le profil sp�cifi� est actif dans le contexte Spring.
 */
@Profile("prod")	// ne sert que en mode prod (on n'�crit pas dans la base de donn�es mais en m�moire)
public class StatusBadgeServiceJpaImpl implements StatusBadgeService {

	/*
	 * L�annotation @Autowired permet d�activer l�injection automatique de d�pendance.
	 * Cette annotation peut �tre plac�e sur un constructeur, une m�thode ou directement sur un attribut.
	 * Le Spring Framework va chercher le bean du contexte d�application dont le type est applicable 
	 * � chaque param�tre du constructeur, aux param�tres de la m�thode ou � l�attribut.
	 */
	@Autowired
	StatusBadgeRepository statusBadgeRepository;

	@Override
	public StatusBadge getStatusBadge(long id) {
		return statusBadgeRepository.findById(id).get();
	}

	@Override
	public List<StatusBadge> getStatusBadges() {
		return (List<StatusBadge>) statusBadgeRepository.findAll();
	}
}