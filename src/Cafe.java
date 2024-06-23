public class Cafe {
    private String tipo;
    private int tiempoDePreparacionTecho;
    private int tiempoDePreparacionPiso;
    
    public Cafe(String tipo, int tiempoDePreparacionPiso, int tiempoDePreparacionTecho) {
        this.tipo = tipo;
        this.tiempoDePreparacionTecho = tiempoDePreparacionTecho;
        this.tiempoDePreparacionPiso = tiempoDePreparacionPiso;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getTiempoDePreparacionTecho() {
        return tiempoDePreparacionTecho;
    }

    public void setTiempoDePreparacionTecho(int tiempoDePreparacionTecho) {
        this.tiempoDePreparacionTecho = tiempoDePreparacionTecho;
    }

    public int getTiempoDePreparacionPiso() {
        return tiempoDePreparacionPiso;
    }

    public void setTiempoDePreparacionPiso(int tiempoDePreparacionPiso) {
        this.tiempoDePreparacionPiso = tiempoDePreparacionPiso;
    }
    

}
