package controller;


import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import dao.beans.*;
import services.Metier;

@Controller
public class CEController {

	@Autowired         
	Metier services;    // services est un interface: spring, grace à @Autowired, lui associe une instanciation des l'objet qcmService définit dans spring-beans.xml
	
	@RequestMapping(value="/accueil")
	public String accueil(Model model){
		
		return "accueil";
	}
	
	@RequestMapping(value="/nouveauUser")
	public String nouveauUser(Model model, 
							  @RequestParam(value="nom") String nom,
							  @RequestParam(value="prenom") String prenom,
							  @RequestParam(value="identifiant") String identifiant,
							  @RequestParam(value="password") String password,
							  @RequestParam(value="fonction") String fonction){
		
		Utilisateur u = new Utilisateur(nom, prenom, identifiant, password, fonction);
		u.show();
		String style_ajout = services.ajouterUtilisateur(u);
		String message_ajout ;
		if (style_ajout.equals("succes")) message_ajout = "Utilisateur ajouté avec succès";
		else message_ajout = "Cette identifiant existe déjà";
		model.addAttribute("user", u);
		model.addAttribute("message_ajout", message_ajout);
		model.addAttribute("style_ajout", style_ajout);
		
		return "accueil";
	}

	
	@RequestMapping(value="/authentification")
	public String sidentifier(Model model ,
							  @RequestParam(value="identifiant") String identifiant,
							  @RequestParam(value="password") String password){
		String message = "";

		Utilisateur user = services.getUtilisateur(identifiant, password);
		String espace;
		String bonjour;
		
		if(user != null){
			
			bonjour = "Bonjour "+user.getNom() +" "+ user.getPrenom();			
			model.addAttribute("bonjour", bonjour);
			model.addAttribute("user", user);
			
			switch (user.getFonction()) {
			case "Employe":
				espace = "Espace Employé";
				model.addAttribute("espace", espace);
				//model.addAttribute("liste???", services.consulterQcm(userEmp.getId()));
				return "espace-employe";	
			case "Prestataire":
				espace = "Espace Prestataire";
				model.addAttribute("espace", espace);
				//model.addAttribute("liste???", services.consulterQcm(userPres.getId()));
				return "espace-prestataire";	
			case "Tresorier":
				espace = "Espace Tresorier";
				model.addAttribute("espace", espace);
				model.addAttribute("displayCorpsAccueil", "block");
				model.addAttribute("displayCorps", "none");
				model.addAttribute("displayInfosPerso", "none");   
				model.addAttribute("displayMdp", "none"); 
				model.addAttribute("displayPrestation", "none"); 
				model.addAttribute("displayBudget", "none"); 
				//model.addAttribute("liste???", services.consulterQcm(userTres.getId()));
				return "espace-tresorier";	
			default:
				return "accueil";
			}			
		}else {
			message = "Identifiant ou mot de pass incorrect, réessayer!";
			model.addAttribute("message", message);
			return "accueil";
		}
	}
	
	
	@RequestMapping(value="/seDeconnecter")
	public String seDeconnecter(Model model){	
		//services.seDeconnecter();
		return "accueil";
	}

	@RequestMapping(value="/accueilTresorier")
	public String accueilTresorier(Model model,
								   @RequestParam(value="id") Integer id,
			  					   @RequestParam(value="bonjour") String bonjour,
			  					   @RequestParam(value="espace") String espace){
		Tresorier user = services.getTresorier(id);
		model.addAttribute("bonjour", bonjour);
		model.addAttribute("espace" , espace);
		model.addAttribute("user"   , user);
		model.addAttribute("espace", espace);
		model.addAttribute("displayCorpsAccueil", "block");
		model.addAttribute("displayCorps", "none");
		model.addAttribute("displayInfosPerso", "none");   
		model.addAttribute("displayMdp", "none"); 
		model.addAttribute("displayPrestation", "none"); 
		model.addAttribute("displayBudget", "none"); 
		return "espace-tresorier";
	}
	
