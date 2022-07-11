package controller;

import model.DAO.DocenteDAO;
import model.bean.Docente;

public class DocenteController implements InterfaceController {
    private Docente docente;

    @Override
    public void executa(Object view, int parameter) {
        DocenteDAO docenteDAO = new DocenteDAO();
        
        docente = (Docente) view;
        if (parameter == 1) {
            docenteDAO.salvar(docente);
        } else if (parameter == 2) {
            docenteDAO.atualizar(docente);
        }
    }
}
