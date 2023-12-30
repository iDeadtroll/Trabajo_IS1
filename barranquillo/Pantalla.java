package barranquillo;

import java.util.List;
import java.util.Scanner;

public class Pantalla {

    public static void main(String[] args) {
        menuPrincipal();
    }

    private static void limpiarPantalla() {
        System.out.print("\033[2J\033[H");
    }

    private static void imprimirCabezera(String titulo, String... opciones) {
        System.out.print("\033[1;7m " + titulo + " | ");
        for (String opcion : opciones) {
            System.out.print(opcion + " ");
        }
        System.out.print("| ");
    }

    private static char seleccionarOpcion() {
        Scanner sc = new Scanner(System.in);
        char c = sc.nextLine().toLowerCase().trim().charAt(0);
        System.out.print("\033[A\033[2K\033[0m");
        return c;
    }

    private static void menuPrincipal() {
        boolean salir = false;

        limpiarPantalla();
        while (!salir) {
            imprimirCabezera("Menú principal",
                    "\033[4mP\033[24melículas",
                    "\033[4mS\033[24mocios",
                    "\033[4mV\033[24menta",
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
                    /* realizar venta */
                    System.out.println("Realizar venta...\n...\n...");
                }
                case 'a' -> {
                    /* realizar alquiler */
                    System.out.println("Realizar alquiler...\n...\n...");
                }
                case 'd' -> {
                    /* realizar devolucion */
                    System.out.println("Realizar devolucion...\n...\n...");
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
                    System.out.println("Añadir película...\n...\n...");
                }
                case 't' -> {
                    /* actualizar película */
                    System.out.println("Actualizar película...\n...\n...");
                }
                case 'c' -> {
                    /* consultar película */
                    System.out.println("Consultar película...\n...\n...");
                }
                case 'l' -> {
                    /* listar películas */
                    System.out.println("Listar películas...\n...\n...");
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
                    System.out.println("Alta socio...\n...\n...");
                }
                case 'b' -> {
                    /* baja socio */
                    System.out.println("Baja socio...\n...\n...");
                }
                case 'c' -> {
                    /* baja socio */
                    System.out.println("Baja socio...\n...\n...");
                }
                case 'l' -> {
                    /* listar socios */
                    System.out.println("Listar socios...\n...\n...");
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

    private static void manejarOpcionDesconocida() {
        System.out.print("\007");
    }
    

    public void confirmacionDeAlta() {
        System.out.println("Alta realizada.");
    }

    public void confirmacionDePelicula() {
        System.out.println("Película añadida.");
    }

    public void confirmacionDeBaja() {
        System.out.println("Baja realizada.");
    }

    public void imprimePelicula(Pelicula pe) {
    
    }

    public void imprimePeliculas(List<Pelicula> lp) {
        for (Pelicula pelicula : lp) {
            imprimePelicula(pelicula);
        }
    }

    public void imprimeRecibo(Recibo r) {
    
    }

    public void imprimeSocio(Socio s) {
    
    }

    public void imprimeSocios(List<Socio> ls) {
        for (Socio socio : ls) {
            imprimeSocio(socio);
        }
    }

    public void resumePelicula(Pelicula pe) {
    
    }

    public void resumeSocio(Socio s) {
    
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
