package dao.Implementations;

import dao.interfaces.*;
import dao.beans.*;

import org.hibernate.Session;

import util.HibernateUtil;

public class PrestataireImplementation implements PrestataireInterface {

	@Override
	public void init() {

	}

	@Override
	public Prestataire getPrestataire(Integer id) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();	
		Prestataire p = (Prestataire) session.load(Prestataire.class, id);
		return p;
	}
	
}
