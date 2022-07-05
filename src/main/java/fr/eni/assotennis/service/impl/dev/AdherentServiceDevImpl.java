package fr.eni.assotennis.service.impl.dev;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import fr.eni.assotennis.bo.Adherent;
import fr.eni.assotennis.bo.TypeCotisation;
import fr.eni.assotennis.bo.TypeLicence;
import fr.eni.assotennis.service.AdherentService;

/*@Service permet de déclarer un bean de service, c’est à dire de la couche métier.*/
@Service

/*
 * La notion de profile permet d’activer ou désactiver des beans en fonction du contexte de déploiement.
 * 
 * Un bean annoté avec @Profile ne sera valable que si le profil spécifié est actif dans le contexte Spring.
 */
@Profile("dev")	// ne sert que en mode dev (on n'Ã©crit pas dans la base de donnÃ©e mais en mÃ©moire)
public class AdherentServiceDevImpl implements AdherentService{

	// Pour le dev, on gère nos adherents dans une liste en memoire
	private List<Adherent> adherents = new ArrayList<>();
	/**
	 * On initialise la liste des adherents dans le constructeur
	 */
	public AdherentServiceDevImpl() {
		adherents.add(new Adherent(1,"Mesguen","Frédéric","rue de la comète","Berné",56240,47,"M",LocalDate.of(1975, 3, 27),"0297111886",
			"0630182329","fmesguen@free.fr","NON",LocalDate.of(2021, 9, 10),LocalDate.of(2022, 9, 01),"54156456LK","30/5","NC",new TypeCotisation(1,"BABY TENNIS","ADHESION SIMPLE",30),new TypeLicence(1, "BABY TENNIS",12)));
	}
		
	@Override
	public List<Adherent> getAdherents() {
		return adherents;
	}
	
	@Override
	public Adherent addAdherent(Adherent adherent) {
		adherents.add(adherent);
		return adherent;
	}
		
	@Override
	public Adherent getAdherentById(long id) {
		// on fait une boucle sur notre liste de genres
		for (Adherent adherent : adherents) {
			// si jamais l'adhrent correspond Ã  l'id demandÃ©, on le retourne
			if (adherent.getIdAdherent() == id) {
				return adherent;
			}
		}
		return null; // si jamais on a pas trouvÃ© le genre, on retourne null
	}

	/*
	 * @Override public Adherent getAdherentByName(String nom) { // on fait une
	 * boucle sur notre liste de genres for (Adherent adherent : adherents) { // si
	 * jamais l'adhrent correspond Ã  l'id demandÃ©, on le retourne if
	 * (adherent.getNom() == nom) { return adherent; } } return null; // si jamais
	 * on a pas trouvÃ© le genre, on retourne null }
	 */

	@SuppressWarnings("unlikely-arg-type")
	@Override
	public void removeAdherentById(long id) {
		// on fait une boucle sur notre liste de genres
		for (Adherent adherent : adherents) {
			// si jamais le badge correspond Ã  l'id demandÃ©, on le supprime
			if (adherent.getIdAdherent() == id) {
					adherents.remove(id);
			}
		}
	}

	@Override
	public void updateAdherent(Adherent adherent) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Adherent> getAdherentByName(String nom) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void removeAdherent(Adherent adherent) {
		// TODO Auto-generated method stub
		
	}
}