package barranquillo;

import java.util.List;

public class Venta extends Recibo {

    private List<LineaDeVenta> lineasDeVenta;
    private Socio socio;

    public Venta(Socio socio, List<LineaDeVenta> lineasDeVenta) {
        this.socio = socio;
        this.lineasDeVenta = lineasDeVenta;
    }

    public List<LineaDeVenta> obtenerLineasDeVenta() {
        return lineasDeVenta;
    }

    public Socio obtenerSocio() {
        return socio;
    }

    @Override
    public double obtenerTotal() {
        double total = 0;
        for (LineaDeVenta lineaDeVenta : lineasDeVenta) {
            total += lineaDeVenta.obtenerTotal();
        }
        return total;
    }

    @Override
    public String aTexto() {
        String s = "Venta para el socio " + socio.obtenerDni() + "\n";
        for (LineaDeVenta lineaDeVenta : lineasDeVenta) {
            s += "Película: " + lineaDeVenta.obtenerPelicula().obtenerTitulo()
                    + ", Unidades: " + lineaDeVenta.obtenerUnidades()
                    + ", Precio de venta: " + lineaDeVenta.obtenerPelicula().obtenerPrecioVenta()
                    + ", Total: " + lineaDeVenta.obtenerTotal()
                    + "\n";
        }
        s += "Total de la venta: " + obtenerTotal();
        return s;
    }
}
