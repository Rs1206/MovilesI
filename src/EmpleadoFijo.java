public class EmpleadoFijo extends EmpleadoNomina{
    private double salarioMensual;
    private boolean reciboAuxilioTransporte;
    public EmpleadoFijo(String documento, String nombreCompleto, String eps, double salarioMensual, boolean reciboAuxilioTransporte) {
        super(documento, nombreCompleto, eps);
        this.salarioMensual = salarioMensual;
        this.reciboAuxilioTransporte = reciboAuxilioTransporte;
    }
    @Override
    public double calcularDeduccionesSeguridad() {
        return this.salarioMensual * 0.08;
    }
    @Override
    public double calcularSalarioNeto() {
        double auxilio = reciboAuxilioTransporte ? 230000.0 : 0.0;
        return (this.salarioMensual + auxilio) - calcularDeduccionesSeguridad();
    }
    @Override
    public void mostrarDetalleLiquidacion(){
        imprimirColillaEncabezado();
        System.out.println("Modalidad: CONTRATO TERMINO INDEFINIDO/FIJO ");
        System.out.println("Salario Base: " + this.salarioMensual);
        System.out.println("Auxilio Transporte : $" + (reciboAuxilioTransporte ? 230000.0 : 0.0));
        System.out.println("Deducciones (8%) : -$" + calcularDeduccionesSeguridad());
        System.out.println("TOTAL NETO A PAGAR: $" + String.format("%.2f", calcularSalarioNeto()));
        System.out.println("-------------------------");
    }
}
