import java.util.Scanner;

public class validator {
    public double leerPeso(Scanner sc) {
        double peso;
        do {
            System.out.print("ingreze el peso en kg (0.1 a 50.0): ");
            while (!sc.hasNextDouble()) { sc.next(); }
            peso = sc.nextDouble();
        } while (peso < 0.1 || peso > 50.0);
        return peso;
    }

    public int leerDistancia(Scanner sc) {
        int distancia;
        do {
            System.out.print("ingresa la distancia (1 a 2000): ");
            while (!sc.hasNextInt()) { sc.next(); }
            distancia = sc.nextInt();
        } while (distancia < 1 || distancia > 2000);
        return distancia;
    }

    public int leerTipoServicio(Scanner sc) {
        int tipo;
        do {
            System.out.print("selecciona servicio  1: estandar, 2: expres: ");
            while (!sc.hasNextInt()) { sc.next(); }
            tipo = sc.nextInt();
        } while (tipo < 1 || tipo > 2);
        return tipo;
    }

    public boolean leerEsZonaRemota(Scanner sc) {
        while (true) {
            System.out.print("la entrega es en zona remota ? (si/no): ");
            String texto = sc.next().toLowerCase();
            if (texto.equals("si")) return true;
            if (texto.equals("no")) return false;
            System.out.println("error intentalo de nuevo ");
        }
    }
}