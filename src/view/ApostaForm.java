package view;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;


import controller.ApostaController;
import static controller.Constante.*;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import model.DAO.ApostaDAO;
import model.bean.Aposta;

/*
public class ApostaForm {
    public static void main(String[] args) {
        Aposta aposta = new Aposta();
        ApostaController apostaController = new ApostaController();
        
        aposta.setEsporte("Futebol");
        aposta.setPartida("Brasil vs Alemanha");
        aposta.setMercado("Vitória - Brasil");
        aposta.setValor(10);
        aposta.setOdd((float)1.8);
        aposta.setLucro((float)8);
        aposta.setAcerto(true);
        aposta.setCod(1);
        //apostaController.executa(aposta, SALVAR);
        //apostaController.executa(aposta, ATUALIZAR);
        //apostaController.executa(aposta, APAGAR);
       apostaController.executa(aposta, LISTAR);
    }
}
*/

public class ApostaForm extends JFrame {

    private JPanel contentPane;
    private JTable tableApostas;
    private JTextField textEsporte;
    private JTextField textPartida;
    private JTextField textMercado;
    private JTextField textValor;
    private JTextField textOdd;
    private JTextField textLucro;
    private JTextField textAcerto;
    private JTextField textCod;
    private JTextField textPesquisaCod;
    private JButton btnPesquisar;
    private JButton btnAtualizar;
    private JTextField textPesquisaId;
        
    Aposta aposta = new Aposta();
    ApostaController apostaController = new ApostaController();
  
