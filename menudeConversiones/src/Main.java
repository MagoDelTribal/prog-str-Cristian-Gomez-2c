import java.util.Scanner;
public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcion;
        int c1 = 0, c2 = 0, c3 = 0, c4 = 0;
        do {
            mostrarMenu();
            opcion = leerEntero(sc,"seleccione una opción: ");
            switch (opcion) {
                case 1:
                    double celsius = leerDouble(sc, "ingrese °C: ");
                    System.out.println("resultado: " + (celsius * 9 / 5 + 32) + " °F");
                    c1++;
                    break;
                case 2:
                    double fahr = leerDouble(sc, "ingrese °F: ");
                    System.out.println("resultado: " + ((fahr - 32) * 5 / 9) + " °C");
                    c2++;
                    break;
                case 3:
                    double km = leerDouble(sc, "ingreese Km: ");
                    System.out.println("resultado: " + (km * 0.621371) + " millas");
                    c3++;
                    break;
                case 4:
                    double millas = leerDouble(sc, "ingrese millas: ");
                    System.out.println("resultado: " + (millas / 0.621371) + " Km");
                    c4++;
                    break;
                case 5:
                    imprimirResumen(c1, c2, c3, c4);
                    break;
                default:
                    System.out.println("opcion invalida");
            }
        } while (opcion != 5);
    }
    public static void  mostrarMenu() {
        System.out.println("----MENU DE CONVERSIONES----");
        System.out.println("1) °C a °F");
        System.out.println("2) °F a °C");
        System.out.println("3) Km a millas");
        System.out.println("4) millas a Km");
        System.out.println("5) salir");
    }
  public static int leerEntero(Scanner sc, String mensaje) {
        while (true) {
            try {
                System.out.print(mensaje);
                return Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("error: debe ingresar un enumero entero");
            }
        }
    }
    public static double leerDouble(Scanner sc, String mensaje) {
        while(true) {
            try {
                System.out.print(mensaje);
                return Double.parseDouble(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("error: ungrese un valor numrico valido");
            }
        }
    }
    public static void imprimirResumen(int c1, int c2, int c3, int c4) {
        int total =c1+c2+c3+c4;
        System.out.println("===============================");
        System.out.println("°C a °F: "+c1);
        System.out.println("°F a °C: "+c2);
        System.out.println("Km a Millas: "+c3);
        System.out.println("Millas a Km: "+c4);
        System.out.println("TOTAL DE CONVERSIONES: " + total);
        System.out.println("hasta la vista beiby");
    }
}