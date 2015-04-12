package dao.beans;

public class Prestation {
	private Integer numero;
	private String date, lieu, type;
	private Integer idUser;
	
	public Prestation() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Prestation(String date, String lieu, String type, Integer idUser) {
		super();
		this.date = date;
		this.lieu = lieu;
		this.type = type;
		this.idUser = idUser;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getLieu() {
		return lieu;
	}

	public void setLieu(String lieu) {
		this.lieu = lieu;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Integer getIdUser() {
		return idUser;
	}

	public void setIdUser(Integer idUser) {
		this.idUser = idUser;
	}
	
	
}
