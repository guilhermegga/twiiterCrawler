package scheduler;

import java.time.LocalDateTime;
import java.util.List;

import javax.swing.JOptionPane;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import com.mongodb.QueryBuilder;

import crawler.PegaDadosTwitter;
import repository.CrudDados;
import repository.CrudDadosImpl;
import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Twitter;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;
import util.XmlUtil;

public class CustomJob implements Job {

	private ConfigurationBuilder config;
	private TwitterFactory twitterFactory;
	private Twitter tw;
	private Query query;
	
	/**
	 * Tudo que está neste metodo será chamado pelo scheduler e será executado.
	 */
	@Override
	public void execute(JobExecutionContext arg0) throws JobExecutionException {
		config = new ConfigurationBuilder();
		config.setOAuthConsumerKey("3OKAOOEoPlJ5aQKR3ZII5OQGY");
		config.setOAuthConsumerSecret("IdfwEWchz8Mv468pklbb06px08lpDKHYHMEGSKpuLWYjtD1pMa");
		config.setOAuthAccessToken("296608449-X8wgkb5pbreYlU1gcSNBNayJTGuF1SyRIX6zapp3");
		config.setOAuthAccessTokenSecret("nxKcuaGed9V7kxQhU5DDCy3FrGqcuzwqZgHdvT5Gtb9Cf");

		twitterFactory = new TwitterFactory(config.build());
		tw = twitterFactory.getInstance();
		
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
//			PegaDadosTwitter dadosTwitter = new PegaDadosTwitter();
			
			query = new Query();
			query.setCount(100); // - limite 100 NAO PODE PASSAR DISSO
			
			
			for(String palavra: palavrasChave) {
//			int i=0;
//			do {	
				
//				query.setQuery(palavrasChave.get(i));
				query.setQuery(palavra);
				
				QueryResult result; 
//				do {
					result = tw.search(query);
					
//					System.out.println(i+"-"+palavrasChave.get(i)+"-"+result.getTweets().size()+" registros");
					System.out.println("Rate limit: " + result.getRateLimitStatus());
					if(result.getTweets().size()>0) {
						
						dao.save(result.getTweets());
					}
					
//				}while((query=result.nextQuery())!=null);
				
				
//				i++;
				
//			}while(i < palavrasChave.size());	
			
			}


			System.out.println("Executado com sucesso! - " + LocalDateTime.now());

		} catch (Exception e) {

			throw new JobExecutionException();
		}

	}

}
