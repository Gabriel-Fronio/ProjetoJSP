
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
                    ret.add(new DBOSetor(result.getInt("idEvento"), result.getInt("qtdIngressos"), result.getString("nomeSetor")));
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
            String sql = "SELECT * FROM setorEvento where idEvento = "+ idEvento;
            DAOs.getBD().prepareStatement(sql);
            MeuResultSet result = (MeuResultSet)DAOs.getBD().executeQuery();
            if(result.first())
                do
                {
                    ret.add(new DBOSetor(result.getInt("idEvento"), result.getInt("qtdIngressos"), result.getString("nomeSetor")));
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
    
    public static int getIdSetor(DBOSetor setor)
    {
        if(setor == null)
            return -2;
        try
        {
            String sql = "SELECT codSetor FROM setorEvento WHERE idEvento="+setor.getIdEvento()+" AND nomeSetor='"+setor.getNomeSetor()+"'";
            DAOs.getBD().prepareStatement(sql);
            MeuResultSet result = (MeuResultSet)DAOs.getBD().executeQuery();
            if(result.first())
                return result.getInt("codSetor");
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
            return -3;
        }
        return -1;
    }
    
    public static DBOSetor getSetor(int id)
    {
        if(id < 0)
            return null;
        try
        {
            String sql = "SELECT * FROM setorEvento WHERE codSetor="+id;
            DAOs.getBD().prepareStatement(sql);
            MeuResultSet result = (MeuResultSet)DAOs.getBD().executeQuery();
            if(result.first())
                return new DBOSetor(result.getInt("idEvento"), result.getInt("qtdIngressos"), result.getString("nomeSetor"));
            return null;
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
            return null;
        }
    }
}
