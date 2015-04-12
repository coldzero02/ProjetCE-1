package dao.Implementations;
import java.util.List;
import dao.interfaces.*;
import dao.beans.*;

import org.hibernate.Session;

import util.HibernateUtil;

public class UtilisateurImplementation implements UtilisateurInterface {

	@Override
	public void init() {
		// TODO Auto-generated method stub
	}
	
	@Override
	public String ajouterUtilisateur(Utilisateur u) {
		
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();	
		session.beginTransaction();	
		
		String requete = "from Utilisateur where identifiant = '" + u.getIdentifiant() + "'"; 		
		List<Utilisateur> liste_users = (List<Utilisateur>) session.createQuery(requete).list();
		
		String chaine;
		if(liste_users.isEmpty()) {
			session.save(u);
			session.getTransaction().commit();
			chaine = "succes";
		}else {
			chaine = "erreur";
		}
		return chaine;
	}
	
	@Override
	public Utilisateur getUtilisateur(Integer id) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();	
		Utilisateur u = (Utilisateur) session.load(Utilisateur.class, id);
		return u;
	}

	@Override
	public Utilisateur getUtilisateur(String identifiant, String password) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();	
		String requete = "from Utilisateur where identifiant = '" + identifiant + "' and password = '" + password + "'"; 
		//Utilisateur u = (Utilisateur) session.createQuery(requete).list();
		Utilisateur u = null;
		List<Utilisateur> liste_users = (List<Utilisateur>) session.createQuery(requete).list();
		if(!liste_users.isEmpty()) u=liste_users.get(0);
		return u; /// à vérifier
	}

	@Override
	public void seDeconnecter() {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
	    session.disconnect();	
	}



	

}
