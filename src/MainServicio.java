import java.util.Scanner;

public class MainServicio {
    public static Scanner entrada = new Scanner(System.in);
    public static double dineroFacturado = 0;
    public static int serviciosRegistrados = 0;

    public static void main(String[] args) {
        mostrarMenu();
        entrada.close();
    }

    public static void mostrarMenu() {
        System.out.println("\n--- MENÚ DE SERVICIOS ---");
        System.out.println("1. Registrar y liquidar Plan Pospago");
        System.out.println("2. Registrar y liquidar Plan Prepago");
        System.out.println("3. Salir");
        System.out.print("Seleccione una opción: ");
        int opcion = entrada.nextInt();
        entrada.nextLine();

        switch (opcion) {
            case 1:
            {
                System.out.println("\nRegistro de Plan Pospago");
                System.out.print("Código del servicio: ");
                String codigo = entrada.nextLine();
                System.out.print("Nombre del cliente: ");
                String cliente = entrada.nextLine();
                System.out.print("Costo base: ");
                double costoBase = entrada.nextDouble();
                System.out.print("Gigas incluidas: ");
                int gigasIncluidas = entrada.nextInt();
                System.out.print("Gigas consumidas: ");
                int gigasConsumidas = entrada.nextInt();
                System.out.print("Cargo por giga adicional: ");
                double cargoGiga = entrada.nextDouble();
                entrada.nextLine();

                PlanPospago plan = new PlanPospago(codigo, cliente, costoBase,
                        gigasIncluidas, gigasConsumidas, cargoGiga);
                plan.mostrarFactura();
                dineroFacturado += plan.calcularTotalPagar();
                serviciosRegistrados++;
                mostrarMenu();
                break;
            }
            case 2:
            {
                System.out.println("\nRegistro de Plan Prepago");
                System.out.print("Código del servicio: ");
                String codigo = entrada.nextLine();
                System.out.print("Nombre del cliente: ");
                String cliente = entrada.nextLine();
                System.out.print("Costo base: ");
                double costoBase = entrada.nextDouble();
                System.out.print("Días de vigencia: ");
                int diasVigencia = entrada.nextInt();
                System.out.print("¿Aplica promoción del 10%? (true/false): ");
                boolean aplicaPromocion = entrada.nextBoolean();
                entrada.nextLine();

                PlanPrepagoPaquete plan = new PlanPrepagoPaquete(codigo, cliente,
                        costoBase, diasVigencia, aplicaPromocion);
                plan.mostrarFactura();
                dineroFacturado += plan.calcularTotalPagar();
                serviciosRegistrados++;
                mostrarMenu();
                break;
            }
            case 3:
                System.out.println("\nTotal de servicios registrados: " + serviciosRegistrados);
                System.out.println("Dinero total facturado: " + dineroFacturado);
                System.out.println("Saliendo del sistema.");
                break;
            default:
                System.out.println("Opción inválida. Intente de nuevo.");
        }
    }
}
