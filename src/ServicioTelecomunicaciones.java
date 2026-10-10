public abstract class ServicioTelecomunicaciones {
    protected String codigoAbonado;
    protected String direccionInstalacion;
    protected int estrato;

    public ServicioTelecomunicaciones(String codigoAbonado, String direccionInstalacion, int estrato) {
        this.codigoAbonado = codigoAbonado;
        this.direccionInstalacion = direccionInstalacion;
        this.estrato = estrato;
    }
    public void imprimirDatosSuscripcion() {
        System.out.println("Código de abonado: " + codigoAbonado);
        System.out.println("Dirección de instalación: " + direccionInstalacion);
        System.out.println("Estrato: " + estrato);
    }

    public void imprimirFactura() {
        imprimirDatosSuscripcion();
        System.out.println("Tarifa final: $" + String.format("%.2f", calcularTarifaFinal()));
    }

    public abstract double calcularTarifaFinal();
}
