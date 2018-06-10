/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DBO.DBOEvento;
import java.sql.Date;
import Connect.*;
import java.util.List;

/**
 *
 * @author u16166
 */
public class DAOEvento {
    
    /**
     * Pega o id do evento passado no parametro no dia passado como parametro
     * @param ev evento cujo nome sera verificado no BD
     * @param dt data que ocorrera o evento
     * @return -3 se algum erro inesperado ocorreu, -2 se algum dos parametros for nulo, -1 se nao houver tal evento em tal dia no BD, senao retorna o id do evento 
     */
    public static int getIdEvento(DBOEvento ev, Date dt)
    {
        if(ev == null || dt == null)
            return -2;
        
        try
        {
            String sql = "SELECT id FROM Evento WHERE nome='"+ev.getNome()+"' AND data="+dt.toString();
            DAOs.getBD().prepareStatement(sql);
            MeuResultSet result = (MeuResultSet)DAOs.getBD().executeQuery();
            if(result.first())
                return result.getInt("id");
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
            return -3;
        }
        return -1;
    }
    
    /**
     * @param even o DBOEvento cujo nome sera passado para o BD
     * @return Todas as datas as quais o evento com mesmo nome do parametro irao ocorrer
    */
    public static List<Date> getDataPorEvento(DBOEvento even)
    {
        if(even == null)
            return null;
        List<Date> ret = null;
        try
        {
            String sql = "SELECT data FROM Evento WHERE nome='"+even.getNome()+"'";
            DAOs.getBD().prepareStatement(sql);
            MeuResultSet result = (MeuResultSet)DAOs.getBD().executeQuery();
            if(result.first())
                do
                {
                    ret.add(Date.valueOf(result.getDate("data").toString()));
                }
                while(result.next());                
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
            return null;
        }
        return ret;
    }
    
    /**
     * Pega todos os eventos que ocorrerao na data passada como parametro
     * @param data a data a ser verificada no BD
     * @return lista de eventos que ocorrerao naquele dia
     */
    public static List<DBOEvento> getEventoPorData(Date data)
    {
        if(data == null)
            return null;
        List<DBOEvento> ret = null;
        try
        {
            String sql = "SELECT * FROM Evento WHERE data="+data.toString();
            DAOs.getBD().prepareStatement(sql);
            MeuResultSet result = (MeuResultSet)DAOs.getBD().executeQuery();
            if(result.first())
                do
                {
                    ret.add(new DBOEvento(result.getString("nome"), result.getDate("data")));
                }
                while(result.next());                
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
            return null;
        }
        return ret;
    }
    
    public static List<DBOEvento> getAllEventos()
    {
        List<DBOEvento> ret = null;
        try
        {
            String sql = "SELECT * FROM Evento";
            DAOs.getBD().prepareStatement(sql);
            MeuResultSet result = (MeuResultSet)DAOs.getBD().executeQuery();
            if(result.first())
                do
                {
                    ret.add(new DBOEvento(result.getString("nome"), result.getDate("data")));
                }
                while(result.next());                
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
            return null;
        }
        return ret;
    }
    
    public static List<Date> getAllDatas()
    {
        List<Date> ret;
        try
        {
            String sql = "SELECT * FROM Evento";
            DAOs.getBD().prepareStatement(sql);
            MeuResultSet result = (MeuResultSet)DAOs.getBD().executeQuery();
            if(result.first())
                do
                {
                    ret.add(Date.valueOf(result.getDate("data").toString()));
                }
                while(result.next());                
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
            return null;
        }
        return ret;
    }
}
