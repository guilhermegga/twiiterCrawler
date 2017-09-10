package crawler;

import java.util.ArrayList;
import java.util.List;

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
		config.setOAuthConsumerKey("xxxx");
		config.setOAuthConsumerSecret("xxxx");
		config.setOAuthAccessToken("xxxxxx");
		config.setOAuthAccessTokenSecret("xxxxx");


		twitterFactory = new TwitterFactory(config.build());
		tw = twitterFactory.getInstance();

	}

	/*
	 * método responsável por buscar os dados do twitter e retornar uma lista de
	 * modelDaados para serem persistidos
	 */
	public List<ModelDados> buscaDados(String palavraChave) {

		List<ModelDados> dados = new ArrayList<>();
		query = new Query(palavraChave);
		query.setCount(100); // - limite 100 NAO PODE PASSAR DISSO

		try {

			QueryResult result = tw.search(query);
			// joga os resultados em uma lista de Status
			List<Status> tweets = result.getTweets();

			// pega so o que é importante dos status e joga em uma outra lista de modelDados
			for (Status st : tweets) {
				
				dados.add(new ModelDados(String.valueOf(st.getId()),
						st.getUser().getScreenName(),
						st.getText(),
						st.getCreatedAt(),
						st.getGeoLocation(),
						st.getPlace()));

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return dados;
	}

}
