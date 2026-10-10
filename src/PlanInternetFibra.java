public class PlanInternetFibra extends ServicioTelecomunicaciones {
    private int megasVelocidad;
    private double costoPorMega;
    public PlanInternetFibra(String codigoAbonado, String direccionInstalacion, int estrato, int megasVelocidad, double costoPorMega) {
        super(codigoAbonado, direccionInstalacion, estrato);
        this.megasVelocidad = megasVelocidad;
        this.costoPorMega = costoPorMega;
    }
    @Override
    public double calcularTarifaFinal() {
        double tarifa = megasVelocidad * costoPorMega;
        if (estrato == 1 || estrato == 2) {
            tarifa *= 0.85;
        } else if (estrato == 5 || estrato == 6) {
            tarifa *= 1.20;
        }
        return tarifa;
    }
    public void imprimirFactura() {
        imprimirDatosSuscripcion();
        System.out.println("Servicio: Internet por fibra");
        System.out.println("Velocidad: " + megasVelocidad + " Mbps");
        System.out.println("Costo por mega: $" + String.format("%.2f", costoPorMega));
        System.out.println("Tarifa final: $" + String.format("%.2f", calcularTarifaFinal()));
    }
}
