package Modelo;
import static Modelo.ConectarBD.GetConnection;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MetodosProfesores extends Modelo.ConectarBD{
  PreparedStatement ps = null;
  Connection conexion = GetConnection();
    
    public List BusquedaProfesor(Recipiente recipiente, String buscarProfesor){
    ResultSet rs = null;   
    List<Recipiente>datosProfesor = new ArrayList<>();
    String llenadoModuloProfesor = "SELECT nrc\n" +
        "   , exp_educativa\n" +
        "   , GROUP_CONCAT(LUNES) AS Lunes\n" +
        "   , GROUP_CONCAT(MARTES) AS Martes\n" +
        "   , GROUP_CONCAT(MIERCOLES) AS Miercoles\n" +
        "   , GROUP_CONCAT(JUEVES) AS Jueves\n" +
        "   , GROUP_CONCAT(VIERNES) AS Viernes\n" +
        "   , GROUP_CONCAT(SABADO) AS Sabado\n" +
        "   FROM (SELECT curso.nrc\n" +
        "       , curso.exp_educativa\n" +
        "       , CONCAT_WS(' ',profesor.nombre, profesor.paterno, profesor.materno) AS 'Profesor'\n" +
        "       , IF (reserva.dia_clases_clases = 'LUNES', reserva.horarios_clases, null) AS 'LUNES'\n" +
        "       , IF (reserva.dia_clases_clases = 'MARTES', reserva.horarios_clases, null) AS 'MARTES'\n" +
        "       , IF (reserva.dia_clases_clases = 'MIERCOLES', reserva.horarios_clases, null) AS 'MIERCOLES'\n" +
        "       , IF (reserva.dia_clases_clases = 'JUEVES', reserva.horarios_clases, null) AS 'JUEVES'\n" +
        "       , IF (reserva.dia_clases_clases = 'VIERNES', reserva.horarios_clases, null) AS 'VIERNES'\n" +
        "       , IF (reserva.dia_clases_clases = 'SABADO', reserva.horarios_clases, null) AS 'SABADO'\n" +
        "       FROM curso \n" +
"       INNER JOIN profesor ON profesor.id_profesor = curso.profesor\n" +
"       INNER JOIN reserva ON reserva.nrc_reserva = curso.nrc\n" +
"       WHERE CONCAT_WS(' ',profesor.nombre, profesor.paterno, profesor.materno) LIKE '%"+buscarProfesor+"%') AS TablaProfesores\n" +
"	GROUP BY nrc;";
    try {
      ps = (com.mysql.jdbc.PreparedStatement) conexion.prepareStatement(llenadoModuloProfesor);
      rs = ps.executeQuery();
      
      while(rs.next()){
        Recipiente contenedorProfesores = new Recipiente();
        contenedorProfesores.setNrc(rs.getString(1));
        contenedorProfesores.setNombreCompleto(rs.getString(2));
        contenedorProfesores.setDiaLunes(rs.getString(3));
        contenedorProfesores.setDiaMartes(rs.getString(4));
        contenedorProfesores.setDiaMiercoles(rs.getString(5));
        contenedorProfesores.setDiaJueves(rs.getString(6));
        contenedorProfesores.setDiaViernes(rs.getString(7));
        contenedorProfesores.setDiaSabado(rs.getString(8));
        datosProfesor.add(contenedorProfesores);
      }
    } catch (SQLException e) {
      System.err.println(e);
    } 
      return datosProfesor;          
  }

}
