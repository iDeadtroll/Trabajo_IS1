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

    }

    public void anadirLineaDeVenta() {

    }

    public void anadirPelicula(String titulo) {
        Pelicula pe = new Pelicula(titulo);

        double pv = pantalla.pedirPrecioVenta();
        double pa = pantalla.pedirPrecioAlquiler();
        int stockDisponible = pantalla.pedirStockDisponible();
        introducirDatosPelicula(pe, pv, pa, stockDisponible);

        List<Pelicula> lp = videoclub.obtenerPeliculas();
        lp.add(pe);
    }

    public void bajaSocio(String dni) {
        Socio s = seleccionarSocio(dni);
        if (s != null) {
            s.asignarBaja();
        }
    }

    public void finalizarPrestamo() {

    }

    public void iniciarAlquiler() {

    }

    public void iniciarPrestamo() {

    }

    public void iniciarDevolucion() {

    }

    public void iniciarVenta() {

    }

    public void introducirDatosPelicula(Pelicula pe, double pv, double pa, int stockDisponible) {
        pe.asignarPrecioVenta(pv);
        pe.asignarPrecioAlquiler(pa);
        pe.asignarStockDisponible(stockDisponible);

        pantalla.imprimePelicula(pe);
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
        return videoclub.obtenerPeliculas();
    }

    public List<Recibo> listarRecibos(Socio s) {

        return null;
    }

    public List<Socio> listarSocios() {
        return videoclub.obtenerSocios();
    }

    public Pelicula seleccionarPelicula(String titulo) {
        return videoclub.buscarPelicula(titulo);
    }

    public Socio seleccionarSocio(String dni) {
        return videoclub.buscarSocio(dni);
    }

}