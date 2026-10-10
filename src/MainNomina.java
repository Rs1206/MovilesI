public class MainNomina {
    public static void main(String[] args){
        //EmpleadoNomina test = new EmpleadoNomina("001", "Alguien", "Sura");

        EmpleadoFijo emp1 = new EmpleadoFijo("1234567890", "Juan Zamora", "Salud Total", 2500000.0, true);
        EmpleadoFijo emp2 = new EmpleadoFijo("1000555888", "Jeison Smith", "Sura", 2000000.0, true);
        EmpleadoFijo emp3 = new EmpleadoFijo("1233400900", "Juan Villa", "SaludCoop", 2300000.0, true);

        EmpleadoNomina[] nominaEmpresa = {emp1, emp2, emp3};

        double totalNominaDesembolsar = 0.0;

        System.out.println("PROCESANDO LIQUIDACION DE NOMINA GENERAL... \n");
        for (EmpleadoNomina empleado : nominaEmpresa){
            empleado.mostrarDetalleLiquidacion();
            totalNominaDesembolsar += empleado.calcularSalarioNeto();
        }
        System.out.println("=====================");
        System.out.println("GRAN TOTAL DESEMBOLSO NOMINA: $" + String.format("%.2f", totalNominaDesembolsar));
        System.out.println("=======================");
    }
}