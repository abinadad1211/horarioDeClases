package horarioclases;

import java.sql.*;
import javax.swing.JOptionPane;
import com.mysql.jdbc.Connection;
//import com.mysql.jdbc.Statement;

/**
 * @author Alexis
 */

public class Curso{
    protected String nrc;
    protected String exp_educativa;
    protected String profesor;
    //protected Connection con = null;
    //protected Statement stmt = null;
   
    
    public static Connection GetConection(){
        Connection conexion = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String servidor = "jdbc:mysql://lis401.cbjqnknzqkto.us-east-2.rds.amazonaws.com:3306/horario_de_clases";
            String usuario = "admin";
            String passwordDB = "-Lis401-samsung1";
            conexion = (Connection) DriverManager.getConnection(servidor, usuario, passwordDB);
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
    
    
    public Curso(String nrc, String exp_educativa, String profesor) {
        this.nrc = nrc;
        this.exp_educativa = exp_educativa;
        this.profesor = profesor;
    }
    
    public String getNrc() {
        return nrc;
    }

    public void setNrc(String nrc) {
        this.nrc = nrc;
    }

    public String getExp_educativa() {
        return exp_educativa;
    }

    public void setExp_educativa(String exp_educativa) {
        this.exp_educativa = exp_educativa;
    }

    public String getProfesor() {
        return profesor;
    }

    public void setProfesor(String profesor) {
        this.profesor = profesor;
    }
   
    
}