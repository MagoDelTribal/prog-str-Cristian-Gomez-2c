import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double IVA = 0.16;
        double subtotal = pedirDouble(scanner, "Subtotal: ");
        double total=calcularTotal(subtotal, IVA);
        System.out.println("Total a pagar: %.2f%n"+total);
    }

    public static double pedirDouble(Scanner scanner, String mensaje) {
        System.out.print(mensaje);
        return scanner.nextDouble();
    }

    /**
     *
     * @param subtotal
     * @param IVA
     * @return
     */
    public  static double calcularTotal(double subtotal, double IVA){
        return subtotal+(subtotal*IVA);
    }
}