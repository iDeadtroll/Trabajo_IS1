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
        String s = "\t\nVenta para el socio " + socio.obtenerDni() + "\n";
        for (LineaDeVenta lineaDeVenta : lineasDeVenta) {
            s += "\n\tPelícula: \t\t" + lineaDeVenta.obtenerPelicula().obtenerTitulo()
                    + "\n\tUnidades: \t\t" + lineaDeVenta.obtenerUnidades()
                    + "\n\tPrecio de venta: \t" + lineaDeVenta.obtenerPelicula().obtenerPrecioVenta()
                    + "\n\tTotal: \t\t\t" + lineaDeVenta.obtenerTotal();
        }
        s += "\n\tTotal de la venta: \t" + obtenerTotal();
        return s;
    }
}
