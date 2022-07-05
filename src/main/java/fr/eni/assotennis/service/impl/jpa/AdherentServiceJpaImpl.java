package fr.eni.assotennis.service.impl.jpa;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import fr.eni.assotennis.bo.Adherent;
import fr.eni.assotennis.repository.AdherentRepository;
import fr.eni.assotennis.service.AdherentService;

/*@Service permet de d�clarer un bean de service, c�est � dire de la couche m�tier.*/
@Service

/*
 * La notion de profile permet d�activer ou d�sactiver des beans en fonction du contexte de d�ploiement.
 * 
 * Un bean annot� avec @Profile ne sera valable que si le profil sp�cifi� est actif dans le contexte Spring.
 */
@Profile("prod")	// ne sert que en mode prod (on n'�crit pas dans la base de donn�es mais en m�moire)
public class AdherentServiceJpaImpl implements AdherentService{

	/*
	 * L�annotation @Autowired permet d�activer l�injection automatique de d�pendance.
	 * Cette annotation peut �tre plac�e sur un constructeur, une m�thode ou directement sur un attribut.
	 * Le Spring Framework va chercher le bean du contexte d�application dont le type est applicable 
	 * � chaque param�tre du constructeur, aux param�tres de la m�thode ou � l�attribut.
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