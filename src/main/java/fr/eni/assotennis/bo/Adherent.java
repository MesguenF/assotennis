package fr.eni.assotennis.bo;

import java.time.LocalDate;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/*	------DATA JPA------
 * @Entity est une annotation qui indique que la classe correspond à une table de la base de données.
 */
@Entity
public class Adherent {
	
	//Les variables
	@Id // Definit que cet attribut correspond a  la clé primaire de notre table en base de données
	@GeneratedValue(strategy = GenerationType.AUTO) // on definit comment on veut generer l'id en base de donnee (AUTO : on laisse la configuration par defaut)
	private long idAdherent;
	
	private String nom;
	
	private String prenom;
	
	private String adresse;
	
	private String ville;
	
	private int codePostal;
	
	private int age;
	
	private String sexe;
	
	private LocalDate dateNaissance;
	
	private String telephoneFixe;
	
	private String telephoneMobile;
	
	private String mail;
	
	private String certificatMedicalValide;
	
	private LocalDate dateCertificatMedical;
	
	private LocalDate dateAdhesion;
	
	private String numeroLicence;
	
	private String classementSimple;
	
	private String classementDouble;
		
	//MAPPING
	//Plusieurs type de cotisation (Many) peuvent correspondre à  un adherent(One)
	@ManyToOne
	@JoinColumn(name = "id_type_cotisation")
	TypeCotisation typeCotisation;

	//Plusieurs type de licence (Many) peuvent correspondre à  un adherent(One)
	@ManyToOne
	@JoinColumn(name = "id_type_licence")
	TypeLicence typeLicence;
	
	// Un adherent (One) correspond à plusieurs (Many) badges.
	@OneToMany(mappedBy = "adherentPossesseurDuBadge")
    List<Badge> badges;
	
	//Les constructeurs
	public Adherent() {}

	
	public Adherent(long idAdherent, String nom, String prenom, String adresse, String ville, int codePostal, int age,
			String sexe, LocalDate dateNaissance, String telephoneFixe, String telephoneMobile, String mail,String certificatMedicalValide,
			LocalDate dateCertificatMedical, LocalDate dateAdhesion, String numeroLicence, String classementSimple, String classementDouble,
			TypeCotisation typeCotisation, TypeLicence typeLicence) {
		super();
		this.idAdherent = idAdherent;
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
		this.ville = ville;
		this.codePostal = codePostal;
		this.age = age;
		this.sexe = sexe;
		this.dateNaissance = dateNaissance;
		this.telephoneFixe = telephoneFixe;
		this.telephoneMobile = telephoneMobile;
		this.mail = mail;
		this.certificatMedicalValide = certificatMedicalValide;
		this.dateCertificatMedical = dateCertificatMedical;
		this.dateAdhesion = dateAdhesion;
		this.numeroLicence = numeroLicence;
		this.classementSimple = classementSimple;
		this.classementDouble = classementDouble;
		this.typeCotisation = typeCotisation;
		this.typeLicence = typeLicence;
		}
	 
	public Adherent(long idAdherent, String nom, String prenom, String adresse, String ville, int codePostal, int age,
			String sexe, LocalDate dateNaissance, String telephoneFixe, String telephoneMobile, String mail,
			String certificatMedicalValide, LocalDate dateCertificatMedical, LocalDate dateAdhesion, String numeroLicence,
			String classementSimple, String classementDouble, int idtypeCotisation, int idtypeLicence) {
		super();
		this.idAdherent = idAdherent;
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
		this.ville = ville;
		this.codePostal = codePostal;
		this.age = age;
		this.sexe = sexe;
		this.dateNaissance = dateNaissance;
		this.telephoneFixe = telephoneFixe;
		this.telephoneMobile = telephoneMobile;
		this.mail = mail;
		this.certificatMedicalValide = certificatMedicalValide;
		this.dateCertificatMedical = dateCertificatMedical;
		this.dateAdhesion = dateAdhesion;
		this.numeroLicence = numeroLicence;
		this.classementSimple = classementSimple;
		this.classementDouble = classementDouble;
		this.typeCotisation.setIdTypeCotisation(idtypeCotisation);
		this.typeLicence.setIdTypeLicence(idtypeLicence);
	}
	
