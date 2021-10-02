/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package motorpromocional;

/**
 *
 * @author José Alcantara
 */
public class Producto {
    private String nombre;
    private int ean;
    private String marca; 
    private int stock; 
    private int precio; 

    public Producto(String nombre, int ean, String marca, int stock, int precio) {
        this.nombre = nombre;
        this.ean = ean;
        this.marca = marca;
        this.stock = stock;
        this.precio = precio;
    }

    public int descuento(double porcentajeDescuento,int precio){
        double descuento = this.precio * porcentajeDescuento;
        this.precio = this.precio -  (int) Math.round(descuento);
        System.out.println("El total de este producto con descuento es de : " + this.precio);
        return this.precio;
    }   

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEan() {
        return ean;
    }

    public void setEan(int ean) {
        this.ean = ean;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

}
