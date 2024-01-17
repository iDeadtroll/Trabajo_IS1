package barranquillo;

import java.util.List;

class Alquiler extends Recibo {

    private Socio socio;
    private List<Prestamo> prestamos;

    public Alquiler(Socio socio, List<Prestamo> prestamos) {
        this.socio = socio;
        this.prestamos = prestamos;
    }
    public List<Prestamo> obtenerPrestamos(){
        return prestamos;
    }

    public Socio obtenerSocio() {
        return socio;
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
        String s = "Recibo de Alquiler para el socio " + socio.obtenerDni() + "\n";
        for (Prestamo prestamo : prestamos) {
            s += "Película: " + prestamo.obtenerPelicula().obtenerTitulo() + ", Precio de alquiler: "
                    + prestamo.obtenerPrecioAlquiler() + ", Precio de retención: " + prestamo.obtenerPrecioRetención()
                    + "\n";
        }
        s += "Total: " + obtenerTotal();
        return s;
    }
}
