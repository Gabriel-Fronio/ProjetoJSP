/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DBO.DBOEvento;
import java.sql.Date;
import Connect.*;

/**
 *
 * @author u16166
 */
public class DAOEvento {
    
    public DBOEvento getEvento(Date data)
    {
        try
        {
            String sql = "SELECT * FROM Evento WHERE data="+data;
            DAOs.getBD().prepareStatement(sql);
            MeuResultSet result = (MeuResultSet)DAOs.getBD().executeQuery();
            if(result.first())
                return new DBOEvento(result.getString("nome"), result.getDate("data"));
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
            return null;
        }
        return null;
    }
}
