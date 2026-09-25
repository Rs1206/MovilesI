public class ServicioMovil {
    protected String codigoServicio;
    protected String nombreCliente;
    protected double costoBase;

    public ServicioMovil(String codigoServicio, String nombreCliente, double costoBase) {
        setCodigoServicio(codigoServicio);
        setNombreCliente(nombreCliente);
        setCostoBase(costoBase);
    }
    public String getCodigoServicio() {
        return codigoServicio;
    }
    public void setCodigoServicio(String codigoServicio) {
        if (codigoServicio != null && !codigoServicio.trim().isEmpty())
        this.codigoServicio = codigoServicio.trim();
    }
    public String getNombreCliente() {
        return nombreCliente;
    }
    public void setNombreCliente(String nombreCliente) {
        if (nombreCliente != null && !nombreCliente.trim().isEmpty())
        this.nombreCliente = nombreCliente.trim();
    }
    public double getCostoBase() {
        return costoBase;
    }
    public void setCostoBase(double costoBase) {
        if (costoBase >= 15000)
        this.costoBase = costoBase;
    }
    public double calcularTotalAPagar() {
        return costoBase * 1.19;
    }
    public void mostrarFactura() {
        System.out.println("Referencia: " + codigoServicio);
        System.out.println("Titular de la línea: " + nombreCliente);
        System.out.println("Valor base (COP): " + costoBase);
    }
}
