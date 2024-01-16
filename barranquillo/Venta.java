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
        StringBuilder sb = new StringBuilder();
        sb.append("Venta para el socio ").append(socio.obtenerDni()).append("\n");

        for (LineaDeVenta lineaDeVenta : lineasDeVenta) {
            sb.append("Película: ").append(lineaDeVenta.obtenerPelicula().obtenerTitulo())
                    .append(", Unidades: ").append(lineaDeVenta.obtenerUnidades())
                    .append(", Precio de venta: ").append(lineaDeVenta.obtenerPelicula().obtenerPrecioVenta())
                    .append(", Total: ").append(lineaDeVenta.obtenerTotal())
                    .append("\n");
        }

        sb.append("Total de la venta: ").append(obtenerTotal());
        return sb.toString();
    }
}
