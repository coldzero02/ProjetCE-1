package dao.beans;

public class Utilisateur {
	
	private Integer id;
	private String nom, prenom, identifiant, password;
	private String fonction;
	
	public Utilisateur() {
		super();
	}

	public Utilisateur(String nom, String prenom, String identifiant,
			String password, String fonction) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.identifiant = identifiant;
		this.password = password;
		this.fonction = fonction;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public String getIdentifiant() {
		return identifiant;
	}

	public void setIdentifiant(String identifiant) {
		this.identifiant = identifiant;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFonction() {
		return fonction;
	}

	public void setFonction(String fonction) {
		this.fonction = fonction;
	}
	
	public boolean sIdentifier(String identifiant, String password){
		boolean correct = this.identifiant.equals(identifiant) & this.password.equals(password) ;
		return correct;		
	}
	@Override
	public String toString(){
		return "Fonction: "+getFonction()+"Nom:" + getNom() + " - " + "Prenom : " + getPrenom() + " - " + "Login: " + getIdentifiant() + " - " + "pass: " + getPassword() ; 
	}
	
	public void show(){
		System.out.println(toString());
	}
}
