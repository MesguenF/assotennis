package fr.eni.assotennis.service.impl.jpa;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import fr.eni.assotennis.bo.TypeCotisation;
import fr.eni.assotennis.repository.TypeCotisationRepository;
import fr.eni.assotennis.service.TypeCotisationService;

/*@Service permet de déclarer un bean de service, c’est à dire de la couche métier.*/
@Service

/*
 * La notion de profile permet d’activer ou désactiver des beans en fonction du contexte de déploiement.
 * 
 * Un bean annoté avec @Profile ne sera valable que si le profil spécifié est actif dans le contexte Spring.
 */
@Profile("prod")	// ne sert que en mode prod (on n'écrit pas dans la base de données mais en mémoire)
public class TypeCotisationServiceJpaImpl implements TypeCotisationService{
	
	/*
	 * L’annotation @Autowired permet d’activer l’injection automatique de dépendance.
	 * Cette annotation peut être placée sur un constructeur, une méthode ou directement sur un attribut.
	 * Le Spring Framework va chercher le bean du contexte d’application dont le type est applicable 
	 * à chaque paramètre du constructeur, aux paramètres de la méthode ou à l’attribut.
	 */
	@Autowired
	TypeCotisationRepository typeCotisationRepository;

	@Override
	public TypeCotisation getTypeCotisation(long id) {
		return typeCotisationRepository.findById(id).get();
	}
	
	@Override
	public List<TypeCotisation> getTypeCotisations() {
		return (List<TypeCotisation>) typeCotisationRepository.findAll();
	}
}