
package Modelo;

import static Modelo.ConectarBD.GetConnection;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import java.sql.*;
import java.util.*;

public class MetodosCurso extends ConectarBD{
  PreparedStatement ps = null;
  Connection conexion = GetConnection();

  public MetodosCurso() {
        
  }
  
  public boolean RegistrarCurso(Curso ExpEdu){
       
    String insercionCurso = "INSERT INTO curso (nrc, exp_educativa, profesor,folio_horario)"
            + "VALUES (?,?,?)";
    
    try {
      ps = (PreparedStatement) conexion.prepareStatement(insercionCurso);
      ps.setString(1, ExpEdu.getNrc());
      ps.setString(2, ExpEdu.getExperienciaEducativa());
      ps.setString(3, ExpEdu.getProfesor());
      ps.execute();
      return true;
    } catch (SQLException e) {
      System.err.println(e);
      return false;
    } finally {
      try {
        conexion.close();
      } catch (SQLException e) {
        System.err.println(e);
      }
    }
  }

  public List LlenarTablaCurso(Curso ExpEdu){
    ResultSet rs = null;
    List<Curso>datosExpEdu = new ArrayList<>();
    String llenadoModuloCurso = "SELECT nrc, exp_educativa, "
            + "CONCAT_WS(\" \",profesor.nombre, profesor.paterno, profesor.materno) AS nombre_completo "
            + "FROM curso INNER JOIN profesor ON curso.profesor = profesor.id_profesor;";
    
    try{
      ps = (PreparedStatement) conexion.prepareStatement(llenadoModuloCurso);
      rs = ps.executeQuery();
      while(rs.next()){
          Curso curso = new Curso();
          curso.setNrc(rs.getString(1));
          curso.setExperienciaEducativa(rs.getString(2));
          curso.setProfesor(rs.getString(3));
          datosExpEdu.add(curso);
      }
    }catch(SQLException e){
      System.err.println(e);
    }
    return datosExpEdu;    
  }  

  public List BusquedaCursoNRC(Curso ExpEdu, String buscarNrc){
    ResultSet rs = null;
    List<Curso>datosExpEdu = new ArrayList<>();  
    String llenadoModuloCurso = "SELECT nrc, exp_educativa, "
            + "CONCAT_WS(' ',profesor.nombre, profesor.paterno, profesor.materno) AS nombre_completo "
            + "FROM curso INNER JOIN profesor ON curso.profesor = profesor.id_profesor WHERE nrc='"+buscarNrc+"';";         
    
    try {
      ps = (PreparedStatement) conexion.prepareStatement(llenadoModuloCurso);
      rs = ps.executeQuery();
      
      while(rs.next()){
        Curso curso = new Curso();
        curso.setNrc(rs.getString(1));
        curso.setExperienciaEducativa(rs.getString(2));
        curso.setProfesor(rs.getString(3));
        datosExpEdu.add(curso);
      }
    } catch (SQLException e) {
      System.err.println(e);
    } 
      return datosExpEdu;
  }  

  public List BusquedaCursoExpEdu(Curso ExpEdu, String buscarExpEdu){
    ResultSet rs = null;   
    List<Curso>datosExpEdu = new ArrayList<>();
    String llenadoModuloCurso = "SELECT nrc, exp_educativa, "
            + "CONCAT_WS(' ',profesor.nombre, profesor.paterno, profesor.materno) "
            + "AS nombre_completo FROM curso INNER JOIN profesor ON curso.profesor = "
            + "profesor.id_profesor WHERE curso.exp_educativa = '"+buscarExpEdu+"';";
    try {
      ps = (PreparedStatement) conexion.prepareStatement(llenadoModuloCurso);
      rs = ps.executeQuery();
      
      while(rs.next()){
        Curso curso = new Curso();
        curso.setNrc(rs.getString(1));
        curso.setExperienciaEducativa(rs.getString(2));
        curso.setProfesor(rs.getString(3));
        datosExpEdu.add(curso);
      }
    } catch (SQLException e) {
      System.err.println(e);
    } 
      return datosExpEdu;        
    
  }  
}
