package barranquillo;

import java.util.ArrayList;
import java.util.List;

public class Socio {
    private String dni;
    private boolean estado;
    private String nombre;
    private String apellidos;
    private String telefono;
    private List<Recibo> recibos;

    public Socio(String dni) {
        this.dni = dni;
        this.estado = true;
        this.nombre = "";
        this.apellidos = "";
        this.telefono = "";
        this.recibos = new ArrayList<>();
    }

    public String obtenerDni() {
        return dni;
    }

    public boolean obtenerEstado() {
        return estado;
    }

    public String obtenerNombre() {
        return nombre;
    }

    public String obtenerApellidos() {
        return apellidos;
    }

    public String obtenerTelefono() {
        return telefono;
    }

    public Prestamo buscarPréstamo(Pelicula pe) {
        List<Alquiler> alquileres = obtenerRecibosAlquiler();
        for(Alquiler alquiler : alquileres){
            for(Prestamo prestamo : alquiler.obtenerPrestamos()){
                if (prestamo.obtenerPelicula().equals(pe)) {
                    return prestamo;
                }
            }
        }
        return null;
    }

    public void añadirRecibo(Recibo recibo) {
        this.recibos.add(recibo);
    }

    public void asignarBaja() {
        estado = false;
    }

    public void asignarAlta() {
        estado = true;
    }

    public void asignarNombre(String n) {
        nombre = n;
    }

    public void asignarApellidos(String ns) {
        apellidos = ns;
    }

    public void asignarTelefono(String n) {
        telefono = n;
    }

    public List<Recibo> obtenerRecibos() {
        return recibos;
    }

    public List<Alquiler> obtenerRecibosAlquiler() {
        List<Alquiler> alquileres = new ArrayList<>();
        for (Recibo recibo : recibos) {
            if (recibo instanceof Alquiler) {
                alquileres.add((Alquiler) recibo);
            }
        }
        return alquileres;
    }

    public String toString() {
        String estadoSocio = obtenerEstado() ? "activo" : "inactivo";
        String s =  "DNI: \t\t" + dni + 
                    "\nNombre: \t" + nombre + 
                    "\nApellidos: \t" + apellidos + 
                    "\nTeléfono: \t" + telefono+   
                    "\nEstado: \t" + estadoSocio;
                s +="\n\t\t----Recibos----\n";
        for (Recibo recibo : recibos) {
            s += recibo.aTexto() + "\n";
        }
        return s;
    }
}