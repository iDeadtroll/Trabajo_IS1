package barranquillo;

import java.util.ArrayList;
import java.util.List;

public class Videoclub {

    private List<Pelicula> peliculas;
    private List<Socio> socios;

    public Videoclub() {
        peliculas = new ArrayList<>();
        socios = new ArrayList<>();
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
