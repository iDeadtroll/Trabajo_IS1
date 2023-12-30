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
     
    public Prestamo buscarPréstamo(Pelicula película) {
        // Implementar método
        return null; 
    }
     
    public void añadirRecibo(Recibo recibo) {
        this.recibos.add(recibo);
    }
     
    public void asignarBaja() {
        estado = false; 
        // Implementación adicional si es necesario
    }
     
    public void asignarAlta() { 
        estado = true; 
        // Implementación adicional si es necesario 
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
}

