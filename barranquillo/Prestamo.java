package barranquillo;

public class Prestamo {
    private double precioAlquiler;
    private double precioRetención;
    private Pelicula pelicula;

    public Prestamo(Pelicula titulo) {
        this.pelicula = titulo;
        this.precioAlquiler = obtenerPrecioAlquiler();
        this.precioRetención = obtenerPrecioRetención();
    }

    public Pelicula obtenerPelicula() {
        return pelicula;
    }

    public double obtenerPrecioAlquiler() {
        return precioAlquiler;
    }

    public double obtenerPrecioRetención() {
        precioRetención = pelicula.obtenerPrecioVenta() - pelicula.obtenerPrecioAlquiler();
        return precioRetención;
    }

    public double obtenerTotal() {
        return precioAlquiler + precioRetención;
    }
}
