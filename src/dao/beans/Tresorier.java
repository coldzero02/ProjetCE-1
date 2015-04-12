package dao.beans;

public class Tresorier extends Utilisateur {
	
	public Tresorier(){
		super();
		this.setFonction("Tresorier") ;
	}
	public Tresorier(String nom, String prenom, String identifiant, String password) {
		super(nom, prenom, identifiant, password, "Tresorier");
	}
	
	@Override
	public String toString(){
		return "Tresorier Nom: " + getNom() + " - " + "Prenom : " + getPrenom() + " - " + "Login: " + getIdentifiant() + " - " + "pass: " + getPassword() ; 
	}
	
	public void show(){
		System.out.println(toString());
	}
}
