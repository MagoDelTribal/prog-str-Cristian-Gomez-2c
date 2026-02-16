public class Gestor{
    public Alumno[] alumnos = new Alumno[25];
    public int contador = 0;

    public void agregarPersona(int id, String name, double promedio) {
        if (contador < 25) {
            alumnos[contador] = new Alumno(id, name, promedio);
            System.out.println("sistema: " + name + " guardado.");
            contador++;
        }
    }

    public int buscarIndice(int id) {
        for (int i = 0; i < contador; i++) {
            if (alumnos[i].getId() == id && alumnos[i].isActivo()) {
                return i;
            }
        }
        return -1;
    }

    public void darBaja(int id) {
        int idd = buscarIndice(id);
        if (idd != -1) {
            alumnos[idd].setActivo(false);
            System.out.println("sistema: baja realizada.");
        } else {
            System.out.println("sistema: no encontrado.");
        }
    }

    public void mostrarActivas() {
        System.out.println("---ACTIVAS---");
        boolean hayPersonas = false;

        for (int i = 0; i < contador; i++) {
            if (alumnos[i].isActivo()) {
                System.out.println(alumnos[i].toString());
                hayPersonas = true;

            }
        }
        if (!hayPersonas) {
            System.out.println("no hay registros activos para mostrar.");
        }
    }

    public void actualizar(int id, String nuevoName) {
        int idd = buscarIndice(id);
        if (idd != -1) {
           alumnos[idd].setName(nuevoName);
            System.out.println("sistema: actualizado.");
        } else {
            System.out.println("sistema: no se puede actualizar.");
        }
    }

    public void generarReportes() {
        if (contador == 0) {
            System.out.println("No hay alumnos registrados.");
            return;
        }
        double sumaPromedios = 0;
        int activosTotales = 0;
        int alumnosExcelentes = 0;
        Alumno mejorAlumno = null;
        Alumno peorAlumno = null;
        for (int i = 0; i < contador; i++) {
            if (alumnos[i].isActivo()) {
                double pActual = alumnos[i].getPromedio();

                sumaPromedios += pActual;
                activosTotales++;

                if (pActual >= 8.0) {
                    alumnosExcelentes++;
                }

                if (mejorAlumno == null || pActual > mejorAlumno.getPromedio()) {
                    mejorAlumno = alumnos[i];
                }

                if (peorAlumno == null || pActual < peorAlumno.getPromedio()) {
                    peorAlumno = alumnos[i];
                }
            }
        }
        if (activosTotales > 0) {
            System.out.println("======REPORTE DE RENDIMIENTO======");
            System.out.println("promedio grupal: " + (sumaPromedios / activosTotales));
            System.out.println("alumnos con promedio >= 8.0: " + alumnosExcelentes);
            System.out.println("alumno con mayor promedio: " + mejorAlumno.getName() + " (" + mejorAlumno.getPromedio() + ")");
            System.out.println("alumno con menor promedio: " + peorAlumno.getName() + " (" + peorAlumno.getPromedio() + ")");
        } else {
            System.out.println("No hay alumnos activos para generar reportes.");
        }
    }
}