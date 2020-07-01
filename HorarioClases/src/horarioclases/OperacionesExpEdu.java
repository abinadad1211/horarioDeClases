
package horarioclases;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import conexionBaseDatos.ConectarBD;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class OperacionesExpEdu extends ConectarBD{
    
  public boolean RegistrarExpRsrvcn(Curso ExpEdu){
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
        conexion.close();;
      } catch (SQLException e) {
        System.err.println(e);
      }
    }
  }
  public boolean RegistrarReservacion(Reservacion rsrvcn, Curso expEdu){
    PreparedStatement ps = null;
    Connection conexion = GetConnection();
      
    String insercionReservacion = "INSERT INTO reservacion (salon, dia_clases_clases, horarios_clases)"
            + "VALUES (?,?,?,?)";
    
    try {
      ps = (PreparedStatement) conexion.prepareStatement(insercionReservacion);
      ps.setString(1, rsrvcn.getSalon());
      ps.setString(2, String.valueOf(rsrvcn.getDiaSemana()));
      ps.setString(3, rsrvcn.getHoraDia());
      ps.setString(4, expEdu.getNrc());
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
