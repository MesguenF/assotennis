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
public class TypeLicence {
	
	//Les variables
	@Id // Definit que cet attribut correspond a  la clé primaire de notre table en base de données
	@GeneratedValue(strategy = GenerationType.AUTO) // on definit comment on veut generer l'id en base de donnee (AUTO : on laisse la configuration par defaut)
	private long idTypeLicence;
	
	private String categorieLicence;
	
	private int montantLicence;
		
	//MAPPING
	// Un type de licence (One) peut correspondre à plusieurs (Many) adherents.
	@OneToMany(mappedBy = "typeLicence", fetch = FetchType.LAZY)
	List<TypeLicence> typeLicence;
	 
	//Les constructeurs
	public TypeLicence() {
		super();
	}
	
	public TypeLicence(long idTypeLicence, String categorieLicence, int montantLicence) {
		super();
		this.idTypeLicence = idTypeLicence;
		this.categorieLicence = categorieLicence;
		this.montantLicence = montantLicence;
	}
	
	//Getters and Setters
	public long getIdTypeLicence() {
		return idTypeLicence;
	}

	public void setIdTypeLicence(long idTypeLicence) {
		this.idTypeLicence = idTypeLicence;
	}

	public List<TypeLicence> getTypeLicence() {
		return typeLicence;
	}

	public void setTypeLicence(List<TypeLicence> typeLicence) {
		this.typeLicence = typeLicence;
	}

	public String getCategorieLicence() {
		return categorieLicence;
	}
	
	public void setCategorieLicence(String categorieLicence) {
		this.categorieLicence = categorieLicence;
	}
	
	public int getMontantLicence() {
		return montantLicence;
	}

	public void setMontantLicence(int montantLicence) {
		this.montantLicence = montantLicence;
	}
	
	/**
	 * Je surcharge le toString() car c'est cette méthode qui est appelée implicitement
	 * lorsqu'on affiche un objet de type TypeLicence dans un template ou en console
	 */
	@Override
	public String toString() {
		return "TypeLicence [idTypeLicence=" + idTypeLicence + ", categorieLicence=" + categorieLicence
				+ ", montantLicence=" + montantLicence + "]";
	}
}