package repository;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class ConexaoMongo {

	private final String host ="localhost";
	private final int port= 27017;
	private final String dbName="local";
	private final String collection = "pi-app";
	private MongoClient mongoClient;
	
	
	/**Este método ja se conecta ao banco de dados e ja retorna a coleção onde os dados serão salvos.*/
	public MongoCollection<Document> getCollection(){
		//conecta com o banco
		mongoClient = new MongoClient(host,port);
		//escolhe o banco que será utilizado
		MongoDatabase mongoDatabase = mongoClient.getDatabase(dbName); 
		
		//retorna a coleção que será usado.
		return mongoDatabase.getCollection(collection);
		
	}
	
	/**Este método fecha a conexão com o banco de dados.
	 * OBS: para nao se esquecer de fechar coloque-a no finally em um bloco try*/
	public void closeConnection() {
		
		if(this.mongoClient != null) {
			
			this.mongoClient.close();
			
		}
		
	}
	
}
