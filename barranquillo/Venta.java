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
        String s = "Recibo de Venta para el socio " + socio.toString() + "\n";
        for (LineaDeVenta lineaDeVenta : lineasDeVenta) {
            s += "Película: " + lineaDeVenta.obtenerPelicula().obtenerTitulo() + ", Unidades: "
                    + lineaDeVenta.obtenerUnidades() + ", Precio de venta: "
                    + lineaDeVenta.obtenerPelicula().obtenerPrecioVenta() + "\n";
        }
        s += "Total: " + obtenerTotal();
        return s;
    }
}
