package barranquillo;

public class Prestamo {
    private double precioAlquiler;
    private double precioRetención;
    private Pelicula pelicula;

    public Prestamo(Pelicula pe, double pa, double pr) {
        this.pelicula = pe;
        this.precioAlquiler = pa;
        this.precioRetención = pr;
    }

    public Pelicula obtenerPelicula() {
        return pelicula;
    }

    public double obtenerPrecioAlquiler() {
        return precioAlquiler;
    }

    public double obtenerPrecioRetención() {
        return precioRetención;
    }

    public double obtenerTotal() {
        return precioAlquiler + precioRetención; 
    }
}
