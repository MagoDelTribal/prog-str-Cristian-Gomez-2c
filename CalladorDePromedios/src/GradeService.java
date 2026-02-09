public class GradeService {
    public double calcularPromedio(double c1, double c2, double c3) {
        return (c1 + c2 + c3) / 3;
    }
    public double determinarCalificacionFinal(double promedio, int asistencia) {
        return (promedio * 0.7) + (asistencia * 0.3);
    }
    public String estado(double promedio, int asistencia, boolean leerProyecto, double calificacionFinal){
        if (asistencia<80){
            return  "REPROBADO por asistencia";
        }
        if (!leerProyecto){
            return "REPROBADO por no entregar proyecto ";
        }
        if (calificacionFinal>=70){
            return "APROVADO";
        }else {
            return "REPROBADO por calificacion";
        }
    }

}


