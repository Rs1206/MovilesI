public class PlanPospagoMovil extends ServicioTelecomunicaciones {
    private String numeroLinea;
    private double cargoFijo;
    public PlanPospagoMovil(String codigoAbonado, String direccionInstalacion, int estrato, String numeroLinea, double cargoFijo) {
        super(codigoAbonado, direccionInstalacion, estrato);
        this.numeroLinea = numeroLinea;
        this.cargoFijo = cargoFijo;
    }
    @Override
    public double calcularTarifaFinal() {
        return cargoFijo * 1.19;
    }
    public void imprimirFactura() {
        imprimirDatosSuscripcion();
        System.out.println("Servicio: Plan móvil pospago");
        System.out.println("Número de línea: " + numeroLinea);
        System.out.println("Cargo fijo: $" + String.format("%.2f", cargoFijo));
        System.out.println("Tarifa final (IVA incluido): $" + String.format("%.2f", calcularTarifaFinal()));
    }
}
