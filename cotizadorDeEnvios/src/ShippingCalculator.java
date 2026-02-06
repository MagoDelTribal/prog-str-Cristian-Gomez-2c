public class ShippingCalculator {
    public double calcularSubtotal(double pesoKg, int distanciaKm, int tipoServicio, boolean esZonaRemota) {
        double costoBase = (tipoServicio == 1) ? 50.0 : 90.0;
        double costoPeso = pesoKg * 12.0;
        double costoDistancia;

        if (distanciaKm <= 50) {
            costoDistancia = 20.0;
        } else if (distanciaKm <= 200) {
            costoDistancia = 60.0;
        } else {
            costoDistancia = 120.0;
        }

        double subtotal = costoBase + costoPeso + costoDistancia;

        if (esZonaRemota) {
            subtotal *= 1.10;
        }
        return subtotal;
    }

    public double calcularIva(double subtotal) {
        return subtotal * 0.16;
    }
    public double calcularTotal(double subtotal, double iva) {
        return subtotal + iva;
    }
}