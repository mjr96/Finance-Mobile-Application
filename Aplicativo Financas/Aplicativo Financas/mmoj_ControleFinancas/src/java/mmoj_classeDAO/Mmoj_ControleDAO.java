/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mmoj_classeDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import mmoj_objetos.Mmoj_Controle;
import mmoj_utilitarios.Mmoj_Conexao;

/**
 *
 * @author Maria
 */
public class Mmoj_ControleDAO {
    Connection conn;

    public Mmoj_ControleDAO() 
    {
        conn = new Mmoj_Conexao().conectar();
    }

    
    public void mmoj_salvarControle(Mmoj_Controle mmoj_controle)
    {
        try
        {
            PreparedStatement ppStmt = conn.prepareStatement("INSERT INTO controle(nome, tipo, valor) values(?,?,?)");
            ppStmt.setString(1, mmoj_controle.getMmoj_nome());
            ppStmt.setString(2, mmoj_controle.getMmoj_tipo());
            ppStmt.setDouble(3, mmoj_controle.getMmoj_valor());
            
            ppStmt.execute();
        }
        catch(SQLException ex)
        {
            ex.printStackTrace();
        }
    }
    
    public List<Mmoj_Controle> mmoj_getControle()
    {
        List<Mmoj_Controle> mmoj_controle = new LinkedList<>();
        
        try
        {
            PreparedStatement ppStmt = conn.prepareStatement("SELECT * FROM controle");
            ResultSet rs = ppStmt.executeQuery();
            while(rs.next())
            {
                mmoj_controle.add(getControle(rs));
            }
        }
        catch(SQLException ex)
        {
            ex.printStackTrace();
        }
        return mmoj_controle;
    }
    
    private Mmoj_Controle getControle(ResultSet rs) throws SQLException
    {
        Mmoj_Controle mmoj_controle = new Mmoj_Controle();
        
        mmoj_controle.setMmoj_nome(rs.getString("nome"));
        mmoj_controle.setMmoj_tipo(rs.getString("tipo"));
        mmoj_controle.setMmoj_valor(rs.getDouble("valor"));
        
        return mmoj_controle;
    }
}
