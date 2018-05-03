/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mmoj_utilitarios;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Maria
 */
public class Mmoj_Conexao {
     final private String masb_driver = "com.mysql.jdbc.Driver";
    final private String masb_url = "jdbc:mysql://localhost/controle";//_financeiro (Tirei isso depois do controle)
    final private String masb_usuario = "root";
    final private String masb_senha = "";
    
    public Connection conectar()
    {
        Connection conn = null;
        
        try
        {
           Class.forName(masb_driver);
           conn = DriverManager.getConnection(masb_url, masb_usuario, masb_senha);
        }
        catch(ClassNotFoundException ex)
        {
            ex.printStackTrace();
        }
        catch(SQLException ex)
        {
            ex.printStackTrace();
        }
        return conn;
    }
}
