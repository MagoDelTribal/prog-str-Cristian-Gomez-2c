import java.util.Scanner;
public class Main {
    static Gestion repo = new Gestion();
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        int opcion = -1;

        while (opcion != 0) {
            System.out.println("\n1) alta | 2) buscar | 3) baja | 4) listar | 5) actualizar | 0) salir");
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
                case 0 -> System.out.println("saliendo del sistema...");
                default -> System.out.println("opcion invalida, intente de nuevo.");
            }
        }
    }

    static void ejecutarAlta() {
        System.out.print("ingrese id: ");
        int id = sc.nextInt();
        sc.nextLine();

        if (!validator.idEsValido(id)) {
            System.out.println("error: el id debe ser mayor a 0.");
            return;
        }
        if (validator.idEstaRepetido(id, repo.personas, repo.contador)) {
            System.out.println("error: el id ya existe.");
            return;
        }

        System.out.print("ingrese nombre: ");
        String nombre = sc.nextLine();
        if (!validator.nombreEsValido(nombre)) {
            System.out.println("error: el nombre no puede estar vacio.");
            return;
        }

        repo.agregarPersona(id, nombre);
    }

    static void ejecutarBuscar() {
        System.out.print("id a buscar: ");
        int id = sc.nextInt();
        int indice = repo.buscarIndice(id);
        if (indice != -1) {
            System.out.println("encontrado: " + repo.personas[indice].name);
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

        if (validator.nombreEsValido(nuevoNombre)) {
            repo.actualizar(id, nuevoNombre);
        } else {
            System.out.println("error: nombre no valido.");
        }
    }
}