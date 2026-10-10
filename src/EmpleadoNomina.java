//Clases Abstractas y Métodos Abstractos.
//No se puede instanciar con 'new'.
public abstract class EmpleadoNomina {
    protected String documento;
    protected String nombreCompleto;
    protected String eps;

    public EmpleadoNomina(String documento, String nombreCompleto, String eps){
        this.documento = documento;
        this.nombreCompleto = nombreCompleto;
        this.eps = eps;
    }

    public String getNombreCompleto(){
        return nombreCompleto;
    }

    public void imprimirColillaEncabezado(){
        System.out.println("==========================================");
        System.out.println("       COLILLA DE PAGO - CESDE            ");
        System.out.println("==========================================");
        System.out.println("Documento: " + documento);
        System.out.println("Empleado: " + nombreCompleto);
        System.out.println("EPS: " + eps);
    }
    public abstract double calcularSalarioNeto();
    public abstract double calcularDeduccionesSeguridad();
    public abstract void mostrarDetalleLiquidacion();
}