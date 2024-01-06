package barranquillo;

import java.util.List;

public class Devolucion extends Recibo {
    
    private Socio socio;
    private List<Prestamo> prestamos;
    
    public Devolucion(Socio socio, List<Prestamo> prestamos) {
        this.socio = socio;
        this.prestamos = prestamos;
    }

    @Override
    public double obtenerTotal() {
        double total = 0;
        for (Prestamo prestamo : prestamos) {
            total += prestamo.obtenerTotal();
        }
        return total;
    }

    @Override
    public String aTexto() {
        String s = "Recibo de Devolución para el socio " + socio.toString() + "\n";
        for (Prestamo prestamo : prestamos) {
            s += "Película: " + prestamo.obtenerPelicula().obtenerTitulo() + ", Precio de alquiler: "
                    + prestamo.obtenerPrecioAlquiler() + ", Precio de retención: " + prestamo.obtenerPrecioRetención()
                    + "\n";
        }
        s += "Total: " + obtenerTotal();
        return s;
    }
}