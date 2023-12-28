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
        // Suponiendo que hay un método en la clase Pelicula que devuelve el precio
        return pelicula.obtenerPrecioVenta() * unidades; 
    }
}
