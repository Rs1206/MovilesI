import java.util.Scanner;

public class MainServicio {
    public static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        mostrarMenu();
    }
    public static double dineroFacturado = 0;
    public static int serviciosRegistrados = 0;

    public static void mostrarMenu() {
        int opcion = 0;
        do {
            System.out.println("\n=== Gestion de planes ===");
            System.out.println("1. Crear factura de plan pospago");
            System.out.println("2. Crear factura de plan prepago");
            System.out.println("3. Cerrar el sistema");
            System.out.print("Indique la opcion: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                {
                    System.out.println("\nFactura de la linea pospago");
                    System.out.print("Referencia: ");
                    String codigo = scanner.nextLine();
                    System.out.print("Titular de la línea: ");
                    String cliente = scanner.nextLine();
                    System.out.print("Valor mensual base: ");
                    double costoBase = scanner.nextDouble();
                    System.out.print("GB Incluidos: ");
                    int gigasIncluidas = scanner.nextInt();
                    System.out.print("GB Utilizados: ");
                    int gigasConsumidas = scanner.nextInt();
                    System.out.print("Tarifa por GB adicional: ");
                    double cargoGiga = scanner.nextDouble();
                    scanner.nextLine();

                    PlanPospago plan = new PlanPospago(codigo, cliente, costoBase, gigasIncluidas, gigasConsumidas, cargoGiga);
                    plan.mostrarFactura();
                    dineroFacturado += plan.calcularTotalAPagar();
                    serviciosRegistrados++;
                    break;
                }
                case 2:
                {
                    System.out.println("\nFactura del paquete prepago");
                    System.out.print("Referencia: ");
                    String codigo = scanner.nextLine();
                    System.out.print("Titular de la línea: ");
                    String cliente = scanner.nextLine();
                    System.out.print("Valor del paquete: ");
                    double costoBase = scanner.nextDouble();
                    System.out.print("Duración del paquete en días: ");
                    int diasVigencia = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("¿Activar descuento promocional del 10%? (true/false): ");
                    boolean aplicaPromocion = scanner.nextBoolean();
                    scanner.nextLine();

                    PlanPrepagoPaquete plan = new PlanPrepagoPaquete(codigo, cliente, costoBase, diasVigencia, aplicaPromocion);
                    plan.mostrarFactura();
                    dineroFacturado += plan.calcularTotalAPagar();
                    serviciosRegistrados++;
                    break;
                }
                case 3:
                    System.out.println("\nServicios procesados: " + serviciosRegistrados);
                    System.out.println("Facturación acumulada: " + dineroFacturado);
                    System.out.println("La sesión ha finalizado.");
                    break;
                default:
                    System.out.println("Opcion no valida");
            }
        } while (opcion != 3);
    }
}