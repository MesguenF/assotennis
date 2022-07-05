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
public class TypeCotisation {
	
	//Les variables
	@Id // Definit que cet attribut correspond a  la clé primaire de notre table en base de données
	@GeneratedValue(strategy = GenerationType.AUTO) // on definit comment on veut generer l'id en base de donnee (AUTO : on laisse la configuration par defaut)
	private long idTypeCotisation;
	
	private String categorieCotisation;
	
	private String detailCotisation;
		
	private int montantCotisation;

	//MAPPING
	// Un type de cotisation (One) peut concerner plusieurs (Many) adherents.
	@OneToMany(mappedBy = "typeCotisation", fetch = FetchType.LAZY)
	List<TypeCotisation> typeCotisation;
	 
	//Les constructeurs
	public TypeCotisation() {
		super();
	}
	public TypeCotisation(long idTypeCotisation, String categorieCotisation, String detailCotisation,
			int montantCotisation) {
		super();
		this.idTypeCotisation = idTypeCotisation;
		this.categorieCotisation = categorieCotisation;
		this.detailCotisation = detailCotisation;
		this.montantCotisation = montantCotisation;
	}

	//Getters and Setters
	public long getIdTypeCotisation() {
		return idTypeCotisation;
	}
	public void setIdTypeCotisation(long idTypeCotisation) {
		this.idTypeCotisation = idTypeCotisation;
	}
	
	public List<TypeCotisation> getTypeCotisation() {
		return typeCotisation;
	}
	public void setTypeCotisation(List<TypeCotisation> typeCotisation) {
		this.typeCotisation = typeCotisation;
	}
	
	public String getCategorieCotisation() {
		return categorieCotisation;
	}
	
	public void setCategorieCotisation(String categorieCotisation) {
		this.categorieCotisation = categorieCotisation;
	}

	public String getDetailCotisation() {
		return detailCotisation;
	}

	public void setDetailCotisation(String detailCotisation) {
		this.detailCotisation = detailCotisation;
	}

	public int getMontantCotisation() {
		return montantCotisation;
	}

	public void setMontantCotisation(int montantCotisation) {
		this.montantCotisation = montantCotisation;
	}
	
	/**
	 * Je surcharge le toString() car c'est cette méthode qui est appelée implicitement
	 * lorsqu'on affiche un objet de type TypeCotisation dans un template ou en console
	 */
	@Override
	public String toString() {
		return "TypeCotisation [idTypeCotisation=" + idTypeCotisation + ", categorieCotisation=" + categorieCotisation
				+ ", detailCotisation=" + detailCotisation + ", montantCotisation=" + montantCotisation + "]";
	}
}