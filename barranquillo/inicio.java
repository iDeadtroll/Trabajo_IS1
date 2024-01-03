package barranquillo;

public class inicio {
    public static void main(String[] args) {
        Videoclub vi = new Videoclub();
        Controlador ctrl = new Controlador(vi);
        Pantalla p = new Pantalla(ctrl);
        p.mostrarInterfaz();
    }
}