public class PlanPospago extends ServicioMovil {
    private int gigasIncluidas;
    private int gigasConsumidas;
    private double cargoGigaAdicional;
    public PlanPospago(String codigoServicio, String nombreCliente, double costoBase, int gigasIncluidas, int gigasConsumidas, double cargoGigaAdicional) {
        super(codigoServicio, nombreCliente, costoBase);
        setGigasIncluidas(gigasIncluidas);
        setGigasConsumidas(gigasConsumidas);
        setCargoGigaAdicional(cargoGigaAdicional);
    }
    public int getGigasIncluidas() {
        return gigasIncluidas;
    }
    public void setGigasIncluidas(int gigasIncluidas) {
        if (gigasIncluidas >= 0)
        this.gigasIncluidas = gigasIncluidas;
    }
    public int getGigasConsumidas() {
        return gigasConsumidas;
    }
    public void setGigasConsumidas(int gigasConsumidas) {
        if (gigasConsumidas >= 0)
        this.gigasConsumidas = gigasConsumidas;
    }
    public double getCargoGigaAdicional() {
        return cargoGigaAdicional;
    }
    public void setCargoGigaAdicional(double cargoGigaAdicional) {
        if (cargoGigaAdicional >= 0)
        this.cargoGigaAdicional = cargoGigaAdicional;
    }
    @Override
    public double calcularTotalAPagar() {
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
        System.out.println("Datos incluidos en el plan: " + gigasIncluidas + " GB");
        System.out.println("Datos utilizados: " + gigasConsumidas + " GB");
        System.out.println("GB adicionales: " + gigasAdicionales);
        System.out.println("Tarifa por GB adicional: " + cargoGigaAdicional);
        System.out.println("Cobro por GB adicionales: " + cobroAdicional);
        System.out.println("Base sujeto a impuestos : " + subtotal);
        System.out.println("Impuesto IVA 19%: " + subtotal * 0.19);
        System.out.println("Importe final: " + calcularTotalAPagar());
    }
}
