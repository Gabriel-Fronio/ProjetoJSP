/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DBO.DBOUsuario;
import Connect.*;
import java.math.BigInteger;
import java.security.MessageDigest;

public class DAOUsuario {
    
    public static boolean insert(DBOUsuario usr)
    {
        try
        {
            String senha = usr.getSenha();
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(senha.getBytes(), 0, senha.length());
            senha = (new BigInteger(1,md.digest()).toString(32)).toString();
            
            if(getUsuario(usr.getEmail()) != null)
                return false;
                
            
            String sql = "INSERT INTO usuario VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
            DAOs.getBD().prepareStatement(sql);
            DAOs.getBD().setString(1, usr.getNome());
            DAOs.getBD().setString(2, usr.getCpf());
            DAOs.getBD().setString(3, usr.getSexo()+"");
            DAOs.getBD().setDate(4, usr.getData());
            DAOs.getBD().setString(5, usr.getTel());
            DAOs.getBD().setString(6, usr.getCep());
            DAOs.getBD().setString(7, usr.getEnd());
            DAOs.getBD().setString(8, usr.getEmail());
            DAOs.getBD().setString(9, senha);
            
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
    
    public static DBOUsuario getUsuario(String email)
    {
        DBOUsuario usr = null;
        try
        {
            String sql = "SELECT * FROM usuario WHERE email = '"+email+"'";
            DAOs.getBD().prepareStatement(sql);
            
            MeuResultSet result = (MeuResultSet)DAOs.getBD().executeQuery();
            if(result.first())
                usr = new DBOUsuario(result.getString("nome"), result.getString("cpf"), result.getString("telefone"),
                        result.getString("cep"), result.getString("endereco"), email, result.getString("senha"), 
                        result.getString("sexo").charAt(0), result.getDate("dataNasc"));
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
            return null;
        }
        return usr;
    }
    
}
