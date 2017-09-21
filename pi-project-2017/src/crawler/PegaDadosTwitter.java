package crawler;

import java.util.ArrayList;
import java.util.List;

import com.mongodb.QueryOperators;

import main.Principal;
import model.ModelDados;
import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

public class PegaDadosTwitter {

	private ConfigurationBuilder config;
	private TwitterFactory twitterFactory;
	private Twitter tw;
	private Query query;

	public PegaDadosTwitter() {

		// autorizaçoes para buscar os dados(tiradas com cadastro no twitter dev)
		config = new ConfigurationBuilder();
		config.setOAuthConsumerKey("XXXXXXXXXXXXXXXXXXXXXX");
		config.setOAuthConsumerSecret("XXXXXXXXXXXXXXXXXXXXXXXXXX");
		config.setOAuthAccessToken("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
		config.setOAuthAccessTokenSecret("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");


		twitterFactory = new TwitterFactory(config.build());
		tw = twitterFactory.getInstance();

	}

	/*
	 * método responsável por buscar os dados do twitter e retornar uma lista de
	 * modelDaados para serem persistidos
	 */
	public List<Status> buscaDados(String palavrasChave) {
		
	
//		List<ModelDados> dados = new ArrayList<>();
		query = new Query(palavrasChave);
		query.setCount(100); // - limite 100 NAO PODE PASSAR DISSO
	
		List<Status> tweets=null;
		
		try {
			
			
			QueryResult result = tw.search(query);
			
			// joga os resultados em uma lista de Status
			tweets = result.getTweets();
			
			// pega so o que é importante dos status e joga em uma outra lista de modelDados
//			for (Status st : tweets) {
//				
//				dados.add(new ModelDados(String.valueOf(st.getId()),
//						st.getUser().getScreenName(),
//						st.getText(),
//						st.getCreatedAt(),
//						st.getGeoLocation(),
//						st.getPlace()));
//
//			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		return tweets;
	}

}
