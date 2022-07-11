package view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import model.DAO.ApostaDAO;

public class EstatisticasForm extends JFrame{
    private JPanel contentPane;
    private JTextField textTotal;
    private JTextField textGreen;
    private JTextField textRed;
    private JTextField textLucro;
    private JButton btnVoltar;
    
    ApostaDAO apostaDao = new ApostaDAO();
    
    public static void main(String[] args){
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    EstatisticasForm frame = new EstatisticasForm();
                    frame.setTitle("Dados Estatisticos");
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
    
    public EstatisticasForm(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setBounds(300, 300, 290, 300);
	contentPane = new JPanel();
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);
	contentPane.setLayout(null);
        
        JLabel lbDadosEst = new JLabel("Dados Estatisticos");
	lbDadosEst.setBounds(90, 0, 200, 50);
	contentPane.add(lbDadosEst);
        
        JLabel lbTotal = new JLabel("Quantidade de Apostas: ");
        lbTotal.setBounds(10, 45, 140, 30);
	contentPane.add(lbTotal);
        
        textTotal = new JTextField();
	textTotal.setBounds(150, 45, 115, 30);
        textTotal.setText(Integer.toString(apostaDao.total()));
        textTotal.setEnabled(false);
	contentPane.add(textTotal);
	textTotal.setColumns(10);
        
        JLabel lbReds = new JLabel("Reds: ");
        lbReds.setBounds(10, 80, 50, 30);
	contentPane.add(lbReds);
        
	textRed = new JTextField();
	textRed.setBounds(75, 80, 190, 30);
        textRed.setEnabled(false);
        textRed.setText(Integer.toString(apostaDao.red()));
	contentPane.add(textRed);
	textRed.setColumns(10);
        
        JLabel lbGren = new JLabel("Greens: ");
        lbGren.setBounds(10, 115, 50, 30);
	contentPane.add(lbGren);
        
        textGreen = new JTextField();
	textGreen.setBounds(75, 115, 190, 30);
        textGreen.setText(Integer.toString(apostaDao.green()));
        textGreen.setEnabled(false);
	contentPane.add(textGreen);
	textGreen.setColumns(10);
        
        JLabel lbLucro = new JLabel("Lucro: ");
        lbLucro.setBounds(10, 150, 50, 30);
	contentPane.add(lbLucro);
        
        textLucro = new JTextField();
	textLucro.setBounds(75, 150, 190, 30);
        textLucro.setText(Float.toString(apostaDao.luc_total()));
        textLucro.setEnabled(false);
	contentPane.add(textLucro);
	textLucro.setColumns(10);       
        
        btnVoltar = new JButton("Voltar");
        btnVoltar.setBounds(75, 185, 190, 30);
	contentPane.add(btnVoltar);

        btnVoltar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            fechar();    
            }
        });
        
    }
    private void fechar() {
        PrincipalForm ja = new PrincipalForm();
        ja.setVisible(true); 
        dispose();
    }
}