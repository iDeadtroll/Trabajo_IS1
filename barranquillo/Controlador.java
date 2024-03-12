package barranquillo;

import java.util.ArrayList;
import java.util.List;

public class Controlador {
    private Videoclub videoclub;
    private Pantalla pantalla;
    private OrderContexStrategy order;

    public Controlador(Videoclub videoclub) {
        this.videoclub = videoclub;
        // this.pantalla = new Pantalla(this);
        this.pantalla = Pantalla.getInstance();
        this.order = new OrderContexStrategy();
    }

    // public void anadirLineaDeVenta(String titulo, int unidades) {
    // Pelicula pelicula = videoclub.buscarPelicula(titulo);
    // LineaDeVenta lineaDeVenta = new LineaDeVenta(pelicula, unidades);
    // ventaActual.obtenerLineasDeVenta().add(lineaDeVenta);
    // pelicula.decrementarStockDisponible(unidades);
    // pelicula.incrementarStockNoDisponible(unidades);
    // }

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

    private void introducirDatosSocio(Socio s, String nombre, String apellidos, String telefono) {
        s.asignarNombre(nombre);
        s.asignarApellidos(apellidos);
        s.asignarTelefono(telefono);
        pantalla.imprimeSocio(s);
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

    private void introducirDatosPelicula(Pelicula pe, double pv, double pa, int stockDisponible) {
        pe.asignarPrecioVenta(pv);
        pe.asignarPrecioAlquiler(pa);
        pe.asignarStockDisponible(stockDisponible);
        pantalla.imprimePelicula(pe);
    }

    public void bajaSocio(String dni) {
        Socio s = seleccionarSocio(dni);
        s.asignarBaja();
    }

    public void iniciarAlquiler(String dni) {
        OrderAlquilerStrategy al = new OrderAlquilerStrategy(videoclub);
        order.setStrategy(al);

        order.orderRunner(dni);

        // Socio s = seleccionarSocio(dni);
        // Alquiler alquilerActual = new Alquiler(s, new ArrayList<>());
        // boolean masPeliculas = true;
        // while (masPeliculas) {
        // pantalla.imprimePeliculas(videoclub.obtenerPeliculas());
        // String titulo = pantalla.pedirTitulo();
        // iniciarPrestamo(titulo, alquilerActual);
        // masPeliculas = pantalla.masPeliculas();
        // }
        // Recibo recibo = alquilerActual;
        // alquilerActual.obtenerSocio().añadirRecibo(recibo);
        // pantalla.imprimeRecibo(alquilerActual);
    }

    // public void iniciarPrestamo(String titulo, Alquiler alquilerActual) {
    // Pelicula pe = seleccionarPelicula(titulo);
    // Prestamo prestamo = new Prestamo(pe);
    // alquilerActual.obtenerPrestamos().add(prestamo);
    // int unidades = 1;
    // pe.decrementarStockDisponible(unidades);
    // pe.incrementarStockNoDisponible(unidades);

    // }

    public void iniciarDevolucion(String dni) {
        Socio s = seleccionarSocio(dni);
        Recibo<Devolucion> devolucionActual = new Devolucion(s, new ArrayList<>());
        boolean masPeliculas = true;
        while (masPeliculas) {
            List<Alquiler> recibos = s.obtenerRecibosAlquiler();
            for (Alquiler alquiler : recibos) {
                pantalla.imprimeRecibo(alquiler);
            }
            String titulo = pantalla.pedirTitulo();
            finalizarPrestamo(titulo);
            masPeliculas = pantalla.masPeliculas();
        }
        Recibo recibo = devolucionActual;
        devolucionActual.obtenerSocio().añadirRecibo(recibo);
        pantalla.imprimeRecibo(devolucionActual);

        devolucionActual = null;
    }

    public void finalizarPrestamo(String titulo) {
        Pelicula pe = seleccionarPelicula(titulo);
        Prestamo prestamo = devolucionActual.obtenerSocio().buscarPréstamo(pe);
        devolucionActual.obtenerPrestamos().add(prestamo);
        int unidades = 1;
        pe.decrementarStockNoDisponible(unidades);
        pe.incrementarStockDisponible(unidades);
    }

    public void iniciarVenta(String dni) {

        OrderVentaStrategy v = new OrderVentaStrategy(videoclub);
        order.setStrategy(v);

        order.orderRunner(dni);
        // Socio s = seleccionarSocio(dni);
        // ventaActual = new Venta(s, new ArrayList<>());
        // boolean masPeliculas = true;
        // while (masPeliculas) {
        // pantalla.imprimePeliculas(videoclub.obtenerPeliculas());
        // String titulo = pantalla.pedirTitulo();
        // int cantidad = pantalla.pedirCantidad();
        // anadirLineaDeVenta(titulo, cantidad);
        // masPeliculas = pantalla.masPeliculas();
        // }
        // Recibo recibo = ventaActual;
        // ventaActual.obtenerSocio().añadirRecibo(recibo);
        // pantalla.imprimeRecibo(ventaActual);
        // ventaActual = null;
    }

    public List<Pelicula> listarPeliculas() {
        return videoclub.obtenerPeliculas();
    }

    public List<Recibo> listarRecibos(Socio s) {
        return s.obtenerRecibos();
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

    public List<Recibo> listarPrestamos(Socio s) {
        List<Recibo> recibos = new ArrayList<>();
        List<Alquiler> alquileres = s.obtenerRecibosAlquiler();
        for (Alquiler alquiler : alquileres) {
            recibos.add(alquiler);
        }
        return recibos;
    }

    public void añadirValoracion(Pelicula pe) {
        int val = pantalla.pedirValoracion();
        pe.asignarValoracion(val);
    }

    public Pantalla getPantalla() {
        return this.pantalla;
    }
}