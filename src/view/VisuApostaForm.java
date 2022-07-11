package view;

import controller.ApostaController;
import static controller.Constante.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import model.bean.Aposta;

public class VisuApostaForm extends JFrame{
    
    private JPanel contentPane;
    private JTextField textEsporte;
    private JTextField textPartida;
    private JTextField textMercado;
    private JTextField textValor;
    private JTextField textOdd;
    private JTextField textLucro;
    private JTextField textAcerto;
    private JTextField textCod;
    //private JComboBox cbxAcerto;
    private JButton btnVoltar;
    private JButton btnAlterar;   
    private JButton btnExcluir;  
    
    ApostaController apostaController = new ApostaController();
    
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    VisuApostaForm frame = new VisuApostaForm();
                    frame.setTitle("Dados da Aposta");
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
    
    public VisuApostaForm() {
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setBounds(500, 300, 290, 520);
	contentPane = new JPanel();
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);
	contentPane.setLayout(null);
	
        JLabel lbDadosAposta= new JLabel("Dados da Aposta");
        lbDadosAposta.setBounds(100, 0, 200, 50);
	contentPane.add(lbDadosAposta);
                               
        JLabel lbCod = new JLabel("Codigo");
        lbCod.setBounds(10, 45, 50, 30);
	contentPane.add(lbCod);
		
	textCod = new JTextField();
	textCod.setBounds(75, 45, 170, 30);
        textCod.setEnabled(false);
        textCod.setText(Integer.toString(PrincipalForm.visuAposta.getCod()));
	contentPane.add(textCod);
	textCod.setColumns(10);
                
	JLabel lbEsporte = new JLabel("Esporte");
	lbEsporte.setBounds(10, 80, 50, 30);
	contentPane.add(lbEsporte);
		
	textEsporte = new JTextField();
	textEsporte.setBounds(75, 80, 170, 30);
        textEsporte.setText(PrincipalForm.visuAposta.getEsporte());
	contentPane.add(textEsporte);
	textEsporte.setColumns(10);
		
	JLabel lbPartida = new JLabel("Partida");
	lbPartida.setBounds(10, 115, 50, 30);
	contentPane.add(lbPartida);
		
	textPartida = new JTextField();
	textPartida.setBounds(75, 115, 170, 30);
        textPartida.setText(PrincipalForm.visuAposta.getPartida());
	contentPane.add(textPartida);
	textPartida.setColumns(10);
                
        JLabel lbMercado = new JLabel("Mercado");
	lbMercado.setBounds(10, 150, 50, 30);
	contentPane.add(lbMercado);
		
	textMercado = new JTextField();
	textMercado.setBounds(75, 150, 170, 30);
        textMercado.setText(PrincipalForm.visuAposta.getMercado());
	contentPane.add(textMercado);
	textMercado.setColumns(10);

        JLabel lbValor = new JLabel("Valor");
	lbValor.setBounds(10, 185, 50, 30);
	contentPane.add(lbValor);
		
	textValor = new JTextField();
	textValor.setBounds(75, 185, 170, 30);
        textValor.setText(Float.toString(PrincipalForm.visuAposta.getValor()));
	contentPane.add(textValor);
	textValor.setColumns(10);
                
        JLabel lbOdd = new JLabel("Odd");
	lbOdd.setBounds(10, 220, 50, 30);
	contentPane.add(lbOdd);
		
	textOdd = new JTextField();
	textOdd.setBounds(75, 220, 170, 30);
        textOdd.setText(Float.toString(PrincipalForm.visuAposta.getOdd()));
	contentPane.add(textOdd);
	textOdd.setColumns(10);
                
        JLabel lbLucro = new JLabel("Lucro");
	lbLucro.setBounds(10, 255, 50, 30);
	contentPane.add(lbLucro);
		
	textLucro = new JTextField();
	textLucro.setBounds(75, 255, 170, 30);
        textLucro.setEnabled(false);
        textLucro.setText(Float.toString(PrincipalForm.visuAposta.getLucro()));
	contentPane.add(textLucro);
	textLucro.setColumns(10);
                
        JLabel lbAcerto = new JLabel("Acerto");
	lbAcerto.setBounds(10, 290, 50, 30);
	contentPane.add(lbAcerto);
	/*	
	textAcerto = new JTextField();
	textAcerto.setBounds(75, 290, 170, 30);
        textAcerto.setText(Boolean.toString(PrincipalForm.visuAposta.getAcerto()));
	contentPane.add(textAcerto);
	textAcerto.setColumns(10);
        */
        
        JComboBox cbxAcerto = new JComboBox();
        if (PrincipalForm.visuAposta.getAcerto()) {
            cbxAcerto.addItem("Green");
            cbxAcerto.addItem("Red");
        } else {
            cbxAcerto.addItem("Red");
            cbxAcerto.addItem("Green");
        }
        
        cbxAcerto.setBounds(75, 290, 170, 30);
        contentPane.add(cbxAcerto);
        
        btnAlterar = new JButton("Alterar");
        btnAlterar.setBounds(75, 325, 170, 30);
        btnAlterar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Aposta aposta = new Aposta();
                aposta.setCod(Integer.parseInt(textCod.getText()));
                aposta.setEsporte(textEsporte.getText());
                aposta.setPartida(textPartida.getText());
                aposta.setMercado(textMercado.getText());
                aposta.setValor(Float.parseFloat(textValor.getText()));
                aposta.setOdd(Float.parseFloat(textOdd.getText()));
                aposta.setLucro(Float.parseFloat(textLucro.getText()));
                aposta.setAcerto(verificarAcerto(cbxAcerto));
                System.out.println(""+aposta.getAcerto());
                apostaController.executa(aposta, ATUALIZAR);
                fechar();
              //preecherTabela();
              //limpar();
               //btnAtualizar.setEnabled(false);
            }
	});
	
        contentPane.add(btnAlterar);
        
        btnExcluir = new JButton("Excluir");
        btnExcluir.setBounds(75, 360, 170, 26);
        btnExcluir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {	
            Aposta aposta = new Aposta();
            aposta.setCod(Integer.parseInt(textCod.getText()));
            aposta.setCod(Integer.parseInt(textCod.getText()));
            apostaController.executa(aposta, APAGAR);
            fechar();
            }
	});
	contentPane.add(btnExcluir);        
        
        btnVoltar = new JButton("Voltar");
        btnVoltar.setBounds(75, 395, 170, 30);
        btnVoltar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                fechar(); 
            }
	});
	contentPane.add(btnVoltar);        
    }  
    private boolean verificarAcerto(JComboBox cbxAcerto) {
        if (PrincipalForm.visuAposta.getAcerto()) {
            if (cbxAcerto.getSelectedIndex()==1)
                return false;
            else if (cbxAcerto.getSelectedIndex()==0) 
                return true;
        } else {
            if (cbxAcerto.getSelectedIndex()==0) 
                return false;
            else if (cbxAcerto.getSelectedIndex()==1) 
                return true;
        } 
        return false;
    }
    
    private void fechar() {
        PrincipalForm ja = new PrincipalForm();
        ja.setVisible(true); 
        dispose();
    }
}

