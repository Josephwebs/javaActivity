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
public class Boleta {
    private int numeroBoleta; 
    private int cantidad; 
    private int totalCompra; 
    private String codigosCupones;
    private String rutCliente;

    public Boleta() {
    }

    public Boleta(int numeroBoleta, int cantidad, int totalCompra, String codigosCupones, String rutCliente) {
        this.numeroBoleta = numeroBoleta;
        this.cantidad = cantidad;
        this.totalCompra = totalCompra;
        this.codigosCupones = codigosCupones;
        this.rutCliente = rutCliente;
    }
    
    public void sunarCantidad(int cantidad){
        if (this.cantidad == 0){
            this.cantidad = cantidad;
        }else {
            this.cantidad = this.cantidad + cantidad;
        }
    }
    
    
    public void sunarTotal(int Compra, int cantidad){
        if (this.totalCompra == 0){
            this.totalCompra = Compra*cantidad;
        }else {
            this.totalCompra = this.totalCompra + (Compra*cantidad);
        }
    }

    public int getNumeroBoleta() {
        return numeroBoleta;
    }

    public void setNumeroBoleta(int numeroBoleta) {
        this.numeroBoleta = numeroBoleta;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getTotalCompra() {
        return totalCompra;
    }

    public void setTotalCompra(int totalCompra) {
        this.totalCompra = totalCompra;
    }

    public String getCodigosCupones() {
        return codigosCupones;
    }

    public void setCodigosCupones(String codigosCupones) {
        this.codigosCupones = codigosCupones;
    }

    public String getRutCliente() {
        return rutCliente;
    }

    public void setRutCliente(String rutCliente) {
        this.rutCliente = rutCliente;
    }
    
    public void agregarCupones(String codigosCupones){
        if(this.codigosCupones == null){
            this.codigosCupones = codigosCupones;
        }else{
            this.codigosCupones = this.codigosCupones + ";" + codigosCupones;
        }
    
    }
}