package dao.Implementations;

import dao.interfaces.*;
import dao.beans.*;

import java.util.List;

import org.hibernate.Session;

import util.HibernateUtil;

public class TresorierImplementation implements TresorierInterface {
	
	@Override
	public void init() {

	}
	
	@Override
	public Tresorier getTresorier(Integer id) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();	
		Tresorier t = (Tresorier) session.load(Tresorier.class, id);
		return t;
	}

	@Override
	public void ajouterPrestation(Prestation p) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		session.save(p);
		session.getTransaction().commit();

	}

	@Override
	public void supprimerPrestation(Integer numero) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();	
		Prestation p = (Prestation) session.load(Prestation.class, numero);
		session.delete(p);
		session.getTransaction().commit();

	}

	@Override
	public Prestation getPrestationById(Integer numero) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();	
		Prestation p = (Prestation) session.load(Prestation.class, numero);
		return p;
	}

	@Override
	public List<Prestation> consulterPrestations(Integer idTre) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();	
		String requete = "from Prestation where idUser = '" + idTre;
		return session.createQuery(requete).list();
	}

	@Override
	public void updateProduit(Prestation p) {
		// TODO Auto-generated method stub

	}

}
