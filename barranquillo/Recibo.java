package barranquillo;

public abstract class Recibo {

    private Socio socio;

    public abstract double obtenerTotal();
    public abstract String aTexto();
}

