import java.util.Scanner;
public class LecctorNotas {

    public String llerMateria(Scanner sc) {
        String materia;
        do {
            System.out.print("ingrese  la materia : ");
            materia = sc.nextLine();
        } while (materia.trim().isEmpty());
        return materia;
    }

    public String llerNombre(Scanner sc) {
        String nombre;
        do {
            System.out.print("ingrese su nombre : ");
            nombre = sc.nextLine();
        } while (nombre.trim().isEmpty());
        return nombre;
    }

    public double leerCalificacion(Scanner sc, String materia) {
        double calificacion;
        do {
            System.out.print("pon la nota de " + materia + " (0 a 100): ");
            while (!sc.hasNextDouble()) {
                System.out.print("error solo ingresa numeros: ");
                sc.next();
            }
            calificacion = sc.nextDouble();
        } while (calificacion < 0 || calificacion > 100);
        return calificacion;
    }
    public int leerAsistencia(Scanner sc){
        int asistencia;
        do {
            System.out.println("ingresa cuantas asistencias tienes: ");
            while (!sc.hasNextBigInteger()){
                System.out.println("ingresa solo numero enteros: ");
                sc.next();
            }
            asistencia=sc.nextInt();
        }while(asistencia<0 || asistencia>100);
        return asistencia;
    }
    public boolean leerProyecto(Scanner sc){
        while (true){
            System.out.println("entregaste proyecto? (Si/No)");
            String respuesta= sc.next().toLowerCase();
            if (respuesta.equals("si"))return true;
            if (respuesta.equals("no"))return false;
            System.out.println("solo escribe SI o NO");
        }
    }

}