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
        boolean cuponValidador = true;
        boolean var = true;
        while (var){
            System.out.print("Ingrese opcion : ");
            int opcionCupon = s.nextInt();
            s.nextLine();
            if (opcionCupon == 1){
                while (cuponValidador){
                    System.out.print("Ingrese el codigo de cupon o digite 0 para dejar de agregar cupones : ");
                    String nombreCupon = s.nextLine();
                    switch (nombreCupon) {
                        case "AUSTRAL2021":
                            if (!nombresCupones.contains(nombreCupon)){
                                System.out.println("Felicidades, tu cupon es valido tienes 20% de descuento en 6 cervezas!!");
                                Cupon cuponCerveza = new Cupon("AUSTRAL2021", 0.2, "21/08/2021" ,"21/08/2022","Austral Patagonia", 6, 65497321);
                                nombresCupones.add("AUSTRAL2021");
                                cupones.add(cuponCerveza);
                            }else{
                                System.out.println("--------------------------------------");
                                System.out.println("Ya as ingresado este cupon...");
                                System.out.println("--------------------------------------");
                            }   
                            break;
                        case "MANI2021":
                            if (!nombresCupones.contains(nombreCupon)){
                                System.out.println("Felicidades, tu cupon es valido tienes 40% de descuento en 5 paquetes de mani salado!!");
                                Cupon cuponMani = new Cupon("MANI2021", 0.4, "21/08/2021" ,"21/08/2022","Evercrisp", 5 , 34322342);
                                nombresCupones.add("MANI2021");
                                cupones.add(cuponMani);
                            }else{
                                System.out.println("--------------------------------------");
                                System.out.println("Ya as ingresado este cupon...");
                                System.out.println("--------------------------------------");
                            }   
                            break;
                        case "0":
                            cuponValidador = false;
                            var = false;
                            break;
                        default:
                            System.out.println("---------------------");
                            System.out.println("Cupon no valido...");
                            System.out.println("---------------------");
                            break; 
                    }
                }
            
            }else if (opcionCupon == 2){ 
                cuponValidador = false;
                var = false;
            }else {
                System.out.println("-------------------------------------");
                System.out.println("Opcion no valida, intente denuevo");
                System.out.println("-------------------------------------");
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
        List<Integer> precios = new ArrayList<>();
        Producto cerveza = new Producto("Cerveza Austral",65497321, "Austral Patagonia", 10, 1200);
        Producto mani = new Producto("Mani Salado",34322342, "Evercrisp", 10, 600);
        Cupon cuponCerveza = new Cupon("AUSTRAL2021", 0.2, "21/08/2021" ,"21/08/2022","Austral Patagonia", 6, 65497321);
        Cupon cuponMani = new Cupon("MANI2021", 0.4, "21/08/2021" ,"21/08/2022","Evercrisp", 2 , 34322342);
        int c = 0;
        int m = 0;
        while(!validador){
            System.out.println("--------------------------------------");
            System.out.println("Muchas gracias por escogernos " + cliente.getNombre() + ", a continuacion le mostraremos lo que puede hacer... " );
            System.out.println("1. Agregar productos al carro");
            System.out.println("2. Ver boleta");
            System.out.println("3. Salir");
            System.out.println("--------------------------------------");
            System.out.print("Escoga una opcion : ");
            int opcion = s.nextInt();
            s.nextLine();
            if (1 == opcion){   
                validadorCompras = false;
                while(!validadorCompras){
                    System.out.println("--------------------------------------");
                    System.out.println("1. cerveza ... precio : $"+ cerveza.getPrecio());
                    System.out.println("2. mani    ... precio : $"+ mani.getPrecio());
                    System.out.println("3. Salir ");
                    System.out.println("--------------------------------------");
                    System.out.print("Escoga una opcion : ");
                    int op = s.nextInt();
                    switch (op) {
                        case 1:
                            int cantidadCerveza = 0;
                            if (cerveza.getStock() >= 0){
                                productos.add(cerveza);
                                    if (productos.contains(cerveza)) {
                                        cantidadCerveza = cantidadCerveza + 1;
                                        cerveza.setStock(cerveza.getStock()-cantidadCerveza);
                                        if (cerveza.getStock() > -1){
                                            System.out.println("--------------------------------------");
                                            System.out.println("quedan "+ (cerveza.getStock()) +" cervezas");
                                            System.out.println("--------------------------------------");
                                        }else{
                                            System.out.println("--------------------------------");
                                            System.out.println("No queda cervezas en stock...");
                                            System.out.println("--------------------------------");       
                                        }
                                    }
                            }else{
                                System.out.println("--------------------------------");
                                System.out.println("No queda cervezas en stock...");
                                System.out.println("--------------------------------");
                            }
                            break;
                        case 2:
                            if (mani.getStock() >= 0){
                                int cantidadMani = 0;
                                productos.add(mani);
                                    if (productos.contains(mani)) {
                                        cantidadMani = cantidadMani + 1;
                                        mani.setStock(mani.getStock() - cantidadMani );
                                        if (mani.getStock() > -1) {
                                            System.out.println("--------------------------------------");
                                            System.out.println("quedan "+ (mani.getStock()) +" mani");
                                            System.out.println("--------------------------------------");
                                        }else {
                                            System.out.println("----------------------------");
                                            System.out.println("No queda mani en stock...");
                                            System.out.println("----------------------------");
                                        }
                                    }
                            }else{
                                System.out.println("----------------------------");
                                System.out.println("No queda mani en stock...");
                                System.out.println("----------------------------");
                            } break;
                        case 3:
                            validadorCompras = true;
                            break;
                        default:
                            System.out.println("opcion invalida, intente denuevo");
                            break;
                    }
                        boolean cuponValido;
                        if (cerveza.getStock() >= 0 && op == 1 && productos.size() > 0){
                            c = c + 1;
                            if (c <= cuponCerveza.getMaxUnidades() && nombresCupones.contains("AUSTRAL2021")){
                                cuponValido = true;
                            }else {
                                cuponValido = false;
                            }
                            int precioFinaLProducto = cerveza.descuento(cuponCerveza.getDescuento(), cerveza.getPrecio(), cuponValido);
                            if (cerveza.getStock() >= 0 && op == 1){
                                precios.add(precioFinaLProducto);
                            }
                            
                        }else if (mani.getStock() >= 0 && op == 2 && productos.size() > 0){
                            m = m + 1;
                            if (m <= cuponMani.getMaxUnidades() && nombresCupones.contains("MANI2021") ){
                                cuponValido = true;
                            }else {
                                cuponValido = false;
                            }
                            int precioFinaLProducto = mani.descuento(cuponMani.getDescuento(), mani.getPrecio(), cuponValido);
                            if (mani.getStock() >= 0 && op == 2) {
                                precios.add(precioFinaLProducto);
                            }
                        }
                    
                    int total = 0;
                    for (int precio : precios) {
                        total = total + precio;
                    }
                    System.out.println("Usted lleva " + precios.size() + " productos lo que da un total de $" + total + " pesos");
                    boleta.setCantidad(productos.size());
                    boleta.setTotalCompra(total);
                    boleta.setCodigosCupones(cupones);
                    s.nextLine();
                }
            }else if (2 == opcion){
                System.out.println("------------BOLETA------------");
                System.out.println("Productos en carro...");
                productos.forEach(producto -> {
                    System.out.println(producto.getNombre() +"\t\t" + producto.getPrecio());
                });
            }else if  (3 == opcion){
                System.out.println("Muchas gracias por visitarnos,"+ cliente.getNombre()+ " esperamos que vuelvas pronto!!!");
                validador = true;
            }
            
            else{
                System.out.println("--------------------------------------");
                System.out.println("Opcion no valida, intente nuevamente");
                System.out.println("--------------------------------------");

            }
        }
    }
}

