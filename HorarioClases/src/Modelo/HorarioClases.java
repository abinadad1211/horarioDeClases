
package Modelo;

public class HorarioClases {

    public static void main(String[] args) {
        Curso curso = new Curso();
        MetodosCurso metodosCurso = new MetodosCurso();
        ConsultaExpEdu consultaExpEdu = new ConsultaExpEdu();
        
        CtrlCurso ctrlCurso = new CtrlCurso (curso, metodosCurso, consultaExpEdu);
        ctrlCurso.iniciar();
        
    }
}
