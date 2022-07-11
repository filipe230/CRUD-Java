package model.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Conexao {
    private static final String URL = "jdbc:mysql://localhost:3306/proj_bd";
    private static final String USUARIO = "root";
    private static final String SENHA = "";
    
    private PreparedStatement adiciona;
    
    public static Connection getConexao(){
            Connection con = null;
        try {
             con = DriverManager.getConnection(URL, USUARIO, SENHA);
            return con;
            
        } catch (Exception e) {
            System.err.println(e);
            System.exit(1);
        }
        return con;
    }
    
    public static void fechaConexao(Connection conn) {
        try {
            if (conn != null) {
                conn.close();
                System.out.println("Fechada a conexão com o banco de dados");
            }
        }catch (Exception e) {
            System.out.println("Não foi possível fechar a conexão com o banco de dados " + e.getMessage());
        }
    }
    
        public static void fechaConexao(Connection conn, PreparedStatement stm) {
        try {
            if(conn != null){
                fechaConexao(conn);
            }
            if (stm != null) {
                stm.close();
                System.out.println("Fechada a conexão com o banco de dados");
            }
        }catch (Exception e) {
            System.out.println("Não foi possível fechar o statement com o banco de dados " + e.getMessage());
        }
    }
    
    public static void fechaConexao(Connection conn, PreparedStatement stm, ResultSet rs) {
        try {
            if(conn != null || stm != null){
                fechaConexao(conn,stm);
            }
            if (rs != null) {
                rs.close();
                System.out.println("Fechado o resultSet com o banco de dados");
            }
        }catch (Exception e) {
            System.out.println("Não foi possível fechar o resultSet com o banco de dados " + e.getMessage());
        }
    }
    
}
