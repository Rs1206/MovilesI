public class EmpleadoPorHoras extends EmpleadoNomina{
    private int horasTrabajadas;
    private double valorPorHora;

    public EmpleadoPorHoras(String documento, String nombreCompleto, String eps, int horasTrabajadas, double valorPorHora){
        super(documento, nombreCompleto, eps);
        this.horasTrabajadas = Math.max(0, horasTrabajadas);
        this.valorPorHora = Math.max(0, valorPorHora);
    }

    @Override
    public double calcularDeduccionesSeguridad(){
        double subtotal = this.horasTrabajadas * this.valorPorHora;
        if (subtotal > 1700000.0){
            return subtotal * 0.10;
        }
        return 0.0;
    }

    @Override
    public double calcularSalarioNeto(){
        double subtotal = this.horasTrabajadas + this.valorPorHora;
        return subtotal - calcularDeduccionesSeguridad();
    }

    @Override
    public void mostrarDetalleLiquidacion() {
        imprimirColillaEncabezado();
        double subtotal = this.horasTrabajadas * this.valorPorHora;
        System.out.println("Modalidad : PRESTACION DE SERVICIOS (POR HORAS)");
        System.out.println("Horas reportadas    : " + horasTrabajadas + "hrs");
        System.out.println("Valos por Hora      : $" + valorPorHora);
        System.out.println("Subtotal Honorarios : $" + subtotal);
        System.out.println("Retencio/Deduccion  : $" + calcularDeduccionesSeguridad());
        System.out.println("TOTAL NETO A PAGAR  : $" + String.format("%.2f", calcularSalarioNeto()));
        System.out.println("==========================================");
    }
}