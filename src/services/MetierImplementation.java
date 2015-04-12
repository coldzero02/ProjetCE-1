package services;
import dao.beans.*;
import dao.interfaces.*;

import java.util.List;

public class MetierImplementation implements Metier {
	
	UtilisateurInterface utilisateur;
	EmployeInterface employe;
	PrestataireInterface prestataire;
	TresorierInterface tresorier;
	
	@Override
	public String ajouterUtilisateur(Utilisateur u) {
		
		return utilisateur.ajouterUtilisateur(u);
	}
	
	@Override
	public Utilisateur getUtilisateur(Integer id) {
		
		return utilisateur.getUtilisateur(id);
	}
	
	@Override
	public Utilisateur getUtilisateur(String identifiant,
			String password) {
		
		return utilisateur.getUtilisateur(identifiant, password);
	}
	@Override
	public Tresorier getTresorier(Integer id) {
		
		return tresorier.getTresorier(id);
	}
	@Override
	public void ajouterPrestation(Prestation p) {
		tresorier.ajouterPrestation(p);
		
	}
	@Override
	public void supprimerPrestation(Integer numero) {
		
		tresorier.supprimerPrestation(numero);
	}
	@Override
	public Prestation getPrestationById(Integer numero) {
		
		return tresorier.getPrestationById(numero);
	}
	@Override
	public List<Prestation> consulterPrestations(Integer idTre) {
		
		return tresorier.consulterPrestations(idTre);
	}
	@Override
	public void updateProduit(Prestation p) {
		tresorier.updateProduit(p);
		
	}
	@Override
	public Prestataire getPrestataire(Integer id) {
		
		return prestataire.getPrestataire(id);
	}
	@Override
	public Employe getEmploye(Integer id) {
		
		return employe.getEmploye(id);
	}

	public void setUtilisateur(UtilisateurInterface utilisateur) {
		this.utilisateur = utilisateur;
	}

	public void setEmploye(EmployeInterface employe) {
		this.employe = employe;
	}

	public void setPrestataire(PrestataireInterface prestataire) {
		this.prestataire = prestataire;
	}

	public void setTresorier(TresorierInterface tresorier) {
		this.tresorier = tresorier;
	}

	@Override
	public void seDeconnecter() {
		utilisateur.seDeconnecter();	
	}
	
	
}
