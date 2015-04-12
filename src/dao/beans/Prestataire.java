package dao.beans;

public class Prestataire extends Utilisateur {
	
	public Prestataire(){
		super();
		this.setFonction("Prestataire") ;
	}
	public Prestataire(String nom, String prenom, String identifiant, String password) {
		super(nom, prenom, identifiant, password, "Prestataire");
	}
	@Override
	public String toString(){
		return "Prestataire Nom: " + getNom() + " - " + "Prenom : " + getPrenom() + " - " + "Login: " + getIdentifiant() + " - " + "pass: " + getPassword() ; 
	}
	
	public void show(){
		System.out.println(toString());
	}
}
