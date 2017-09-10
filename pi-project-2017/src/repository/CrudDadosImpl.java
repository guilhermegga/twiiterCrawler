package repository;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;

import model.ModelDados;

public class CrudDadosImpl implements CrudDados {

	/**
	 * Este método recebe uma lista de dados, prepara e insere todos na collection
	 * do banco de dados.
	 * 
	 * @throws Exception
	 */
	@Override
	public void save(List<ModelDados> dados) throws Exception {

		ConexaoMongo con = new ConexaoMongo();
		try {

			List<Document> documentos = new ArrayList<>();

			for (ModelDados modelDados : dados) {

				documentos.add(new Document("_id", modelDados.getId())
						.append("user", modelDados.getUsuario())
						.append("tweet", modelDados.getMenssagem())
						.append("data", modelDados.getDataHora())

				);

			}

			con.getCollection().insertMany(documentos);

		} catch (Exception e) {
			throw new Exception();
		} finally {

			con.closeConnection();
		}

	}

	@Override
	public void update(ModelDados dados) {
		// AINDA NAO IMPLEMENTADO.
	}

}
