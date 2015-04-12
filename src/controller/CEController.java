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
	Metier services;    
	
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
				return "espace-employe";	
			case "Prestataire":
				espace = "Espace Prestataire";
				model.addAttribute("espace", espace);
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
}
