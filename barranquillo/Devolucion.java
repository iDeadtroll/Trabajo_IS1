package barranquillo;

import java.util.List;

public class Devolucion extends Recibo {
    
    private Socio socio;
    private List<Prestamo> prestamos;
    
    public Devolucion(Socio socio, List<Prestamo> prestamos) {
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
        String s = "\t\nDevolución para el socio " + socio.obtenerDni() + "\n";
        for (Prestamo prestamo : prestamos) {
            s += "\tPelícula: \t" + prestamo.obtenerPelicula().obtenerTitulo() + 
                "\t\nPrecio de alquiler: \t"+ prestamo.obtenerPrecioAlquiler() + 
                "\t\nPrecio de retención: \t" + prestamo.obtenerPrecioRetención();
        }
        s += "\t\nTotal: \t" + obtenerTotal();
        return s;
    }
}