package dao.Implementations;

import dao.interfaces.*;
import dao.beans.*;

import org.hibernate.Session;

import util.HibernateUtil;

public class EmployeImplementation implements EmployeInterface {

	@Override
	public void init() {

	}

	@Override
	public Employe getEmploye(Integer id) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();	
		Employe e = (Employe) session.load(Employe.class, id);
		return e ;
	}

}
