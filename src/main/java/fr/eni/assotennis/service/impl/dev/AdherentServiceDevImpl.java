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

/*@Service permet de d�clarer un bean de service, c�est � dire de la couche m�tier.*/
@Service

/*
 * La notion de profile permet d�activer ou d�sactiver des beans en fonction du contexte de d�ploiement.
 * 
 * Un bean annot� avec @Profile ne sera valable que si le profil sp�cifi� est actif dans le contexte Spring.
 */
@Profile("dev")	// ne sert que en mode dev (on n'écrit pas dans la base de donnée mais en mémoire)
public class AdherentServiceDevImpl implements AdherentService{

	// Pour le dev, on g�re nos adherents dans une liste en memoire
	private List<Adherent> adherents = new ArrayList<>();
	/**
	 * On initialise la liste des adherents dans le constructeur
	 */
	public AdherentServiceDevImpl() {
		adherents.add(new Adherent(1,"Mesguen","Fr�d�ric","rue de la com�te","Bern�",56240,47,"M",LocalDate.of(1975, 3, 27),"0297111886",
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
			// si jamais l'adhrent correspond à l'id demandé, on le retourne
			if (adherent.getIdAdherent() == id) {
				return adherent;
			}
		}
		return null; // si jamais on a pas trouvé le genre, on retourne null
	}

	/*
	 * @Override public Adherent getAdherentByName(String nom) { // on fait une
	 * boucle sur notre liste de genres for (Adherent adherent : adherents) { // si
	 * jamais l'adhrent correspond à l'id demandé, on le retourne if
	 * (adherent.getNom() == nom) { return adherent; } } return null; // si jamais
	 * on a pas trouvé le genre, on retourne null }
	 */

	@SuppressWarnings("unlikely-arg-type")
	@Override
	public void removeAdherentById(long id) {
		// on fait une boucle sur notre liste de genres
		for (Adherent adherent : adherents) {
			// si jamais le badge correspond à l'id demandé, on le supprime
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