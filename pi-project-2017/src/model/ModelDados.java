package model;

import java.util.Date;

import twitter4j.GeoLocation;
import twitter4j.Place;

public class ModelDados {

	private String id;
	private String usuario;
	private String menssagem;
	private Date dataHora;
	private GeoLocation geoLocation;
	private Place place;

	public ModelDados(String id, String usuario, String menssagem, Date dataHora, GeoLocation geoLocation, Place place) {
		this.id = id;
		this.usuario = usuario;
		this.menssagem = menssagem;
		this.dataHora = dataHora;
		this.geoLocation = geoLocation;
		this.place = place;
	}


	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getMenssagem() {
		return menssagem;
	}

	public void setMenssagem(String menssagem) {
		this.menssagem = menssagem;
	}

	public Date getDataHora() {
		return dataHora;
	}

	public void setDataHora(Date dataHora) {
		this.dataHora = dataHora;
	}

	public GeoLocation getGeoLocation() {
		return geoLocation;
	}

	public void setGeoLocation(GeoLocation geoLocation) {
		this.geoLocation = geoLocation;
	}

	public Place getPlace() {
		return place;
	}

	public void setPlace(Place place) {
		this.place = place;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}

	
	
}
