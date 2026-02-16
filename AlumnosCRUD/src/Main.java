import java.util.Scanner;

public class Main {
    static Gestor repo = new Gestor();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int opcion = -1;

        while (opcion != 0) {
            System.out.println("\n1) alta | \n2) buscar | \n3) baja | \n4) listar | \n5) actualizar | \n6) generar reporte | \n0) salir");
            System.out.print("seleccione una opcion: ");

            if (!sc.hasNextInt()) {
                System.out.println("error: debe ingresar un numero.");
                sc.next();
                continue;
            }
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1 -> ejecutarAlta();
                case 2 -> ejecutarBuscar();
                case 3 -> ejecutarBaja();
                case 4 -> repo.mostrarActivas();
                case 5 -> ejecutarActualizar();
                case 6 -> gene();
                case 0 -> System.out.println("saliendo del sistema...");
                default -> System.out.println("opcion invalida, intente de nuevo.");
            }
        }
    }

    static void ejecutarAlta() {
        System.out.print("ingrese id: ");
        int id = sc.nextInt();
        sc.nextLine();

        if (!Validator.idEsValido(id)) {
            System.out.println("error: el id debe ser mayor a 0.");
            return;
        }
        if (Validator.idEstaRepetido(id, repo.alumnos, repo.contador)) {
            System.out.println("error: el id ya existe.");
            return;
        }

        System.out.print("ingrese nombre: ");
        String nombre = sc.nextLine();
        if (!Validator.nombreEsValido(nombre)) {
            System.out.println("error: el nombre no puede estar vacio.");
            return;
        }

        System.out.print("ingrese promedio (0.0 a 10.0): ");
        double promedio = sc.nextDouble();
        sc.nextLine();

        if (promedio < 0 || promedio > 10) {
            System.out.println("error: el promedio debe estar entre 0 y 10.");
            return;
        }

        repo.agregarPersona(id, nombre, promedio);
    }


    static void ejecutarBuscar() {
        System.out.print("id a buscar: ");
        int id = sc.nextInt();
        int indice = repo.buscarIndice(id);
        if (indice != -1) {
            System.out.println("encontrado: " + repo.alumnos[indice].getName());
        } else {
            System.out.println("no encontrada o inactiva.");
        }
    }

    static void ejecutarBaja() {
        System.out.print("id para baja logica: ");
        int id = sc.nextInt();
        repo.darBaja(id);
    }

    static void ejecutarActualizar() {
        System.out.print("id para actualizar: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("nuevo nombre: ");
        String nuevoNombre = sc.nextLine();

        if (Validator.nombreEsValido(nuevoNombre)) {
            repo.actualizar(id, nuevoNombre);
        } else {
            System.out.println("error: nombre no valido.");
        }
    }

    static void gene() {
        repo.generarReportes();
    }
}