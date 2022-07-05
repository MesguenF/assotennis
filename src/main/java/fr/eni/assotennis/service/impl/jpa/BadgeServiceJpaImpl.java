package fr.eni.assotennis.service.impl.jpa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import fr.eni.assotennis.bo.Badge;
import fr.eni.assotennis.repository.BadgeRepository;
import fr.eni.assotennis.service.BadgeService;


/*@Service permet de d�clarer un bean de service, c�est � dire de la couche m�tier.*/
@Service

/*
 * La notion de profile permet d�activer ou d�sactiver des beans en fonction du contexte de d�ploiement.
 * 
 * Un bean annot� avec @Profile ne sera valable que si le profil sp�cifi� est actif dans le contexte Spring.
 */
@Profile("prod")	// ne sert que en mode prod (on n'�crit pas dans la base de donn�es mais en m�moire)
public class BadgeServiceJpaImpl implements BadgeService{

	/*
	 * L�annotation @Autowired permet d�activer l�injection automatique de d�pendance.
	 * Cette annotation peut �tre plac�e sur un constructeur, une m�thode ou directement sur un attribut.
	 * Le Spring Framework va chercher le bean du contexte d�application dont le type est applicable 
	 * � chaque param�tre du constructeur, aux param�tres de la m�thode ou � l�attribut.
	 */
	@Autowired
	BadgeRepository badgeRepository;

	@Override
	public List<Badge> getBadges() {
		return (List<Badge>) badgeRepository.findAll();
	}
	
	@Override
	public Badge addBadge(Badge badge) {
		badgeRepository.save(badge);
		return badge;
	}

	@Override
	public Badge getBadge(long id) {
		return badgeRepository.findById(id).get();
	}

	@Override
	public void removeBadge(long id) {
		badgeRepository.deleteById(id);
	}

	@Override
	public Badge updateBadge(long id) {
		return null;
		
	}
}