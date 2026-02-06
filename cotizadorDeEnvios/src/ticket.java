public class ticket{
    public void imprimirTicket(int tipoServicio, double pesoKg, int distanciaKm, boolean esZonaRemota, double subtotal, double iva, double total) {
        String servicioTexto = (tipoServicio == 1) ? "estansar" : "expres ";
        String remotaTexto = esZonaRemota ? "si" : "no";

        System.out.println("\n--- generando tu tiket ---");
        System.out.println("servicio: " + servicioTexto);
        System.out.println("peos: " + pesoKg + " kg");
        System.out.println("distancia : " + distanciaKm + " km");
        System.out.println("remota : " + remotaTexto);
        System.out.println("--------------------------");
        System.out.printf("subtotal: $%.2f\n", subtotal);
        System.out.printf("iva: $%.2f\n", iva);
        System.out.printf("total final: $%.2f\n", total);
        System.out.println("hasta la vista chichabeba");
    }
}