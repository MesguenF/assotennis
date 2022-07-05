package fr.eni.assotennis.bo;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/*	------DATA JPA------
 * @Entity est une annotation qui indique que la classe correspond à une table de la base de données.
 */
@Entity
public class StatusBadge {

	//Les variables
    @Id // Definit que cet attribut correspond a  la clé primaire de notre table en base de données
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idStatusBadge;

    private String status;

    //Un status peut concerner plusieurs badges
    @OneToMany(mappedBy = "statusDuBadge", fetch = FetchType.EAGER)
    List<Badge> badges;

	//Les constructeurs
	public StatusBadge() {
		super();
	}
	
	public StatusBadge(int idStatusBadge, String status) {
		super();
		this.idStatusBadge = idStatusBadge;
		this.status = status;
	}
	
	//Getters and Setters
	public long getIdStatusBadge() {
		return idStatusBadge;
	}

	public void setIdStatusBadge(long idStatusBadge) {
		this.idStatusBadge = idStatusBadge;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<Badge> getBadges() {
		return badges;
	}

	public void setBadges(List<Badge> badges) {
		this.badges = badges;
	}
	
	/**
	 * Je surcharge le toString() car c'est cette méthode qui est appelée implicitement
	 * lorsqu'on affiche un objet de type StatusBadge dans un template ou en console
	 */
	@Override
	public String toString() {
		return "StatusBadge [idStatusBadge=" + idStatusBadge + ", status=" + status + "]";
	}
}