package view;


import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.lang.String;
import model.DAO.ApostaDAO;
import model.bean.Aposta;

public class PrincipalForm extends JFrame{
    private JPanel contentPane;
    private JButton btnDadosUsu;
    private JButton btnDadosEst;   
    private JButton btnCadastrar; 
    private JButton btnSair;
    private JTable tableApostas;
    
    public static Aposta visuAposta = new Aposta();
    
    Aposta aposta = new Aposta();
    //ApostaController apostaController = new ApostaController();
    
    ArrayList dadosAposta = new ArrayList();
    ApostaDAO tableDAO = new ApostaDAO();
    
    public static void main(String[] args){
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    PrincipalForm frameVisu = new PrincipalForm();
                    frameVisu.setTitle("Tela Principal");
                    frameVisu.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
    
    public PrincipalForm(){
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setBounds(100, 100, 1056, 668);
	contentPane = new JPanel();
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);
	contentPane.setLayout(null);
        
        tableApostas = new JTable();
        tableApostas.setModel(new DefaultTableModel(
            new Object[][] {},
            new String[] {"Código", "Esporte", "Partida","Mercado","Valor", "Odd", "Lucro", "Acerto"}
            ));
	tableApostas.setBounds(10, 130, 1020, 480);
        tableApostas.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
                            int row = tableApostas.getSelectedRow();
                            visuAposta = (Aposta) dadosAposta.get(row); 
                            VisuApostaForm ja = new VisuApostaForm();
                            ja.setVisible(true); 
                            dispose();
			}
		});
        preecherTabela();
        contentPane.add(tableApostas);
        
        JLabel lbCod = new JLabel("Código");
        lbCod.setBounds(50, 110, 60, 26);
        contentPane.add(lbCod);
        
        JLabel lbEsporte = new JLabel("Esporte");
        lbEsporte.setBounds(170, 110, 60, 26);
        contentPane.add(lbEsporte);
        
        JLabel lbPartida = new JLabel("Partida");
        lbPartida.setBounds(290, 110, 60, 26);
        contentPane.add(lbPartida);
        
        JLabel lbMercado = new JLabel("Mercado");
        lbMercado.setBounds(430, 110, 60, 26);
        contentPane.add(lbMercado);
        
        JLabel lbValor = new JLabel("Valor");
        lbValor.setBounds(550, 110, 60, 26);
        contentPane.add(lbValor);
        
        JLabel lbOdd = new JLabel("Odd");
        lbOdd.setBounds(690, 110, 60, 26);
        contentPane.add(lbOdd);
        
        JLabel lbLucro = new JLabel("Lucro");
        lbLucro.setBounds(810, 110, 60, 26);
        contentPane.add(lbLucro);
                
        JLabel lbAcerto = new JLabel("Acerto");
        lbAcerto.setBounds(940, 110, 60, 26);
        contentPane.add(lbAcerto);
                
        JLabel lbCadUsu = new JLabel("Tela principal");
	lbCadUsu.setBounds(500, 0, 200, 50);
	contentPane.add(lbCadUsu);
        
        btnDadosUsu = new JButton("Dados do Usuario");
        btnDadosUsu.setBounds(10, 45, 140, 30);
	contentPane.add(btnDadosUsu); 
        
        btnCadastrar = new JButton("Cadastrar Aposta");
        btnCadastrar.setBounds(160, 45, 140, 30);
	contentPane.add(btnCadastrar);
        
        btnDadosEst = new JButton("Estatisticas");
        btnDadosEst.setBounds(310, 45, 140, 30);
	contentPane.add(btnDadosEst);        
        
        btnSair = new JButton("Sair");
        btnSair.setBounds(880, 45, 140, 30);
	contentPane.add(btnSair);
        
        btnDadosUsu.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
                VisualizarUsuForm ja = new VisualizarUsuForm();
                ja.setVisible(true);  
            }
        });
    
        btnCadastrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
                CadastrarApostaForm ja = new CadastrarApostaForm();
                ja.setVisible(true); 
            }
        });
        
        btnDadosEst.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                EstatisticasForm ja = new EstatisticasForm();
                ja.setVisible(true);  
                dispose();
            }
        });

        btnSair.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0); 
            }
        });
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
