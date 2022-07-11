package view;

import static controller.Constante.*;
import controller.UsuarioController;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;
import model.DAO.UsuarioDAO;
import model.bean.Usuario;

class LoginForm extends JFrame{
    public static Usuario visuLogin;
    
    private JPanel contentPane;
    private JTextField txtUser;
    private JPasswordField txtPassword;
    private JButton btnEntrar;
    private JButton btnSair;
    private JButton btnCadastrar;
    
    Usuario usuario = new Usuario();
    UsuarioController usuarioController = new UsuarioController();
    
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
		try {
                    LoginForm frame = new LoginForm();
                    frame.setVisible(true);
		} catch (Exception e) {
                    e.printStackTrace();
		}
	}
    });
    }
    
   public LoginForm() {
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setBounds(350, 300, 300, 350);
    contentPane = new JPanel();
    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
    setContentPane(contentPane);
    contentPane.setLayout(null);
   
    JLabel lbDadosEst = new JLabel("Tela de Login");
    lbDadosEst.setBounds(110, 0, 200, 50);
    contentPane.add(lbDadosEst);
        
    JLabel lblUser = new JLabel("Usuário: ");
    lblUser.setBounds(25, 50, 100, 30); 
    contentPane.add(lblUser);

    JLabel lblPass = new JLabel("Senha: ");
    lblPass.setBounds(25, 100, 100, 30); 
    contentPane.add(lblPass);
    
    txtUser = new JTextField();
    txtUser.setBounds(90, 50, 150, 30);
    contentPane.add(txtUser);
    txtUser.setColumns(10);

    txtPassword = new JPasswordField(); 
    txtPassword.setBounds(90, 100, 150, 30);
    contentPane.add(txtPassword);
    txtPassword.setColumns(10);
    
    btnEntrar = new JButton("Entrar");
    btnEntrar.setBounds(110, 150, 100, 30);
    contentPane.add(btnEntrar);
   
    btnCadastrar = new JButton("Cadastrar");
    btnCadastrar.setBounds(110, 200, 100, 30);
    contentPane.add(btnCadastrar);
   
    btnSair = new JButton("Sair");
    btnSair.setBounds(110, 250, 100, 30);
    contentPane.add(btnSair);
        
    btnEntrar.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            UsuarioDAO login = new UsuarioDAO();
            if (login.login(txtUser.getText(), new String (txtPassword.getPassword()))) {
                visuLogin = login.retorna(txtUser.getText(), new String (txtPassword.getPassword())); 
                entrar();
            } else {
                JOptionPane.showMessageDialog(contentPane, "Usuário e/ou senha incorretos");
            }
        }
    });
    
    btnCadastrar.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            CadastrarUsuForm ja = new CadastrarUsuForm();
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
   private void entrar() {
       PrincipalForm ja = new PrincipalForm();
       ja.setVisible(true); 
       dispose();
   }
}