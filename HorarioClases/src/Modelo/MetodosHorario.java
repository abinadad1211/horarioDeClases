
package Modelo;

import static Modelo.ConectarBD.GetConnection;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import java.sql.SQLException;

public class MetodosHorario {
    public boolean RegistrarReservacion(Horario horario){
    PreparedStatement ps = null;
    Connection conexion = GetConnection();
      
    String insercionHorario = "INSERT INTO horario (folio_horario, grupo, programa_educativo)"
            + "VALUES (?,?,?)";
    
    try {
      ps = (PreparedStatement) conexion.prepareStatement(insercionHorario);
      ps.setString(1, horario.getFolioHorario());
      ps.setString(2, horario.getGrupo());
      ps.setString(3, horario.getProgramaEducativo());
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
