package barranquillo;

import java.util.ArrayList;

public class OrderVentaStrategy implements OrderStrategy {

    private Videoclub videoclub;
    private Pantalla pantalla;

    public OrderVentaStrategy(Videoclub videoclub) {
        this.pantalla = Pantalla.getInstance();
        this.videoclub = videoclub;
    }

    @Override
    public void iniciar(String dni) {
        Socio s = this.videoclub.buscarSocio(dni);
        Venta ventaActual = new Venta(s, new ArrayList<>());
        boolean masPeliculas = true;
        while (masPeliculas) {
            pantalla.imprimePeliculas(videoclub.obtenerPeliculas());
            String titulo = pantalla.pedirTitulo();
            int cantidad = pantalla.pedirCantidad();
            anadirLineaDeVenta(ventaActual, titulo, cantidad);
            masPeliculas = pantalla.masPeliculas();
        }
        Recibo recibo = ventaActual;
        ventaActual.obtenerSocio().añadirRecibo(recibo);
        pantalla.imprimeRecibo(ventaActual);
    }

    private void anadirLineaDeVenta(Venta ventaActual, String titulo, int unidades) {
        Pelicula pelicula = videoclub.buscarPelicula(titulo);
        LineaDeVenta lineaDeVenta = new LineaDeVenta(pelicula, unidades);
        ventaActual.obtenerLineasDeVenta().add(lineaDeVenta);
        pelicula.decrementarStockDisponible(unidades);
        pelicula.incrementarStockNoDisponible(unidades);
    }

}
