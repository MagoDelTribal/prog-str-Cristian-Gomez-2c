public class Resumen {
    public void inprimirResumen(String nombre, String materia, double c1, double c2, double c3, double promedio, int asistencia, boolean proyecto, double calificacionFinal, String estado ){
        System.out.println("========Reporte final========");
        System.out.println("materia: "+materia);
        System.out.println("nombres: "+nombre);
        System.out.println("nota por parciales: parcial 1:"+c1+ " \nparcial 2: "+c2+" \nparcial 3:"+c3);
        System.out.println("asistencia: "+asistencia);
        System.out.println("promedio de parciales: "+promedio);
        System.out.println("entrego proyecto: "+ (proyecto?"SI":"NO"));
        System.out.println("===================================");
        System.out.println("calificaciion final: "+calificacionFinal);
        System.out.println("estado:"+estado);
        System.out.println("==================================================");
    }
}
