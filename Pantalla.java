import java.util.Scanner;

public class Pantalla {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int opcionPrincipal = 0;
            int opcionSubMenu = 0;
            boolean salir = false;

            while (!salir) {
                System.out.println("\t\tMenú principal:");
                System.out.println("1. Gestión películas");
                System.out.println("2. Gestión socios");
                System.out.println("3. Gestión ventas");
                System.out.println("4. Gestión alquiler");
                System.out.println("5. Gestión registro");
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
                            System.out.println("\t\tGestión películas:");
                            System.out.println("1. Añadir película");
                            System.out.println("2. Actualizar datos de película");
                            System.out.println("3. Consultar película");
                            System.out.println("4. Listar películas");
                            System.out.println("5. Salir al menú principal");

                            try {
                                opcionSubMenu = Integer.parseInt(scanner.nextLine());
                            } catch (NumberFormatException e) {
                                System.out.println("Error: Seleccione una opción válida (1-5)");
                                continue;
                            }

                            switch (opcionSubMenu) {
                                case 1:
                                    System.out.println("Has seleccionado la opción 1 del submenú gestión películas");
                                    break;
                                case 2:
                                    System.out.println("Has seleccionado la opción 2 del submenú gestión películas");
                                    break;
                                case 3:
                                    System.out.println("Has seleccionado la opción 3 del submenú gestión películas");
                                    break;
                                case 4:
                                    System.out.println("Has seleccionado la opción 4 del submenú gestión películas");
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
                                    System.out.println("Has seleccionado la opción 1 del submenú gestión socios");
                                    break;
                                case 2:
                                    System.out.println("Has seleccionado la opción 2 del submenú gestión socios");
                                    break;
                                case 3:
                                    System.out.println("Has seleccionado la opción 3 del submenú gestión socios");
                                    break;
                                case 4:
                                    System.out.println("Has seleccionado la opción 4 del submenú gestión socios");
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
                    case 3:
                        opcionSubMenu = 0;
                        while (opcionSubMenu != 3) {
                            System.out.println("\t\tGestión ventas:");
                            System.out.println("1. Realizar venta");
                            System.out.println("2. Devolver venta");
                            System.out.println("3. Salir al menú principal");

                            try {
                                opcionSubMenu = Integer.parseInt(scanner.nextLine());
                            } catch (NumberFormatException e) {
                                System.out.println("Error: Seleccione una opción válida (1-3)");
                                continue;
                            }

                            switch (opcionSubMenu) {
                                case 1:
                                    System.out.println("Has seleccionado la opción 1 del submenú gestión ventas");
                                    break;
                                case 2:
                                    System.out.println("Has seleccionado la opción 2 del submenú gestión ventas");
                                    break;
                                case 3:
                                    System.out.println("Volviendo al menú principal...");
                                    break;
                                default:
                                    System.out.println("Seleccione una opción válida (1-3)");
                                    break;
                            }
                        }
                        break;
                    case 4:
                        opcionSubMenu = 0;
                        while (opcionSubMenu != 3) {
                            System.out.println("\t\tGestión alquiler:");
                            System.out.println("1. Realizar alquiler");
                            System.out.println("2. Devolver alquiler");
                            System.out.println("3. Salir al menú principal");

                            try {
                                opcionSubMenu = Integer.parseInt(scanner.nextLine());
                            } catch (NumberFormatException e) {
                                System.out.println("Error: Seleccione una opción válida (1-3)");
                                continue;
                            }

                            switch (opcionSubMenu) {
                                case 1:
                                    System.out.println("Has seleccionado la opción 1 del submenú gestión alquiler");
                                    break;
                                case 2:
                                    System.out.println("Has seleccionado la opción 2 del submenú gestión alquiler");
                                    break;
                                case 3:
                                    System.out.println("Volviendo al menú principal...");
                                    break;
                                default:
                                    System.out.println("Seleccione una opción válida (1-3)");
                                    break;
                            }
                        }
                        break;
                    case 5:
                        opcionSubMenu = 0;
                        while (opcionSubMenu != 3) {
                            System.out.println("\t\tGestión registro:");
                            System.out.println("1. Registro ventas");
                            System.out.println("2. Registro alquiler");
                            System.out.println("3. Salir al menú principal");

                            try {
                                opcionSubMenu = Integer.parseInt(scanner.nextLine());
                            } catch (NumberFormatException e) {
                                System.out.println("Error: Seleccione una opción válida (1-3)");
                                continue;
                            }

                            switch (opcionSubMenu) {
                                case 1:
                                    System.out.println("Has seleccionado la opción 1 del submenú gestión registro");
                                    break;
                                case 2:
                                    System.out.println("Has seleccionado la opción 2 del submenú gestión registro");
                                    break;
                                case 3:
                                    System.out.println("Volviendo al menú principal...");
                                    break;
                                default:
                                    System.out.println("Seleccione una opción válida (1-3)");
                                    break;
                            }
                        }
                        break;
                    case 6:
                        salir = true;
                        System.out.println("Saliendo...");
                        break;
                    default:
                        System.out.println("Seleccione una opción válida (1-6)");
                        break;
                }
            }
        }
    }
}