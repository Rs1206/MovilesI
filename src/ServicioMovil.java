public class ServicioMovil {
    protected String codigoServicio;
    protected String nombreCliente;
    protected double costoBase;

    public ServicioMovil(String codigoServicio, String nombreCliente, double costoBase) {
        this.codigoServicio = codigoServicio;
        this.nombreCliente = nombreCliente;
        setCostoBase(costoBase);
    }
    public String getCodigoServicio() {
        return codigoServicio;
    }
    public void setCodigoServicio(String codigoServicio) {
        if (codigoServicio != null && !codigoServicio.isEmpty()) {
            this.codigoServicio = codigoServicio;
        }
    }
    public String getNombreCliente() {
        return nombreCliente;
    }
    public void setNombreCliente(String nombreCliente) {
        if (nombreCliente != null && !nombreCliente.isEmpty()) {
            this.nombreCliente = nombreCliente;
        }
    }
    public double getCostoBase() {
        return costoBase;
    }
    public void setCostoBase(double costoBase) {
        if (costoBase >= 15000) {
            this.costoBase = costoBase;
        }
    }
    public double calcularTotalPagar() {
        return costoBase * 1.19;
    }
    public void mostrarFactura() {
        System.out.println("Código del servicio: " + codigoServicio);
        System.out.println("Nombre del cliente: " + nombreCliente);
        System.out.println("Costo base: " + costoBase);
    }
}
