/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package horarioclases;

import java.sql.*;

/**
 *
 * @author Alexis
 */

public class Curso{
    
    public static void main (String[] args){
     
        String url = "jdbc:mysql://lis401.cbjqnknzqkto.us-east-2.rds.amazonaws.com:3306/horario_de_clases";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            // Creamos el objeto conexion
            Connection conexion = (Connection) DriverManager.getConnection(url, "admin", "-Lis401-samsung1");
            // Creamos un objeto Statement
            Statement instruccion = conexion.createStatement();
            // Creamos el query
            String sql = "SELECT nrc, exp_educativa, profesor.nombre FROM curso INNER JOIN profesor ON curso.profesor = profesor.id_profesor;";
            ResultSet result = instruccion.executeQuery(sql);
            System.out.println("NRC\tEXP\tPROFESOR");
            while (result.next()) {
                /*System.out.print("ID:" + result.getString(1));
                System.out.print(" NOMBRE:" + result.getString(2));
                System.out.println(" PRIMER APELLIDO:" + result.getString(3));*/
                System.out.println(result.getString(1)+"\t"+result.getString(2)+"\t"+result.getString(3));
            }
            // Cerrar cada uno de los objetos utilizados
            result.close();
            instruccion.close();
            conexion.close();
        } 
        catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
}
      
}