    ArrayList dadosAposta = new ArrayList();
    ApostaDAO tableDAO = new ApostaDAO();

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
		try {
                    ApostaForm frame = new ApostaForm();
                    frame.setVisible(true);
		} catch (Exception e) {
                    e.printStackTrace();
		}
	}
	});
        }
    
    public ApostaForm() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1056, 648);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		tableApostas = new JTable();
		
		tableApostas.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
                            //btnAtualizar.setEnabled(false);
                            int row = tableApostas.getSelectedRow();
                            aposta = (Aposta) dadosAposta.get(row); 
                            textCod.setText(Integer.toString(aposta.getCod()));
                            textEsporte.setText(aposta.getEsporte());
                            textPartida.setText(aposta.getPartida());
                            textMercado.setText(aposta.getMercado());
                            textValor.setText(Float.toString(aposta.getValor()));
                            textOdd.setText(Float.toString(aposta.getOdd()));
                            textLucro.setText(Float.toString(aposta.getLucro()));
                            textAcerto.setText(Boolean.toString(aposta.getAcerto()));
			}
		});
		
		tableApostas.setModel(new DefaultTableModel(
			new Object[][] { 
			},
			new String[] {
				"Código", "Esporte", "Partida","Mercado","Valor", "Odd", "Lucro", "Acerto"
			}
		));
		tableApostas.setBounds(10, 300, 1020, 333);
                contentPane.add(tableApostas);
		
                JLabel lbCod = new JLabel("Código");
		lbCod.setBounds(10, 10, 50, 26);
		contentPane.add(lbCod);
		
		textCod = new JTextField();
		textCod.setBounds(75, 10, 105, 26);
                textCod.setEnabled(false);
		contentPane.add(textCod);
		textCod.setColumns(10);
                
		JLabel lbEsporte = new JLabel("Esporte");
		lbEsporte.setBounds(10, 45, 50, 26);
		contentPane.add(lbEsporte);
		
		textEsporte = new JTextField();
		textEsporte.setBounds(75, 45, 105, 26);
		contentPane.add(textEsporte);
		textEsporte.setColumns(10);
		
		JLabel lbPartida = new JLabel("Partida");
		lbPartida.setBounds(10, 80, 50, 26);
		contentPane.add(lbPartida);
		
		textPartida = new JTextField();
		textPartida.setBounds(75, 80, 105, 26);
		contentPane.add(textPartida);
		textPartida.setColumns(10);
                
                JLabel lbMercado = new JLabel("Mercado");
		lbMercado.setBounds(10, 115, 50, 26);
		contentPane.add(lbMercado);
		
		textMercado = new JTextField();
		textMercado.setBounds(75, 115, 105, 26);
		contentPane.add(textMercado);
		textMercado.setColumns(10);

                JLabel lbValor = new JLabel("Valor");
		lbValor.setBounds(10, 150, 50, 26);
		contentPane.add(lbValor);
		
		textValor = new JTextField();
		textValor.setBounds(75, 150, 105, 26);
		contentPane.add(textValor);
		textValor.setColumns(10);
                
                JLabel lbOdd = new JLabel("Odd");
		lbOdd.setBounds(10, 185, 50, 26);
		contentPane.add(lbOdd);
		
		textOdd = new JTextField();
		textOdd.setBounds(75, 185, 105, 26);
		contentPane.add(textOdd);
		textOdd.setColumns(10);
                
                JLabel lbLucro = new JLabel("Lucro");
		lbLucro.setBounds(10, 220, 50, 26);
		contentPane.add(lbLucro);
		
		textLucro = new JTextField();
		textLucro.setBounds(75, 220, 105, 26);
		contentPane.add(textLucro);
		textLucro.setColumns(10);
                
                JLabel lbAcerto = new JLabel("Acerto");
		lbAcerto.setBounds(10, 255, 50, 26);
		contentPane.add(lbAcerto);
		
		textAcerto = new JTextField();
		textAcerto.setBounds(75, 255, 105, 26);
		contentPane.add(textAcerto);
		textAcerto.setColumns(10);
		
		btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				aposta.setCod(Integer.parseInt(textPesquisaId.getText()));
				//aposta = (Aposta) apostaController.executa(aposta,4);
				

				textEsporte.setText(aposta.getEsporte());
                                textPartida.setText(aposta.getPartida());
                                textMercado.setText(aposta.getMercado());
                                textValor.setText(Float.toString(aposta.getValor()));
                                textOdd.setText(Float.toString(aposta.getOdd()));
                                textLucro.setText(Float.toString(aposta.getLucro()));
                              	textAcerto.setText(Boolean.toString(aposta.getAcerto()));
			}
		});
		btnPesquisar.setBounds(800, 10, 95, 26);
		contentPane.add(btnPesquisar);
		
                
		textPesquisaCod = new JTextField();
		textPesquisaCod.setBounds(410, 10, 380, 26);
		contentPane.add(textPesquisaCod);
		textPesquisaCod.setColumns(10);
		
		JButton btnSalvar = new JButton("Adionar aposta");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				aposta.setEsporte(textEsporte.getText());
                                aposta.setPartida(textPartida.getText());
                                aposta.setMercado(textMercado.getText());
                                aposta.setValor(Float.parseFloat(textValor.getText()));
				aposta.setOdd(Float.parseFloat(textOdd.getText()));
                                aposta.setLucro(Float.parseFloat(textLucro.getText()));
                                aposta.setAcerto(Boolean.parseBoolean(textAcerto.getText()));
                                apostaController.executa(aposta,SALVAR);
				
                                limpar();
				preecherTabela();
				
			}
		});
		btnSalvar.setBounds(190, 10, 150, 26);
		contentPane.add(btnSalvar);
		
		JButton btnExcluir = new JButton("Excluir aposta");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			aposta.setCod(Integer.parseInt(textCod.getText()));
			apostaController.executa(aposta, APAGAR);
			preecherTabela();
			limpar();	
			}
		});
		btnExcluir.setBounds(190, 45, 150, 26);
		contentPane.add(btnExcluir);
		
		JButton btnAtualizar = new JButton("Atualiza aposta");
		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                            aposta.setEsporte(textEsporte.getText());
                            aposta.setPartida(textPartida.getText());
                            aposta.setMercado(textMercado.getText());
                            aposta.setValor(Float.parseFloat(textValor.getText()));
                            aposta.setOdd(Float.parseFloat(textOdd.getText()));
                            aposta.setLucro(Float.parseFloat(textLucro.getText()));
                            aposta.setAcerto(Boolean.parseBoolean(textAcerto.getText()));
                            apostaController.executa(aposta, ATUALIZAR);	
                            preecherTabela();
                            limpar();
                            //btnAtualizar.setEnabled(false);
			}
		});
		btnAtualizar.setBounds(190, 80, 150, 26);
		contentPane.add(btnAtualizar);
		//btnAtualizar.setEnabled(false);
		preecherTabela();
	}
    private void limpar() {
        textCod.setText("");
        textEsporte.setText("");
        textPartida.setText("");
        textMercado.setText("");
        textValor.setText("");
        textOdd.setText("");
        textLucro.setText("");
        textAcerto.setText("");
    }
    
    private void preecherTabela() {
        DefaultTableModel modelo = (DefaultTableModel)tableApostas.getModel();
	//ArrayList dadosAposta = new ArrayList();
	//ApostaDAO tableDAO = new ApostaDAO();
	dadosAposta = (ArrayList) tableDAO.listarTodos();
	
	modelo.setRowCount (0);
	for(Object aLista: tableDAO.listarTodos()) {
            modelo.addRow(new Object [] {
                ((Aposta) aLista).getCod(),
                ((Aposta) aLista).getEsporte(),
                ((Aposta) aLista).getPartida(),
                ((Aposta) aLista).getMercado(),
                ((Aposta) aLista).getValor(),
                ((Aposta) aLista).getOdd(),
                ((Aposta) aLista).getLucro(),
                ((Aposta) aLista).getAcerto(),
             });
	}
    }
}


