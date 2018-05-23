/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DBO.DBOUsuario;
import Connect.*;

public class DAOUsuario {
    
    public boolean insert(DBOUsuario usr)
    {
        try
        {
            MeuPreparedStatement bd = DAOs.getBD();//nome, cpf, sexo, dataNasc, tel, cep, end, email, senha
            String sql = "INSET INTO usuario VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
            bd.prepareStatement(sql);
            bd.setString(0, usr.getNome());
            bd.setString(1, usr.getCpf());
            bd.setString(2, usr.getSexo()+"");
            bd.setDate(3, usr.getData());
            bd.setString(4, usr.getTel());
            bd.setString(5, usr.getCep());
            bd.setString(6, usr.getEnd());
            bd.setString(7, usr.getEmail());
            bd.setString(8, usr.getSenha());
            
            int ret = bd.executeUpdate();
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
    
    public boolean insert(DBOUsuario usr)
    {
        try
        {
            MeuPreparedStatement bd = DAOs.getBD();//nome, cpf, sexo, dataNasc, tel, cep, end, email, senha
            String sql = "INSET INTO usuario VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
            bd.prepareStatement(sql);
            bd.setString(0, usr.getNome());
            bd.setString(1, usr.getCpf());
            bd.setString(2, usr.getSexo()+"");
            bd.setDate(3, usr.getData());
            bd.setString(4, usr.getTel());
            bd.setString(5, usr.getCep());
            bd.setString(6, usr.getEnd());
            bd.setString(7, usr.getEmail());
            bd.setString(8, usr.getSenha());
            
            int ret = bd.executeUpdate();
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
