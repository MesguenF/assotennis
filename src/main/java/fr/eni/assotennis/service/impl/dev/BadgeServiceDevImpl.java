package fr.eni.assotennis.service.impl.dev;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import fr.eni.assotennis.bo.Adherent;
import fr.eni.assotennis.bo.Badge;
import fr.eni.assotennis.bo.StatusBadge;
import fr.eni.assotennis.bo.TypeCotisation;
import fr.eni.assotennis.bo.TypeLicence;
import fr.eni.assotennis.service.BadgeService;

/*@Service permet de déclarer un bean de service, c’est à dire de la couche métier.*/
@Service

/*
 * La notion de profile permet d’activer ou désactiver des beans en fonction du
 * contexte de déploiement.
 * 
 * Un bean annoté avec @Profile ne sera valable que si le profil spécifié est
 * actif dans le contexte Spring.
 */
@Profile("dev") // ne sert que en mode dev (on n'Ã©crit pas dans la base de donnÃ©e mais en
				// mÃ©moire)
public class BadgeServiceDevImpl implements BadgeService {

	// Pour le dev, on gère nos badges dans une liste en memoire
	private List<Badge> badges = new ArrayList<>();

	/**
	 * On initialise la liste des badges dans le constructeur
	 */
	public BadgeServiceDevImpl() {

		badges.add(new Badge(1, "00567tr", 50, "NON", LocalDate.of(2022, 10, 12), new StatusBadge(3, "PERDU"),
				new Adherent(1, "Mesguen", "Frédéric", "rue de la comète", "Berné", 56240, 47, "M",
						LocalDate.of(1975, 3, 27), "0297111886", "0630182329", "fmesguen@free.fr", "NON",
						LocalDate.of(2021, 9, 10), LocalDate.of(2022, 9, 01), "54156456LK", "30/5", "NC",
						new TypeCotisation(1, "BABY TENNIS", "ADHESION SIMPLE", 30),
						new TypeLicence(1, "BABY TENNIS", 12))));

		badges.add(new Badge(2, "25567t5", 50, "OUI", LocalDate.of(2022, 9, 12), new StatusBadge(3, "PERDU"),
				new Adherent(1, "Mesguen", "Frédéric", "rue de la comète", "Berné", 56240, 47, "M",
						LocalDate.of(1975, 3, 27), "0297111886", "0630182329", "fmesguen@free.fr", "NON",
						LocalDate.of(2021, 9, 10), LocalDate.of(2022, 9, 01), "54156456LK", "30/5", "NC",
						new TypeCotisation(1, "BABY TENNIS", "ADHESION SIMPLE", 30),
						new TypeLicence(1, "BABY TENNIS", 12))));

		badges.add(new Badge(3, "38977tgh", 50, "OUI", LocalDate.of(2021, 10, 12), new StatusBadge(3, "PERDU"),
				new Adherent(1, "Mesguen", "Frédéric", "rue de la comète", "Berné", 56240, 47, "M",
						LocalDate.of(1975, 3, 27), "0297111886", "0630182329", "fmesguen@free.fr", "NON",
						LocalDate.of(2021, 9, 10), LocalDate.of(2022, 9, 01), "54156456LK", "30/5", "NC",
						new TypeCotisation(1, "BABY TENNIS", "ADHESION SIMPLE", 30),
						new TypeLicence(1, "BABY TENNIS", 12))));

		badges.add(new Badge(4, "34544fd", 50, "NON", LocalDate.of(2020, 10, 03), new StatusBadge(3, "PERDU"),
				new Adherent(1, "Mesguen", "Frédéric", "rue de la comète", "Berné", 56240, 47, "M",
						LocalDate.of(1975, 3, 27), "0297111886", "0630182329", "fmesguen@free.fr", "NON",
						LocalDate.of(2021, 9, 10), LocalDate.of(2022, 9, 01), "54156456LK", "30/5", "NC",
						new TypeCotisation(1, "BABY TENNIS", "ADHESION SIMPLE", 30),
						new TypeLicence(1, "BABY TENNIS", 12))));
	}

	@Override
	public List<Badge> getBadges() {
		return badges;
	}

	@Override
	public Badge addBadge(Badge badge) {
		badges.add(badge);
		return badge;
	}

	@Override
	public Badge getBadge(long id) {
		// on fait une boucle sur notre liste de genres
		for (Badge badge : badges) {
			// si jamais le badge correspond Ã  l'id demandÃ©, on le retourne
			if (badge.getNumeroBadge() == id) {
				return badge;
			}
		}
		return null; // si jamais on a pas trouvÃ© le genre, on retourne null
	}

	@SuppressWarnings("unlikely-arg-type")
	@Override
	public void removeBadge(long id) {
		// on fait une boucle sur notre liste de genres
		for (Badge badge : badges) {
			// si jamais le badge correspond Ã  l'id demandÃ©, on le supprime
			if (badge.getNumeroBadge() == id) {
				badges.remove(id);
			}
		}
	}

	@Override
	public Badge updateBadge(long id) {
		// TODO Auto-generated method stub
		return null;
	}
}