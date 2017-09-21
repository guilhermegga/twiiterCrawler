package repository;

import java.util.List;

import model.ModelDados;
import twitter4j.Status;

public interface CrudDados {

	
	public void save(List<Status> dados)throws Exception;
	
	public void update(ModelDados dados);
	
	
	
	
}
