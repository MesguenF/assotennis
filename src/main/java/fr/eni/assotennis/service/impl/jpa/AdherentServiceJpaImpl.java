package fr.eni.assotennis.service.impl.jpa;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import fr.eni.assotennis.bo.Adherent;
import fr.eni.assotennis.repository.AdherentRepository;
import fr.eni.assotennis.service.AdherentService;

/*@Service permet de déclarer un bean de service, c’est à dire de la couche métier.*/
@Service

/*
 * La notion de profile permet d’activer ou désactiver des beans en fonction du contexte de déploiement.
 * 
 * Un bean annoté avec @Profile ne sera valable que si le profil spécifié est actif dans le contexte Spring.
 */
@Profile("prod")	// ne sert que en mode prod (on n'écrit pas dans la base de données mais en mémoire)
public class AdherentServiceJpaImpl implements AdherentService{

	/*
	 * L’annotation @Autowired permet d’activer l’injection automatique de dépendance.
	 * Cette annotation peut être placée sur un constructeur, une méthode ou directement sur un attribut.
	 * Le Spring Framework va chercher le bean du contexte d’application dont le type est applicable 
	 * à chaque paramètre du constructeur, aux paramètres de la méthode ou à l’attribut.
	 */
	@Autowired
	AdherentRepository adherentRepository;
	
	@Override
	public List<Adherent> getAdherents() {
		return (List<Adherent>) adherentRepository.findAll();
	}
	
	@Override
	public Adherent addAdherent(Adherent adherent) {
		return adherentRepository.save(adherent);
	}

	@Override
	public Adherent getAdherentById(long id) {
		return adherentRepository.findById(id).get();
	}

	@Override
	public void removeAdherentById(long idAdherent) {
		adherentRepository.deleteById(idAdherent);
	}

	@Override
	public void updateAdherent(Adherent adherent) {
		adherentRepository.save(adherent);
		
	}

	@Override
	public List<Adherent> getAdherentByName(String nom) {
		return adherentRepository.findByNomStartingWith(nom);
	}

	@Override
	public void removeAdherent(Adherent adherent) {
		adherentRepository.delete(adherent);
		
	}

	/*
	 * @Override public Adherent getAdherentByName(String nom) { // TODO
	 * Auto-generated method stub return null; }
	 */
}