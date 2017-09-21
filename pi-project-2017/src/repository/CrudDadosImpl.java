package repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.bson.Document;

import com.google.gson.Gson;
import com.mongodb.client.model.InsertManyOptions;

import model.ModelDados;
import twitter4j.Status;
import twitter4j.TwitterObjectFactory;

public class CrudDadosImpl implements CrudDados {

	/**
	 * Este método recebe uma lista de dados, prepara e insere todos na collection
	 * do banco de dados.
	 * 
	 * @param List<ModelDados>
	 * @throws Exception
	 */
//	@Override
//	public void save(List<Status> dados) throws Exception {
//
//		ConexaoMongo con = new ConexaoMongo();
//		try {
//
//			List<Document> documentos = new ArrayList<>();
//
//			//TODO: id sendo o id do tweet postado... isso pode dar erro se ele buscar o mesmo
//			//mas nao atrapalha o schedule.
//			for (ModelDados modelDados : dados) {
//				
//				
////				documentos.add(new Document("nosso_id", modelDados.getId())
////						.append("user", modelDados.getUsuario())
////						.append("tweet", modelDados.getMenssagem())
////						.append("data", modelDados.getDataHora())
////				);
//				
//				documentos.add(dados);
//			}
//
//			con.getCollection().insertMany(documentos);
//
//		} catch (Exception e) {
//			throw new Exception();
//		} finally {
//
//			con.closeConnection();
//		}
//
//	}

	@Override
	public void update(ModelDados dados) {
		// AINDA NAO IMPLEMENTADO.
	}

	@Override
	public void save(List<Status> dados) throws Exception {
		ConexaoMongo con = new ConexaoMongo();
		try {

			List<Document> documentos = new ArrayList<>();
			Gson gson = new Gson();
			//TODO: id sendo o id do tweet postado... isso pode dar erro se ele buscar o mesmo
			//mas nao atrapalha o schedule.
			for (Status modelDados : dados) {
				
				
//				documentos.add(new Document("nosso_id", modelDados.getId())
//						.append("user", modelDados.getUsuario())
//						.append("tweet", modelDados.getMenssagem())
//						.append("data", modelDados.getDataHora())
//				);
			
				String json = gson.toJson(modelDados);
				documentos.add(Document.parse(json));
			}
		
			
			con.getCollection().insertMany(documentos);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			con.closeConnection();
		}
		
	}

}
