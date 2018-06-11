
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Connect.DAOs;
import Connect.MeuPreparedStatement;
import Connect.MeuResultSet;
import DBO.DBOSetor;
import java.util.ArrayList;

/**
 *
 * @author u16168
 */
public class DAOSetor {
    
    public static ArrayList<DBOSetor> getAllSetores()
    {
        ArrayList<DBOSetor> ret = new ArrayList<DBOSetor>();
        
        try
        {
            String sql = "SELECT * FROM setorEvento";
            DAOs.getBD().prepareStatement(sql);
            MeuResultSet result = (MeuResultSet)DAOs.getBD().executeQuery();
            if(result.first())
                do
                {
                    ret.add(new DBOSetor(result.getInt("idSetor"), result.getInt("qtdIngressos"), result.getString("nome")));
                }
                while(result.next());
            else
                ret = null;
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
            return null;
        }
        return ret;
    }
    
    public static ArrayList<DBOSetor> getSetorEvento(int idEvento) //VERIFICAR
    {
        ArrayList<DBOSetor> ret = new ArrayList<DBOSetor>();
        
        try
        {
            String sql = "SELECT * FROM setorEvento where idEvento = ?";
            DAOs.getBD().prepareStatement(sql);
            DAOs.getBD().setInt(1, idEvento);
            MeuResultSet result = (MeuResultSet)DAOs.getBD().executeQuery();
            if(result.first())
                do
                {
                    ret.add(new DBOSetor(result.getInt("idSetor"), result.getInt("qtdIngressos"), result.getString("nome")));
                }
                while(result.next());
            else
                ret = null;
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
            return null;
        }
        return ret;
    }
}
