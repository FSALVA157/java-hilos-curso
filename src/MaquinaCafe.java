
import java.util.Random;

public class MaquinaCafe extends Thread {
    

private String nombre;
private Cafe cafe;
private Random random = new Random();


    public MaquinaCafe(String nombre) {
    this.nombre = nombre;    
}

    @Override
    public void run() {
        //Indicar la máquina y el café que se va a preparar
        //System.out.println("La maquina " + this.getNombre() + " prepara el cafe " + this.getCafe().getTipo());

        //Determinar y asignar el tiempo de preparación según el tipo de café pedido
        Random random = new Random();
        int min = this.getCafe().getTiempoDePreparacionPiso();
        int max = this.getCafe().getTiempoDePreparacionTecho();
        int tiempo = random.nextInt((max - min) + 1) + min;        
        

        System.out.println("El rango de tiempo de preparación del cafe " + this.getCafe().getTiempoDePreparacionPiso()+ " y " + this.getCafe().getTiempoDePreparacionTecho() + " y el tiempo asignado por la maquina es " + tiempo + " segundos");   

        //Esperar el tiempo asignado pausando el hilo
    try {
        
        Thread.sleep(tiempo * 1000);
    } catch (InterruptedException ex) {
        System.out.println("Error en el hilo de la maquina " + this.getNombre());
        Thread.currentThread().interrupt();
    }
        System.out.println(">>>>>>>>>>>< SALE EL  " + this.getCafe().getTipo() + " <<<<<<<<<<<<<");
        this.prepararAdicional();

        //liberamos el hilo
        //Thread.currentThread().interrupt();
        
    }

    public void preparar(Cafe cafe) {
        System.out.println("La maquina " + this.getNombre() + "INICIA PREPARACION del cafe " + cafe.getTipo());
        this.setCafe(cafe);
        this.start();
    }

    public void prepararAdicional(){
         int opcion = this.random.nextInt(2) + 1;
        System.out.println("********ADICIONAL*************");
        switch (opcion) {
            case 1:
                StringBuilder s = new StringBuilder();
                s.append("Mensaje en el Vaso");
                s.append("\n");
                s.append("Gracias por Venir!");
                System.out.println(s.toString());
                break;
            case 2:
                s = new StringBuilder();
                switch (this.cafe.getTipo()) {
                    case "Espresso":
                        s.append("DETALLES DEL ESPRESSO");
                        s.append("\n");
                        s.append("Es 1 onza de cafe preparado con 8 a 10 g de cafe molido");
                        s.append("\n");
                        s.append("usando una maquina de cafe que usa la presión para la extracción");
                        System.out.println(s.toString());
                        break;
                    case "Capuchino":
                        s.append("DETALLES DEL CAPUCHINO");
                        s.append("\n");
                        s.append("Son 5 onzas de leche y un cafe Espresso");
                        s.append("\n");
                        s.append("usando una maquina de cafe se logra una bebida dulce y cremosa");
                        System.out.println(s.toString());
                        break;
                    case "Latte":
                        s.append("DETALLES DEL LATTE");
                        s.append("\n");
                        s.append("Son 7 onzas de leche y un cafe Espresso");
                        s.append("\n");
                        s.append("usando una maquina de cafe se logra una bebida sabrosa con mucha leche");
                        System.out.println(s.toString());
                        break;
                    case "Americano":
                        s.append("DETALLES DEL AMERICANO");
                        s.append("\n");
                        s.append("Son 7 onzas de agua caliente y un cafe Espresso");
                        s.append("\n");
                        s.append("cafe negro dulce y de calidad");
                        System.out.println(s.toString());
                        break;
                    case "Cortado":
                        s.append("DETALLES DEL CORTADO");
                        s.append("\n");
                        s.append("Se obtiene con una onza de cafe espresso");
                        s.append("\n");
                        s.append("y dos onzas de leche");
                        s.append("\n");
                        s.append("bebida española muy popular y sabrosa");
                        System.out.println(s.toString());
                        break;
                
                    default:
                        break;
                }
                break;
            case 3:
                this.preparar(cafe);
                break;
            default:
                break;
        }

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Cafe getCafe() {
        return cafe;
    }

    public void setCafe(Cafe cafe) {
        this.cafe = cafe;
    }

    

    

}
