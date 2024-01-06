package barranquillo;

import java.util.List;
import java.util.Scanner;

public class Pantalla {
    private Controlador controlador;
    private Scanner scanner;

    public Pantalla(Controlador ctrl) {
        this.controlador = ctrl;
        this.scanner = new Scanner(System.in);
    }

    public void mostrarInterfaz() {
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
                case 1:
                    opcionSubMenu = 0;

                    while (opcionSubMenu != 5) {
                        System.out.println("\t\tPeliculas:");
                        System.out.println("1. Añadir pelicula");
                        System.out.println("2. Actualizar datos de pelicula");
                        System.out.println("3. Consultar datos de pelicula");
                        System.out.println("4. Listar peliculas");
                        System.out.println("5. Salir al menú principal");

                        try {
                            opcionSubMenu = Integer.parseInt(scanner.nextLine());
                        } catch (NumberFormatException e) {
                            System.out.println("Error: Seleccione una opción válida (1-5)");
                            continue;
                        }

                        switch (opcionSubMenu) {
                            case 1:
                                System.out.println("----Añadir pelicula----");
                                String titulo1 = pedirTitulo();
                                controlador.anadirPelicula(titulo1);
                                confirmacionDePelicula();
                                break;
                            case 2:
                                System.out.println("----Actualizar datos de pelicula----");
                                List<Pelicula> lp1 = controlador.listarPeliculas();
                                imprimePeliculas(lp1);
                                String titulo2 = pedirTitulo();
                                Pelicula pe1 = controlador.seleccionarPelicula(titulo2);

                                if (pe1 != null) {
                                    imprimePelicula(pe1);
                                    double pv = pedirPrecioVenta();
                                    double pa = pedirPrecioAlquiler();
                                    int stockDisponible = pedirStockDisponible();
                                    controlador.introducirDatosPelicula(pe1, pv, pa, stockDisponible);
                                } else {
                                    System.out.println("No se encontró una pelicula con el TITULO proporcionado.");
                                }

                                break;
                            case 3:
                                System.out.println("----Consultar datos de pelicula----");
                                List<Pelicula> lp2 = controlador.listarPeliculas();
                                imprimePeliculas(lp2);
                                String titulo3 = pedirTitulo();
                                Pelicula pe2 = controlador.seleccionarPelicula(titulo3);

                                if (pe2 != null) {
                                    imprimePelicula(pe2);
                                } else {
                                    System.out.println("No se encontró una pelicula con el TITULO proporcionado.");
                                }
                                break;
                            case 4:
                                System.out.println("----Listar peliculas----");
                                List<Pelicula> lp3 = controlador.listarPeliculas();
                                imprimePeliculas(lp3);
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
                                confirmacionDeAlta();
                                break;
                            case 2:
                                System.out.println("----Dar de baja a socio----");
                                List<Socio> ls1 = controlador.listarSocios();
                                imprimeSocios(ls1);
                                String dni2 = pedirDni();
                                Socio s1 = controlador.seleccionarSocio(dni2);

                                if (s1 != null) {
                                    controlador.bajaSocio(dni2);
                                    imprimeSocio(s1);
                                } else {
                                    System.out.println("No se encontró un socio con el DNI proporcionado.");
                                }
                                confirmacionDeBaja();
                                break;
                            case 3:
                                System.out.println("----Consultar datos de socio----");
                                List<Socio> ls2 = controlador.listarSocios();
                                imprimeSocios(ls2);
                                String dni3 = pedirDni();
                                Socio s2 = controlador.seleccionarSocio(dni3);

                                if (s2 != null) {
                                    imprimeSocio(s2);
                                } else {
                                    System.out.println("No se encontró un socio con el DNI proporcionado.");
                                }
                                break;
                            case 4:
                                System.out.println("----Listar socios----");
                                List<Socio> ls3 = controlador.listarSocios();
                                imprimeSocios(ls3);
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

    public void confirmacionDeAlta() {
        System.out.println("Alta realizada.");
    }

    public void confirmacionDePelicula() {
        System.out.println("Pelicula añadida");
    }

    public void confirmacionDeBaja() {
        System.out.println("Baja realizada");
    }

    public void imprimePelicula(Pelicula pe) {
        System.out.println("Datos de la película:");
        System.out.println(pe.toString());
    }

    public void imprimePeliculas(List<Pelicula> lp) {
        System.out.println("| Titulo | Stock Disponible | Stock No Disponible | Stock Total |");
        System.out.println("|--------|------------------|---------------------|-------------|");

        for (Pelicula pe : lp) {
            resumePelicula(pe);
        }
    }

    public void imprimeRecibo(Recibo r) {
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

    public void resumePelicula(Pelicula pe) {
        System.out.println("| " + pe.obtenerTitulo() + " | " + pe.obtenerStockDisponible() + " | "
                + pe.obtenerStockNoDisponible() + " | " + pe.obtenerStockTotal() + "|");
    }

    public void resumeSocio(Socio s) {
        String estado = s.obtenerEstado() ? "activo" : "inactivo";
        int numPrestamos = s.obtenerRecibos().size();
        System.out.println("| " + s.obtenerDni() + " | " + estado + " | " + numPrestamos + " |");
    }

    public String pedirTitulo() {
        System.out.println("Introduzca un titulo:");
        String titulo = scanner.nextLine();
        return titulo;
    }

    public double pedirPrecioVenta() {
        System.out.println("Introduzca precio de venta:");
        double precioVenta = scanner.nextDouble();
        return precioVenta;
    }

    public double pedirPrecioAlquiler() {
        System.out.println("Introduzca precio de alquiler:");
        double precioAlquiler = scanner.nextDouble();
        return precioAlquiler;
    }

    public int pedirStockDisponible() {
        System.out.println("Introduzca stock disponible:");
        int stockDisponible = scanner.nextInt();
        return stockDisponible;
    }

    public String pedirDni() {
        System.out.println("Introduzca un DNI:");
        String dni = scanner.nextLine();
        return dni;
    }

    public String pedirNombre() {
        System.out.println("Introduzca el nombre del socio:");
        String nombre = scanner.nextLine();
        return nombre;
    }

    public String pedirApellidos() {
        System.out.println("Introduzca los apellidos del socio:");
        String apellidos = scanner.nextLine();
        return apellidos;
    }

    public String pedirTelefono() {
        System.out.println("Introduzca el teléfono del socio:");
        String telefono = scanner.nextLine();
        return telefono;
    }
}