package fr.eni.assotennis.service.impl.dev;

import java.util.ArrayList;
import java.util.List;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import fr.eni.assotennis.bo.TypeLicence;
import fr.eni.assotennis.service.TypeLicenceService;

/*@Service permet de déclarer un bean de service, c’est à dire de la couche métier.*/
@Service

/*
 * La notion de profile permet d’activer ou désactiver des beans en fonction du contexte de déploiement.
 * 
 * Un bean annoté avec @Profile ne sera valable que si le profil spécifié est actif dans le contexte Spring.
 */
@Profile("dev")	// ne sert que en mode dev (on n'Ã©crit pas dans la base de donnÃ©e mais en mÃ©moire)
public class TypeLicenceServiceDevImpl implements TypeLicenceService{

	// Pour le dev, on gère nos types de licence dans une liste en memoire
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
			// si jamais le typeLicence correspond à l'id demande, on le retourne
			if (typeLicence.getIdTypeLicence() == id) {
				return typeLicence;
			}
		}
		return null; // si jamais on a pas trouvÃ© le genre, on retourne null
	}
}