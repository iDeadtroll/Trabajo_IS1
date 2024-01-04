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

    public void bajaSocio(String dni) {
        Socio s = videoclub.buscarSocio(dni);
        if (s != null) {
            s.asignarBaja();
        }
    }

    public void introducirDatosSocio(Socio s, String nombre, String apellidos, String telefono) {
        // Guardar los datos del socio en el objeto
        s.asignarNombre(nombre);
        s.asignarApellidos(apellidos);
        s.asignarTelefono(telefono);

        // Imprimir los datos del socio
        pantalla.imprimeSocio(s);
    }

    public List<Socio> listarSocios() {
        return videoclub.obtenerSocios();
    }

    public Socio seleccionarSocio(String dni) {
        return videoclub.buscarSocio(dni);
    }

    
}