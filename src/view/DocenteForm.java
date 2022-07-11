package view;

import controller.DocenteController;
import model.bean.Docente;

public class DocenteForm {
    public static void main(String[] args) {
        Docente docente = new Docente();
        DocenteController docenteController = new DocenteController();
        
        docente.setName("Wesley");
        docente.setIdade(43);
        
        docenteController.executa(docente, 1);
        
    }
}
