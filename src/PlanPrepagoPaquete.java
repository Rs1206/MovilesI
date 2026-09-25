public class PlanPrepagoPaquete extends ServicioMovil {
    private int diasVigencia;
    private boolean aplicaPromocion;
    public PlanPrepagoPaquete(String codigoServicio, String nombreCliente, double costoBase, int diasVigencia, boolean aplicaPromocion) {
        super(codigoServicio, nombreCliente, costoBase);
        setDiasVigencia(diasVigencia);
        setAplicaPromocion(aplicaPromocion);
    }
    public int getDiasVigencia() {
        return diasVigencia;
    }
    public void setDiasVigencia(int diasVigencia) {
        if (diasVigencia <= 0)
        this.diasVigencia = diasVigencia;
    }
    public boolean isAplicaPromocion() {
        return aplicaPromocion;
    }
    public void setAplicaPromocion(boolean aplicaPromocion) {
        this.aplicaPromocion = aplicaPromocion;
    }
    @Override
    public double calcularTotalAPagar() {
        double subtotal = costoBase;
        if (aplicaPromocion) {
            subtotal = subtotal * 0.90;
        }
        return subtotal * 1.19;
    }
    @Override
    public void mostrarFactura() {
        super.mostrarFactura();
        System.out.println("Paquete activo por: " + diasVigencia + " días");
        System.out.println("Descuento por promocion: " + (aplicaPromocion ? "Descuento del 10% aplicado" : "Sin descuento"));
        double subtotal = costoBase * (aplicaPromocion ? 0.90 : 1.0);
        System.out.println("Impuesto IVA 19%: " + subtotal * 0.19);
        System.out.println("Importe final: " + calcularTotalAPagar());
    }
}
