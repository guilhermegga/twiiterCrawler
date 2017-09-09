package main;

import java.util.List;

import crawler.PegaDadosTwitter;
import repository.CrudDados;
import repository.CrudDadosImpl;
import util.XmlUtil;

public class Principal {

	public static void main(String[] args) {

			
		/*configuraçoes do arquivo xml
		 * consulte classe XmlUtil para ver exemplo do arquivo
		*/
		
		XmlUtil xml = new XmlUtil();
		
		//qual caminho esta o xml
		xml.setCaminhoXML("/home/guilherme/eclipse-workspace/tags.xml");
		
		//qual tag buscar no xml
		xml.setTagXml("palavra");
	
		//retorna uma lista de palavras do xml
		List<String> palavrasChave = xml.retornaPalavrasXml();

		CrudDados dao = new CrudDadosImpl();
		PegaDadosTwitter dadosTwitter = new PegaDadosTwitter();

		for (String s : palavrasChave) {

			dao.save(dadosTwitter.buscaDados(s));

		}

	}

}
