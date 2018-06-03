/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DBO.DBOUsuario;
import Connect.*;

public class DAOUsuario {
    
    public static boolean insert(DBOUsuario usr)
    {
        try
        {
            MeuPreparedStatement bd = DAOs.getBD();//nome, cpf, sexo, dataNasc, tel, cep, end, email, senha
            String sql = "INSERT INTO usuario VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
            bd.prepareStatement(sql);
            bd.setString(1, usr.getNome());
            bd.setString(2, usr.getCpf());
            bd.setString(3, usr.getSexo()+"");
            bd.setDate(4, usr.getData());
            bd.setString(5, usr.getTel());
            bd.setString(6, usr.getCep());
            bd.setString(7, usr.getEnd());
            bd.setString(8, usr.getEmail());
            bd.setString(9, usr.getSenha());
            
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
    
    public static DBOUsuario getUsuario(String email)
    {
        DBOUsuario usr = null;
        try
        {
            MeuPreparedStatement bd = DAOs.getBD();
            String sql = "SELECT * FROM usuario WHERE email = "+email;
            bd.prepareStatement(sql);
            
            MeuResultSet result = (MeuResultSet)bd.executeQuery();
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