	@RequestMapping(value="/infosPersoTresorier")
	public String infosPersoTresorier(Model model,
									   @RequestParam(value="id") Integer id,
				  					   @RequestParam(value="bonjour") String bonjour,
				  					   @RequestParam(value="espace") String espace){
		Tresorier user = services.getTresorier(id);
		model.addAttribute("bonjour", bonjour);
		model.addAttribute("espace" , espace);
		model.addAttribute("user"   , user);
		model.addAttribute("espace", espace);
		
		model.addAttribute("displayCorpsAccueil", "none");
		model.addAttribute("displayCorps", "block");
		model.addAttribute("displayInfosPerso", "block");   
		model.addAttribute("displayMdp", "none"); 
		model.addAttribute("displayPrestation", "none"); 
		model.addAttribute("displayBudget", "none"); 
		return "espace-tresorier";
	}
	
	
	@RequestMapping(value="/modifierMdpTresorier")
	public String modifierMdpTresorier(Model model,
									   @RequestParam(value="id") Integer id,
				  					   @RequestParam(value="bonjour") String bonjour,
				  					   @RequestParam(value="espace") String espace){
		Tresorier user = services.getTresorier(id);
		model.addAttribute("bonjour", bonjour);
		model.addAttribute("espace" , espace);
		model.addAttribute("user"   , user);
		model.addAttribute("espace", espace);
		
		model.addAttribute("displayCorpsAccueil", "none");
		model.addAttribute("displayCorps", "block");
		model.addAttribute("displayInfosPerso", "none");   
		model.addAttribute("displayMdp", "block"); 
		model.addAttribute("displayPrestation", "none"); 
		model.addAttribute("displayBudget", "none"); 
		return "espace-tresorier";
	}
	
	
	@RequestMapping(value="/saisirPrestations")
	public String saisirPrestations(Model model,
									   @RequestParam(value="id") Integer id,
				  					   @RequestParam(value="bonjour") String bonjour,
				  					   @RequestParam(value="espace") String espace){
		Tresorier user = services.getTresorier(id);
		model.addAttribute("bonjour", bonjour);
		model.addAttribute("espace" , espace);
		model.addAttribute("user"   , user);
		model.addAttribute("espace", espace);
		
		model.addAttribute("displayCorpsAccueil", "none");
		model.addAttribute("displayCorps", "block");
		model.addAttribute("displayInfosPerso", "none");   
		model.addAttribute("displayMdp", "none"); 
		model.addAttribute("displayPrestation", "block"); 
		model.addAttribute("displayBudget", "none"); 
		return "espace-tresorier";
	}
	
	@RequestMapping(value="/consulterBudget")
	public String consulterBudget(Model model,
									   @RequestParam(value="id") Integer id,
				  					   @RequestParam(value="bonjour") String bonjour,
				  					   @RequestParam(value="espace") String espace){
		Tresorier user = services.getTresorier(id);
		model.addAttribute("bonjour", bonjour);
		model.addAttribute("espace" , espace);
		model.addAttribute("user"   , user);
		model.addAttribute("espace", espace);
		
		model.addAttribute("displayCorpsAccueil", "none");
		model.addAttribute("displayCorps", "block");
		model.addAttribute("displayInfosPerso", "none");   
		model.addAttribute("displayMdp", "none"); 
		model.addAttribute("displayPrestation", "none"); 
		model.addAttribute("displayBudget", "block"); 
		return "espace-tresorier";
	}
	/*
	 * 
	@RequestMapping(value="/nouveauQcm")
	public String nouveauProduit(Model model, @RequestParam(value="idEmp") Integer idEmp,											 
											  @RequestParam(value="question") String question,
											  @RequestParam(value="choix1") String choix1,
											  @RequestParam(value="choix2") String choix2,
											  @RequestParam(value="choix3") String choix3,
											  @RequestParam(value="choix4") String choix4,
											  @RequestParam(value="bonneRep") String bonneRep ){
		System.out.println("\n\n");
		System.out.println("---------------- Debut Test /nouveauQcm dans le controller -------------");
		System.out.println("niveau1 ");
		
		Employe user = services.getEmploye(idEmp);
		System.out.println("niveau2: idEmp = "+idEmp + "User: "+user.toString());
		
	    String dateCreation;
        dateCreation = "2000";
        System.out.println("niveau3 ");
        
        Qcm qcm = new Qcm(dateCreation, question, user.getId(), choix1, choix2, choix3, choix4, bonneRep);
        System.out.print("niveau4 : Qcm à ajouter: ");qcm.show();
		services.ajouterQcm(qcm);	
		model.addAttribute("listeQcms", services.consulterQcm(user.getId())); 
		System.out.println("niveau5 ");       
		model.addAttribute("qcm", qcm);
		System.out.println("niveau6 : size liste consulter qcm: "+services.consulterQcm(user.getId()).size());
		model.addAttribute("user", user);
		System.out.println("utilisateur: "+user.toString()); //user.show();
		String espace = "Espace Employé";
		String bonjour  = "Bonjour "+user.getNom() +" "+ user.getPrenom();
		
		System.out.println(bonjour);
		model.addAttribute("bonjour", bonjour);
		model.addAttribute("espace", espace);
		
		System.out.println("---------------- Fin Test /nouveauQcm dans le controller -------------");
		System.out.println("\n\n");
		return "espace-employe";
	}
	
	
	@RequestMapping(value="/supprimer")
	public String supprimerProduit(Model model, @RequestParam(value="id") Integer id,
												@RequestParam(value="idEmp") Integer idEmp){
		System.out.println("\n\n");
		System.out.println("---------------- Debut Test /supprimer dans le controller -------------");
		Employe user = services.getEmploye(idEmp);
		user.show();
		System.out.println("id QCMMMMMM: "+id);
		services.supprimerQcm(id); 
		model.addAttribute("listeQcms", services.consulterQcm(idEmp));
		model.addAttribute("user", user);
		
		String espace = "Espace Employé";
		String bonjour  = "Bonjour "+user.getNom() +" "+ user.getPrenom();
		model.addAttribute("espace", espace);
		model.addAttribute("bonjour", bonjour);
		
		System.out.println("---------------- Fin Test /supprimer dans le controller -------------");
		System.out.println("\n\n");
		
		return "espace-employe";
	}
	*/
}
