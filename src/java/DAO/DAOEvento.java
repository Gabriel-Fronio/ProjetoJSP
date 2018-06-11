/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DBO.DBOEvento;
import java.sql.Date;
import Connect.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.text.SimpleDateFormat;

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
            String sql = "SELECT id FROM Evento WHERE nome='"+ev.getNome()+"' AND data='"+(new SimpleDateFormat("yyyy-dd-MM")).format(dt)+"'";
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
    public static ArrayList<Date> getDataPorEvento(DBOEvento even)
    {
        if(even == null)
            return null;
        ArrayList<Date> ret = new ArrayList<Date>();
        try
        {
            String sql = "SELECT data FROM Evento WHERE nome='"+even.getNome()+"'";
            DAOs.getBD().prepareStatement(sql);
            MeuResultSet result = (MeuResultSet)DAOs.getBD().executeQuery();
            if(result.first())
                do
                {
                    ret.add(result.getDate("data"));
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
    public static ArrayList<DBOEvento> getEventoPorData(Date data)
    {
        if(data == null)
            return null;
        ArrayList<DBOEvento> ret = new ArrayList<DBOEvento>();
        try
        {
            String sql = "SELECT * FROM Evento WHERE data='"+ (new SimpleDateFormat("yyyy-dd-MM")).format(data) +"'";
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
    
    public static ArrayList<DBOEvento> getAllEventos()
    {
        ArrayList<DBOEvento> ret = new ArrayList<DBOEvento>();
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
    
    public static ArrayList<Date> getAllDatas()
    {
        ArrayList<Date> ret = new ArrayList<Date>();
        try
        {
            String sql = "SELECT DISTINCT data FROM Evento";
            DAOs.getBD().prepareStatement(sql);
            MeuResultSet result = (MeuResultSet)DAOs.getBD().executeQuery();
            if(result.first())
                do
                {
                    ret.add(result.getDate("data"));
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
