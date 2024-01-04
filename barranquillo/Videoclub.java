package barranquillo;

import java.util.ArrayList;
import java.util.List;
public class Videoclub {

    private List<Pelicula> peliculas;
    private List<Socio> socios;

    public Videoclub() {
        peliculas = new ArrayList<>();
        socios = new ArrayList<>();

        // Añadir 3 socios al inicializar la aplicación
        Socio socio1 = new Socio("1111");
        socio1.asignarNombre("Juan");
        socio1.asignarApellidos("Pérez");
        socio1.asignarTelefono("123456789");
        socios.add(socio1);

        Socio socio2 = new Socio("2222");
        socio2.asignarNombre("Ana");
        socio2.asignarApellidos("Gómez");
        socio2.asignarTelefono("987654321");
        socios.add(socio2);

        Socio socio3 = new Socio("3333");
        socio3.asignarNombre("Carlos");
        socio3.asignarApellidos("Martínez");
        socio3.asignarTelefono("567890123");
        socios.add(socio3);

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
