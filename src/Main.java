public class Main {
    public static void main(String[] args) {
        ServicioTelecomunicaciones[] servicios = {
            new PlanInternetFibra("AB-001", "Calle 10 # 20-30", 2, 300, 500.0),
            new PlanPospagoMovil("AB-002", "Carrera 15 # 8-40", 4, "3001234567", 80000.0)
        };

        double totalFacturado = 0.0;
        for (ServicioTelecomunicaciones servicio : servicios) {
            System.out.println("\n========== FACTURA ==========");
            servicio.imprimirFactura();
            totalFacturado += servicio.calcularTarifaFinal();
        }

        System.out.println("\nTotal facturado: $" + String.format("%.2f", totalFacturado));
    }
}
