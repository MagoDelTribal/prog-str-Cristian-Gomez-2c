import java.util.Scanner;
public class ActividadIfElseTarifa {
    public static void main(String[] args) {
        Scanner es = new Scanner(System.in);
        int tarifa = 0;
        int edad = obtenerEdad(es, "Ingreses su edad: ");
        if (edad <= 0 || edad >= 120) {
            System.out.println("Edad no valida");
            System.exit(1);
        }
        if (edad < 12) {
            tarifa = 50;
        }
        boolean estudiante = esEstudiante(es);
        if (edad > 12 && edad < 17) {
            if (estudiante) {
                tarifa = 60;
            } else {
                tarifa = 80;
            }
        } else if (edad >= 18) {
            if (estudiante) {
                tarifa = 90;
            } else {
                tarifa = 120;
            }
        }

            System.out.println("\n--- TARIFA---");
            System.out.println("Estudiante: "+estudiante);
            System.out.println("Total: $" + tarifa);
    }

    public static int obtenerEdad(Scanner es, String mensaje) {
        System.out.println(mensaje);
        return es.nextInt();
    }
    public static boolean esEstudiante(Scanner es) {
        while (true) {
            System.out.print("¿Es estudiante? (si/no): ");
            String respuesta = es.next().toLowerCase();

            if (respuesta.equals("si")) return true;
            if (respuesta.equals("no")) return false;
            System.out.println("Error: Por favor ingresa  Sí o No.");
        }
    }
}