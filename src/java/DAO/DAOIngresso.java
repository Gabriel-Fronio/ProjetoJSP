package DAO;

import DBO.DBOIngresso;
import Connect.*;
import java.util.ArrayList;


public class DAOIngresso {
    
    public static int getId(DBOIngresso ingresso)
    {
        if(ingresso == null)
            return -2;
        try
        {
            String sql = "SELECT id FROM ingresso WHERE codSetor="+ingresso.getCodSetor()+" AND categoria='"+ingresso.getCategoria()+"' AND preco="+ingresso.getPreco();
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
    
    public static ArrayList<DBOIngresso> getIngressoSetor(int codSetor)
    {
        ArrayList<DBOIngresso> ret = new ArrayList<DBOIngresso>();
        try
        {
            String sql = "SELECT * FROM Ingresso WHERE codSetor="+codSetor;
            DAOs.getBD().prepareStatement(sql);
            MeuResultSet result = (MeuResultSet)DAOs.getBD().executeQuery();
            if(result.first())
                do               
                    ret.add(new DBOIngresso(result.getInt("codSetor"), result.getString("categoria"), result.getFloat("preco")));                
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
    
    public static DBOIngresso getIngresso(int id)
    {
        DBOIngresso ret = null;
        try
        {
            String sql = "SELECT * FROM Ingresso WHERE id="+id;
            DAOs.getBD().prepareStatement(sql);
            MeuResultSet result = (MeuResultSet)DAOs.getBD().executeQuery();
            if(result.first())
                ret = new DBOIngresso(result.getInt("codSetor"), result.getString("categoria"), result.getFloat("preco"));
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
            return null;
        }
        return ret;
    }
}