package controller;

import static controller.Constante.*;
import model.DAO.UsuarioDAO;
import model.bean.Usuario;

public class UsuarioController implements InterfaceController {
    private Usuario usuario;
    
    @Override
    public void executa(Object view, int parameter) {
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        
        usuario = (Usuario) view;
        switch (parameter) {
            case SALVAR:
                usuarioDAO.salvar(usuario);
                break;    
            case ATUALIZAR:
                usuarioDAO.atualizar(usuario);
                break;
            case APAGAR:
                usuarioDAO.apagar(usuario.getId());
                break;
            case LOGIN:
                //usuarioDAO.login();
                break;
            default:
                break;
        }
    }
}    

