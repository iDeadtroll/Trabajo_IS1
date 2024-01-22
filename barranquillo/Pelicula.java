package barranquillo;

import java.util.ArrayList;
import java.util.List;

public class Pelicula {
    private String titulo;
    private double precioVenta;
    private double precioAlquiler;
    private int stockDisponible;
    private int stockNoDisponible;
    private List<Integer> valoracion;

    public Pelicula(String t) {
        this.titulo = t;
        this.precioVenta = 0;
        this.precioAlquiler = 0;
        this.stockDisponible = 0;
        this.stockNoDisponible = 0;
        this.valoracion = new ArrayList<>();
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
        return obtenerStockDisponible() + obtenerStockNoDisponible();
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

    public void asignarValoracion(int val){
        valoracion.add(val);
    }

    public List<Integer> obtenerValoraciones(){
        return valoracion;
    }

    public double obtenerValoracion(){
        int contador = 0;
        int suma = 0;
        for(int i=0; i< valoracion.size(); i++){
            contador++;
            suma = suma + valoracion.get(i);
        }
        if(contador == 0) {
            return 0;
        } else {
            return (double)suma/contador;
        }
    }
    @Override
    public String toString() {
        return "Titulo: \t\t" + obtenerTitulo() + "\n" +
                "Precio de Venta: \t" + obtenerPrecioVenta() + "\n" +
                "Precio de Alquiler: \t" + obtenerPrecioAlquiler() + "\n" +
                "Stock Disponible: \t" + obtenerStockDisponible() + "\n" +
                "Stock No Disponible: \t" + obtenerStockNoDisponible() + "\n" +
                "Stock Total: \t\t" + obtenerStockTotal() + "\n" +
                "Valoracion: \t\t" + obtenerValoracion() + "\n\n";
    }
}