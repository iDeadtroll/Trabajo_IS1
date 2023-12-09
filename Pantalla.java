package barranquillo;

import java.util.Scanner;

public class Pantalla {

    public static void main(String[] args) {
        menuPrincipal();
    }

    private static void limpiarPantalla() {
        System.out.print("\033[2J\033[H");
    }

    private static void imprimirCabezera(String titulo, String... opciones) {
        System.out.print("\033[1;7m" + titulo + " |");
        for (String opcion : opciones) {
            System.out.print(" " + opcion + " ");
        }
    }

    private static char seleccionarOpcion() {
        Scanner sc = new Scanner(System.in);
        System.out.print("\033[0m");
        return sc.nextLine().toLowerCase().trim().charAt(0);
    }

    private static void menuPrincipal() {
        boolean salir = false;

        limpiarPantalla();
        while (!salir) {
            imprimirCabezera("Menú principal",
                    "\033[4mP\033[24melículas",
                    "\033[4mS\033[24mocios",
                    "\033[4mV\033[24mentas",
                    "\033[4mA\033[24mlquiler",
                    "\033[4mD\033[24mevolución",
                    "\033[4mC\033[24merrar"
            );

            switch (seleccionarOpcion()) {
                case 'p' -> {
                    submenuPeliculas();
                }
                case 's' -> {
                    submenuSocios();
                }
                case 'v' -> {
                    realizarVenta();
                }
                case 'a' -> {
                    realizarAlquiler();
                }
                case 'd' -> {
                    realizarDevolucion();
                }
                case 'c' -> {
                    salir = true;
                }
                default -> {
                    manejarOpcionDesconocida();
                }
            }
        }
        limpiarPantalla();
    }

    private static void submenuPeliculas() {
        boolean volver = false;

        limpiarPantalla();
        while (!volver) {
            imprimirCabezera("Gestión de películas",
                    "\033[4mA\033[24mñadir",
                    "Ac\033[4mt\033[24mualizar",
                    "\033[4mC\033[24monsultar",
                    "\033[4mL\033[24mistar",
                    "\033[4mV\033[24molver"
            );

            switch (seleccionarOpcion()) {
                case 'a' -> {
                    /* añadir película */
                    System.out.println("Añadir película...");
                }
                case 't' -> {
                    /* actualizar película */
                    System.out.println("Actualizar película...");
                }
                case 'c' -> {
                    /* consultar película */
                    System.out.println("Consultar película...");
                }
                case 'l' -> {
                    /* listar películas */
                    System.out.println("Listar películas...");
                }
                case 'v' -> {
                    volver = true;
                }
                default -> {
                    manejarOpcionDesconocida();
                }
            }
        }
        limpiarPantalla();
    }

    private static void submenuSocios() {
        boolean volver = false;

        limpiarPantalla();
        while (!volver) {
            imprimirCabezera("Gestión de socios",
                    "\033[4mA\033[24mlta",
                    "\033[4mB\033[24maja",
                    "\033[4mC\033[24monsultar",
                    "\033[4mL\033[24mistar",
                    "\033[4mV\033[24molver"
            );

            switch (seleccionarOpcion()) {
                case 'a' -> {
                    /* alta socio */
                    System.out.println("Alta socio...");
                }
                case 'b' -> {
                    /* baja socio */
                    System.out.println("Baja socio...");
                }
                case 'c' -> {
                    /* baja socio */
                    System.out.println("Baja socio...");
                }
                case 'l' -> {
                    /* listar socios */
                    System.out.println("Listar socios...");
                }
                case 'v' -> {
                    volver = true;
                }
                default -> {
                    manejarOpcionDesconocida();
                }
            }
        }
        limpiarPantalla();
    }

    private static void realizarVenta() {
        /**
         * @todo
         */
    }

    private static void realizarAlquiler() {
        /**
         * @todo
         */
    }

    private static void realizarDevolucion() {
        /**
         * @todo
         */
    }

    private static void manejarOpcionDesconocida() {
        System.out.print("\007");
    }

}
