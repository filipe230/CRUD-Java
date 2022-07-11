package view;

import static controller.Constante.SALVAR;
import controller.UsuarioController;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import model.bean.Usuario;

public class CadastrarUsuForm extends JFrame{
    private JPanel contentPane;
    private JTable tableApostas;
    private JTextField textNome;
    private JTextField textEndereco;
    private JTextField textEmail;
    private JTextField textTelefone;
    private JTextField textCPF;
    private JTextField textUsuario;
    private JTextField textSenha;
    private JButton btnVoltar;
    private JButton btnCadastrar;    
    
    Usuario usuario = new Usuario();
    UsuarioController usuarioController = new UsuarioController();
    
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    CadastrarUsuForm frame = new CadastrarUsuForm();
                    frame.setTitle("Cadastrar Usuario");
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
    
    public CadastrarUsuForm(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(500, 300, 290, 450);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lbCadUsu = new JLabel("Cadastrar Usuario");
        lbCadUsu.setBounds(90, 0, 200, 50);
        contentPane.add(lbCadUsu);

        JLabel lbNome = new JLabel("Nome");
        lbNome.setBounds(10, 45, 60, 26);
        contentPane.add(lbNome);

        textNome = new JTextField();
        textNome.setBounds(75, 45, 170, 26);
        contentPane.add(textNome);
        textNome.setColumns(10);

        JLabel lbEndereco = new JLabel("Endereco");
        lbEndereco.setBounds(10, 80, 60, 26);
        contentPane.add(lbEndereco);

        textEndereco = new JTextField();
        textEndereco.setBounds(75, 80, 170, 26);
        contentPane.add(textEndereco);
        textEndereco.setColumns(10);

        JLabel lbEmail = new JLabel("Email");
        lbEmail.setBounds(10, 115, 60, 26);
        contentPane.add(lbEmail);

        textEmail = new JTextField();
        textEmail.setBounds(75, 115, 170, 26);
        contentPane.add(textEmail);
        textEmail.setColumns(10);

        JLabel lbTelefone = new JLabel("Telefone");
        lbTelefone.setBounds(10, 150, 60, 26);
        contentPane.add(lbTelefone);

        textTelefone = new JTextField();
        textTelefone.setBounds(75, 150, 170, 26);
        contentPane.add(textTelefone);
        textTelefone.setColumns(10);

        JLabel lbCPF = new JLabel("CPF");
        lbCPF.setBounds(10, 185, 60, 26);
        contentPane.add(lbCPF);

        textCPF = new JTextField();
        textCPF.setBounds(75, 185, 170, 26);
        contentPane.add(textCPF);
        textCPF.setColumns(10);

        JLabel lbUsuario = new JLabel("Usuario*");
        lbUsuario.setBounds(10, 220, 60, 26);
        contentPane.add(lbUsuario);

        textUsuario = new JTextField();
        textUsuario.setBounds(75, 220, 170, 26);
        contentPane.add(textUsuario);
        textUsuario.setColumns(10);

        JLabel lbSenha = new JLabel("Senha*");
        lbSenha.setBounds(10, 255, 60, 26);
        contentPane.add(lbSenha);

        textSenha = new JTextField();
        textSenha.setBounds(75, 255, 170, 26);
        contentPane.add(textSenha);
        textSenha.setColumns(10);

        btnVoltar = new JButton("Voltar");
        btnVoltar.setBounds(75, 290, 170, 26);
        btnVoltar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                fechar(); 
            }
	});
        contentPane.add(btnVoltar);

        btnCadastrar = new JButton("Cadastrar");
        btnCadastrar.setBounds(75, 325, 170, 26);
        btnCadastrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (validarDados(textUsuario, textSenha)) {
                    usuario.setNome(textNome.getText());
                    usuario.setEnd(textEndereco.getText());
                    usuario.setEmail(textEmail.getText());
                    usuario.setCpf(textCPF.getText());
                    usuario.setUsuario(textUsuario.getText());
                    usuario.setSenha(textSenha.getText());
                    usuarioController.executa(usuario,SALVAR);	
                    fechar();
                } else {
                  JOptionPane.showMessageDialog(contentPane, "Dados obrigatórios não preenchidos");
                }
            }
	});
        contentPane.add(btnCadastrar);
    }
    private boolean validarDados(JTextField textUsuario, JTextField textSenha) {
        if (textUsuario.getText().equals("") || textSenha.getText().equals(""))
            return false;
        return true;
    }
    
    private void fechar() {
       LoginForm ja = new LoginForm();
       ja.setVisible(true); 
       dispose();
    }
}   

