
import java.util.ArrayList;
import java.util.Scanner;

public class App {
    ArrayList<MaquinaCafe> maquinas = new ArrayList<>();
    ArrayList<Cafe> listaPedidos;

    public static void main(String[] args) throws Exception {
        App app = new App();

        //Inicialización de las máquinas
        app.inicializarMaquinas();

        //Inicialización de la lista de pedidos
        app.listaPedidos = new ArrayList<>();

        //Uso de Scanner para poder recibir entrada del usuario
        Scanner scanner = new Scanner(System.in);        

        //Uso de booleano para repetir el menú las veces necesarias
        boolean bandera = true;
        while(bandera){
            System.out.println("1. Pedir Cafe");
            System.out.println("2. Salir");
            int opcion  = scanner.nextInt();
            switch (opcion) {
                case 1:
                boolean b = true;
                while(b){
                    System.out.println("¿Que tipo de cafe desea pedir?");
                    System.out.println("1. Espresso");
                    System.out.println("2. Capuchino");
                    System.out.println("3. Latte");
                    System.out.println("4. Americano");
                    System.out.println("5. Cortado");
                    int tipoCafe = scanner.nextInt();
                    Cafe cafe;
                    switch (tipoCafe) {
                        case 1:
                            cafe = new Cafe("Espresso", 10, 15);                                
                            break;

                        case 2:
                            cafe = new Cafe("Capuchino", 12, 20);                                                        
                            break;

                        case 3:
                            cafe = new Cafe("Latte", 5, 30);                            
                            break;

                        case 4:
                            cafe = new Cafe("Americano", 12, 20);                            
                            break;
                        case 5:
                            cafe = new Cafe("Cortado", 10, 20);                            
                            break;
                    
                        default:
                            System.out.println("Opcion no valida");
                            continue;                            
                    }
                    app.listaPedidos.add(cafe);
                    app.asignarMaquina(cafe);                                        
                    b = false;                    
                }
                break;
                //porcion de switch externo
                case 2:
                    bandera = false;
                    break;
                default:
                    System.out.println("Opcion no valida");
            }
        }

    }

    void inicializarMaquinas() {
        this.maquinas.add(new MaquinaCafe("Monaco-4587"));
        this.maquinas.add(new MaquinaCafe("Longgi-1000"));
        this.maquinas.add(new MaquinaCafe("Breccia-3852"));
    }

    void asignarMaquina(Cafe cafe){
        if(!this.listaPedidos.isEmpty()){
            boolean bandera = true;
             do {
                for (int i = 0; i < this.maquinas.size(); i++) {
                    if (!this.maquinas.get(i).isAlive()) {
                        System.out.println("La maquina " + this.maquinas.get(i).getNombre() + " se encuentra inactiva");
                        this.maquinas.set(i, new MaquinaCafe(this.maquinas.get(i).getNombre()));                         
                        this.maquinas.get(i).preparar(cafe);                                                
                        this.listaPedidos.remove(cafe);
                        bandera = false;
                        return;
                    }else{
                     //   System.out.println("La maquina " + this.maquinas.get(i).getNombre() + " OCUPADA");
                    }
                }
                
             } while (bandera);
        }  
    }

    
}
