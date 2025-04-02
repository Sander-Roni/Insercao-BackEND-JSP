/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import model.Cliente;
import util.ConectaDB;
import java.sql.*;
import java.text.SimpleDateFormat;
        

/**
 *
 * @author alunocmc
 */
public class ClienteDAO {
    // Zero Atrib.
    
    // Métodos - CRUD
    public boolean inserir (Cliente p_cli) throws ClassNotFoundException{
        //Conectar
        Connection conexao = null;
        try{
            conexao = ConectaDB.conectar(); //Abre a conexão
            Statement stmt = conexao.createStatement();
            //String sql = "Insert into cliente (codigo, nome, renda, nasc) values(987654, 'José da Silva', 9500, '1981/03/22')";
            String sql = "Insert into cliente (codigo, nome, renda, nasc) values(" 
                    + p_cli.getCod() + ", '" 
                    + p_cli.getNome() + "', " 
                    + p_cli.getRenda() + ", '"
                    + new SimpleDateFormat("yyyy/MM/dd").format(p_cli.getNasc())+"')";
            stmt.executeUpdate(sql); // Insert - Update - Delete
            return true;
        }
        catch(SQLException ex){
            System.out.println("Erro SQL: " + ex);
            return false;
        }               
    }
    
    
}
