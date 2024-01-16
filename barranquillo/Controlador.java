package barranquillo;

import java.util.ArrayList;
import java.util.List;

public class Controlador {
    private Videoclub videoclub;
    private Pantalla pantalla;
    private Venta ventaActual;

    public Controlador(Videoclub videoclub) {
        this.videoclub = videoclub;
        this.pantalla = new Pantalla(this);
    }

    public void altaSocio(String dni) {
        Socio s = new Socio(dni);
        s.asignarAlta();
        String nombre = pantalla.pedirNombre();
        String apellidos = pantalla.pedirApellidos();
        String telefono = pantalla.pedirTelefono();
        introducirDatosSocio(s, nombre, apellidos, telefono);
        List<Socio> ls = videoclub.obtenerSocios();
        ls.add(s);
    }

    public void anadirLineaDeVenta(String titulo, int unidades) {
        Pelicula pelicula = videoclub.buscarPelicula(titulo);

        if (pelicula != null) {
            LineaDeVenta lineaDeVenta = new LineaDeVenta(pelicula, unidades);
            ventaActual.obtenerLineasDeVenta().add(lineaDeVenta);
            pelicula.decrementarStockDisponible(unidades);
            pelicula.incrementarStockNoDisponible(unidades);
        } else {
            System.out.println("Pelicula no encontrada.");
        }
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
        s.asignarBaja();
    }

    public void finalizarPrestamo() {
    }

    public void iniciarAlquiler() {
    }

    public void iniciarPrestamo() {
    }

    public void iniciarDevolucion() {
    }

    public void iniciarVenta(String dni) {
        Socio s = videoclub.buscarSocio(dni);
        ventaActual = new Venta(s, new ArrayList<>());
        boolean masPeliculas = true;
        while (masPeliculas) {
            pantalla.imprimePeliculas(videoclub.obtenerPeliculas());
            String titulo = pantalla.pedirTitulo();
            int cantidad = pantalla.pedirCantidad();
            anadirLineaDeVenta(titulo, cantidad);
            masPeliculas = pantalla.masPeliculas();
        }
        Recibo recibo = ventaActual;
        ventaActual.obtenerSocio().añadirRecibo(recibo);
    }

    public void finalizarVenta() {
        pantalla.imprimeRecibo(ventaActual);
        ventaActual = null;
    }

    public void introducirDatosPelicula(Pelicula pe, double pv, double pa, int stockDisponible) {
        pe.asignarPrecioVenta(pv);
        pe.asignarPrecioAlquiler(pa);
        pe.asignarStockDisponible(stockDisponible);
        pantalla.imprimePelicula(pe);
    }

    public void introducirDatosSocio(Socio s, String nombre, String apellidos, String telefono) {
        s.asignarNombre(nombre);
        s.asignarApellidos(apellidos);
        s.asignarTelefono(telefono);
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