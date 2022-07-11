package model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import model.bean.Docente;

public class DocenteDAO implements CRUD {

    @Override
    public void salvar(Object bean) {
        Docente docente = (Docente) bean;
        
        if (docente != null) {
            Connection conn = null;
            try {
                conn = Conexao.getConexao();
                PreparedStatement pstm;
                pstm = conn.prepareStatement("insert into docente (nome, idade) values (?, ?)");
                pstm.setString(1,docente.getName());
                pstm.setInt(2, docente.getIdade());
                pstm.execute();
                System.out.println("Armazenado");
                Conexao.fechaConexao(conn);
            } catch (SQLException e) {
                System.out.println("Erro: "+e);
            }
        }
    }

    @Override
    public void atualizar(Object bean) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void apagar(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Object> listarTodos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
