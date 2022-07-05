package fr.eni.assotennis.service.impl.dev;

import java.util.ArrayList;
import java.util.List;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import fr.eni.assotennis.bo.TypeCotisation;
import fr.eni.assotennis.service.TypeCotisationService;

/*@Service permet de d�clarer un bean de service, c�est � dire de la couche m�tier.*/
@Service

/*
 * La notion de profile permet d�activer ou d�sactiver des beans en fonction du contexte de d�ploiement.
 * 
 * Un bean annot� avec @Profile ne sera valable que si le profil sp�cifi� est actif dans le contexte Spring.
 */
@Profile("dev")	// ne sert que en mode dev (on n'écrit pas dans la base de donnée mais en mémoire)
public class TypeCotisationServiceDevImpl implements TypeCotisationService{
	
	// Pour le dev, on g�re nos types de cotisation dans une liste en memoire
	private List<TypeCotisation> typeCotisations = new ArrayList<>();
	/**
	 * On initialise la liste des types de cotisation dans le constructeur
	 */
	public TypeCotisationServiceDevImpl() {
		
		typeCotisations.add(new TypeCotisation(1,"BABY TENNIS","ADHESION SIMPLE",30));

		typeCotisations.add(new TypeCotisation(2,"JEUNES","ADHESION SIMPLE",85));

		typeCotisations.add(new TypeCotisation(3,"JEUNES","ADHESION + COURS 1H30",190));

		typeCotisations.add(new TypeCotisation(4,"JEUNES","ADHESION + COURS 1H + ENTRAINEMENT SUPPLEMENTAIRE",200));

		typeCotisations.add(new TypeCotisation(5,"ADULTES","ADHESION SIMPLE",95));

		typeCotisations.add(new TypeCotisation(6,"ADULTES","ADHESION + COURS 1H30",120));

		typeCotisations.add(new TypeCotisation(7,"ADULTES","'ADHESION + COURS 1H30 + ENTRAINEMENT SUPPLEMENTAIRE",290));

	}

	@Override
	public List<TypeCotisation> getTypeCotisations() {
		return typeCotisations;
	}	
	
	@Override
	public TypeCotisation getTypeCotisation(long id) {
		// on fait une boucle sur notre liste de types de licence
		for (TypeCotisation typeCotisation : typeCotisations) {
			// si jamais le typeLicence correspond � l'id demande, on le retourne
			if (typeCotisation.getIdTypeCotisation() == id) {
				return typeCotisation;
				}
			}
		return null; // si jamais on a pas trouvé le genre, on retourne null
	}
}