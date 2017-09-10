package scheduler;

import java.time.LocalDateTime;
import java.util.List;

import javax.swing.JOptionPane;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import crawler.PegaDadosTwitter;
import repository.CrudDados;
import repository.CrudDadosImpl;
import util.XmlUtil;

public class CustomJob implements Job {

	/**
	 * Tudo que está neste metodo será chamado pelo scheduler e será executado.
	 */
	@Override
	public void execute(JobExecutionContext arg0) throws JobExecutionException {

		try {
			/*
			 * configuraçoes do arquivo xml consulte classe XmlUtil para ver exemplo do
			 * arquivo
			 */

			XmlUtil xml = new XmlUtil();

			// qual caminho esta o xml
			xml.setCaminhoXML("/home/guilherme/eclipse-workspace/tags.xml");

			// qual tag buscar no xml
			xml.setTagXml("palavra");

			// retorna uma lista de palavras do xml
			List<String> palavrasChave = xml.retornaPalavrasXml();

			CrudDados dao = new CrudDadosImpl();
			PegaDadosTwitter dadosTwitter = new PegaDadosTwitter();

			for (String s : palavrasChave) {

				dao.save(dadosTwitter.buscaDados(s));

			}

			System.out.println("Executado com sucesso! - " + LocalDateTime.now());

		} catch (Exception e) {

			throw new JobExecutionException();
		}

	}

}
