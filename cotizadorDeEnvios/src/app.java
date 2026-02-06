import java.util.Scanner;

public class app {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);


        validator lector = new validator();
        ShippingCalculator calculadora = new ShippingCalculator();
        ticket impresora = new ticket();


        double pesoIngresado = lector.leerPeso(sc);
        int distanciaIngresada = lector.leerDistancia(sc);
        int tipoServicio = lector.leerTipoServicio(sc);
        boolean esZonaRemota = lector.leerEsZonaRemota(sc);

        double subtotal = calculadora.calcularSubtotal(pesoIngresado, distanciaIngresada, tipoServicio, esZonaRemota);
        double montoIva = calculadora.calcularIva(subtotal);
        double totalFinal = calculadora.calcularTotal(subtotal, montoIva);


        impresora.imprimirTicket(tipoServicio, pesoIngresado, distanciaIngresada, esZonaRemota, subtotal, montoIva, totalFinal);

        sc.close();
    }
}