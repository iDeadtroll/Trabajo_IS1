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
        String s = "\t\nAlquiler para el socio " + socio.obtenerDni() + "\n";
        for (Prestamo prestamo : prestamos) {
            s += "\tPelícula: \t\t" + prestamo.obtenerPelicula().obtenerTitulo() 
                + "\n\tPrecio de alquiler: \t" + prestamo.obtenerPrecioAlquiler() 
                + "\n\tPrecio de retención: \t" + prestamo.obtenerPrecioRetención();
        }
        s += "\n\tTotal: \t\t\t" + obtenerTotal();
        return s;
    }
}
