package barranquillo;

import java.util.List;
import java.util.Scanner;

public class Pantalla {
    Controlador controlador;

    public Pantalla(Controlador ctrl) {
        this.controlador = ctrl;
    }

    public void mostrarInterfaz() {

        try (Scanner scanner = new Scanner(System.in)) {
            int opcionPrincipal = 0;
            int opcionSubMenu = 0;
            boolean salir = false;

            while (!salir) {
                System.out.println("\t\tMenú principal:");
                System.out.println("1. Gestión películas");
                System.out.println("2. Gestión socios");
                System.out.println("3. Realizar venta");
                System.out.println("4. Realizar alquiler");
                System.out.println("5. Realizar devolucion");
                System.out.println("6. Salir");

                try {
                    opcionPrincipal = Integer.parseInt(scanner.nextLine());
                } catch (NumberFormatException e) {
                    System.out.println("Error: Seleccione una opción válida (1-6)");
                    continue;
                }

                switch (opcionPrincipal) {

                    case 2:
                        opcionSubMenu = 0;
                        while (opcionSubMenu != 5) {
                            System.out.println("\t\tGestión socios:");
                            System.out.println("1. Dar de alta a socio");
                            System.out.println("2. Dar de baja a socio");
                            System.out.println("3. Consultar datos de socio");
                            System.out.println("4. Listar socios");
                            System.out.println("5. Salir al menú principal");

                            try {
                                opcionSubMenu = Integer.parseInt(scanner.nextLine());
                            } catch (NumberFormatException e) {
                                System.out.println("Error: Seleccione una opción válida (1-5)");
                                continue;
                            }

                            switch (opcionSubMenu) {
                                case 1:
                                    System.out.println("----Dar de alta a socio----");
                                    String dni1 = pedirDni();
                                    controlador.altaSocio(dni1);
                                    break;
                                case 2:
                                    System.out.println("----Dar de baja a socio----");
                                    String dni = pedirDni();
                                    controlador.bajaSocio(dni);
                                    System.out.println("El socio con DNI " + dni + " ha sido dado de baja.");
                                    break;
                                case 3:
                                    System.out.println("----Consultar datos de socio----");
                                    List<Socio> ls1 = controlador.listarSocios();
                                    imprimeSocios(ls1);
                                    String dni2 = pedirDni();
                                    Socio s = controlador.seleccionarSocio(dni2);
                                    if (s != null) {
                                        imprimeSocio(s);
                                    } else {
                                        System.out.println("No se encontró un socio con el DNI proporcionado.");
                                    }

                                    break;
                                case 4:
                                    System.out.println("----Listar socios----");
                                    List<Socio> ls2 = controlador.listarSocios();
                                    imprimeSocios(ls2);
                                    break;
                                case 5:
                                    System.out.println("Volviendo al menú principal...");
                                    break;
                                default:
                                    System.out.println("Seleccione una opción válida (1-5)");
                                    break;
                            }
                        }
                        break;

                }
            }
        }
    }

    public void confirmacionDeAlta() {
        System.out.println("Alta realizada.");
    }

    public void confirmacionDeBaja() {
        System.out.println("Baja realizada.");
    }

    public void imprimeSocio(Socio s) {
        System.out.println("Datos del socio:");
        System.out.println(s.toString());
    }

    public void imprimeSocios(List<Socio> ls) {
        System.out.println("| DNI | Estado | Número de préstamos en curso |");
        System.out.println("|-----|--------|-------------------------------|");
        for (Socio s : ls) {
            resumeSocio(s);
        }
    }

    public void resumeSocio(Socio s) {
        String estado = s.obtenerEstado() ? "activo" : "inactivo";
        int numPrestamos = s.obtenerRecibos().size(); // Asumiendo que cada recibo corresponde a un préstamo
        System.out.println("| " + s.obtenerDni() + " | " + estado + " | " + numPrestamos + " |");
    }

    public String pedirDni() {
        System.out.println("Introduzca un DNI:");
        Scanner sc = new Scanner(System.in);
        String dni = sc.nextLine();
        return dni;
    }

    public String pedirNombre() {
        System.out.println("Introduzca el nombre del socio:");
        Scanner sc = new Scanner(System.in);
        String nombre = sc.nextLine();
        return nombre;
    }

    public String pedirApellidos() {
        System.out.println("Introduzca los apellidos del socio:");
        Scanner sc = new Scanner(System.in);
        String apellidos = sc.nextLine();
        return apellidos;
    }

    public String pedirTelefono() {
        System.out.println("Introduzca el teléfono del socio:");
        Scanner sc = new Scanner(System.in);
        String telefono = sc.nextLine();
        return telefono;
    }

}