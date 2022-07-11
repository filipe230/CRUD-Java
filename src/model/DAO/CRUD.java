package model.DAO;

import java.util.List;

public interface CRUD {
    public void salvar(Object bean);
    public void atualizar(Object bean);
    public void apagar(int id);
    public List<Object> listarTodos();
    
}
