/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package motorpromocional;

import java.util.Scanner;

/**
 *
 * @author José Alcantara
 */
public class MotorPromocional {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner s = new Scanner(System.in);
        Cliente cliente = new Cliente();
        System.out.println("bienvenido!!!");
        System.out.println("Porfavor ingrese su nombre : ");
        String nombre = s.nextLine();
        System.out.println("Porfavor ingrese su apellido : ");
        String apellido = s.nextLine();
        System.out.println("Porfavor ingrese su direccion de despacho : ");
        String direccion = s.nextLine();
        System.out.println("Ingrese su rut : ");
        String rut = s.nextLine();
        cliente.setNombre(nombre);
        cliente.setApellido(apellido);
        cliente.setDireccionDespacho(direccion);
        cliente.setRutCliente(rut);
        Boleta boleta = new Boleta();
        boleta.setRutCliente(cliente.getRutCliente());
        boolean validador = false;
        boolean validadorCompras = false; 
        Cupon cuponCerveza = new Cupon("AUSTRAL2021", 0.2, "21/08/2021" ,"21/08/2022","Austral Patagonia", 100, 65497321);
        Cupon cuponMani = new Cupon("MANI2021", 0.4, "21/08/2021" ,"21/08/2022","Evercrisp", 50, 34322342);
        Producto cerveza = new Producto(65497321, "Austral Patagonia", 1000, 1200);
        Producto mani = new Producto(34322342, "Evercrisp", 1000, 600);    
        System.out.println(cuponMani.getEan());
        
        while(!validador){
            System.out.println("Muchas gracias por escogernos " + cliente.getNombre() + ", a continuacion le mostraremos lo que puede hacer... " );
            System.out.println("1. Agregar productos al carro");
            System.out.println("2. Agregar cupones");
            int opcion = s.nextInt();
            if (1 == opcion){    
                while(!validadorCompras){
                    System.out.println("1. cerveza ... precio : $"+ cerveza.getPrecio() );
                    System.out.println("2. mani    ... precio : $"+ mani.getPrecio() );
                    System.out.println("3. Salir ");

                    System.out.println("Escoga una opcion : ");
                    int op = s.nextInt();
                    if (1 == op){
                        System.out.println("¿Cuantas cervezas desea? :");
                        int cantidad = s.nextInt();
                        boleta.sunarCantidad(cantidad);
                        boleta.sunarTotal(cerveza.getPrecio(), cantidad);
                    }else if(2 == op) {
                        System.out.println("¿Cuantos paquetes de mani desea? :");
                        int cantidad = s.nextInt();
                        boleta.sunarTotal(mani.getPrecio(), cantidad);
                        boleta.sunarCantidad(cantidad);
                    }else if(3 == op) {
                        validadorCompras = true;
                    }
                    System.out.println("Usted lleva " + boleta.getCantidad() + " productos, lo que da un total de $"+ boleta.getTotalCompra());
                }
            }else if (2 == opcion){
                System.out.println("Ingrese el codigo de cupon : ");
                String nombreCupon = s.nextLine(); 
                if (nombreCupon == "AUSTRAL2021" ){
                    System.out.println("Felicidades, tu cupon es valido...");
                    System.out.println("obtendras un descuento de $" + cuponCerveza.getDescuento()*cerveza.getPrecio()+ " pesos sobre cada cerveza");
                    System.out.println("El total de tu cuenta es de " +boleta.getTotalCompra());
                }else if (nombreCupon == "MANI2021"){
                    System.out.println("Felicidades, tu cupon es valido...");
                    System.out.println("obtendras un descuento de $" + cuponCerveza.getDescuento()*mani.getPrecio()+ " pesos sobre cada cerveza");
                        System.out.println("El total de tu cuenta es de " +boleta.getTotalCompra());
                }
            }
        }
    }
    
}
