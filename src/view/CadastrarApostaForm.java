package view;

import controller.ApostaController;
import static controller.Constante.*;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import model.bean.Aposta;

class CadastrarApostaForm extends JFrame{
    private JPanel contentPane;
    private JTextField textEsporte;
    private JTextField textPartida;
    private JTextField textMercado;
    private JTextField textValor;
    private JTextField textOdd;
    private JTextField textLucro;
    private JTextField textAcerto;
    private JTextField textCod;
    private JComboBox cbxAcerto;
    private JButton btnVoltar;
    private JButton btnCadastrar;   
    
    Aposta aposta = new Aposta();
    ApostaController apostaController = new ApostaController();
    
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    CadastrarApostaForm frame = new CadastrarApostaForm();
                    frame.setTitle("Cadastrar Aposta");
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
    
    public CadastrarApostaForm(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setBounds(500, 300, 280, 400);
	contentPane = new JPanel();
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);
	contentPane.setLayout(null);
        
        JLabel lbDadosAposta= new JLabel("Cadastrar Aposta");
        lbDadosAposta.setBounds(90, 0, 200, 50);
	contentPane.add(lbDadosAposta);
                
	JLabel lbEsporte = new JLabel("Esporte*");
	lbEsporte.setBounds(10, 45, 50, 30);
	contentPane.add(lbEsporte);
		
	textEsporte = new JTextField();
	textEsporte.setBounds(75, 45, 170, 30);
	contentPane.add(textEsporte);
	textEsporte.setColumns(10);
		
	JLabel lbPartida = new JLabel("Partida*");
	lbPartida.setBounds(10, 80, 80, 30);
	contentPane.add(lbPartida);
		
	textPartida = new JTextField();
	textPartida.setBounds(75, 80, 170, 30);
	contentPane.add(textPartida);
	textPartida.setColumns(10);
                
        JLabel lbMercado = new JLabel("Mercado*");
	lbMercado.setBounds(10, 115, 80, 30);
	contentPane.add(lbMercado);
		
	textMercado = new JTextField();
	textMercado.setBounds(75, 115, 170, 30);
	contentPane.add(textMercado);
	textMercado.setColumns(10);

        JLabel lbValor = new JLabel("Valor*");
	lbValor.setBounds(10, 150, 50, 30);
	contentPane.add(lbValor);
		
	textValor = new JTextField();
	textValor.setBounds(75, 150, 170, 30);
	contentPane.add(textValor);
	textValor.setColumns(10);
                
        JLabel lbOdd = new JLabel("Odd*");
	lbOdd.setBounds(10, 185, 50, 30);
	contentPane.add(lbOdd);
		
	textOdd = new JTextField();
	textOdd.setBounds(75, 185, 170, 30);
	contentPane.add(textOdd);
	textOdd.setColumns(10);
        
        /*
        JLabel lbLucro = new JLabel("Lucro");
	lbLucro.setBounds(10, 220, 50, 30);
	contentPane.add(lbLucro);
		
	textLucro = new JTextField();
	textLucro.setBounds(75, 220, 170, 30);
        textLucro.setEnabled(false);
	contentPane.add(textLucro);
	textLucro.setColumns(10);
        */
        
        JLabel lbAcerto = new JLabel("Acerto");
	lbAcerto.setBounds(10, 220, 50, 30);
	contentPane.add(lbAcerto);
		
	/*textAcerto = new JTextField();
	textAcerto.setBounds(75, 290, 130, 30);
	contentPane.add(textAcerto);
	textAcerto.setColumns(10);*/
        cbxAcerto = new JComboBox();
        cbxAcerto.addItem("Red");
        cbxAcerto.addItem("Green");
        cbxAcerto.setBounds(75, 220, 170, 30);
        contentPane.add(cbxAcerto);
        
        btnCadastrar = new JButton("Cadastrar");
        btnCadastrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (validarDados(textEsporte, textPartida, textMercado, textValor, textOdd)) {
                    aposta.setEsporte(textEsporte.getText());
                    aposta.setPartida(textPartida.getText());
                    aposta.setMercado(textMercado.getText());
                    aposta.setValor(Float.parseFloat(textValor.getText()));
                    aposta.setOdd(Float.parseFloat(textOdd.getText()));
                    //aposta.setLucro(calcLucro(textLucro));
                    aposta.setAcerto(verificarAcerto(cbxAcerto));
                    apostaController.executa(aposta,SALVAR);	
                    fechar();
                } else {
                  JOptionPane.showMessageDialog(contentPane, "Dados obrigatórios não preenchidos");
                }
            }
	});
        
        btnCadastrar.setBounds(75, 255, 170, 30);
	contentPane.add(btnCadastrar);       
        
        btnVoltar = new JButton("Voltar");
        btnVoltar.setBounds(75, 290, 170, 30);
        btnVoltar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                fechar();
            }
	});
	contentPane.add(btnVoltar);        
    }
    
    private boolean verificarAcerto(JComboBox cbxAcerto) {
        if (cbxAcerto.getSelectedIndex()==0) {
            return false;
        } else if (cbxAcerto.getSelectedIndex()==1) {
            return true;
        } 
        return false;
    }
    private boolean validarDados(JTextField textEsporte, JTextField textPartida, JTextField textMercado, JTextField textValor, JTextField textOdd) {
        if (textEsporte.getText().equals("") || textPartida.getText().equals("") || textMercado.getText().equals("") || textValor.getText().equals("") || textOdd.getText().equals(""))
            return false;
        return true;
    }
    
    private float calcLucro (JTextField textLucro) {
        if (textLucro.getText().equals(""))
            return 0;
        return Float.parseFloat(textLucro.getText());              
    }
    
    private void fechar() {
        PrincipalForm ja = new PrincipalForm();
        ja.setVisible(true); 
        dispose();
    }
}   