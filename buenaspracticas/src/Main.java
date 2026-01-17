

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //presentamos programa
        System.out.println("programa que te suma numeros hasta el numero que ingresaste ");

        int numlimite = solicitarEntero(sc, "Same tu cantidad limite de sumade ");
        int sumaacumulada = calcularSuma(numlimite);

     //muestreo de los resultados
        System.out.println("la suma del 1 hasta tu numero:  " + numlimite + " es: " + sumaacumulada);

    }
    /**
     * metodo para pedir el numero limite
     */
    public static int solicitarEntero(Scanner sc, String mensaje) {
        System.out.println(mensaje);
        return sc.nextInt();
    }
    /**
     * metodo para calcular la suma de los numeros
     */
    public static int calcularSuma(int numlimite) {
        int suma = 0;
        for (int i = 1; i <= numlimite; i++) {
            suma += i;
        }
        return suma;
    }
}