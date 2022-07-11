package model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.bean.Usuario;

public class UsuarioDAO  implements CRUD {

    //public boolean login() {
    public boolean login(String usuario, String senha) {
        Connection conn = null;
        try {
            conn = Conexao.getConexao();
            Usuario usu = new Usuario();
            PreparedStatement pstm;
            /*
            pstm = conn.prepareStatement("Select usuario, senha from cliente where usuario = '?' and senha = '?'");
            System.out.println("Select usuario, senha from cliente where usuario = '?' and senha = '?'");
            pstm.setString(1,usuario);
            System.out.println("pstm.setString(1, usuario);");
            pstm.setString(2,senha);
            System.out.println("pstm.setString(2, senha);");
            */
            pstm = conn.prepareStatement("Select * from cliente where usuario = '"+usuario+"' and senha = '"+senha+"'");
            ResultSet rset = null;   
            rset = pstm.executeQuery();
            rset.next();
            usu.setCpf(rset.getString("cpf"));
            usu.setEmail(rset.getString("email"));
            usu.setEnd(rset.getString("email"));
            usu.setId(rset.getInt("id"));
            usu.setNome(rset.getString("nome"));
            usu.setTelefone(rset.getString("telefone"));
            usu.setUsuario(rset.getString("usuario"));
            usu.setSenha(rset.getString("senha")) ;
            Conexao.fechaConexao(conn);
            if(usu.getUsuario().equals("") || usu.getSenha().equals("")){
                System.out.println("Usuário incorreto");
                return false;
            } else {
                System.out.println("Usuário correto ");
                return true;
            }
        } catch (SQLException e) {
            System.out.println("Erro: "+e);
        }    
        return false;
    }
    
    public Usuario retorna(String usuario, String senha){
        Connection conn = null;
        Usuario usu = new Usuario();
        try {
            conn = Conexao.getConexao();
            PreparedStatement pstm;
            pstm = conn.prepareStatement("Select * from cliente where usuario = '"+usuario+"' and senha = '"+senha+"'");
            ResultSet rset = null;   
            rset = pstm.executeQuery();
            rset.next();
            usu.setCpf(rset.getString("cpf"));
            usu.setEmail(rset.getString("email"));
            usu.setEnd(rset.getString("Endereco"));
            usu.setId(rset.getInt("id"));
            usu.setNome(rset.getString("nome"));
            usu.setTelefone(rset.getString("telefone"));
            usu.setUsuario(rset.getString("usuario"));
            usu.setSenha(rset.getString("senha")) ;
            Conexao.fechaConexao(conn);
        } catch (SQLException e) {
            System.out.println("Erro: "+e);
        }
        return usu;
    }
    
    @Override
    public void salvar(Object bean) {
        Usuario usuario = (Usuario) bean;
        
        if (usuario != null) {
            Connection conn = null;
            try {
                conn = Conexao.getConexao();
                PreparedStatement pstm;
                pstm = conn.prepareStatement("insert into cliente (nome, email, endereco, cpf, senha, usuario, telefone) values (?, ?, ?, ?, ?, ?, ?)");
                pstm.setString(1,usuario.getNome());
                pstm.setString(2, usuario.getEmail());
                pstm.setString(3, usuario.getEnd());
                pstm.setString(4, usuario.getCpf());
                pstm.setString(5, usuario.getSenha());
                pstm.setString(6, usuario.getUsuario());
                pstm.setString(7, usuario.getTelefone());
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
        Usuario usuario = (Usuario) bean;
        
        if (usuario != null) {
            Connection conn = null;
            try {
                conn = Conexao.getConexao();
                PreparedStatement pstm;
                pstm = conn.prepareStatement("insert into cliente (nome, email, endereco, cpf, senha, usuario, telefone) values (?, ?, ?, ?, ?, ?, ?)");
                pstm.setString(1,usuario.getNome());
                pstm.setString(2, usuario.getEmail());
                pstm.setString(3, usuario.getEnd());
                pstm.setString(4, usuario.getCpf());
                pstm.setString(5, usuario.getSenha());
                pstm.setString(6, usuario.getUsuario());
                pstm.setString(7, usuario.getTelefone());
                pstm = conn.prepareStatement("UPDATE cliente "
                        + "SET nome = ?, email = ?, endereco = ?,"
                        + " cpf = ?, senha = ?, usuario = ?, telefone = ?"
                        + " WHERE cliente.id = ?");
                pstm.setString(1,usuario.getNome());
                pstm.setString(2, usuario.getEmail());
                pstm.setString(3, usuario.getEnd());
                pstm.setString(4, usuario.getCpf());
                pstm.setString(5, usuario.getSenha());
                pstm.setString(6, usuario.getUsuario());
                pstm.setString(7, usuario.getTelefone());
                pstm.setInt(8, usuario.getId());
                pstm.execute();
                System.out.println("Atualizado");
                Conexao.fechaConexao(conn);
            } catch (SQLException e) {
                System.out.println("Erro: "+e);
            }
        }
    }

    @Override
    public void apagar(int id) {
        Connection conn = null;
        try {
            conn = Conexao.getConexao();
            PreparedStatement pstm;
            pstm = conn.prepareStatement("Delete from cliente where id = ?");
            pstm.setInt(1, id);
            pstm.execute();
            System.out.println("Apagado");
            Conexao.fechaConexao(conn);
        } catch (SQLException e) {
            System.out.println("Erro: "+e);
        }    
    }

    @Override
    public List<Object> listarTodos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

