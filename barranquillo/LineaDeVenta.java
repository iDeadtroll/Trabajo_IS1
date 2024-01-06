package barranquillo;

public class LineaDeVenta {
    private int unidades;
    private Pelicula pelicula;

    public LineaDeVenta(Pelicula pe, int u) {
        this.pelicula = pe;
        this.unidades = u;
    }

    public int obtenerUnidades() {
        return unidades;
    }

    public Pelicula obtenerPelicula() {
        return pelicula;
    }

    public double obtenerTotal() {
        return pelicula.obtenerPrecioVenta() * unidades;
    }
}
