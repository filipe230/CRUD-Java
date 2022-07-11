package model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.bean.Aposta;

public class ApostaDAO implements CRUD {

    public int total(){
        Connection conn = null;
        int qtd = 0,green,red;
        try {
            conn = Conexao.getConexao();
            PreparedStatement pstm;
            pstm = conn.prepareStatement("Select Count(*) As total From aposta;");
            ResultSet rset = null;   
            rset = pstm.executeQuery();
            rset.next();
            qtd = rset.getInt("total");
            Conexao.fechaConexao(conn);
        } catch (SQLException e) {
            System.out.println("Erro: "+e);
        }
        return qtd;
    }
    
    public int green(){
        Connection conn = null;
        int verd = 0;
        try {
            conn = Conexao.getConexao();
            PreparedStatement pstm;
            pstm = conn.prepareStatement("Select Count(*) As green From aposta where acerto = true;");
            ResultSet rset = null;   
            rset = pstm.executeQuery();
            rset.next();
            verd = rset.getInt("green");
            Conexao.fechaConexao(conn);
        } catch (SQLException e) {
            System.out.println("Erro: "+e);
        }
        return verd;
    }
    
    public int red(){
        Connection conn = null;
        int verm = 0;

        try {
            conn = Conexao.getConexao();
            PreparedStatement pstm;
            ResultSet rset = null;   
            pstm = conn.prepareStatement("Select Count(*) As Red From aposta where acerto = false;"); 
            rset = pstm.executeQuery();
            rset.next();
            verm = rset.getInt("red");
            Conexao.fechaConexao(conn);
        } catch (SQLException e) {
            System.out.println("Erro: "+e);
        }
        return verm;
    }
    
    public float luc_total(){
        Connection conn = null;
        float luc = 0;
        try {
            conn = Conexao.getConexao();
            PreparedStatement pstm;
            ResultSet rset = null;   
            pstm = conn.prepareStatement("SELECT sum(lucro) As lucro from aposta;");
            rset = pstm.executeQuery();
            rset.next();
            luc = rset.getInt("lucro");
            Conexao.fechaConexao(conn);
        } catch (SQLException e) {
            System.out.println("Erro: "+e);
        }
        return luc;
    }
    
    @Override
    
    public void salvar(Object bean) {
        Aposta aposta = (Aposta) bean;
        if (aposta.getAcerto()) {
            aposta.setLucro((aposta.getOdd()*aposta.getValor())-aposta.getValor());
        } else {
            aposta.setLucro(aposta.getValor()*-1);
        }
        
        if (aposta != null) {
            Connection conn = null;
            try {
                conn = Conexao.getConexao();
                PreparedStatement pstm;
                pstm = conn.prepareStatement("insert into aposta (esporte, partida, mercado, valor, odd, lucro, acerto) values (?, ?, ?, ?, ?, ?, ?)");
                pstm.setString(1,aposta.getEsporte());
                pstm.setString(2, aposta.getPartida());
                pstm.setString(3, aposta.getMercado());
                pstm.setFloat(4, aposta.getValor());
                pstm.setFloat(5, aposta.getOdd());
                pstm.setFloat(6, aposta.getLucro());
                pstm.setBoolean(7, aposta.getAcerto());
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
        Aposta aposta = (Aposta) bean;
        if (aposta.getAcerto()) {
            aposta.setLucro((aposta.getOdd()*aposta.getValor())-aposta.getValor());
        } else {
            aposta.setLucro(aposta.getValor()*-1);
        }
        if (aposta != null) {
            Connection conn = null;
            try {
                conn = Conexao.getConexao();
                PreparedStatement pstm;
                pstm = conn.prepareStatement("UPDATE aposta "
                        + "SET esporte = ?, partida = ?, mercado = ?,"
                        + " valor = ?, odd = ?, lucro = ?, acerto = ?"
                        + " WHERE aposta.cod = ?");
                pstm.setString(1, aposta.getEsporte());
                pstm.setString(2, aposta.getPartida());
                pstm.setString(3, aposta.getMercado());
                pstm.setFloat(4, aposta.getValor());
                pstm.setFloat(5, aposta.getOdd());
                pstm.setFloat(6, aposta.getLucro());
                pstm.setBoolean(7, aposta.getAcerto());
                pstm.setInt(8, aposta.getCod());
                pstm.execute();
                System.out.println("Atualizado");
                Conexao.fechaConexao(conn);
            } catch (SQLException e) {
                System.out.println("Erro: "+e);
            }
        }
    }

    @Override
    public void apagar(int cod) {
        Connection conn = null;
            try {
                conn = Conexao.getConexao();
                PreparedStatement pstm;
                pstm = conn.prepareStatement("Delete from aposta where cod = ?");
                pstm.setInt(1, cod);
                pstm.execute();
                System.out.println("Apagado");
                Conexao.fechaConexao(conn);
            } catch (SQLException e) {
                System.out.println("Erro: "+e);
            }
        }

    @Override
    public List<Object> listarTodos() {
    List<Object> apostas = new ArrayList<Object>();
		
	Connection conn = null;
	PreparedStatement pstm=null;
	try {
            conn = Conexao.getConexao();           
            pstm = conn.prepareStatement("select * from aposta");
            ResultSet rset = null;   
            rset = pstm.executeQuery();
            while(rset.next()) {
            	Aposta aposta = new Aposta();
                aposta.setCod(rset.getInt(("cod")));
            	aposta.setEsporte(rset.getString("esporte"));
                aposta.setPartida(rset.getString("partida"));
                aposta.setMercado(rset.getString("mercado"));
                aposta.setValor(rset.getFloat("valor"));
                aposta.setOdd(rset.getFloat("odd"));
                aposta.setLucro(rset.getFloat("lucro"));
                aposta.setAcerto(rset.getBoolean("acerto"));
            	apostas.add(aposta);	 
            }
            }catch(Exception ex) {
            	System.out.println("Erro: " + ex);
            }
            Conexao.fechaConexao(conn,pstm);
    for(int i = 0; i < apostas.size(); i++) {
        Aposta aux = (Aposta) apostas.get(i);
            System.out.println(" | "+aux.getCod()+" | "+
                    aux.getEsporte()+" | "+
                    aux.getPartida()+" | "+
                    aux.getMercado()+" | "+
                    aux.getValor()+" | "+
                    aux.getOdd()+" | "+
                    aux.getLucro()+" | "+
                    aux.getAcerto()+" |");
        }  
        return apostas;
    }
    
    
}
