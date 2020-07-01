
package Modelo;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import java.sql.SQLException;

public class MetodosCurso extends ConectarBD{
    
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
        conexion.close();;
      } catch (SQLException e) {
        System.err.println(e);
      }
    }
  }
  
}
