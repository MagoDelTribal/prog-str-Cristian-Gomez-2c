import java.util.Scanner;
public class Main{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);

        LecctorNotas lector=new LecctorNotas();
        GradeService calculador=new GradeService();
        Resumen resumen=new Resumen();

        String nombreAlumno= lector.llerNombre(sc);
        String materia= lector.llerMateria(sc);

        double c1=lector.leerCalificacion(sc, "parcial 1: ");
        double c2= lector.leerCalificacion(sc, "parcial 2: ");
        double c3= lector.leerCalificacion(sc,"parcial 3:");
        int asistencia= lector.leerAsistencia(sc);
        boolean proyecto= lector.leerProyecto(sc);


        double promedio= calculador.calcularPromedio(c1,c2,c3);
        double calificacionFinal= calculador.determinarCalificacionFinal(promedio, asistencia);
        String estado= calculador.estado(promedio, asistencia, proyecto, calificacionFinal);

        resumen.inprimirResumen(nombreAlumno,  materia, c1, c2, c3,  promedio, asistencia, proyecto, calificacionFinal,estado );
            sc.close();

    }
}