
package Modelo;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import static Modelo.ConectarBD.GetConnection;
import java.sql.SQLException;

public class MetodosReservacion {
    
    public boolean RegistrarReservacion(Reservacion reserva){
    PreparedStatement ps = null;
    Connection conexion = GetConnection();
      
    String insercionReservacion = "INSERT INTO reservacion (salon, dia_clases_clases, horarios_clases, nrc_reserva)"
            + "VALUES (?,?,?,?)";
    
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
}
