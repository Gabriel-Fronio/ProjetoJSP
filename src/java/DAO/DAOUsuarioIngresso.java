package DAO;

import Connect.DAOs;
import DBO.DBOUsuarioIngresso;


public class DAOUsuarioIngresso {
    public static boolean insert(DBOUsuarioIngresso ui)
    {
        try
        {
            if(ui == null)
                return false;
            String sql = "INSERT INTO UsuarioIngresso values(?,?)";
            DAOs.getBD().prepareStatement(sql);
            DAOs.getBD().setInt(1, ui.getIdIngresso());
            DAOs.getBD().setString(2, ui.getIdUsuario());
            
            int ret = DAOs.getBD().executeUpdate();
            DAOs.getBD().commit();
            if (ret > 0)
                return true;
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
            return false;
        }
        return false;
    }
}
