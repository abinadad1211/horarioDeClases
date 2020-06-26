package conexionBaseDeDatos;

import java.sql.*;
import javax.swing.JOptionPane;

public class conectar {    
    private static String db="horario_de_clases";
    private static String usuario="admin";
    private static String contrasenia="-Lis401-samsung1";
    private static String url="jdbc:mysql://lis401.cbjqnknzqkto.us-east-2.rds.amazonaws.com:3306/horario_de_clases";

    private static Connection Conn;
    
    public static Connection getConnection(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Conn = DriverManager.getConnection(url, usuario, contrasenia);
            //conectar=DriverManager.getConnection(host, usuario, usuario);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Error :( "+e.getMessage());
        }
        return Conn;
    }  
}