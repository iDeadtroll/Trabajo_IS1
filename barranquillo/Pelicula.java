package barranquillo;

public class Pelicula {
    private String titulo;
    private double precioVenta;
    private double precioAlquiler;
    private int stockDisponible;
    private int stockNoDisponible;

    public Pelicula(String t, double pv, double pa) {
        this.titulo = t;
        this.precioVenta = pv;
        this.precioAlquiler = pa;
        this.stockDisponible = 0;
        this.stockNoDisponible = 0;
    }

    public String obtenerTitulo() {
        return titulo;
    }

    public double obtenerPrecioVenta() {
        return precioVenta;
    }

    public double obtenerPrecioAlquiler() {
        return precioAlquiler;
    }

    public int obtenerStockDisponible() {
        return stockDisponible;
    }

    public int obtenerStockNoDisponible() {
        return stockNoDisponible;
    }

    public int obtenerStockTotal() {
        return stockDisponible + stockNoDisponible;
    }

    public void incrementarStockDisponible(int inc) {
        stockDisponible += inc;
    }

    public void decrementarStockDisponible(int dec) {
        stockDisponible -= dec;
    }

    public void incrementarStockNoDisponible(int inc) {
        stockNoDisponible += inc;
    }

    public void decrementarStockNoDisponible(int dec) {
        stockNoDisponible -= dec;
    }

    public void asignarPrecioVenta(double pv) {
        precioVenta = pv;
    }

    public void asignarPrecioAlquiler(double pa) {
        precioAlquiler = pa;
    }

    public void asignarStockDisponible(int sd) {
        stockDisponible = sd;
    }
}

