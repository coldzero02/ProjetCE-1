package services;
import dao.beans.*;

import java.util.List;


public interface Metier {
	
	public Utilisateur getUtilisateur(Integer id);
	public Utilisateur getUtilisateur(String identifiant, String password); 
	public String ajouterUtilisateur(Utilisateur u);
	
	public Tresorier getTresorier(Integer id);
	public void ajouterPrestation(Prestation p);
	public void supprimerPrestation(Integer numero);
	public Prestation getPrestationById(Integer numero);
	public List<Prestation> consulterPrestations(Integer idTre);
	public void updateProduit(Prestation p);
	
	public Prestataire getPrestataire(Integer id);
	
	public Employe getEmploye(Integer id);
	public void seDeconnecter();
}
