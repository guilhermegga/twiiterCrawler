package main;

import java.util.List;

import crawler.PegaDadosTwitter;
import repository.CrudDados;
import repository.CrudDadosImpl;
import util.XmlUtil;

public class Principal {

	public static void main(String[] args) {

		CrudDados dao = new CrudDadosImpl();
		XmlUtil xml = new XmlUtil();

		List<String> palavrasChave = xml.retornaPalavrasXml();

		PegaDadosTwitter dadosTwitter = new PegaDadosTwitter();

		for (String s : palavrasChave) {

			dao.save(dadosTwitter.buscaDados(s));

		}

	}

}
