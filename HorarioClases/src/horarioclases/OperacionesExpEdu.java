
package horarioclases;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import conexionBaseDatos.ConectarBD;

public class OperacionesExpEdu extends ConectarBD{
    
  public boolean RegistrarExpEdu(Curso ExpEdu, Reservacion Rsvrcn) throws java.sql.SQLException{
    PreparedStatement ps = null;
    Connection conexion = GetConnection();
      
    String insercionCurso = "INSERT INTO curso (nrc, exp_educativa, profesor,folio_horario)"
            + "VALUES (?,?,?)";
    String insercionReservacion = "INSERT INTO reservacion (salon, dia_clases_clases, horarios_clases)"
            + "VALUES (?,?,?,?)";
    
    try{
      ps = (PreparedStatement) conexion.prepareStatement(insercionCurso);
      ps.setString(1, ExpEdu.getNrc());
      ps.setString(2, ExpEdu.getExp_educativa());
      ps.setString(3, ExpEdu.getProfesor());
      ps.execute();
      return true;
    
    } catch(SQLException e){
      System.err.println(e);
      return false;
    } finally {
        try{
            conexion.close();
        }catch () {}    
    
    
    
  }
}

