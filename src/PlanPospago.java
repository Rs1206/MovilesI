public class PlanPospago extends ServicioMovil {
    private int gigasIncluidas;
    private int gigasConsumidas;
    private double cargoGigaAdicional;

    public PlanPospago(String codigoServicio, String nombreCliente, double costoBase, int gigasIncluidas, int gigasConsumidas, double cargoGigaAdicional) {
        super(codigoServicio, nombreCliente, costoBase);
        this.gigasIncluidas = gigasIncluidas;
        this.gigasConsumidas = gigasConsumidas;
        this.cargoGigaAdicional = cargoGigaAdicional;
    }

    public int getGigasIncluidas() {
        return gigasIncluidas;
    }

    public int getGigasConsumidas() {
        return gigasConsumidas;
    }

    public double getCargoGigaAdicional() {
        return cargoGigaAdicional;
    }

    @Override
    public double calcularTotalPagar() {
        int gigasAdicionales = 0;
        if (gigasConsumidas > gigasIncluidas) {
            gigasAdicionales = gigasConsumidas - gigasIncluidas;
        }
        double subtotal = costoBase + gigasAdicionales * cargoGigaAdicional;
        return subtotal * 1.19;
    }

    @Override
    public void mostrarFactura() {
        super.mostrarFactura();
        int gigasAdicionales = 0;
        if (gigasConsumidas > gigasIncluidas) {
            gigasAdicionales = gigasConsumidas - gigasIncluidas;
        }
        double cobroAdicional = gigasAdicionales * cargoGigaAdicional;
        double subtotal = costoBase + cobroAdicional;
        System.out.println("Gigas incluidas: " + gigasIncluidas);
        System.out.println("Gigas consumidas: " + gigasConsumidas);
        System.out.println("Gigas adicionales: " + gigasAdicionales);
        System.out.println("Cargo por giga adicional: " + cargoGigaAdicional);
        System.out.println("Cobro por consumo adicional: " + cobroAdicional);
        System.out.println("Subtotal: " + subtotal);
        System.out.println("IVA (19%): " + subtotal * 0.19);
        System.out.println("Total a pagar: " + calcularTotalPagar());
    }
}
