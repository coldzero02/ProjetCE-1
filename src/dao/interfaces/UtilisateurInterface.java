package dao.interfaces;

import dao.beans.*;

public interface UtilisateurInterface {
	
	public void init();
	
	public String ajouterUtilisateur(Utilisateur u); 
	public Utilisateur getUtilisateur(Integer id);
	public Utilisateur getUtilisateur(String identifiant, String password);
	public void seDeconnecter();
	
}
