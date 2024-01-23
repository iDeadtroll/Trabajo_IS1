package barranquillo;

public class Prestamo {
    private double precioAlquiler;
    private double precioRetención;
    private Pelicula pelicula;

    public Prestamo(Pelicula pe) {
        this.pelicula = pe;
        this.precioAlquiler = obtenerPrecioAlquiler();
        this.precioRetención = obtenerPrecioRetención();
    }

    public double obtenerPrecioAlquiler() {
        return pelicula.obtenerPrecioAlquiler();
    }

    public double obtenerPrecioRetención() {
        precioRetención = pelicula.obtenerPrecioVenta() - pelicula.obtenerPrecioAlquiler();
        return precioRetención;
    }

    public Pelicula obtenerPelicula() {
        return pelicula;
    }

    public double obtenerTotal() {
        return precioAlquiler + precioRetención;
    }
}
