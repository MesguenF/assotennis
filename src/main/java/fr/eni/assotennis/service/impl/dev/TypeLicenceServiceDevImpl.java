package fr.eni.assotennis.service.impl.dev;

import java.util.ArrayList;
import java.util.List;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import fr.eni.assotennis.bo.TypeLicence;
import fr.eni.assotennis.service.TypeLicenceService;

/*@Service permet de d�clarer un bean de service, c�est � dire de la couche m�tier.*/
@Service

/*
 * La notion de profile permet d�activer ou d�sactiver des beans en fonction du contexte de d�ploiement.
 * 
 * Un bean annot� avec @Profile ne sera valable que si le profil sp�cifi� est actif dans le contexte Spring.
 */
@Profile("dev")	// ne sert que en mode dev (on n'écrit pas dans la base de donnée mais en mémoire)
public class TypeLicenceServiceDevImpl implements TypeLicenceService{

	// Pour le dev, on g�re nos types de licence dans une liste en memoire
	private List<TypeLicence> typeLicences = new ArrayList<>();
	/**
	 * On initialise la liste des genres dans le constructeur
	 */
	public TypeLicenceServiceDevImpl() {
		
		typeLicences.add(new TypeLicence(1, "BABY TENNIS",12));
		
		typeLicences.add(new TypeLicence(2,"JEUNES",22));
		
		typeLicences.add(new TypeLicence(3,"ADULTES",32));
	}
		
	@Override
	public List<TypeLicence> getTypeLicences() {
		return typeLicences;
	}
	
	@Override
	public TypeLicence getTypeLicence(long id) {
		// on fait une boucle sur notre liste de types de licence
		for (TypeLicence typeLicence : typeLicences) {
			// si jamais le typeLicence correspond � l'id demande, on le retourne
			if (typeLicence.getIdTypeLicence() == id) {
				return typeLicence;
			}
		}
		return null; // si jamais on a pas trouvé le genre, on retourne null
	}
}