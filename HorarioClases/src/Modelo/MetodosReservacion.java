
package Modelo;
import java.sql.*;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import static Modelo.ConectarBD.GetConnection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;



public class MetodosReservacion extends ConectarBD {
    PreparedStatement ps = null;
    Connection conexion = GetConnection();
    
    public List BusquedaProfesor(Recipiente recipiente, String buscarSalon){
    ResultSet rs = null;   
    List<Recipiente>datosSalon = new ArrayList<>();
    String llenadoModuloSalon = "SELECT idprofesor\n" +
"           , nombreprofesor\n" +
"           , GROUP_CONCAT(LUNES) AS Lunes\n" +
"           , GROUP_CONCAT(MARTES) AS Martes\n" +
"           , GROUP_CONCAT(MIERCOLES) AS Miercoles\n" +
"           , GROUP_CONCAT(JUEVES) AS Jueves\n" +
"           , GROUP_CONCAT(VIERNES) AS Viernes\n" +
"           , GROUP_CONCAT(SABADO) AS Sábado\n" +
"           FROM (SELECT profesor.id_profesor AS 'idprofesor'\n" +
"              , CONCAT_WS(' ',profesor.nombre, profesor.paterno, profesor.materno) AS 'nombreprofesor'\n" +
"	       , IF (reserva.dia_clases_clases = 'LUNES', reserva.horarios_clases, null) AS 'LUNES'\n" +
"	       , IF (reserva.dia_clases_clases = 'MARTES', reserva.horarios_clases, null) AS 'MARTES'\n" +
"	       , IF (reserva.dia_clases_clases = 'MIERCOLES', reserva.horarios_clases, null) AS 'MIERCOLES'\n" +
"	       , IF (reserva.dia_clases_clases = 'JUEVES', reserva.horarios_clases, null) AS 'JUEVES'\n" +
"	       , IF (reserva.dia_clases_clases = 'VIERNES', reserva.horarios_clases, null) AS 'VIERNES'\n" +
"	       , IF (reserva.dia_clases_clases = 'SABADO', reserva.horarios_clases, null) AS 'SABADO'\n" +
"	       FROM curso \n" +
"              INNER JOIN profesor ON profesor.id_profesor = curso.profesor\n" +
"              INNER JOIN reserva ON reserva.nrc_reserva = curso.nrc\n" +
"              WHERE reserva.salon = '"+buscarSalon+"') AS TablaHorario\n" +
"           GROUP BY idprofesor;";
    try {
      ps = (com.mysql.jdbc.PreparedStatement) conexion.prepareStatement(llenadoModuloSalon);
      rs = ps.executeQuery();
      
      while(rs.next()){
        Recipiente contenedorSalon = new Recipiente();
        contenedorSalon.setIdProfesor(rs.getString(1));
        contenedorSalon.setDiaLunes(rs.getString(2));
        contenedorSalon.setDiaMartes(rs.getString(3));
        contenedorSalon.setDiaMiercoles(rs.getString(4));
        contenedorSalon.setDiaJueves(rs.getString(5));
        contenedorSalon.setDiaViernes(rs.getString(6));
        contenedorSalon.setDiaSabado(rs.getString(7));
        datosSalon.add(contenedorSalon);
      }
    } catch (SQLException e) {
      System.err.println(e);
    } 
      return datosSalon;          
  }

}


    










