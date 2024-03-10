package barranquillo;

import java.util.ArrayList;

public class OrderAlquilerStrategy implements OrderStrategy {
    private Videoclub videoclub;
    private Pantalla pantalla;

    public OrderAlquilerStrategy(Videoclub videoclub) {
        this.pantalla = Pantalla.getInstance();
        this.videoclub = videoclub;
    }

    @Override
    public void iniciar(String dni) {
        Socio s = this.videoclub.buscarSocio(dni);
        Alquiler alquilerActual = new Alquiler(s, new ArrayList<>());
        boolean masPeliculas = true;
        while (masPeliculas) {
            pantalla.imprimePeliculas(videoclub.obtenerPeliculas());
            String titulo = pantalla.pedirTitulo();
            iniciarPrestamo(titulo, alquilerActual);
            masPeliculas = pantalla.masPeliculas();
        }
        Recibo recibo = alquilerActual;
        alquilerActual.obtenerSocio().añadirRecibo(recibo);
        pantalla.imprimeRecibo(alquilerActual);
    }

    private void iniciarPrestamo(String titulo, Alquiler alquilerActual) {
        Pelicula pe = this.videoclub.buscarPelicula(titulo);
        Prestamo prestamo = new Prestamo(pe);
        alquilerActual.obtenerPrestamos().add(prestamo);
        int unidades = 1;
        pe.decrementarStockDisponible(unidades);
        pe.incrementarStockNoDisponible(unidades);

    }

}
