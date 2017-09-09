package model;

import java.util.Date;

public class ModelDados {

	private String usuario;
	private String menssagem;
	private Date dataHora;

	public ModelDados(String usuario, String menssagem, Date dataHora) {
		this.usuario = usuario;
		this.menssagem = menssagem;
		this.dataHora = dataHora;
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

}
