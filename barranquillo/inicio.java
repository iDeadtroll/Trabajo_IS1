package barranquillo;

public class inicio {
    public static void main(String[] args) {
        // System.out.println(Calculadora.suma(1, 1));
        Videoclub vi = new Videoclub();
        Controlador ctrl = new Controlador(vi);
        // Pantalla p = new Pantalla(ctrl);
        Pantalla p = Pantalla.getInstance();
        p.setController(ctrl);
        p.mostrarInterfaz();
    }
}