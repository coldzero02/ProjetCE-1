package dao.interfaces;

import java.util.List;

import dao.beans.*;

public interface TresorierInterface {
	
	void init();
	public Tresorier getTresorier(Integer id);
	
	public void ajouterPrestation(Prestation p);
	public void supprimerPrestation(Integer numero);
	public Prestation getPrestationById(Integer numero);
	public List<Prestation> consulterPrestations(Integer idTre);
	public void updateProduit(Prestation p);

	
	
}
