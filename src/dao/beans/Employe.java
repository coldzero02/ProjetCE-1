package dao.beans;

public class Employe extends Utilisateur {
	
	public Employe(){
		super();
		this.setFonction("Employe") ;
	}
	public Employe(String nom, String prenom, String identifiant, String password) {
		super(nom, prenom, identifiant, password, "Employe");
	}
	
	@Override
	public String toString(){
		return "Employe, Nom: " + getNom() + " - " + "Prenom : " + getPrenom() + " - " + "Login: " + getIdentifiant() + " - " + "pass: " + getPassword() ; 
	}
	
	public void show(){
		System.out.println(toString());
	}
}
