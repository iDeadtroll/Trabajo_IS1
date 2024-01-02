package barranquillo;

import java.util.List;

public class Controlador {

    private Videoclub videoclub;
    private Pantalla pantalla;

    public Controlador(Videoclub videoclub) {
        this.videoclub = videoclub;
        this.pantalla = new Pantalla(this);
    }

    public void altaSocio(String dni) {
        // Crear un nuevo socio
        Socio s = new Socio(dni);
        s.asignarAlta();
        // Pedir al usuario los datos del socio
        String nombre = pantalla.pedirNombre();
        String apellidos = pantalla.pedirApellidos();
        String telefono = pantalla.pedirTelefono();
        introducirDatosSocio(s, nombre, apellidos, telefono);

        // Obtener la lista de socios del videoclub
        List<Socio> ls = videoclub.obtenerSocios();

        // Añadir el nuevo socio a la lista
        ls.add(s);

        // Confirmar alta del socio
        pantalla.confirmacionDeAlta();
    }

    public void añadirLineaDeVenta() {

    }

    public void añadirPelicula() {

    }

    public void bajaSocio() {

    }

    public void finalizarPréstamo() {

    }

    public void iniciarAlquiler() {

    }

    public void iniciarPréstamo() {

    }

    public void iniciarDevolución() {

    }

    public void iniciarVenta() {

    }

    public void introducirDatosPelicula() {

    }

    public void introducirDatosSocio(Socio s, String nombre, String apellidos, String telefono) {
        // Guardar los datos del socio en el objeto
        s.asignarNombre(nombre);
        s.asignarApellidos(apellidos);
        s.asignarTelefono(telefono);

        // Imprimir los datos del socio
        pantalla.imprimeSocio(s);
    }

    public List<Pelicula> listarPeliculas() {

        return null;
    }

    public List<Socio> listarSocios() {

        return null;
    }

    public Pelicula seleccionarPelicula() {

        return null;
    }

    public Socio seleccionarSocio() {

        return null;
    }
}
