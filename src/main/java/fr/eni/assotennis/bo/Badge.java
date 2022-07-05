package fr.eni.assotennis.bo;

import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import org.springframework.format.annotation.DateTimeFormat;

/*	------DATA JPA------
 * @Entity est une annotation qui indique que la classe correspond à une table de la base de données.
 */
@Entity
public class Badge {
	
	//Les variables
	@Id // Definit que cet attribut correspond a  la clé primaire de notre table en base de données
	private long numeroBadge;
		
	private String numeroSerie;
	
	private int montantCaution;
	
	private String cautionVersee;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate dateAcquisition;
	
	//LE MAPPING
	//Plusieurs status (Many) peuvent concerner un badge(One) de saison en saison
	@ManyToOne
    @JoinColumn(name = "id_status_badge")
    StatusBadge statusDuBadge;
	
	//Plusieurs badges (Many) peuvent correspondre à un adherent(One) de saison en saison
	@ManyToOne
    @JoinColumn(name = "id_adherent")
    Adherent adherentPossesseurDuBadge;
	
	//Les Constructeurs
	public Badge() {}
	
	public Badge(long numeroBadge, String numeroSerie, int montantCaution, String cautionVersee,
			LocalDate dateAcquisition, StatusBadge statusBadge, Adherent adherentPossesseurBadge) {
		super();
		this.numeroBadge = numeroBadge;
		this.numeroSerie = numeroSerie;
		this.montantCaution = montantCaution;
		this.cautionVersee = cautionVersee;
		this.dateAcquisition = dateAcquisition;
		this.statusDuBadge = statusBadge;
		this.adherentPossesseurDuBadge = adherentPossesseurBadge;
	}

	public Badge(long numeroBadge, String numeroSerie, int montantCaution, String cautionVersee,
			LocalDate dateAcquisition, long idStatusBadge, int idAdherent) {
		super();
		this.numeroBadge = numeroBadge;
		this.numeroSerie = numeroSerie;
		this.montantCaution = montantCaution;
		this.cautionVersee = cautionVersee;
		this.dateAcquisition = dateAcquisition;
		this.statusDuBadge.setIdStatusBadge(idStatusBadge); 
		this.adherentPossesseurDuBadge.setIdAdherent(idAdherent);
	}

	//Getters and Setters
	public long getNumeroBadge() {
		return numeroBadge;
	}

	public void setNumeroBadge(long numeroBadge) {
		this.numeroBadge = numeroBadge;
	}

	public String getNumeroSerie() {
		return numeroSerie;
	}

	public void setNumeroSerie(String numeroSerie) {
		this.numeroSerie = numeroSerie;
	}

	public int getMontantCaution() {
		return montantCaution;
	}

	public void setMontantCaution(int montantCaution) {
		this.montantCaution = montantCaution;
	}

	public String getCautionVersee() {
		return cautionVersee;
	}

	public void setCautionVersee(String cautionVersee) {
		this.cautionVersee = cautionVersee;
	}

	public LocalDate getDateAcquisition() {
		return dateAcquisition;
	}

	public void setDateAcquisition(LocalDate dateAcquisition) {
		this.dateAcquisition = dateAcquisition;
	}

	public StatusBadge getStatusDuBadge() {
		return statusDuBadge;
	}

	public void setStatusDuBadge(StatusBadge statusDuBadge) {
		this.statusDuBadge = statusDuBadge;
	}

	public Adherent getAdherentPossesseurDuBadge() {
		return adherentPossesseurDuBadge;
	}

	public void setAdherentPossesseurDuBadge(Adherent adherentPossesseurDuBadge) {
		this.adherentPossesseurDuBadge = adherentPossesseurDuBadge;
	}
	
	/**
	 * Je surcharge le toString() car c'est cette méthode qui est appelée implicitement
	 * lorsqu'on affiche un objet de type Badge dans un template ou en console
	 */
	@Override
	public String toString() {
		return "Badge [numeroBadge=" + numeroBadge + ", numeroSerie=" + numeroSerie + ", montantCaution="
				+ montantCaution + ", cautionVersee=" + cautionVersee + ", dateAcquisition=" + dateAcquisition + "]";
	}
}