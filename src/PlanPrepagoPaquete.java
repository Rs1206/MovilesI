public class PlanPrepagoPaquete extends ServicioMovil {
    private int diasVigencia;
    private boolean aplicaPromocion;

    public PlanPrepagoPaquete(String codigoServicio, String nombreCliente, double costoBase, int diasVigencia, boolean aplicaPromocion) {
        super(codigoServicio, nombreCliente, costoBase);
        this.diasVigencia = diasVigencia;
        this.aplicaPromocion = aplicaPromocion;
    }

    public int getDiasVigencia() {
        return diasVigencia;
    }

    public boolean isAplicaPromocion() {
        return aplicaPromocion;
    }

    @Override
    public double calcularTotalPagar() {
        double subtotal = costoBase;
        if (aplicaPromocion) {
            subtotal = subtotal * 0.90;
        }
        return subtotal * 1.19;
    }

    @Override
    public void mostrarFactura() {
        super.mostrarFactura();
        System.out.println("Días de vigencia: " + diasVigencia);
        System.out.println("Descuento aplicado: " + (aplicaPromocion ? "Si (10%)" : "No"));
        System.out.println("IVA (19%): " + calcularTotalPagar() / 1.19 * 0.19);
        System.out.println("Total a pagar: " + calcularTotalPagar());
    }
}
