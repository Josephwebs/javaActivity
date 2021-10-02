/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package motorpromocional;

import java.util.ArrayList;
import java.util.List;
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
        System.out.print("Porfavor ingrese su nombre : ");
        String nombre = s.nextLine();
        System.out.print("Porfavor ingrese su apellido : ");
        String apellido = s.nextLine();
        System.out.print("Porfavor ingrese su direccion de despacho : ");
        String direccion = s.nextLine();
        System.out.print("Ingrese su rut : ");
        String rut = s.nextLine();
        List<Cupon> cupones = new ArrayList();
        List<String> nombresCupones = new ArrayList();
        System.out.println("¿Tienes algun cupon de descuento? Ingrese numero...");
        System.out.println("1.- Si ");
        System.out.println("2.- No");
        int opcionCupon = s.nextInt();
        s.nextLine();
        boolean cuponValidador = true;
        if (opcionCupon == 1){
            while (cuponValidador){
                System.out.print("Ingrese el codigo de cupon o digite 0 para dejar de agregar cupones : ");
                String nombreCupon = s.nextLine();
                switch (nombreCupon) {
                    case "AUSTRAL2021":
                        if (!nombresCupones.contains(nombreCupon)){
                            System.out.println("Felicidades, tu cupon es valido...");
                            Cupon cuponCerveza = new Cupon("AUSTRAL2021", 0.2, "21/08/2021" ,"21/08/2022","Austral Patagonia", 6, 65497321);
                            nombresCupones.add("AUSTRAL2021");
                            cupones.add(cuponCerveza);
                        }else{
                            System.out.println("Ya as ingresado este cupon...");
                        }   
                        break;
                    case "MANI2021":
                        if (!nombresCupones.contains(nombreCupon)){
                            System.out.println("Felicidades, tu cupon es valido...");
                            Cupon cuponMani = new Cupon("MANI2021", 0.4, "21/08/2021" ,"21/08/2022","Evercrisp", 5 , 34322342);
                            nombresCupones.add("MANI2021");
                            cupones.add(cuponMani);
                        }else{
                            System.out.println("Ya as ingresado este cupon...");
                        }   
                        break;
                    case "0":
                        cuponValidador = false;
                        break;
                    default:
                        System.out.println("Cupon no valido...");
                        break; 
                }
            }
        }
        cliente.setNombre(nombre);
        cliente.setApellido(apellido);
        cliente.setDireccionDespacho(direccion);
        cliente.setRutCliente(rut);
        Boleta boleta = new Boleta();
        boleta.setRutCliente(cliente.getRutCliente());
        boolean validador = false;
        boolean validadorCompras = false; 
        List<Producto> productos = new ArrayList();
        List<String> nombresProductos = new ArrayList();

        Producto cerveza = new Producto("Cerveza Austral",65497321, "Austral Patagonia", 10, 1200);
        Producto mani = new Producto("Mani Salado",34322342, "Evercrisp", 10, 600);
        Cupon cuponCerveza = new Cupon("AUSTRAL2021", 0.2, "21/08/2021" ,"21/08/2022","Austral Patagonia", 6, 65497321);
        Cupon cuponMani = new Cupon("MANI2021", 0.4, "21/08/2021" ,"21/08/2022","Evercrisp", 5 , 34322342);


        while(!validador){
            System.out.println("Muchas gracias por escogernos " + cliente.getNombre() + ", a continuacion le mostraremos lo que puede hacer... " );
            System.out.println("1. Agregar productos al carro");
            System.out.println("2. Ver boleta");
            s.nextLine();
            int opcion = s.nextInt();
            if (1 == opcion){    
                while(!validadorCompras){
                    System.out.println("1. cerveza ... precio : $"+ cerveza.getPrecio());
                    System.out.println("2. mani    ... precio : $"+ mani.getPrecio());
                    System.out.println("3. Salir ");
                    System.out.print("Escoga una opcion : ");
                    int op = s.nextInt();
                    if (1 == op){
                        int cantidadCerveza = 0;
                        productos.add(cerveza);
                        for (Producto producto : productos) {
                            if (productos.contains(cerveza)) {
                                cantidadCerveza = cantidadCerveza + 1;
                            }
                        }
                        if (nombresCupones.contains("AUSTRAL2021")){
                            int precioCerveza = cerveza.descuento( cuponCerveza.getDescuento() , cerveza.getPrecio());
                            cerveza.setPrecio(precioCerveza);
                        }
                    }else if(2 == op) {
                        int cantidadMani = 0;
                        productos.add(mani);
                        for (Producto producto : productos) {
                            if (productos.contains(mani)) {
                                cantidadMani = cantidadMani + 1;
                            }
                        }
                        if (nombresCupones.contains("MANI2021")){
                            int precioMani = mani.descuento( cuponMani.getDescuento() , cerveza.getPrecio());
                            mani.setPrecio(precioMani);

                        }
                    }else if(3 == op) {
                        validadorCompras = true;
                    }
                    int total = 0;
                    for (Producto producto : productos) {
                        total = total + producto.getPrecio();
                    }
                    System.out.println("Usted lleva " + productos.size() + " productos lo que da un total de $" + total + " pesos");
                    boleta.setCantidad(productos.size());
                    boleta.setTotalCompra(total);
                    boleta.setCodigosCupones(cupones);
                    s.nextLine();
                }
            }else if (2 == opcion){
                System.out.println("------------BOLETA------------");
                System.out.println("Productos en carro...");
                for (Producto producto : productos) {
                    System.out.println(producto.getNombre() +"\t\t" + producto.getPrecio());
                    
                }
            }
        }
    }
}

