
package Modelo;

import static Modelo.ConectarBD.GetConnection;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import java.sql.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import Vista.ConsultaExpEdu;

public class MetodosCurso extends ConectarBD{
  private DefaultTableModel tablaResultados;
  String filaParaResultados[] = new String [3];
  private ConsultaExpEdu consultaExpEdu;

    public MetodosCurso(DefaultTableModel tablaResultados, ConsultaExpEdu consultaExpEdu) {
        this.tablaResultados = tablaResultados;
        this.consultaExpEdu = consultaExpEdu;
    }

  
  public boolean RegistrarCurso(Curso ExpEdu){
    PreparedStatement ps = null;
    Connection conexion = GetConnection();
      
    String insercionCurso = "INSERT INTO curso (nrc, exp_educativa, profesor,folio_horario)"
            + "VALUES (?,?,?)";
    
    try {
      ps = (PreparedStatement) conexion.prepareStatement(insercionCurso);
      ps.setString(1, ExpEdu.getNrc());
      ps.setString(2, ExpEdu.getExp_educativa());
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

  public boolean LlenarTablaCurso(Curso ExpEdu){
    PreparedStatement ps = null;
    ResultSet rs = null;
    Connection conexion = GetConnection();
      
    String llenadoModuloCurso = "SELECT nrc, exp_educativa, "
            + "CONCAT_WS(\" \",profesor.nombre, profesor.paterno, profesor.materno) AS nombre_completo "
            + "FROM curso INNER JOIN profesor ON curso.profesor = profesor.id_profesor;";
            
    
    try {
      ps = (PreparedStatement) conexion.prepareStatement(llenadoModuloCurso);
      rs = ps.executeQuery();
      tablaResultados = new DefaultTableModel();
      
      while(rs.next()){
          filaParaResultados[0] = rs.getString("nrc");
          filaParaResultados[1] = rs.getString("exp_educativa");
          filaParaResultados[2] = ("nombre_completo");
          tablaResultados.addRow(filaParaResultados);
          
          consultaExpEdu.tblExpEdu.setModel(tablaResultados);
            TableColumn columnaNRC = consultaExpEdu.tblExpEdu.getColumn("NRC");
            columnaNRC.setMaxWidth(75);
            TableColumn columnaExpEdu = consultaExpEdu.tblExpEdu.getColumn("Experiencia Educativa");
            TableColumn columnaProfesor = consultaExpEdu.tblExpEdu.getColumn("Profesor");
          return true;
      }
      
      return false;
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

  public boolean BusquedaCursoNRC(Curso ExpEdu){
    PreparedStatement ps = null;
    ResultSet rs = null;
    Connection conexion = GetConnection();
      
    String llenadoModuloCurso = "SELECT nrc, exp_educativa, "
            + "CONCAT_WS(' ',profesor.nombre, profesor.paterno, profesor.materno) AS nombre_completo "
            + "FROM curso INNER JOIN profesor ON curso.profesor = profesor.id_profesor WHERE nrc=?;";
            
    
    
    try {
      ps = (PreparedStatement) conexion.prepareStatement(llenadoModuloCurso);
      ps.setString(1, ExpEdu.getNrc());
      rs = ps.executeQuery();
      tablaResultados = new DefaultTableModel();
      
      while(rs.next()){
          filaParaResultados[0] = rs.getString("nrc");
          filaParaResultados[1] = rs.getString("exp_educativa");
          filaParaResultados[2] = ("nombre_completo");
          tablaResultados.addRow(filaParaResultados);
          
          consultaExpEdu.tblExpEdu.setModel(tablaResultados);
            TableColumn columnaNRC = consultaExpEdu.tblExpEdu.getColumn("NRC");
            columnaNRC.setMaxWidth(75);
            TableColumn columnaExpEdu = consultaExpEdu.tblExpEdu.getColumn("Experiencia Educativa");
            TableColumn columnaProfesor = consultaExpEdu.tblExpEdu.getColumn("Profesor");
          return true;
      }

      return false;
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

  public boolean BusquedaCursoExpEdu(Curso ExpEdu){
    PreparedStatement ps = null;
    ResultSet rs = null;
    Connection conexion = GetConnection();
      
    String llenadoModuloCurso = "SELECT nrc, exp_educativa, "
            + "CONCAT_WS(' ',profesor.nombre, profesor.paterno, profesor.materno) "
            + "AS nombre_completo FROM curso INNER JOIN profesor ON curso.profesor = "
            + "profesor.id_profesor WHERE exp_educativa=?;";
            
    
    try {
      ps = (PreparedStatement) conexion.prepareStatement(llenadoModuloCurso);
      ps.setString(1, ExpEdu.getNrc());
      rs = ps.executeQuery();
      tablaResultados = new DefaultTableModel();
      
      while(rs.next()){
          filaParaResultados[0] = rs.getString("nrc");
          filaParaResultados[1] = rs.getString("exp_educativa");
          filaParaResultados[2] = ("nombre_completo");
          tablaResultados.addRow(filaParaResultados);
          
          consultaExpEdu.tblExpEdu.setModel(tablaResultados);
            TableColumn columnaNRC = consultaExpEdu.tblExpEdu.getColumn("NRC");
            columnaNRC.setMaxWidth(75);
            TableColumn columnaExpEdu = consultaExpEdu.tblExpEdu.getColumn("Experiencia Educativa");
            TableColumn columnaProfesor = consultaExpEdu.tblExpEdu.getColumn("Profesor");
          return true;
      }
      
      return false;
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
}