	//Getters and Setters
	public long getIdAdherent() {
		return idAdherent;
	}

	public void setIdAdherent(long idAdherent) {
		this.idAdherent = idAdherent;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public int getCodePostal() {
		return codePostal;
	}

	public void setCodePostal(int codePostal) {
		this.codePostal = codePostal;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getSexe() {
		return sexe;
	}

	public void setSexe(String sexe) {
		this.sexe = sexe;
	}

	public LocalDate getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(LocalDate dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	public String getTelephoneFixe() {
		return telephoneFixe;
	}

	public void setTelephoneFixe(String telephoneFixe) {
		this.telephoneFixe = telephoneFixe;
	}

	public String getTelephoneMobile() {
		return telephoneMobile;
	}

	public void setTelephoneMobile(String telephoneMobile) {
		this.telephoneMobile = telephoneMobile;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getCertificatMedicalValide() {
		return certificatMedicalValide;
	}

	public void setCertificatMedicalValide(String certificatMedicalValide) {
		this.certificatMedicalValide = certificatMedicalValide;
	}

	public LocalDate getDateCertificatMedical() {
		return dateCertificatMedical;
	}

	public void setDateCertificatMedical(LocalDate dateCertificatMedical) {
		this.dateCertificatMedical = dateCertificatMedical;
	}

	public LocalDate getDateAdhesion() {
		return dateAdhesion;
	}

	public void setDateAdhesion(LocalDate dateAdhesion) {
		this.dateAdhesion = dateAdhesion;
	}

	public String getNumeroLicence() {
		return numeroLicence;
	}

	public void setNumeroLicence(String numeroLicence) {
		this.numeroLicence = numeroLicence;
	}

	public String getClassementSimple() {
		return classementSimple;
	}

	public void setClassementSimple(String classementSimple) {
		this.classementSimple = classementSimple;
	}

	public String getClassementDouble() {
		return classementDouble;
	}

	public void setClassementDouble(String classementDouble) {
		this.classementDouble = classementDouble;
	}

	public TypeCotisation getTypeCotisation() {
		return typeCotisation;
	}

	public void setTypeCotisation(TypeCotisation typeCotisation) {
		this.typeCotisation = typeCotisation;
	}

	public TypeLicence getTypeLicence() {
		return typeLicence;
	}

	public void setTypeLicence(TypeLicence typeLicence) {
		this.typeLicence = typeLicence;
	}

	public List<Badge> getBadges() {
		return badges;
	}

	public void setBadges(List<Badge> badges) {
		this.badges = badges;
	}
	
	/**
	 * Je surcharge le toString() car c'est cette méthode qui est appelée implicitement
	 * lorsqu'on affiche un objet de type Adherent dans un template ou en console
	 */
	@Override
	public String toString() {
		return "Adherent [idAdherent=" + idAdherent + ", nom=" + nom + ", prenom=" + prenom + ", adresse=" + adresse
				+ ", ville=" + ville + ", codePostal=" + codePostal + ", age=" + age + ", sexe=" + sexe
				+ ", dateNaissance=" + dateNaissance + ", telephoneFixe=" + telephoneFixe + ", telephoneMobile="
				+ telephoneMobile + ", mail=" + mail + ", certificatMedicalValide=" + certificatMedicalValide
				+ ", dateCertificatMedical=" + dateCertificatMedical + ", dateAdhesion=" + dateAdhesion
				+ ", numeroLicence=" + numeroLicence + ", classementSimple=" + classementSimple + ", classementDouble="
				+ classementDouble + "]";
	}
}