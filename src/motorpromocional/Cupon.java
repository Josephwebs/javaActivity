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
public class Cupon {
    private String codigoCupon;
    private double descuento;
    private String fechaDesde;
    private String fechaHasta;
    private String marca; 
    private int maxUnidades;
    private int ean;

    public Cupon(String codigoCupon, double descuento, String fechaDesde, String fechaHasta, String marca, int maxUnidades, int ean) {
        this.codigoCupon = codigoCupon;
        this.descuento = descuento;
        this.fechaDesde = fechaDesde;
        this.fechaHasta = fechaHasta;
        this.marca = marca;
        this.maxUnidades = maxUnidades;
        this.ean = ean;
    }

    public Cupon() {
    }

    public String getCodigoCupon() {
        return codigoCupon;
    }

    public void setCodigoCupon(String codigoCupon) {
        this.codigoCupon = codigoCupon;
    }

    public double getDescuento() {
        return descuento;
    }

    public void setDescuento(double descuento) {
        this.descuento = descuento;
    }

    public String getFechaDesde() {
        return fechaDesde;
    }

    public void setFechaDesde(String fechaDesde) {
        this.fechaDesde = fechaDesde;
    }

    public String getFechaHasta() {
        return fechaHasta;
    }

    public void setFechaHasta(String fechaHasta) {
        this.fechaHasta = fechaHasta;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getMaxUnidades() {
        return maxUnidades;
    }

    public void setMaxUnidades(int maxUnidades) {
        this.maxUnidades = maxUnidades;
    }

    public int getEan() {
        return ean;
    }

    public void setEan(int ean) {
        this.ean = ean;
    }
    
    
}
