/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mmoj_classeBO;

import mmoj_classeDAO.Mmoj_ControleDAO;
import java.util.List;
import mmoj_objetos.Mmoj_Controle;

/**
 *
 * @author Maria
 */
public class Mmoj_ControleBO {
     Mmoj_ControleDAO mmoj_controleDAO;
    
    public Mmoj_ControleBO(){
        mmoj_controleDAO = new Mmoj_ControleDAO();
    }
    public void mmoj_salvarControle(Mmoj_Controle mmoj_controle)
    {
        mmoj_controleDAO.mmoj_salvarControle(mmoj_controle);
    }
    
    public List<Mmoj_Controle> mmoj_getControle()
    {
        return mmoj_controleDAO.mmoj_getControle();
    }    
}
