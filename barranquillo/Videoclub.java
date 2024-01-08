package barranquillo;

import java.util.ArrayList;
import java.util.List;

public class Videoclub {

    private List<Pelicula> peliculas;
    private List<Socio> socios;

    public Videoclub() {
        peliculas = new ArrayList<>();
        socios = new ArrayList<>();

        // Añadir 3 peliculas al inicializar la aplicación
        Pelicula pe1 = new Pelicula("Resistencia");
        pe1.asignarPrecioVenta(10);
        pe1.asignarPrecioAlquiler(5);
        pe1.asignarStockDisponible(1);
        peliculas.add(pe1);

        Pelicula pe2 = new Pelicula("Last of Us");
        pe2.asignarPrecioVenta(8);
        pe2.asignarPrecioAlquiler(4);
        pe2.asignarStockDisponible(2);
        peliculas.add(pe2);

        Pelicula pe3 = new Pelicula("Cars");
        pe3.asignarPrecioVenta(6);
        pe3.asignarPrecioAlquiler(3);
        pe3.asignarStockDisponible(3);
        peliculas.add(pe3);

        // Añadir 3 socios al inicializar la aplicación
        Socio s1 = new Socio("1111");
        s1.asignarNombre("Juan");
        s1.asignarApellidos("Pérez");
        s1.asignarTelefono("123456789");
        socios.add(s1);

        Socio s2 = new Socio("2222");
        s2.asignarNombre("Ana");
        s2.asignarApellidos("Gómez");
        s2.asignarTelefono("987654321");
        socios.add(s2);

        Socio s3 = new Socio("3333");
        s3.asignarNombre("Carlos");
        s3.asignarApellidos("Martínez");
        s3.asignarTelefono("567890123");
        socios.add(s3);

    }

    public Pelicula buscarPelicula(String t) {
        // Método para buscar una película por su título
        for (Pelicula pelicula : obtenerPeliculas()) {
            if (pelicula.obtenerTitulo().equals(t)) {
                return pelicula;
            }
        }
        return null;
    }

    public Socio buscarSocio(String dni) {
        // Método para buscar un socio por su DNI
        for (Socio socio : obtenerSocios()) {
            if (socio.obtenerDni().equals(dni)) {
                return socio;
            }
        }
        return null;
    }

    public List<Pelicula> obtenerPeliculas() {
        return peliculas;
    }

    public List<Socio> obtenerSocios() {
        return socios;
    }
}
