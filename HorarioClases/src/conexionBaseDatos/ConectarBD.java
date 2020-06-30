package conexionBaseDatos;

import java.sql.*;
import javax.swing.JOptionPane;

public class ConectarBD {    
    private static final String db="horario_de_clases";
    private static final String usuario="admin";
    private static final String contrasenia="-Lis401-samsung1";
    private static final String url="jdbc:mysql://lis401.cbjqnknzqkto.us-east-2.rds.amazonaws.com:3306/horario_de_clases";

    public static com.mysql.jdbc.Connection GetConnection(){
        com.mysql.jdbc.Connection conexion = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String servidor = "jdbc:mysql://lis401.cbjqnknzqkto.us-east-2.rds.amazonaws.com:3306/horario_de_clases";
            String usuario = "admin";
            String passwordDB = "-Lis401-samsung1";
            conexion = (com.mysql.jdbc.Connection) DriverManager.getConnection(servidor, usuario, passwordDB);
        }catch (ClassNotFoundException ex){
            JOptionPane.showMessageDialog(null, ex, "Error 1\n\nEjecución del programa falló\n\n-Cursos" + ex.getMessage(),JOptionPane.ERROR_MESSAGE);
        conexion = null;
        }catch (SQLException ex){
            JOptionPane.showMessageDialog(null, ex, "Error 2\n\nInformación no encontrada\n\n-Cursos" + ex.getMessage(),JOptionPane.ERROR_MESSAGE);
        conexion = null;
        }catch (Exception ex){
            JOptionPane.showMessageDialog(null, ex, "Error 3\n\nPrograma colapsado, falta de memoria.\n\n-Cursos" + ex.getMessage(),JOptionPane.ERROR_MESSAGE);
        conexion = null;
        }finally{
        return conexion;
        }
        }
}