package repository;

import java.util.List;

import model.ModelDados;

public interface CrudDados {

	
	public void save(List<ModelDados> dados)throws Exception;
	
	public void update(ModelDados dados);
	
	
	
	
}
