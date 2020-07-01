
package horarioclases;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import conexionBaseDatos.ConectarBD;

public class OperacionesExpEdu extends ConectarBD{
    
  public boolean RegistrarExpEdu(Curso ExpEdu, Reservacion Rsvrcn){
    PreparedStatement ps = null;
    Connection conexion = GetConnection();
      
    String insercionCurso = "INSERT INTO curso (nrc, exp_educativa, profesor,folio_horario)"
            + "VALUES (?,?,?,?)";
    String insercionReservacion = "INSERT INTO reservacion (";
    
    
    
    return false;
    
  }
}

