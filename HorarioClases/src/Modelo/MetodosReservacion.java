
package Modelo;
import java.sql.*;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import static Modelo.ConectarBD.GetConnection;
import Vista.ConsultaSalon;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;



public class MetodosReservacion extends ConectarBD {
     private DefaultTableModel tablaResultados;
     String filaParaResultados[] = new String [3];
     private ConsultaSalon consultaSalon;
    
    public boolean RegistrarReservacion(Reservacion reserva){
    PreparedStatement ps = null;
    Connection conexion = GetConnection();
      
    String insercionReservacion = "INSERT INTO reservacion (salon, dia_clases_clases, horarios_clases, nrc_reserva)"
            + "VALUES (?,?::,?,?)";
    
    try {
      ps = (PreparedStatement) conexion.prepareStatement(insercionReservacion);
      ps.setString(1, reserva.getSalon());
      ps.setString(2, String.valueOf(reserva.getDiaSemana()));
      ps.setString(3, reserva.getHoraDia());
      ps.setString(4, reserva.getNrcReservacion());
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
    public boolean LlenarTablaReservacion(Reservacion Salon){
    PreparedStatement ps = null;
    ResultSet rs = null;
    Connection conexion = GetConnection();
      
    String llenadoModuloReservacion = ("SELECT idprofesor, nombreprofesor, GROUP_CONCAT(LUNES) AS Lunes, GROUP_CONCAT(MARTES) AS Martes,"
            + " GROUP_CONCAT(MIERCOLES) AS Miercoles, GROUP_CONCAT(JUEVES) AS Jueves, GROUP_CONCAT(VIERNES) AS Viernes, GROUP_CONCAT(SABADO) AS Sábado "
            + "FROM (SELECT profesor.id_profesor AS 'idprofesor', CONCAT_WS(' ',profesor.nombre, profesor.paterno, profesor.materno) AS 'nombreprofesor', "
            + "IF (reserva.dia_clases_clases = 'LUNES', reserva.horarios_clases, null) AS 'LUNES', "
            + "IF (reserva.dia_clases_clases = 'MARTES', reserva.horarios_clases, null) AS 'MARTES',"
            + " IF (reserva.dia_clases_clases = 'MIERCOLES', reserva.horarios_clases, null) AS 'MIERCOLES', "
            + "IF (reserva.dia_clases_clases = 'JUEVES', reserva.horarios_clases, null) AS 'JUEVES', "
            + "IF (reserva.dia_clases_clases = 'VIERNES', reserva.horarios_clases, null) AS 'VIERNES', "
            + "IF (reserva.dia_clases_clases = 'SABADO', reserva.horarios_clases, null) AS 'SABADO' "
            + "FROM curso INNER JOIN profesor ON profesor.id_profesor = curso.profesor INNER JOIN reserva ON reserva.nrc_reserva = curso.nrc) AS TablaHorario "
            + "GROUP BY idprofesor;");
    
    try {
      ps = (PreparedStatement) conexion.prepareStatement(llenadoModuloReservacion);
      ps.setString(1, Salon.getSalon());
      rs = ps.executeQuery();
      tablaResultados = new DefaultTableModel();
      
      while(rs.next()){
          filaParaResultados[0] = rs.getString("idprofesor");
          filaParaResultados[1] = rs.getString("nombreprofesor");
          filaParaResultados[2] = ("Lunes");
          filaParaResultados[2] = ("Martes");
          filaParaResultados[2] = ("Miercoles");
          filaParaResultados[2] = ("Jueves");
          filaParaResultados[2] = ("Viernes");
          filaParaResultados[2] = ("Sábado");
          tablaResultados.addRow(filaParaResultados);
          
          consultaSalon.tblSalon.setModel(tablaResultados);
            
            TableColumn columna1 = consultaSalon.tblSalon.getColumn("Mátricula");
            columna1.setMaxWidth(75);
            TableColumn columna2 = consultaSalon.tblSalon.getColumn("Profesor");
            TableColumn columna3 = consultaSalon.tblSalon.getColumn("Lunes");
            TableColumn columna4 = consultaSalon.tblSalon.getColumn("Martes");
            TableColumn columna5 = consultaSalon.tblSalon.getColumn("Miercoles");
            TableColumn columna6 = consultaSalon.tblSalon.getColumn("Jueves");
            TableColumn columna7 = consultaSalon.tblSalon.getColumn("Viernes");
            TableColumn columna8 = consultaSalon.tblSalon.getColumn("Sábado");
            
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
public boolean BusquedaReservacionSalon(Reservacion Salon){
    PreparedStatement ps = null;
    ResultSet rs = null;
    Connection conexion = GetConnection();
        
    String llenadoModuloReservacion = ("SELECT idprofesor, nombreprofesor, GROUP_CONCAT(LUNES) AS Lunes, GROUP_CONCAT(MARTES) AS Martes,"
            + " GROUP_CONCAT(MIERCOLES) AS Miercoles, GROUP_CONCAT(JUEVES) AS Jueves, GROUP_CONCAT(VIERNES) AS Viernes, GROUP_CONCAT(SABADO) AS Sábado "
            + "FROM (SELECT profesor.id_profesor AS 'idprofesor', CONCAT_WS(' ',profesor.nombre, profesor.paterno, profesor.materno) AS 'nombreprofesor', "
            + "IF (reserva.dia_clases_clases = 'LUNES', reserva.horarios_clases, null) AS 'LUNES', "
            + "IF (reserva.dia_clases_clases = 'MARTES', reserva.horarios_clases, null) AS 'MARTES',"
            + " IF (reserva.dia_clases_clases = 'MIERCOLES', reserva.horarios_clases, null) AS 'MIERCOLES', "
            + "IF (reserva.dia_clases_clases = 'JUEVES', reserva.horarios_clases, null) AS 'JUEVES', "
            + "IF (reserva.dia_clases_clases = 'VIERNES', reserva.horarios_clases, null) AS 'VIERNES', "
            + "IF (reserva.dia_clases_clases = 'SABADO', reserva.horarios_clases, null) AS 'SABADO' "
            + "FROM curso INNER JOIN profesor ON profesor.id_profesor = curso.profesor INNER JOIN reserva ON reserva.nrc_reserva = curso.nrc WHERE reserva.salon =?) AS TablaHorario "
            + "GROUP BY idprofesor;");
try {
      ps = (PreparedStatement) conexion.prepareStatement(llenadoModuloReservacion);
      ps.setString(1, Salon.getSalon());
      rs = ps.executeQuery();
      tablaResultados = new DefaultTableModel();
      
      while(rs.next()){
          filaParaResultados[0] = rs.getString("idprofesor");
          filaParaResultados[1] = rs.getString("nombreprofesor");
          filaParaResultados[2] = ("Lunes");
          filaParaResultados[2] = ("Martes");
          filaParaResultados[2] = ("Miercoles");
          filaParaResultados[2] = ("Jueves");
          filaParaResultados[2] = ("Viernes");
          filaParaResultados[2] = ("Sábado");
          tablaResultados.addRow(filaParaResultados);
          
          consultaSalon.tblSalon.setModel(tablaResultados);
            
            TableColumn columna1 = consultaSalon.tblSalon.getColumn("Mátricula");
            columna1.setMaxWidth(75);
            TableColumn columna2 = consultaSalon.tblSalon.getColumn("Profesor");
            TableColumn columna3 = consultaSalon.tblSalon.getColumn("Lunes");
            TableColumn columna4 = consultaSalon.tblSalon.getColumn("Martes");
            TableColumn columna5 = consultaSalon.tblSalon.getColumn("Miercoles");
            TableColumn columna6 = consultaSalon.tblSalon.getColumn("Jueves");
            TableColumn columna7 = consultaSalon.tblSalon.getColumn("Viernes");
            TableColumn columna8 = consultaSalon.tblSalon.getColumn("Sábado");
            
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


    










