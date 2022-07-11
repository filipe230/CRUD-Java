package controller;


import static controller.Constante.*;
import model.DAO.ApostaDAO;
import model.bean.Aposta;

public class ApostaController implements InterfaceController {
    private Aposta aposta;

    @Override
    public void executa(Object view, int parameter) {
        ApostaDAO apostaDAO = new ApostaDAO();
        
        aposta = (Aposta) view;
        switch (parameter) {
            case SALVAR:
                apostaDAO.salvar(aposta);
                break;
            case ATUALIZAR:
                apostaDAO.atualizar(aposta);
                break;
            case APAGAR:
                apostaDAO.apagar(aposta.getCod());
                break;
            case LISTAR:
                apostaDAO.listarTodos();
                break;
            default:
                break;
        }
    }
}
